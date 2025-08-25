package minispring.test.bean;

/**
 * @Description 测试用户服务类（构造函数注入）
 * @Author wazzyy
 * @Date 2025/8/25
 */
public class TestUserServiceWithConstructor {
    private final TestUserDao userDao;

    public TestUserServiceWithConstructor() {
        this.userDao = null;
    }

    public TestUserServiceWithConstructor(TestUserDao userDao) {
        this.userDao = userDao;
    }

    public TestUserDao getUserDao() {
        return userDao;
    }
}
