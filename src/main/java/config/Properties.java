package config;

import org.aeonbits.owner.Config;
import org.aeonbits.owner.Reloadable;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "file:src/test/resources/tests.properties"
})
public interface Properties extends Reloadable {

    @Key("mirapolis.url")
    String mirapolisurl();

    @Key("login")
    String login();

    @Key("password")
    String password();
}
