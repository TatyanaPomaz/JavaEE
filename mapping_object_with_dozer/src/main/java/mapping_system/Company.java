package mapping_system;

public class Company {
    private String companyName;

    public Company(String companyName) {
        this.companyName = companyName;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyName='" + companyName + '\'' +
                '}';
    }
}
