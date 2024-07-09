package Reflection;
import java.lang.reflect.Field;
import java.util.Arrays;

public class FieldReflectionExample {
	public int var1;
	public static void main(String[] args) {
		Class<?> clazz = FieldReflectionExample.class;
		Field[] fields=clazz.getFields();
		Arrays.stream(fields).forEach(f->{
			System.out.println(f.getName());
			System.out.println(f.getType());
		});
		

	}

}
