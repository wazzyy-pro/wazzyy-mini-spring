package minispring.test;

import minispring.beans.PropertyValue;
import minispring.beans.PropertyValues;
import minispring.beans.factory.config.BeanDefinition;
import minispring.beans.factory.config.BeanReference;
import minispring.beans.factory.support.DefaultListableBeanFactory;
import minispring.test.bean.TestUserDao;
import minispring.test.bean.TestUserService;
import minispring.test.bean.TestUserServiceWithConstructor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @Description 依赖注入测试类
 * @Author wazzyy
 * @Date 2025/8/25
 */
public class DependencyInjectionTest {

    /**
     * 测试属性注入
     */
    @Test
    public void testPropertyInjection() {
        // 创建BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 注册UserDao
        BeanDefinition userDaoBeanDefinition = new BeanDefinition(TestUserDao.class);
        beanFactory.registerBeanDefinition("userDao", userDaoBeanDefinition);

        // 创建UserService的属性值
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("name", "张三"));
        propertyValues.addPropertyValue(new PropertyValue("userDao", new BeanReference("userDao")));

        // 注册UserService
        BeanDefinition userServiceBeanDefinition = new BeanDefinition(TestUserService.class, propertyValues);
        beanFactory.registerBeanDefinition("userService", userServiceBeanDefinition);

        // 获取UserService
        TestUserService userService = (TestUserService) beanFactory.getBean("userService");

        // 验证属性注入
        assertEquals("张三", userService.getName());
        assertNotNull(userService.getUserDao());
        assertEquals("UserDao", userService.getUserDao().toString());
    }

    /**
     * 测试构造函数注入
     */
    @Test
    public void testConstructorInjection() {
        // 创建BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 注册UserDao
        BeanDefinition userDaoBeanDefinition = new BeanDefinition(TestUserDao.class);
        beanFactory.registerBeanDefinition("userDao", userDaoBeanDefinition);

        // 注册UserService
        BeanDefinition userServiceBeanDefinition = new BeanDefinition(TestUserServiceWithConstructor.class);
        beanFactory.registerBeanDefinition("userServiceWithConstructor", userServiceBeanDefinition);

        // 获取UserService，通过构造函数注入UserDao
        System.out.println("开始获取userServiceWithConstructor");
        TestUserServiceWithConstructor userService = (TestUserServiceWithConstructor) beanFactory.getBean("userServiceWithConstructor", new Object[]{beanFactory.getBean("userDao")});
        System.out.println("获取到userServiceWithConstructor: " + userService);
        System.out.println("userDao: " + userService.getUserDao());

        // 验证构造函数注入
        assertNotNull(userService.getUserDao());
        assertEquals("UserDao", userService.getUserDao().toString());
    }
}
