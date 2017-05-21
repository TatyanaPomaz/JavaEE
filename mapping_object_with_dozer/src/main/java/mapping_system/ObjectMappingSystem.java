package mapping_system;

import java.util.Arrays;
import org.dozer.DozerBeanMapper;

public class ObjectMappingSystem {
    public static void main(String[] args) {
        DozerBeanMapper mapper = new DozerBeanMapper();
        mapper.setMappingFiles(Arrays.asList("dozer_mapping.xml"));

        User user = new User("xxx", 12, new Company("yyy"));
        Person person = mapper.map(user, Person.class);

        System.out.println(user);
        System.out.println(person);
    }
}
