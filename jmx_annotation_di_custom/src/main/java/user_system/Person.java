package user_system;

public class Person {
    @UserRoleAnnotation
    private User perm;

    @UserRoleAnnotation
    private String perm1;

    @UserRoleAnnotation(role = UserRole.ADMIN)
    private int perm2;

    @Override
    public String toString() {
        return "Person{" +
                "perm=" + (perm == null ? "user is null" : perm) +
                ", perm1='" + perm1 + '\'' +
                ", perm2=" + perm2 +
                '}';
    }
}
