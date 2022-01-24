package org.hhh.fullandlite;

import org.hhh.mycomponet.User;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component  
public class LiteConfig {
    @Bean
    public User userA() {
        User user= new User ();
        user.setName("userA");
        return user;
    }
    //可以是private的方法
    @Bean
    private User userB() {
        System.out.println("------------------lite------------------");
        User user= new User ();
        user.setName("userB");
        //lite模式下:调用userA()方法会生成一个新的Bean
        System.out.println("userB1:"+System.identityHashCode(userA()));
        System.out.println("userB2:"+System.identityHashCode(userA()));
        //返回false
        System.out.println("userB3:"+(userA()== userA()));
        return user;
    }
	//内部类可以是任意模式
    private static class InnerConfig {
        @Bean
        //lit模式下方法可以使用private final修饰
        private final User userInner() { 
            User user= new User ();
            user.setName("userInner");
            return user;
        }
    }
}