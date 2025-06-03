package guru.qa;

import guru.qa.domain.UserInfo;
import guru.qa.jupiter.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

public class ParameterResolverTest {

    @Test
    @DisplayName("ParameterResolverTest")
    void firstTest(TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName());
    }

    @Test
    void secondTest(@User UserInfo userInfo) {
        System.out.println(userInfo);
    }
}
