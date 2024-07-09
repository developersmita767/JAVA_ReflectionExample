package Reflection;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class MethodReflectionExample {
	public void display(String msg) {
		System.out.println("Inside display method"+msg);
	}
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
		Class<?> clazz = MethodReflectionExample.class;
		//get all method details
		Method[] methods=clazz.getMethods();
		Arrays.stream(methods).forEach(a->{
			System.out.println("*************");
			System.out.println("Method name:"+a.getName());
			System.out.println("Method args:");
			Arrays.stream(a.getParameters()).forEach(p->{
				System.out.println(p.getType());
			});
		});
		Constructor<?> constructor = clazz.getConstructor();
		Object instance = constructor.newInstance();
		Method method = clazz.getDeclaredMethod("display", String.class);
		//method.setAccessible(true); // If the method is private
		Object result = method.invoke(instance, "Method argument");
		
	}

}
