package user_system;

public enum UserRole {
    ADMIN("777"),
    DEFAULT_USER("666");

    private String permissions;

    public String getPermissions() {
        return permissions;
    }

    UserRole(String permissions) {
        this.permissions = permissions;
    }

    @Override
    public String toString() {
        return "UserRole{" +
                "permissions='" + permissions + '\'' +
                '}';
    }
}
