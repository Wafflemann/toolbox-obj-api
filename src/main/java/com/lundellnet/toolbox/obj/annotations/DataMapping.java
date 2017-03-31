package com.lundellnet.toolbox.obj.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface DataMapping {

    String mapping() default "";
    
    String delimiter() default "/";
  
}
