package minispring.test.bean;

import minispring.beans.factory.DisposableBean;
import minispring.beans.factory.InitializingBean;

/**
 * @Description 生命周期Bean类（使用接口方式）
 * 实现InitializingBean和DisposableBean接口
 * @Author wazzyy
 * @Date 2025/8/27
 */
public class LifecycleBeanWithInterface implements InitializingBean, DisposableBean {

    private String name;
    private boolean initialized = false;
    private boolean destroyed = false;

    public LifecycleBeanWithInterface() {
        System.out.println("LifecycleBeanWithInterface构造函数");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("LifecycleBeanWithInterface的afterPropertiesSet方法");
        this.initialized = true;
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("LifecycleBeanWithInterface的destroy方法");
        this.destroyed = true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isInitialized() {
        return initialized;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    @Override
    public String toString() {
        return "LifecycleBeanWithInterface{" +
                "name='" + name + '\'' +
                ", initialized=" + initialized +
                ", destroyed=" + destroyed +
                '}';
    }
}
