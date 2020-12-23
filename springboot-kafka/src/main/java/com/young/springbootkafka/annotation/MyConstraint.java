package com.young.springbootkafka.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * MyConstraint 校验自定义注解
 *
 * @author yangbing
 * @date 2020/12/23 上午10:36
 */
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = MyConstraintValidator.class)
public @interface MyConstraint {

    String message() ;

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
