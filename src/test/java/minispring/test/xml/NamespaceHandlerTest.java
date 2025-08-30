package minispring.test.xml;

import minispring.beans.factory.support.DefaultListableBeanFactory;
import minispring.beans.factory.xml.XmlBeanDefinitionReader;
import minispring.core.io.ClassPathResource;
import minispring.core.io.Resource;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @Description 命名空间处理器测试类
 * @Author wazzyy
 * @Date 2025/8/30
 */
public class NamespaceHandlerTest {

    @Test
    void testBeanDefinitionLoading() {
        // 创建Bean工厂
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 创建XML Bean定义读取器
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);

        // 加载XML配置文件
        Resource resource = new ClassPathResource("bean-definitions.xml");
        reader.loadBeanDefinitions(resource);

        // 验证Bean定义是否正确加载
        assertNotNull(beanFactory.getBeanDefinition("person"));
        assertNotNull(beanFactory.getBeanDefinition("address"));

        System.out.println("成功加载 Bean 定义：person, address");
    }
}
