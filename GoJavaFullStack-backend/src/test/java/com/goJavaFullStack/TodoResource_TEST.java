package com.goJavaFullStack;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.net.URI;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.goJavaFullStack.todo.Todo;
import com.goJavaFullStack.todo.TodoHardCodedService;

public class TodoResource_TEST {

	@InjectMocks
	private TodoResource todoResource;

	@InjectMocks
	private TodoHardCodedService todoHardCodedService;

	@Mock
	private TodoHardCodedService todoService;

	private Todo myTodo;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		MockHttpServletRequest request = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
	}

	@Before
	@SuppressWarnings("deprecation")
	public void createTodo() {
		Date date = new Date();
		date.setDate(10);
		date.setMonth(5);
		date.setYear(2020);

		this.myTodo = new Todo(10L, "Arthur", "My todo", date, false);
	}

	@Test
	public void returnAllTodosByUsername() {

		List<Todo> allTodos = todoResource.getAllTodos("Study");

		when(todoResource.getAllTodos("Study")).thenReturn(allTodos);
		assertThat(todoResource.getAllTodos("Study")).isEqualTo(allTodos);
	}

	@Test
	public void returnTodosById() {

		when(todoResource.getAllTodos(myTodo.getUsername(), myTodo.getId())).thenReturn(myTodo);
	}

	@Test
	public void updateTodoTest1() {

		when(todoService.save(myTodo)).thenReturn(myTodo);

		ResponseEntity<Todo> response = new ResponseEntity<Todo>(myTodo, HttpStatus.OK);

		assertThat(todoResource.updateTodo(myTodo.getUsername(), myTodo.getId(), myTodo)).isEqualTo(response);

	}

	@Test
	public void testarAtualizacaoTodo() {

		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(myTodo.getId()).toUri();

		ResponseEntity<Void> response = ResponseEntity.created(uri).build();

		when(todoService.save(myTodo)).thenReturn(myTodo);
		assertThat(todoResource.updateTodo(myTodo.getUsername(), myTodo)).isEqualTo(response);

	}

	@Test
	public void deleteTodo_IF() {

		when(todoService.deleteById(myTodo.getId())).thenReturn(myTodo);

		ResponseEntity<Void> response = ResponseEntity.noContent().build();
		assertThat(todoResource.deleteTodo(myTodo.getUsername(), myTodo.getId())).isEqualTo(response);
		assertNotNull(todoResource.deleteTodo(myTodo.getUsername(), myTodo.getId()));
	}

	@Test
	public void deleteTodo_ELSE() {

		when(todoService.deleteById(myTodo.getId())).thenReturn(null);

		ResponseEntity<Void> response = ResponseEntity.notFound().build();
		assertThat(todoResource.deleteTodo(myTodo.getUsername(), myTodo.getId())).isEqualTo(response);
	}

}
