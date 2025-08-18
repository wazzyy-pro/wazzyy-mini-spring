package minispring.beans.factory.support;

import minispring.beans.BeansException;
import minispring.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @Description 抽象自动装配Bean工厂
 * 实现创建Bean的功能
 * @Author wazzyy
 * @Date 2025/8/16
 */
public class AbstractAutowireCapableBeanFactory extends AbstractBeanFactory {

    private InstantiationStrategy instantiationStrategy = new CglibSubclassingInstantiationStrategy();

    /**
     * 设置实例化策略
     * @param instantiationStrategy 实例化策略
     */
    public void setInstantiationStrategy(InstantiationStrategy instantiationStrategy) {
        this.instantiationStrategy = instantiationStrategy;
    }

    public InstantiationStrategy getInstantiationStrategy() {
        return this.instantiationStrategy;
    }

    /**
     * 创建Bean实例
     * @param beanName Bean名称
     * @param beanDefinition Bean定义
     * @param args 构造参数
     * @return Bean实例
     * @throws BeansException 如果创建Bean失败
     */
    @Override
    protected Object createBean(String beanName, BeanDefinition beanDefinition, Object[] args) throws BeansException {
        Object bean = null;
        try {
            // 创建Bean实例
            bean = createBeanInstance(beanDefinition, beanName, args) {

            }
        }
    }

    /**
     * 创建Bean实例
     * @param beanDefinition Bean定义
     * @param beanName Bean名称
     * @param args 构造参数
     * @return Bean实例
     */
    protected Object createBeanInstance(BeanDefinition beanDefinition, String beanName, Object[] args) {
        System.out.println("创建Bean实例: " + beanName + ", 构造参数: " + (args != null ? args.length : 0));

        // 获取所有构造函数
        Constructor<?>[] declaredConstructors = beanDefinition.getBeanClass().getDeclaredConstructors();

        // 创建构造函数解析器
        ConstructorResolver
    }
}
