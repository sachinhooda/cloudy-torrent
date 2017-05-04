package com.sachin.cloudy.common.logger;

import java.lang.annotation.*;

/**
 * Created by sachinhooda on 2/4/17.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@Documented
public @interface InjectLogger {
}
