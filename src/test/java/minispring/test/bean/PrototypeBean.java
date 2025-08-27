package minispring.test.bean;

/**
 * @Description 原型Bean类
 * 用于测试原型作用域
 * @Author wazzyy
 * @Date 2025/8/26
 */
public class PrototypeBean {

    private String name;
    private long createTime;

    public PrototypeBean() {
        this.createTime = System.currentTimeMillis();
        System.out.println("PrototypeBean构建函数，创建时间：" + createTime);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getCreateTime() {
        return createTime;
    }

    @Override
    public String toString() {
        return "PrototypeBean{" +
                "name='" + name + '\'' +
                ", createTime=" + createTime +
                '}';
    }
}
