package com.codecool.reflectionbasics.reflection;

public class ReflectionBasicClass {

	public void shout() {
		System.out.println("No parameter");
	}

	public void shout(String text) {
		System.out.println(text);
	}

	public int add(int a, int b) { return a + b; }

	public int add(int a, int b, int c) { return a + b + c; }

}
