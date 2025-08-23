package minispring.test.bean;

/**
 * @Description 用户数据访问接口
 * 用于测试IOC容器
 * @Author wazzyy
 * @Date 2025/8/21
 */
public interface UserDao {

    /**
     * 根据用户名查询用户信息
     * @param userName 用户名
     * @return 用户信息
     */
    String queryUserName(String userName);
}
