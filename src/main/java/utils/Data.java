package utils;

import config.Properties;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class Data {

    static Properties props = ConfigFactory.create(Properties.class);

    public static Stream<Arguments> loginTestWithLoginAndPassword() {
        return Stream.of(
                Arguments.of(props.login(), props.password())
        );
    }

    public static Stream<Arguments> loginTestWithIncorrectData() {
        return Stream.of(
                Arguments.of(props.login(), Utilities.generatesRandomString(), "Неверные данные для авторизации"),
                Arguments.of(Utilities.generatesRandomString(), props.password(), "Неверные данные для авторизации"),
                Arguments.of(Utilities.generatesRandomString(), Utilities.generatesRandomString(), "Неверные данные для авторизации"),
                Arguments.of("", "", "Неверные данные для авторизации."),
                Arguments.of(props.login(), "", "Неверные данные для авторизации."),
                Arguments.of("", props.password(), "Неверные данные для авторизации.")
        );
    }

    public static Stream<Arguments> showPassword() {
        return Stream.of(
                Arguments.of(props.password())
        );
    }
}
