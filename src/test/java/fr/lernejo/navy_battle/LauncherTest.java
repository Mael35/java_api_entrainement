package fr.lernejo.navy_battle;

import org.junit.jupiter.api.Test;

import java.io.IOException;


class LauncherTest {

    @Test
    void Argument_True() {
        org.assertj.core.api.Assertions.assertThatNoException()
            .isThrownBy(() -> Launcher.main(new String[] {"2000"}));
    }

    @Test
    void No_Argument_False() {
        org.assertj.core.api.Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> Launcher.main(new String[] {}))
            .withMessage("Argument error !");
    }

    @Test
    void Two_Argument_True() throws IOException {
        Http_Server http_server1 = new Http_Server("2100");
        http_server1.createServer();
        org.assertj.core.api.Assertions.assertThatNoException()
            .isThrownBy(() -> Launcher.main(new String[] {"2200", "http://localhost:2100"}));
    }

    @Test
    void Two_Argument_False() {
        org.assertj.core.api.Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> Launcher.main(new String[] {"-10000", "http://localhost:2300"}))
            .withMessage("Port out of range !");
    }

    @Test
    void TooMany_Argument_False() {
        org.assertj.core.api.Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> Launcher.main(new String[] {"2400", "2500", "2600"}))
            .withMessage("Argument error !");
    }
}
