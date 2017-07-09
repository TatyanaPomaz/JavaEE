package jmx_test;

import javax.management.*;
import java.lang.management.*;

public class JMXTest {
    public static void main(String[] args) throws NotCompliantMBeanException, MalformedObjectNameException, InstanceAlreadyExistsException, MBeanRegistrationException, InterruptedException {
        CalculatorMBean calculatorMBean = new Calculator();  // модель - не mbean ресурс
        StandardMBean standardMBean = new StandardMBean(calculatorMBean, CalculatorMBean.class);

        MBeanServer platformMBeanServer = ManagementFactory.getPlatformMBeanServer();
        platformMBeanServer.registerMBean(standardMBean, new ObjectName("calc_test:name=calcu"));

        Thread.sleep(Long.MAX_VALUE);
    }
}
