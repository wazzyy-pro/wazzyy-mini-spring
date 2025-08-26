package minispring.test;

import minispring.beans.factory.config.BeanDefinition;
import minispring.beans.factory.support.DefaultListableBeanFactory;
import minispring.beans.factory.xml.XmlBeanDefinitionReader;
import minispring.core.io.DefaultResourceLoader;
import minispring.core.io.Resource;
import minispring.test.bean.LifecycleBean;
import minispring.test.bean.PrototypeBean;
import minispring.test.bean.TestBean;
import minispring.test.service.TestService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description XML Bean定义读取器测试类
 * @Author wazzyy
 * @Date 2025/8/26
 */
public class XmlBeanDefinitionReaderTest {

    private DefaultListableBeanFactory beanFactory;
    private XmlBeanDefinitionReader beanDefinitionReader;

    @BeforeEach
    void setUp() {
        // 创建Bean工厂
        beanFactory = new DefaultListableBeanFactory();
        // 创建Bean定义读取器
        beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory);
    }

    @Test
    void testLoadBeanDefinitions() {
        // 加载Bean定义
        DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
        Resource resource = resourceLoader.getResource("classpath:spring.xml");
        beanDefinitionReader.loadBeanDefinitions(resource);

        // 验证Bean定义数量
        assertEquals(6, beanFactory.getBeanDefinitionNames().length);

        // 验证Bean定义内容
        BeanDefinition testBeanDefinition = beanFactory.getBeanDefinition("testBean");
        assertEquals(TestBean.class, testBeanDefinition.getBeanClass());
        assertEquals(1, testBeanDefinition.getPropertyValues().getPropertyValues().length);

        BeanDefinition testServiceDefinition = beanFactory.getBeanDefinition("testService");
        assertEquals(TestService.class, testServiceDefinition.getBeanClass());
        assertEquals(2, testServiceDefinition.getPropertyValues().getPropertyValues().length);

        BeanDefinition lifecycleBeanDefinition = beanFactory.getBeanDefinition("lifecycleBean");
        assertEquals(LifecycleBean.class, lifecycleBeanDefinition.getBeanClass());
        assertEquals("init", lifecycleBeanDefinition.getInitMethodName());
        assertEquals("destroy", lifecycleBeanDefinition.getDestroyMethodName());

        BeanDefinition prototypeBeanDefinition = beanFactory.getBeanDefinition("prototypeBean");
        assertEquals(PrototypeBean.class, prototypeBeanDefinition.getBeanClass());
        assertTrue(prototypeBeanDefinition.isPrototype());
        assertFalse(prototypeBeanDefinition.isSingleton());
    }
}
