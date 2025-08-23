package minispring.test.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 用户数据访问实现类
 * 用于测试IoC容器
 * @Author wazzyy
 * @Date 2025/8/22
 */
public class UserDaoImpl implements UserDao {

    private static final Map<String, String> userMap = new HashMap<>();

    static {
        userMap.put("张三", "北京市");
        userMap.put("李四", "上海市");
        userMap.put("王五", "广州市");
    }

    @Override
    public String queryUserName(String userName) {
        return userMap.get(userName);
    }
}
