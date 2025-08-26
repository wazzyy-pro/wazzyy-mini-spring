package minispring.beans.factory.xml;

import minispring.beans.BeansException;
import minispring.beans.factory.support.BeanDefinitionRegistry;
import org.dom4j.Document;

/**
 * @Description Bean定义文档读取器接口
 * 用于从XML文档中读取Bean定义并注册到BeanDefinitionRegistry
 * @Author wazzyy
 * @Date 2025/8/25
 */
public interface BeanDefinitionDocumentReader {

    /**
     * 从Document中读取Bean定义
     *
     * @param document 要解析的XML文档
     * @param registry Bean定义注册表，用于注册解析出的Bean定义
     * @throws BeansException 读取Bean定义时发生的异常
     */
    void registerBeanDefinitions(Document document, BeanDefinitionRegistry registry) throws BeansException;
}
