package com.example.eval.rhino.provider;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import com.example.eval.rhino.provider.RhinoEvalImpl;

public class RhinoEvalImplTest {
	@Test
	public void simple() {
		RhinoEvalImpl impl = new RhinoEvalImpl();
		assertNotNull(impl);
	}

}
