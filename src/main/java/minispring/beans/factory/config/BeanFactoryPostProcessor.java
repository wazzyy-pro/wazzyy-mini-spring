package minispring.beans.factory.config;

import minispring.beans.BeansException;
import minispring.beans.factory.ConfigurableListableBeanFactory;

/**
 * @Description Bean工厂后处理器接口
 * 允许自定义修改应用上下文的Bean定义，调整上下文的Bean属性值
 * 在所有Bean定义加载完成后，但在Bean实例化之前调用
 * @Author wazzyy
 * @Date 2025/8/20
 */
public interface BeanFactoryPostProcessor {

    /**
     * 在Bean实例化之前修改Bean工厂中的Bean定义
     * @param beanFactory 可配置的Bean工厂
     * @throws BeansException 处理过程中的异常
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
