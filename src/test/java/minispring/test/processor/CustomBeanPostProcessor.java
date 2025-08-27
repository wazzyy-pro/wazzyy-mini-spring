package minispring.test.processor;

import minispring.beans.BeansException;
import minispring.beans.factory.config.BeanPostProcessor;

/**
 * @Description 自定义BeanPostProcessor
 * 用于测试BeanPostProcessor的功能
 * @Author wazzyy
 * @Date 2025/8/27
 */
public class CustomBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor前置处理: " + beanName);
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("BeanPostProcessor后置处理: " + beanName);
        return bean;
    }
}
