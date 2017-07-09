package map_test;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by User on 25.06.2017.
 */
public class MapTest {
    public static void main(String[] args) {
        Map<User, String> userHashMap = new HashMap<User, String>();
        User user = new User("xxx");

        userHashMap.put(user, "login_xxx");
        System.out.println(userHashMap.get(user));
    }
}

class User {
    private String name;

    public User(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return name != null ? name.equals(user.name) : user.name == null;
    }

    @Override
    public int hashCode() {
        return (int) (Math.random() * 100);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                '}';
    }
}