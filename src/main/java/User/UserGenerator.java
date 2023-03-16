package User;

import com.github.javafaker.Faker;

public class UserGenerator {
    static Faker faker = new Faker();

    public LoginUser random() {
        return new LoginUser(faker.name().username() + "@yandex.ru", faker.animal().name());
    }
}
