package kz.uco.testwork.service;

import kz.uco.testwork.entity.Contacts;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target({ ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ContactsValidator.class)
public @interface CheckContactType {
    String message() default "Format of email: s@s.s phone: +n(nnn)nnn-nn-nn";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
