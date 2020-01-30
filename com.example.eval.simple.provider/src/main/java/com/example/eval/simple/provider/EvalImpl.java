package com.example.eval.simple.provider;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.felix.service.command.annotations.GogoCommand;
import org.osgi.framework.ServiceReference;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.example.eval.api.Eval;

@GogoCommand(scope="simple", function= {"eval"})
@Component
public class EvalImpl implements Eval {

	Pattern EXPR = Pattern.compile("\\s*(?<left>\\d+)\\s*(?<op>\\+|-)\\s*(?<right>\\d+)\\s*");

	@Reference
	volatile List<ServiceReference<Object>> list;
	
	@Override
	public double eval(String expression) throws Exception {
		Matcher m = EXPR.matcher(expression);
		if (!m.matches())
			throw new IllegalArgumentException("Invalid expression " + expression);

		double left = Double.valueOf(m.group("left"));
		double right = Double.valueOf(m.group("right"));
		switch (m.group("op")) {
		case "+":
			return left + right;
		case "-":
			return left - right;
		}
		return Double.NaN;
	}
}
