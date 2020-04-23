package com.study.design;

import com.study.design.event.OrderService;
import com.study.design.sale.SaleService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DesignApplicationTests {

    @Autowired
    OrderService orderService;

    @Autowired
    SaleService saleService;


    @Test
    void contextLoads() {
        orderService.saveOrder();
        System.out.println("mc");
    }


    @Test
    void test2() {
        double fee = saleService.sale("normal", 100);
        System.out.println(fee);

        double fee1 = saleService.sale("vip", 100);
        System.out.println(fee1);

        double fee2 = saleService.sale("svip", 100);
        System.out.println(fee2);
    }



}
