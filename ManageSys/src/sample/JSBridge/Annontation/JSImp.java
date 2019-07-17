package sample.JSBridge.Annontation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * js 调用 java 方法的接口
 */
@Target(TYPE)
@Retention(SOURCE)
@Documented
public @interface JSImp {


}
