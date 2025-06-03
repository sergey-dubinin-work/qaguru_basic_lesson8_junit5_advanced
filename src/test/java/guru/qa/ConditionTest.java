package guru.qa;

import guru.qa.jupiter.OnlyProdEnv;
import org.junit.jupiter.api.Test;

public class ConditionTest {


    @Test
    void test1() {
        System.out.println("test1");
    }

    @OnlyProdEnv
    @Test
    void test2() {
        System.out.println("test2");
    }

}
