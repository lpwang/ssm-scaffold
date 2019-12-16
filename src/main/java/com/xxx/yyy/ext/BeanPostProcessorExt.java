package com.xxx.yyy.ext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * beanPostProcessor可以在bean初始化之后对bean做些处理。
 * 同样的策略模式调用
 */
@Component
public class BeanPostProcessorExt implements BeanPostProcessor {

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("studentService")) {
            System.out.println("postProcessBeforeInitialization is called , beanName is => " + beanName);
        }
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if (beanName.equals("studentService")) {
            System.out.println("postProcessAfterInitialization is called , beanName is => " + beanName);
        }
        return bean;
    }
}
