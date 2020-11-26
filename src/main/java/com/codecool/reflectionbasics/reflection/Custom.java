package com.codecool.reflectionbasics.reflection;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Custom {
	public String name();
	public String value();
}
