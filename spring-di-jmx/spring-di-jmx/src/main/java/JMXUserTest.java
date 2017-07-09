import service.IUserService;
import service.UserService;

import javax.management.InstanceAlreadyExistsException;
import javax.management.MBeanRegistrationException;
import javax.management.MBeanServer;
import javax.management.MalformedObjectNameException;
import javax.management.NotCompliantMBeanException;
import javax.management.ObjectName;
import javax.management.StandardMBean;
import java.lang.management.ManagementFactory;

/**
 * Created by BGClassTeacher on 14.05.2017.
 */
public class JMXUserTest {
    public static void main(String[] args) throws NotCompliantMBeanException, MalformedObjectNameException, InstanceAlreadyExistsException, MBeanRegistrationException, InterruptedException {

        MBeanServer server = ManagementFactory.getPlatformMBeanServer();
        StandardMBean userService =
                new StandardMBean(new UserService(), IUserService.class);
        ObjectName userServiceObjectName =
                new ObjectName("user_service:name=user-service");
        server.registerMBean(userService,userServiceObjectName);

        Thread.sleep(Long.MAX_VALUE);
    }
}
