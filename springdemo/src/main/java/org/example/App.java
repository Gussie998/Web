package org.example;

import org.example.controller.LoginController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * User:DELL
 * Date:2021-06-07
 * Time:21:16
 */
public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        //LoginController loginController = (LoginController) context.getBean("loginController");
        LoginController loginController = context.getBean(LoginController.class);
        //得到俩个对象，是同一个对象 地址是一样的
        //单例模式

        //关闭容器
        ((ClassPathXmlApplicationContext)context).close();
    }
}
