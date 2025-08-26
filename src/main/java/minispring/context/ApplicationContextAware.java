package minispring.context;

import minispring.beans.BeansException;

/**
 * @Description ApplicationContextAware接口
 * 实现此接口的Bean会在创建过程中被注入ApplicationContext
 * @Author wazzyy
 * @Date 2025/8/26
 */
public interface ApplicationContextAware {

    /**
     * 设置ApplicationContext
     * 在Bean属性填充后、初始化前调用
     *
     * @param applicationContext 所属的ApplicationContext
     * @throws BeansException 设置ApplicationContext失败
     */
    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
