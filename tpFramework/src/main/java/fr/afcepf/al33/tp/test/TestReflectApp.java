package fr.afcepf.al33.tp.test;

import java.lang.reflect.Method;
import java.util.Date;

public class TestReflectApp {
	
	public static void enPartantNomClasse() throws Exception {
		//String className="java.util.Date";
        //String className="java.sql.DriverManager";
		String className="java.lang.Math";
        
        Class<?> metaClasse = Class.forName(className);
        
        System.out.println("liste des méthodes de la classe " + metaClasse.getName());
        for(Method m : metaClasse.getDeclaredMethods() ) {
        	System.out.println("\t" + m.getName());
        }
	}
	
	public static void enPartantInstance() throws Exception {
		Date date = new Date();//java.util
        
        Class<?> metaClasse = date.getClass();
        
        System.out.println("liste des méthodes de la classe " + metaClasse.getName());
        for(Method m : metaClasse.getDeclaredMethods() ) {
        	System.out.println("\t" + m.getName());
        }
	}

	public static void main(String[] args) throws Exception {
		enPartantNomClasse();
		enPartantInstance();
	}

}
