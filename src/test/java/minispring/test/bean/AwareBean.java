package minispring.test.bean;

import minispring.beans.BeansException;
import minispring.beans.factory.BeanFactory;
import minispring.beans.factory.BeanFactoryAware;
import minispring.beans.factory.BeanNameAware;

/**
 * @Description Aware接口测试Bean类
 * 实现BeanNameAware和BeanFactoryAware接口
 * @Author wazzyy
 * @Date 2025/8/27
 */
public class AwareBean implements BeanNameAware, BeanFactoryAware {

    private String beanName;
    private BeanFactory beanFactory;

    @Override
    public void setBeanName(String name) {
        System.out.println("AwareBean.setBeanName: " + name);
        this.beanName = name;
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("AwareBean.setBeanFactory: " + beanFactory);
        this.beanFactory = beanFactory;
    }

    public String getBeanName() {
        return beanName;
    }

    public BeanFactory getBeanFactory() {
        return beanFactory;
    }
}
