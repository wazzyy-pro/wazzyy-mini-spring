package minispring.core;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

/**
 * @Description 参数名称发现接口
 * 用于获取方法和构造函数的参数名称
 * @Author wazzyy
 * @Date 2025/8/18
 */
public interface ParameterNameDiscoverer {

    /**
     * 获取方法的参数名称
     * @param method 方法
     * @return 参数名称数组，如果无法获取则返回null
     */
    String[] getParameterNames(Method method);

    /**
     * 获取构造函数的参数名称
     * @param constructor 构造函数
     * @return 参数名称数组，如果无法获取则返回null
     */
    String[] getParameterNames(Constructor<?> constructor);
}
