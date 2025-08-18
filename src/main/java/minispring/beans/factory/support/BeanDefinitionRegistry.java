package minispring.beans.factory.support;

import minispring.beans.BeansException;
import minispring.beans.factory.config.BeanDefinition;

/**
 * @Description BeanDefinition注册表接口
 * 定义注册BeanDefinition的方法
 * @Author wazzyy
 * @Date 2025/8/16
 */
public interface BeanDefinitionRegistry {

    /**
     * 注册BeanDefinition
     * @param beanName Bean名称
     * @param beanDefinition Bean定义
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    /**
     * 获取BeanDefinition
     * @param beanName Bean名称
     * @return Bean定义
     * @throws BeansException 如果找不到BeanDefinition
     */
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;

    /**
     * 判断是否包含指定名称的BeanDefinition
     * @param beanName Bean名称
     * @return 是否包含
     */
    boolean containsBeanDefinition(String beanName);
}
