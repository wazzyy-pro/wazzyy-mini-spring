package minispring.context;

import minispring.beans.factory.ListableBeanFactory;
import minispring.core.env.Environment;

/**
 * @Description ApplicationContext接口
 * Spring上下文，继承ListableBeanFactory接口，提供更多企业级功能
 * @Author wazzyy
 * @Date 2025/8/26
 */
public interface ApplicationContext extends ListableBeanFactory {

    /**
     * 获取应用上下文的名称
     * @return 应用上下文名称
     */
    String getApplicationName();

    /**
     * 获取应用上下文的启动时间
     * @return 启动时间（毫秒）
     */
    long getStartupDate();

    /**
     * 获取Environment
     * @return Environment
     */
    Environment getEnvironment();
}
