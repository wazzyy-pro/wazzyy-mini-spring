package minispring.test;

import minispring.beans.factory.config.BeanDefinition;
import minispring.beans.factory.support.DefaultListableBeanFactory;
import minispring.test.bean.LifecycleBean;
import minispring.test.bean.LifecycleBeanWithInterface;
import minispring.test.processor.CustomBeanPostProcessor;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @Description Bean生命周期测试类
 * @Author wazzyy
 * @Date 2025/8/27
 */
public class BeanLifecycleTest {

    @Test
    void testBeanLifecycle() {
        // 创建Bean工厂
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 添加BeanPostProcessor
        beanFactory.addBeanPostProcessor(new CustomBeanPostProcessor());

        // 注册Bean定义（使用配置方法）
        BeanDefinition beanDefinition = new BeanDefinition(LifecycleBean.class);
        beanDefinition.setInitMethodName("init");
        beanDefinition.setDestroyMethodName("destroy");
        beanFactory.registerBeanDefinition("lifecycleBean", beanDefinition);

        // 注册Bean定义（使用接口方式
        BeanDefinition beanDefinition2 = new BeanDefinition(LifecycleBeanWithInterface.class);
        beanFactory.registerBeanDefinition("lifecycleBeanWithInterface", beanDefinition2);

        // 获取Bean
        LifecycleBean lifecycleBean = beanFactory.getBean("lifecycleBean", LifecycleBean.class);
        LifecycleBeanWithInterface lifecycleBeanWithInterface = beanFactory.getBean("lifecycleBeanWithInterface", LifecycleBeanWithInterface.class);

        // 验证Bean已经初始化
        assertTrue(lifecycleBean.isInitialized());
        assertFalse(lifecycleBean.isDestroyed());
        assertTrue(lifecycleBeanWithInterface.isInitialized());
        assertFalse(lifecycleBeanWithInterface.isDestroyed());

        // 销毁Bean
        beanFactory.destroySingletons();
    }

    @Test
    void testBeanPostProcessor() {
        // 创建Bean工厂
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 添加BeanPostProcessor
        CustomBeanPostProcessor postProcessor = new CustomBeanPostProcessor();
        beanFactory.addBeanPostProcessor(postProcessor);

        // 注册Bean定义
        BeanDefinition beanDefinition = new BeanDefinition(LifecycleBean.class);
        beanDefinition.setInitMethodName("init");
        beanFactory.registerBeanDefinition("lifecycleBean", beanDefinition);

        // 获取Bean
        LifecycleBean lifecycleBean = beanFactory.getBean("lifecycleBean", LifecycleBean.class);

        // 验证Bean已经初始化
        assertTrue(lifecycleBean.isInitialized());
    }
}
