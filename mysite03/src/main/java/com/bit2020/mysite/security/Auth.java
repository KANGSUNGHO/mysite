package com.bit2020.mysite.security;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface Auth {
	
//	 admin page에서 접근제어 할때 아래 두줄 사용
	/*
	 * public enum Role {USER,ADMIN} public Role role() default Role.USER;
	 */	
	String value() default "";
	
	boolean test() default false;

}
