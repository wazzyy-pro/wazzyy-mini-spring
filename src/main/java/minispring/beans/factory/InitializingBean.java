package minispring.beans.factory;

/**
 * @Description Bean初始化接口
 * 实现此接口的Bena会在所有属性设置完成后执行afterPropertiesSet方法
 * 这是Spring生命周期中的一个重要扩展点
 * @Author wazzyy
 * @Date 2025/8/20
 */
public interface InitializingBean {

    /**
     * 在Bean的所有属性设置完成后调用
     * 可以在此方法中执行自定义的初始化逻辑
     *
     * @throws Exception 初始化过程中可能抛出的异常
     */
    void afterPropertiesSet() throws Exception;
}
