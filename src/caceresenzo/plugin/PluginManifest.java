package caceresenzo.plugin;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

@Target(TYPE)
@Retention(RUNTIME)
public @interface PluginManifest {
	
	String name();
	
	String description();
	
	double version() default 0.1;
	
	String[] authors() default "Anonymous";
	
}