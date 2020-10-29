package com.example.demo.pojo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * 由于在BussinessPerson中注入了Animal接口，因此BussinessPerson需要一个唯一的bean。
 * Dog和Cat都实现了Animal接口，如果同时将Dog和Cat标注为@Component，那么将会出现类型为Animal的多个bean，错误如下：
 * <p>
 * Description:
 * <p>
 * Field animal in com.example.demo.pojo.BussinessPerson required a single bean, but 2 were found:
 * - cat: defined in file [/home/w/IdeaProjects/demo/target/classes/com/example/demo/pojo/Cat.class]
 * - dog: defined in file [/home/w/IdeaProjects/demo/target/classes/com/example/demo/pojo/Dog.class]
 * <p>
 * <p>
 * Action:
 * <p>
 * Consider marking one of the beans as @Primary, updating the consumer to accept multiple beans, or using @Qualifier to identify the bean that should be consumed
 * <p>
 * 此时只能向容器中一个Animal的实现类的bean。
 * <p>
 * 当然@Autowired可以解决这个问题，@Autowired提供这样的规则，首先会根据它的类型找到对应的bean（会从ApplicationContext中搜寻符合指定类型的所有bean），
 * 如果类型对应的bean不是唯一的，那么它会根据其属性名称和bean的名称进行匹配，如果匹配的上，就会使用该bean；如果还无法匹配，就会抛出异常。
 */

@Component
@Primary
public class Cat implements Animal {
    @Override
    public void use() {
        System.out.println("Cat");
    }
}
