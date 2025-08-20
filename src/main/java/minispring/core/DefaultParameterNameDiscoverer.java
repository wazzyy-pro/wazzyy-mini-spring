package minispring.core;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;

/**
 * @Description 默认参数名称发现器
 * 基于Java 8的反射API实现参数名称发现
 * @Author wazzyy
 * @Date 2025/8/19
 */
public class DefaultParameterNameDiscoverer implements ParameterNameDiscoverer {

    @Override
    public String[] getParameterNames(Method method) {
        Parameter[] parameters = method.getParameters();
        String[] parameterNames = new String[parameters.length];

        for (int i = 0; i < parameters.length; i++) {
            Parameter parameter = parameters[i];
            if (parameter.isNamePresent()) {
                parameterNames[i] = parameter.getName();
            } else {
                parameterNames[i] = "arg" + i;
            }
        }
        return parameterNames;
    }

    @Override
    public String[] getParameterNames(Constructor<?> constructor) {
        Parameter[] parameters = constructor.getParameters();
        String[] parameterNames = new String[parameters.length];

        for (int i = 0; i < parameterNames.length; i++) {
            Parameter parameter = parameters[i];
            if (parameter.isNamePresent()) {
                parameterNames[i] = parameter.getName();
            } else {
                parameterNames[i] = "arg" + i;
            }
        }

        return parameterNames;
    }
}
