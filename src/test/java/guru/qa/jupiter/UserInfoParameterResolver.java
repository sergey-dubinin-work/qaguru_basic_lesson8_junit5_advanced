package guru.qa.jupiter;

import guru.qa.domain.UserInfo;
import org.junit.jupiter.api.extension.*;

public class UserInfoParameterResolver implements ParameterResolver {
    @Override
    public boolean supportsParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        return parameterContext.getParameter().getType().isAssignableFrom(UserInfo.class);
    }

    @Override
    public UserInfo resolveParameter(ParameterContext parameterContext, ExtensionContext extensionContext) throws ParameterResolutionException {
        UserInfo userInfo = new UserInfo();
        userInfo.login = "Sergey";
        userInfo.password = "123456";

        return userInfo;
    }
}
