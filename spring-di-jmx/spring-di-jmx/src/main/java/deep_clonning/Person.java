package deep_clonning;

/**
 * Created by BGClassTeacher on 14.05.2017.
 */
public class Person implements Cloneable {
    private String name;
    private int age;
    private Company company;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.company = new Company("xxx");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", company=" + company +
                '}';
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        Person clone = (Person)super.clone();

//        Company originalCompany = clone.getCompany();
//        Company companyForClone =
//                new Company(originalCompany.getCompanyName());
//        clone.setCompany(companyForClone);

        Company companyForClone = clone.getCompany().clone();
        clone.setCompany(companyForClone);
        return clone;
    }
}
