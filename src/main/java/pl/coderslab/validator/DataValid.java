package pl.coderslab.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.sql.Date;

@Constraint(validatedBy = DataValidValidator.class)
@Target({ElementType.METHOD,  ElementType.FIELD})// nad czym moze byc umieszczona adnotacja
@Retention(RetentionPolicy.RUNTIME)
public @interface DataValid {

    int start();
    int end();


    String message() default "{dataValid.error.message}" ;
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
