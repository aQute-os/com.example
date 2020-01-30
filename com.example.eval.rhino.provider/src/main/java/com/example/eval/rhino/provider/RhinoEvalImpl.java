package com.example.eval.rhino.provider;

import org.apache.felix.service.command.annotations.GogoCommand;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;
import org.osgi.service.component.annotations.Component;

import com.example.eval.api.Eval;

@GogoCommand(scope="rhino", function="eval")
@Component
public class RhinoEvalImpl implements Eval {

	@Override
	public double eval(String expression) throws Exception {
		Context cx = Context.enter();
		try {
			Scriptable scope = cx.initStandardObjects();
			Object result = cx.evaluateString(scope, expression, "?", 1, null);
			if (result instanceof Number)
				return ((Number) result).doubleValue();
			return Double.NaN;
		} finally {
			Context.exit();
		}
	}

}
