package com.goJavaFullStack.todo;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;

public class Todo_TEST {

	@InjectMocks
	private Todo td;

	public Todo todo;

	@Before
	public void createTodo() {
		todo = new Todo(5, "Carlos", "Java", new Date(2019, 9, 10), false);
	}

	@Test
	public void testar_id() {

		todo.setId((long) 3);

		assertThat(todo.getId()).isEqualTo(3L);
	}

	@Test
	public void testar_username() {

		todo.setUsername("Arthur");

		assertNotNull(todo.getUsername());
		assertEquals("Arthur", todo.getUsername());
	}

	@Test
	public void testar_description() {

//		todo.setDescription(Mockito.anyString());
		todo.setDescription("description");

		assertNotNull(todo.getDescription());
	}

	@Test
	public void testar_date() {

		todo.setTargetDate(new Date(2020, 10, 30));

		assertNotNull(todo.getTargetDate());
	}

	@Test
	public void testar_isDone() {

		todo.setDone(true);

		assertTrue(todo.isDone());
	}
}
