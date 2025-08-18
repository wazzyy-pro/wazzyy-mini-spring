package minispring.beans.factory.support;

import minispring.beans.TypeConverter;
import minispring.core.ParameterNameDiscoverer;

import java.util.Set;

/**
 * @Description 构造函数解析器
 * 用于解析构造函数参数并进行自动装配
 * @Author wazzyy
 * @Date 2025/8/18
 */
public class ConstructorResolver {

    private final AbstractAutowireCapableBeanFactory beanFactory;
    private final TypeConverter typeConverter;
    private final ParameterNameDiscoverer parameterNameDiscoverer;
    private final Set<String> inCreationBeans;

    /**
     * 创建一个构造函数解析器
     *
     * @param beanFactory Bean工厂
     */
    public ConstructorResolver(AbstractAutowireCapableBeanFactory beanFactory) {

    }
}