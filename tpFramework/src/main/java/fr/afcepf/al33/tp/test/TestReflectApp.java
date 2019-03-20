package fr.afcepf.al33.tp.test;

import java.lang.reflect.Method;

public class TestReflectApp {

	public static void main(String[] args) throws Exception {

        //String className="java.util.Date";
        //String className="java.sql.DriverManager";
		String className="java.lang.Math";
        
        Class<?> metaClasse = Class.forName(className);
        
        System.out.println("liste des méthodes de la classe:");
        for(Method m : metaClasse.getDeclaredMethods() ) {
        	System.out.println("\t" + m.getName());
        }

	}

}
