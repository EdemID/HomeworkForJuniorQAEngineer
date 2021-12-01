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

    public static Stream<Arguments> loginTestWithLogin() {
        return Stream.of(
                Arguments.of(props.login(), Utilities.generatesRandomString())
        );
    }

    public static Stream<Arguments> loginTestWithPassword() {
        return Stream.of(
                Arguments.of(Utilities.generatesRandomString(), props.password())
        );
    }

    public static Stream<Arguments> loginTestWithIncorrectData() {
        return Stream.of(
                Arguments.of(Utilities.generatesRandomString(), Utilities.generatesRandomString())
        );
    }

    public static Stream<Arguments> loginTestWithoutLoginAndPassword() {
        return Stream.of(
                Arguments.of("", "")
        );
    }

    public static Stream<Arguments> loginTestWithLoginAndWithoutPassword() {
        return Stream.of(
                Arguments.of(props.login(), "")
        );
    }

    public static Stream<Arguments> loginTestWithPasswordAndWithoutLogin() {
        return Stream.of(
                Arguments.of("", props.password())
        );
    }
}
