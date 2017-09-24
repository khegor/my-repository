package com.rocksoft.LogStr;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * Created by Esenin on 24.09.2017.
 */
public class Reflection {

    public static void main (String args[]){

        Class addressClass = Address.class;
        String addressClassName = addressClass.getName();
        Constructor [] constructors = addressClass.getDeclaredConstructors();
        Parameter[] parameters = constructors[0].getParameters();
        Method [] methods = addressClass.getDeclaredMethods();
        Field [] fields = addressClass.getDeclaredFields();
        System.out.println("methods: ");
        for(Method m : methods){
            System.out.println(m.getName());
        }
        System.out.println("fields: ");
        for(Field f : fields){
            System.out.println(f.getName());
        }
    }
}
