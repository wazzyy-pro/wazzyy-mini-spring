package minispring.beans;

/**
 * @Description 类型转换器接口
 * 用于在属性注入过程中将值转换为目标类型
 * @Author wazzyy
 * @Date 2025/8/18
 */
public interface TypeConverter {

    /**
     * 将值转换为指定类型
     * @param value 要转换的值
     * @param requiredType 目标类型
     * @return 转换后的值
     * @param <T> 目标类型
     * @throws TypeMismatchException 如果转换失败
     */
    <T> T converter(Object value, Class<T> requiredType) throws TypeMismatchException;
}
