##1、使用IDEA创建maven工程

说明：社区版没有Spring插件，无法新建Spring工程,需要创建Maven工程，然后自己修改配置文件（详见下文）；如果是旗舰版，直接新建Spring工程即可,参考<https://blog.csdn.net/lom9357bye/article/details/69677120>

![1](https://github.com/hduxyz/springBootDemo/blob/master/src/main/resources/img/1.png)

![2](https://github.com/hduxyz/springBootDemo/blob/master/src/main/resources/img/2.png)

![3](https://github.com/hduxyz/springBootDemo/blob/master/src/main/resources/img/3.png)



##2、修改pom.xml文件

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.zhouxy</groupId>
    <artifactId>helloWord</artifactId>
    <version>1.0.0.1</version>

    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>1.4.3.RELEASE</version>
    </parent>

    <dependencies>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
            <version>1.4.3.RELEASE</version>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
            </plugin>
        </plugins>
    </build>

</project>
```



##3、新增class文件

```java
package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class HelloWord {
    public static void main(String[] args) {
        SpringApplication.run(HelloWord.class, args);
    }

    @RequestMapping("/")
    public String hello() {
        return "hello,spring boot";
    }

}

```



##4、启动

1、命令行中启动

```shell
mvn  clean
mvn  install
mvn  spring-boot:run
```

2、IDEA中直接run



##5、访问

浏览器输入<http://localhost:8080/>



##6、遇到的错误

###1、报错 Unable to  start embedded container

Unable to start embedded container; nested exception is org.springframework.context.ApplicationContextException: Unable to start EmbeddedWebApplicationContext due to missing EmbeddedServletContainerFactory bean.



在类头加上  @EnableAutoConfiguration，就OK了。



###2、errorPageFilter  冲突问题

org.springframework.beans.factory.BeanDefinitionStoreException:  Failed to parse configuration class [Controller]; nested exception is  org.springframework.context.annotation.ConflictingBeanDefinitionException:  Annotation-specified bean name 'errorPageFilter' for bean class  [org.springframework.boot.web.support.ErrorPageFilter] conflicts with  existing, non-compatible bean definition of same name and class  [org.springframework.boot.context.web.ErrorPageFilter]



其实是配置类没有放到package中，而是放在了默认包下。只要随意放到一个package下就不会有问题了。