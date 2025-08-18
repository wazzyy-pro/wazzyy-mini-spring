package minispring.beans;

/**
 * @Description
 * Bean异常
 * Spring Bean相关异常的基类
 * @Author wazzyy
 * @Date 2025/8/15
 */
public class BeansException extends RuntimeException {

    /**
     * 创建一个新的Bean异常
     * @param message 异常消息
     */
    public BeansException(String message) {
        super(message);
    }

    /**
     * 创建一个新的Bean异常
     * @param message 异常消息
     * @param cause 原始异常
     */
    public BeansException(String message, Throwable cause) {
        super(message, cause);
    }

}
