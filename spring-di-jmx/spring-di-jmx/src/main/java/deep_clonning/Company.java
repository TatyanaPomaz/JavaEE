package deep_clonning;

/**
 * Created by BGClassTeacher on 14.05.2017.
 */
public class Company implements Cloneable {
    private String companyName;

    public Company(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public Company clone() throws CloneNotSupportedException {
        Object clone = super.clone();
        return (Company) clone;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyName='" + companyName + '\'' +
                '}';
    }
}
