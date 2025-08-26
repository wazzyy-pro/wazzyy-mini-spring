package minispring.beans.factory.xml;

/**
 * @Description 命名空间处理器解析器接口
 * 用于根据命名空间URI解析对应的命名空间处理器
 * @Author wazzyy
 * @Date 2025/8/25
 */
public interface NamespaceHandlerResolver {

    /**
     * 根据命名空间URI解析对应的命名空间处理器
     *
     * @param namespaceUri 命名空间URI
     * @return 对应的命名空间处理器，如果没有找到则返回null
     */
    NamespaceHandler resolve(String namespaceUri);
}
