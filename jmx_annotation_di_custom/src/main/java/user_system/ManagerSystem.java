package user_system;

import java.lang.reflect.*;

public class ManagerSystem {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        User user = new User("xxx");

        Field permissionsField = user.getClass().getDeclaredField("permissions");
        
        UserRoleAnnotation annotation = permissionsField.getAnnotation(UserRoleAnnotation.class);
        if (annotation != null) {
            UserRole role = annotation.role();
            permissionsField.setAccessible(true);
            permissionsField.set(user, role.getPermissions());
        }

        user.printPermissions();

    }
}
