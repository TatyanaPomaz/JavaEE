package user_system;

public class User {
    private String name;

    @UserRoleAnnotation(role = UserRole.ADMIN)
    private String permissions;

    public User(String name) {
        this.name = name;
    }

    public void printPermissions() {
        System.out.println(permissions.toString());
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", permissions='" + permissions.toString() + '\'' +
                '}';
    }
}
