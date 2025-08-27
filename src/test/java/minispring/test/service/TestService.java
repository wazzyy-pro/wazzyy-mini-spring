package minispring.test.service;

import minispring.test.bean.TestBean;

/**
 * @Description 测试服务类
 * @Author wazzyy
 * @Date 2025/8/26
 */
public class TestService {

    private TestBean testBean;
    private String message;

    public TestService() {
    }

    public TestBean getTestBean() {
        return testBean;
    }

    public void setTestBean(TestBean testBean) {
        this.testBean = testBean;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getServiceInfo() {
        return message + " - " + testBean.toString();
    }

    @Override
    public String toString() {
        return "TestService{" +
                "testBean=" + testBean +
                ", message='" + message + '\'' +
                '}';
    }
}
