package mylab.customer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import mylab.customer.service.CustomerService;
import mylab.customer.vo.CustomerVO;

public class CustomerSpringTest {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring-beans.xml");
        CustomerService service = context.getBean("customerServiceImpl", CustomerService.class);

        CustomerVO vo = new CustomerVO();
        vo.setEmail("test@email.com");
        vo.setName("홍길동");
        vo.setAge(30);

        service.insertCustomer(vo);

        CustomerVO result = service.getCustomerInfo(1);
        System.out.println("고객 이름: " + result.getName());
    }
}
