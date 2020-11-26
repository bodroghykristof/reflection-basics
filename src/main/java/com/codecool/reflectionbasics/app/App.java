package com.codecool.reflectionbasics.app;

import com.codecool.reflectionbasics.reflection.Custom;
import com.codecool.reflectionbasics.reflection.InspectedClass;
import com.codecool.reflectionbasics.reflection.ReflectionBasicClass;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

public class App {

	public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
		basics();
//		classInspection();
//		constructorInspection();
//		fields();
		annotations();
	}


	private static void basics() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException {
//		Class<?> cls = Class.forName("com.codecool.reflectionbasics.reflection.Reflection");
		Class<?> cls = ReflectionBasicClass.class;
		Object obj = cls.getDeclaredConstructor().newInstance();

		Class<?>[] noParams = {};
		cls.getDeclaredMethod("shout").invoke(obj);

		Class<?>[] paramString = new Class[1];
		paramString[0] = String.class;
		Method shoutMethod = cls.getDeclaredMethod("shout", String.class);
		shoutMethod.invoke(obj, "Hello there");

		Class<?>[] paramTwoInts = new Class[2];
		paramTwoInts[0] = int.class;
		paramTwoInts[1] = Integer.TYPE;
		Method addMethod = cls.getDeclaredMethod("add", int.class, int.class);
		System.out.println(addMethod.invoke(obj, 5, 6));

		Class<?>[] paramThreeInts = new Class[3];
		paramThreeInts[0] = Integer.TYPE;
		paramThreeInts[1] = Integer.TYPE;
		paramThreeInts[2] = Integer.TYPE;
		Method addThreeMethod = cls.getDeclaredMethod("add", int.class, int.class, int.class);
		System.out.println(addThreeMethod.invoke(obj, 5, 6, 8));
	}

	private static void classInspection() {

		Class<InspectedClass> myClass = InspectedClass.class;
		System.out.println(myClass.getName());
		System.out.println(myClass.getSimpleName());
		System.out.println(Modifier.isPublic(myClass.getModifiers()));
		System.out.println(myClass.getModifiers());
		System.out.println(myClass.getInterfaces()[0].getSimpleName());
		System.out.println(myClass.getPackage().getName());

	}

	private static void constructorInspection() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
		Class<InspectedClass> myClass = InspectedClass.class;
		Constructor<InspectedClass> constructor = myClass.getConstructor(int.class, int.class);
		System.out.println(constructor.getExceptionTypes()[0].getSimpleName());
		InspectedClass newInstance = constructor.newInstance(4, 5);
	}

	private static void fields() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
		Class<InspectedClass> myClass = InspectedClass.class;
		InspectedClass obj = myClass.getDeclaredConstructor(int.class, int.class).newInstance(8, 8);
		Field age = myClass.getDeclaredField("age");
		age.setAccessible(true);
		System.out.println(age.get(obj));
	}

	private static void annotations() {
		Class<InspectedClass> myClass = InspectedClass.class;
		Annotation[] annotations = myClass.getAnnotations();
		System.out.println(((Custom)annotations[0]).name());

//		Module module = String.class.getModule();

	}

}
