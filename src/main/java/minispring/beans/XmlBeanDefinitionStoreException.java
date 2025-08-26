package minispring.beans;

/**
 * @Description XML Bean定义存储异常
 * 用于处理XML解析过程中的异常
 * @Author wazzyy
 * @Date 2025/8/25
 */
public class XmlBeanDefinitionStoreException extends BeansException {

    /**
     * 构造函数
     * @param message 异常信息
     */
    public XmlBeanDefinitionStoreException(String message) {
        super(message);
    }

    /**
     * 构造函数
     * @param message 异常信息
     * @param cause 原始异常
     */
    public XmlBeanDefinitionStoreException(String message, Throwable cause) {
        super(message, cause);
    }
}
