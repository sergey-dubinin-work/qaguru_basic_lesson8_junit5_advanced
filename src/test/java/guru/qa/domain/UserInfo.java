package guru.qa.domain;

public class UserInfo {

    public String login;
    public String password;

    @Override
    public String toString() {
        return String.format(
                "login: %s, password: %s",
                login,
                password
                );
    }
}
