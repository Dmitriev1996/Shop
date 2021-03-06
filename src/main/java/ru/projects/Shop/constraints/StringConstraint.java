package ru.projects.Shop.constraints;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;
import javax.validation.ReportAsSingleViolation;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Size(min=2)
@Pattern(regexp="[a-zA-Zа-яА-Я]")
@ReportAsSingleViolation
@Constraint(validatedBy= {})
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, 
	ElementType.CONSTRUCTOR, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface StringConstraint {
	String message() default "{ru.projects.Shop.constarints.StringConstraint.message}";
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
	@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, 
		ElementType.CONSTRUCTOR, ElementType.PARAMETER})
	@Retention(RetentionPolicy.RUNTIME)
	@interface List {
		StringConstraint[] value();
	}
	

}
