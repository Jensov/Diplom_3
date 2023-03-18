package User;

import com.github.javafaker.Faker;

public class UserGenerator {
    static Faker faker = new Faker();

    public RegistrationUser random() {
        return new RegistrationUser(faker.name().username() + "@yandex.ru", faker.internet().password(), faker.name().name());
    }
}
