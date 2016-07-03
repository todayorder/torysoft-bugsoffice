package com.torysoft.bugsoffice;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "com.torysoft", nameGenerator = BOBeanNameGenerator.class)
public class Application {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(Application.class, args);
	}
}

class BOBeanNameGenerator implements BeanNameGenerator {
	@Override
	public String generateBeanName(BeanDefinition define, BeanDefinitionRegistry registry) {
		return define.getBeanClassName();
	}
}
