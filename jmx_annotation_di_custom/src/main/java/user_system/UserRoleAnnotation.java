package user_system;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface UserRoleAnnotation {
    UserRole role() default UserRole.DEFAULT_USER;
}
