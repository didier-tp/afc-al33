package fr.afcepf.al33.tp.annot;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)  //annotation conservée au runtime dans le code compilé
public @interface MadMax {
	int value();
}
