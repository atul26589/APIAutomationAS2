package annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import static java.lang.annotation.ElementType.METHOD;

@Retention(java.lang.annotation.RetentionPolicy.RUNTIME)
@Target({METHOD})
public @interface FrameworkAnnotations {
	
	String[] author()default "Atul";
	String[] category()default "Regression";
}
