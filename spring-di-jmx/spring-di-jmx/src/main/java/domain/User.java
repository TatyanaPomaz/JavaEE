package domain;

/**
 * Created by BGClassTeacher on 14.05.2017.
 */
public class User implements Cloneable {
    private String name;
    private Integer age;


    public User()
    {
        this.name = "Vasia";
        this.age= 75;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
