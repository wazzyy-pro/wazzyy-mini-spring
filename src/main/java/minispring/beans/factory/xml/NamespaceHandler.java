package minispring.beans.factory.xml;

import minispring.beans.BeansException;
import minispring.beans.factory.support.BeanDefinitionRegistry;
import org.dom4j.Element;

/**
 * @Description 命名空间处理器接口
 * 用于处理XML中的自定义命名空间
 * @Author wazzyy
 * @Date 2025/8/25
 */
public interface NamespaceHandler {

    /**
     * 初始化命名空间处理器
     */
    void init();

    /**
     * 解析命名空间元素
     *
     * @param element 要解析的元素
     * @param registry Bean定义注册表
     * @throws BeansException 如果无法解析元素
     */
    void parse(Element element, BeanDefinitionRegistry registry) throws BeansException;

    /**
     * 解析自定义属性
     *
     * @param element 包含属性的元素
     * @param attributeName 属性名
     * @param registry Bean定义注册表
     * @throws BeansException 如果无法解析属性
     */
    void decorate(Element element, String attributeName, BeanDefinitionRegistry registry) throws BeansException;
}
