package com.goJavaFullStack.todo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class TodoHardCodedService_TEST {

	@InjectMocks
	private TodoHardCodedService todoService;
	
	private Todo myTodo;

	@Before
	public void setUp() {
		MockitoAnnotations.initMocks(this);		
	}
	
	@Before
	public void createTodo() {
		Date date = new Date();
		date.setDate(10);
		date.setMonth(5);
		date.setYear(2020);

		myTodo = new Todo(10L, "Arthur", "My todo", date, false);
	}

	@Test
	public void testarSave_IF() {
		
		myTodo.setId(0L);
		
		todoService.save(myTodo);

		TodoHardCodedService service = Mockito.mock(TodoHardCodedService.class);
//		assertEquals(0L, myTodo.getId());
		
	}

	@Test
	public void testarSave_ELSE() {
		
		TodoHardCodedService service = org.mockito.Mockito.mock(TodoHardCodedService.class);
		when(service.save(myTodo)).thenReturn(myTodo);
		todoService.save(myTodo);

		assertEquals(myTodo, todoService.save(myTodo));

	}

	@Test
	public void retornarListaTodos() {
		
		List<Todo> todos = new ArrayList<Todo>();
		todos.add(myTodo);
		
		TodoHardCodedService service = org.mockito.Mockito.mock(TodoHardCodedService.class);
		when(service.findAll()).thenReturn(todos);

		assertEquals(5, todoService.findAll().size());
	}

	@Test
	public void testarFindById() {
		
		TodoHardCodedService service = org.mockito.Mockito.mock(TodoHardCodedService.class);
		when(service.findById(myTodo.getId())).thenReturn(myTodo);

		assertEquals(10L, myTodo.getId());
		assertNotNull(service.findById(myTodo.getId()));
	}

	@Test
	public void testarDeletarporID() {

		List<Todo> todos = new ArrayList<Todo>();
		todos.add(myTodo);
		
		assertNotNull(todos.remove(myTodo));

		TodoHardCodedService service = org.mockito.Mockito.mock(TodoHardCodedService.class);
		when(service.findById(myTodo.getId())).thenReturn(myTodo);
		when(service.deleteById(myTodo.getId())).thenReturn(myTodo);

	}
	
	@Test
	public void deleteById_retornaNulo() {
						
//		TodoHardCodedService service = org.mockito.Mockito.mock(TodoHardCodedService.class);
//		when(service.findById(myTodo.getId())).thenReturn(null);
		
		assertThat(todoService.deleteById(myTodo.getId())).isEqualTo(null);
	}
}
