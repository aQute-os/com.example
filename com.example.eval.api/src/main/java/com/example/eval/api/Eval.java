package com.example.eval.api;

import org.osgi.annotation.versioning.ProviderType;

@ProviderType
public interface Eval {
	double eval(String s) throws Exception;
}
