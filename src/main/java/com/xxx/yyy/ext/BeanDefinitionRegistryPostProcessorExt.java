package com.xxx.yyy.ext;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanDefinitionRegistryPostProcessor;
import org.springframework.stereotype.Component;

/**
 * 在bean的ioc容器和beandefinition创建在ioc容器之后调用，spring使用策略模式对实现BeanDefinitionRegistryPostProcessor
 * 的实现类进行调用。可以在这个阶段进行beandefinition的属性的读取和修改。
 *
 * 这里面需要注意的是，由于使用的是父子容器，所以在这里是获取不到ctrl层的bean,如果有对ctrl层bean修改的需求，可以不使用
 * 父子容器，合并成一个容器便可以获取到。
 */
@Component
public class BeanDefinitionRegistryPostProcessorExt implements BeanDefinitionRegistryPostProcessor {

    public void postProcessBeanDefinitionRegistry(BeanDefinitionRegistry registry) throws BeansException {
        BeanDefinition studentService = registry.getBeanDefinition("studentService");
        String beanClassName = studentService.getBeanClassName();
        System.out.println("postProcessBeanDefinitionRegistry is called , get beandefinition is => " + beanClassName);
    }

    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

    }
}
