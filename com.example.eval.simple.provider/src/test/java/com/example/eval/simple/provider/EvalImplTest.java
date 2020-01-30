package com.example.eval.simple.provider;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EvalImplTest {
	

	@Test
	public void testSimple() throws Exception {
		
		EvalImpl t = new EvalImpl();
		assertEquals(3.0, t.eval("1 + 2"), 0.001);
	}
}