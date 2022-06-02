package lecture12_exceptions;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * Example code for Reflection (Class class).
 * @author Terry Lee
 */
public class CustomerInspector {

    /**
     * Program to inspect customer class at runtime.
     * @param args arguments
     */
    public static void main(String[] args) {
        try {
            Class<?> c = Class.forName("Customer");

            Class<?> superClass = c.getSuperclass();
            System.out.println(superClass);

            Constructor<?>[] constructors = c.getConstructors();
            for (int i = 0; i < constructors.length; i++) {
                System.out.println(constructors[i]);
            }
            System.out.println();

            Field[] fields = c.getDeclaredFields();
            for (int i = 0; i < fields.length; i++) {
                System.out.println(fields[i]);
            }
            System.out.println();
            
            Method[] methods = c.getDeclaredMethods();
            for (int i = 0; i < methods.length; i++) {
                System.out.println(methods[i]);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
