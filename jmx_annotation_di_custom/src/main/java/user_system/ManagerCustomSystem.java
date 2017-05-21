package user_system;

import java.lang.reflect.*;

public class ManagerCustomSystem {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        //Object object = new User("xxx");
        Object object = new Person();

        Field[] declaredFields = object.getClass().getDeclaredFields();
        for (Field field : declaredFields) {
            UserRoleAnnotation annotation = field.getAnnotation(UserRoleAnnotation.class);
            if (annotation != null) {
                if (annotation.role().getPermissions().getClass().getTypeName().equals(field.getType().getName())) {
                    UserRole role = annotation.role();
                    field.setAccessible(true);
                    field.set(object, role.getPermissions());
                }
            }

        }

        System.out.println(object);;

    }
}
