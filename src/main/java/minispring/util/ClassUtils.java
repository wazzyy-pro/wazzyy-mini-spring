package minispring.util;

/**
 * @Description 类工具，提供类加载器相关的实用方法
 * @Author wazzyy
 * @Date 2025/8/20
 */
public class ClassUtils {

    public static ClassLoader getDefaultClassLoader() {
        ClassLoader cl = null;
        try {
            // 首先，尝试获取当前线程的上下文类加载器
            cl = Thread.currentThread().getContextClassLoader();
        } catch (Throwable ex) {
            // 无法访问线程上下文类加载器，忽略
        }
        if (cl == null) {
            // 其次，使用ClassUtils类的类加载器
            cl = ClassUtils.class.getClassLoader();
            if (cl == null) {
                // 最后，使用系统类加载器
                try {
                    cl = ClassLoader.getSystemClassLoader();
                } catch (Throwable ex) {
                    // 无法获取系统类加载器，忽略
                }
            }
        }
        return cl;
    }

    /**
     * 判断给定的类是否存在
     * @param className 类名
     * @param classLoader 类加载器
     * @return true 表示类存在，false 表示类不存在
     */
    public static boolean isPresent(String className, ClassLoader classLoader) {
        try {
            Class.forName(className, false, classLoader);
            return true;
        } catch (ClassNotFoundException e) {
            return false;
        }
    }
}
