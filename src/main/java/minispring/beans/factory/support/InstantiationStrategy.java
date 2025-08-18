package minispring.beans.factory.support;

import minispring.beans.BeansException;
import minispring.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @Description Bean实例化策略接口
 * 定义如何实例化Bean的策略，允许使用不同的实例化机制
 * @Author wazzyy
 * @Date 2025/8/16
 */
public interface InstantiationStrategy {

    /**
     * 实例化Bean
     * @param beanDefinition Bean定义
     * @param beanName Bean名称
     * @param ctor 要使用的构造函数，如果为null则使用默认的构造函数
     * @param args 构造函数参数，如果为null则表示没有参数（等同于空数组）
     * @return 实例化Bean对象
     * @throws BeansException 如果实例化失败
     */
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor<?> ctor, Object[] args) throws BeansException;
}
