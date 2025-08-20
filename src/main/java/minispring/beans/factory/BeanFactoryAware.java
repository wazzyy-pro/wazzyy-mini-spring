package minispring.beans.factory;

import minispring.beans.BeansException;

/**
 * @Description BeanFactoryAware接口
 * 实现此接口的Bean会在创建过程中被注入BeanFactory
 * @Author wazzyy
 * @Date 2025/8/20
 */
public interface BeanFactoryAware {

    /**
     * 设置BeanFactory
     * 在Bean属性填充后、初始化前调用
     *
     * @param beanFactory 所属的BeanFactory
     * @throws BeansException 如果设置过程中发生错误
     */
    void setBeanFactory(BeanFactory beanFactory) throws BeansException;
}
