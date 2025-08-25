package minispring.test;

import minispring.beans.BeanWrapper;
import minispring.beans.PropertyValue;
import minispring.beans.PropertyValues;
import minispring.beans.factory.config.BeanDefinition;
import minispring.beans.factory.support.CglibSubclassingInstantiationStrategy;
import minispring.beans.factory.support.DefaultListableBeanFactory;
import minispring.beans.factory.support.InstantiationStrategy;
import minispring.beans.factory.support.SimpleInstantiationStrategy;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Constructor;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Description 实例化策略和Bean包装器测试
 * @Author wazzyy
 * @Date 2025/8/23
 */
public class InstantiationStrategyTest {

    /**
     * 测试JDK反射实例化策略
     * @throws Exception 如果实例化失败
     */
    @Test
    public void testSimpleInstantiationStrategy() throws Exception {
        // 创建BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 创建BeanDefinition
        BeanDefinition beanDefinition = new BeanDefinition(TestBean.class);

        // 创建JDK反射实例化策略
        InstantiationStrategy strategy = new SimpleInstantiationStrategy();

        // 使用无参构造函数实例化
        Object bean1 = strategy.instantiate(beanDefinition, "testBean", null, null);
        assertNotNull(bean1);
        assertInstanceOf(TestBean.class, bean1);

        // 使用有参构造函数实例化
        Constructor<?> ctor = TestBean.class.getDeclaredConstructor(String.class, int.class);
        Object bean2 = strategy.instantiate(beanDefinition, "testBean", ctor, new Object[]{"test", 42});
        assertNotNull(bean2);
        assertInstanceOf(TestBean.class, bean2);
        assertEquals("test", ((TestBean) bean2).getName());
        assertEquals(42, ((TestBean) bean2).getAge());
    }

    /**
     * 测试CGLIB实例化策略
     * @throws Exception 如果实例化失败
     */
    @Test
    public void testCglibSubclassingInstantiationStrategy() throws Exception {
        // 创建BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 创建BeanDefinition
        BeanDefinition beanDefinition = new BeanDefinition(TestBean.class);

        // 创建CGLIB实例化策略
        InstantiationStrategy strategy = new CglibSubclassingInstantiationStrategy();

        // 使用无参构造函数实例化
        Object bean1 = strategy.instantiate(beanDefinition, "testBean", null, null);
        assertNotNull(bean1);
        assertInstanceOf(TestBean.class, bean1);

        // 使用有参构造函数实例化
        Constructor<?> ctor = TestBean.class.getDeclaredConstructor(String.class, int.class);
        Object bean2 = strategy.instantiate(beanDefinition, "testBean", ctor, new Object[]{"test", 42});
        assertNotNull(bean2);
        assertInstanceOf(TestBean.class, bean2);
        assertEquals("test", ((TestBean) bean2).getName());
        assertEquals(42, ((TestBean) bean2).getAge());
    }

    /**
     * 测试BeanWrapper
     */
    @Test
    public void testBeanWrapper() {
        // 创建测试Bean
        TestBean testBean = new TestBean("test", 42);

        // 创建BeanWrapper
        BeanWrapper beanWrapper = new BeanWrapper(testBean);

        // 测试获取包装的Bean实例
        Object wrappedInstance = beanWrapper.getWrappedInstance();
        assertNotNull(wrappedInstance);
        assertInstanceOf(TestBean.class, wrappedInstance);
        assertEquals(testBean, wrappedInstance);

        // 测试获取包装的Bean类型
        Class<?> wrappedClass = beanWrapper.getWrappedClass();
        assertEquals(TestBean.class, wrappedClass);
    }

    /**
     * 测试类型转换和属性填充
     */
    @Test
    public void testPropertyValuesAndTypeConversion() {
        // 创建BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 注册BeanDefinition
        BeanDefinition beanDefinition = new BeanDefinition(TestBean.class);

        // 设置属性值
        PropertyValues propertyValues = new PropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("name", "test"));
        propertyValues.addPropertyValue(new PropertyValue("age", "42"));
        beanDefinition.setPropertyValues(propertyValues);

        beanFactory.registerBeanDefinition("testBean", beanDefinition);

        // 获取Bean
        TestBean testBean = (TestBean) beanFactory.getBean("testBean");

        // 验证属性值
        assertEquals("test", testBean.getName());
        assertEquals(42, testBean.getAge());
    }

    /**
     * 测试BeanWrapper的嵌套属性支持
     */
    @Test
    public void testNestedProperty() {
        // 创建父Bean
        TestBean parent = new TestBean("parent", 50);

        // 创建子Bean
        TestBean child = new TestBean("child", 20);

        // 设置父子关系
        parent.setChild(child);

        // 创建BeanWrapper
        BeanWrapper wrapper = new BeanWrapper(parent);

        // 测试获取嵌套属性
        assertEquals("child", wrapper.getPropertyValue("child.name"));
        assertEquals(20, wrapper.getPropertyValue("child.age"));

        // 测试设置嵌套属性
        wrapper.setPropertyValue("child.name", "updatedChild");
        wrapper.setPropertyValue("child.age", 25);

        assertEquals("updatedChild", child.getName());
        assertEquals(25, child.getAge());

        // 测试自动创建嵌套对象
        TestBean newParent = new TestBean("newParent", 60);
        BeanWrapper newWrapper = new BeanWrapper(newParent);

        // 设置嵌套属性，此时child为null，应该自动创建
        newWrapper.setPropertyValue("child.name", "autoCreatedChild");
        newWrapper.setPropertyValue("child.age", 10);

        assertNotNull(newParent.getChild());
        assertEquals("autoCreatedChild", newParent.getChild().getName());
        assertEquals(10, newParent.getChild().getAge());
    }

    /**
     * 测试Bean类
     */
    public static class TestBean {
        // 使用public字段，便于测试
        public String name;
        public int age;
        private TestBean child;

        public TestBean() {

        }

        public TestBean(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public TestBean getChild() {
            return child;
        }

        public void setChild(TestBean child) {
            this.child = child;
        }
    }
}
