package hello.core.autowired;

import hello.core.member.Member;
import jakarta.annotation.Nullable;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.annotation.Annotation;
import java.util.Optional;

public class AutowiredTest {

    @Test
    void AutowiredOption() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext();
    }

    static class TestBean {

        public void setNoBean1(Member noBean1) {
            System.out.println("noBean1 = " + noBean1);
        }

        public void setNoBean2(@Nullable Member noBean2) {
            System.out.println("noBean2 =" + noBean2);
        }

        public void setNoBean1(Optional<Member> noBean3) {
            System.out.println("noBean3 = " + noBean3);
        }
    }
}
