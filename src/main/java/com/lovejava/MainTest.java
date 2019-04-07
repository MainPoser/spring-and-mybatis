package com.lovejava;

import com.lovejava.service.AccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author:tianyao
 * @date:2019-04-07 19:49
 */
public class MainTest {
    @Test
    public void test() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        AccountService service = (AccountService) applicationContext.getBean("accountService");
        service.saveAccount();
        System.out.println(service);
    }
}
