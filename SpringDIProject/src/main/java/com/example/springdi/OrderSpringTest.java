package com.example.springdi;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class OrderSpringTest {

    @Test
    public void testShoppingCartBean() {
        ApplicationContext context = new ClassPathXmlApplicationContext("mylab-order-di.xml");
        ShoppingCart cart = (ShoppingCart) context.getBean("shoppingCart");

        assertNotNull(cart);
        assertEquals(2, cart.getProducts().size());
        System.out.println("쇼핑카트에 상품 2개 들어있음 확인 완료");
    }

    @Test
    public void testOrderServiceBean() {
        ApplicationContext context = new ClassPathXmlApplicationContext("mylab-order-di.xml");
        OrderService service = (OrderService) context.getBean("orderService");

        assertNotNull(service);
        service.printOrder();
        System.out.println("주문서비스 출력 성공");
    }
}