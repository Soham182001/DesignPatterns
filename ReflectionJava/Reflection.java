package ReflectionJava;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/*
We can achieve reflection by the following way.
First we need to get an Object of Class

Ways to get particular class Class object

Class bikeClass = Class.forName("Bike"); // way 1

Class bikeClass = Bike.class; // way 2

Bike bikeObj = new Bike();
Class bikeClass = bikeObj.getClass() // way 3
*/



public class Reflection {
    public static void main(String[] args) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException, NoSuchMethodException, InstantiationException, InvocationTargetException {

        // 1. using Bike.class method (reflection of class)
        System.out.println("---------------------------------------");
        System.out.println("|Reflection of Class                  |");
        System.out.println("---------------------------------------");
        Class bikeClass = Bike.class;
        System.out.println(bikeClass.getName());
        System.out.println(Modifier.toString(bikeClass.getModifiers()));

        // extracting only public methods
        System.out.println("---------------------------------------");
        System.out.println("|Extracting Public Methods            |");
        System.out.println("---------------------------------------");
        Method[] methods = bikeClass.getMethods();
        for(Method method: methods){
            System.out.println("Method Name: "+method.getName());
            System.out.println("Return Type: "+method.getReturnType());
            System.out.println("Class Name: "+method.getDeclaringClass());
            System.out.println("======");
        }

        // extracting public and private methods
        System.out.println("---------------------------------------");
        System.out.println("|Extracting Private & Public Methods  |");
        System.out.println("---------------------------------------");
        Method[] methodsPrivateAndPublic = bikeClass.getDeclaredMethods();
        for(Method method: methodsPrivateAndPublic){
            System.out.println("Method Name: "+method.getName());
            System.out.println("======");
        }

        // invoke method using reflection
        System.out.println("---------------------------------------");
        System.out.println("|Invoke Methods                       |");
        System.out.println("---------------------------------------");
        Class busClass = Bus.class;
        Object busObject = busClass.newInstance();
        Method runMethod = busClass.getMethod("Run");
        runMethod.invoke(busObject);

        // reflection of fields
        System.out.println("---------------------------------------");
        System.out.println("|Extracting Public Fields             |");
        System.out.println("---------------------------------------");
        Field[] fields = bikeClass.getFields();
        for(Field field: fields){
            System.out.println("Field Name: "+field.getName());
            System.out.println("Type: "+field.getType());
            System.out.println("Modifier: "+Modifier.toString(field.getModifiers()));
            System.out.println("======");
        }

        // reflection of private and public fields
        System.out.println("---------------------------------------");
        System.out.println("|Extracting Private & Public Fields   |");
        System.out.println("---------------------------------------");
        Field[] fieldsPrivateAndPublic = bikeClass.getDeclaredFields();
        for(Field field: fieldsPrivateAndPublic){
            System.out.println("Field Name: "+field.getName());
            System.out.println("Type: "+field.getType());
            System.out.println("Modifier: "+Modifier.toString(field.getModifiers()));
            System.out.println("======");
        }

        // set the value of public field
        System.out.println("---------------------------------------");
        System.out.println("|Setting Public Fields                |");
        System.out.println("---------------------------------------");
        Bike bikeObj = new Bike();
        Field field1 = bikeClass.getDeclaredField("bikeName");
        field1.set(bikeObj, "RE Hunter 350");
        System.out.println("Renamed Bike Name: "+bikeObj.bikeName);

        // set the value of public and private field
        System.out.println("---------------------------------------");
        System.out.println("|Setting Private & Public Fields      |");
        System.out.println("---------------------------------------");
        Field field2 = bikeClass.getDeclaredField("bikeNo");
        field2.setAccessible(true);
        field2.set(bikeObj, "MH 26 CL 3019");
        System.out.println("Modified Number Plate: "+(String)field2.get(bikeObj));

        // Reflection of constructor (Breaking Singleton Pattern)
        System.out.println("---------------------------------------");
        System.out.println("|Reflection of Constructor            |");
        System.out.println("---------------------------------------");
        Class carClass = Car.class;
        Constructor[] carConstructorList = carClass.getDeclaredConstructors();
        for(Constructor carConstructor: carConstructorList){
            System.out.println("Modifier: "+Modifier.toString(carConstructor.getModifiers()));
            carConstructor.setAccessible(true);
            Car carObj = (Car) carConstructor.newInstance();   // invoke private constructor
            carObj.Run();
        }
    }
}
