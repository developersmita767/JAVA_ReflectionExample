package Reflection;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class ClassReflectionExample {
	public ClassReflectionExample() {
		System.out.println("Inside the noarg constructor");
	}
	public ClassReflectionExample(String message,Integer a) {
		System.out.println("Inside the parametrized constructor"+message);
	}
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		 // Obtain Class object
        Class<?> clazz = ClassReflectionExample.class;
        //using the class name as string
        //Class<?> clazz = Class.forName("com.example.ReflectionExample");
        //using the object
       /* ReflectionExample ex=new ReflectionExample();
        Class<?> clazz =ex.getClass();*/
        
        Constructor<?>[] constructors = clazz.getConstructors();
        for(Constructor<?> con:constructors) {
        	System.out.println("****");
        	System.out.println(con.getName());
        	Arrays.stream(con.getParameters()).forEach(a->{
        		System.out.println(a);
        	});
        }
        //use noarg constructor to create the object
        Constructor<?> noargconstructor = clazz.getConstructor();
        Object instance = noargconstructor.newInstance();
	
        //use parameterized constructor to create object
        Constructor<?> constructor = clazz.getConstructor(String.class,Integer.class);
        Object instance1 = constructor.newInstance("Some argument",10);
		
	}

}
