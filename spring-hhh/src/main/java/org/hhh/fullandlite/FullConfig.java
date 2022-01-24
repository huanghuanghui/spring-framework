package org.hhh.fullandlite;

import org.hhh.mycomponet.Student;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FullConfig {
    @Bean
    public Student studentA() {
        Student student = new Student();
        student.setName("StudentA");
        return student;
    }
    @Bean
    public Student studentB() {
        System.out.println("------------------full------------------");
        Student student = new Student();
        student.setName("StudentB");
        //full模式下：调用StudentA()多少次都是返回容器中注入的同一个Bean
        System.out.println("StudentB1:"+System.identityHashCode(studentA()));
        System.out.println("StudentB2:"+System.identityHashCode(studentA()));
        System.out.println("StudentB3:"+(studentA()== studentA())); //true

        return student;
    }
    private static class InnerConfig {
        @Bean
        public final Student studentInner() {
            Student student = new Student();
            student.setName("studentInner");
            return student;
        }
    }
}
