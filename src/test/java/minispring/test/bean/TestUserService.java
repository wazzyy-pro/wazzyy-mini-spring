package minispring.test.bean;

/**
 * @Description 测试用户服务类（属性注入）
 * @Author wazzyy
 * @Date 2025/8/25
 */
public class TestUserService {
    private String name;
    private TestUserDao userDao;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TestUserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(TestUserDao userDao) {
        this.userDao = userDao;
    }
}
