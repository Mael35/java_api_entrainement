package fr.lernejo.navy_battle;

import org.junit.jupiter.api.Test;

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
    void TooMany_Argument_False() {
        org.assertj.core.api.Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> Launcher.main(new String[] {"2100", "2200"}))
            .withMessage("Argument error !");
    }

    @Test
    void Word_Argument_False() {
        org.assertj.core.api.Assertions.assertThatExceptionOfType(NumberFormatException.class)
            .isThrownBy(() -> Launcher.main(new String[] {"Word argument false"}))
            .withMessage("The port is not a number !");
    }

    @Test
    void Negative_Argument_False() {
        org.assertj.core.api.Assertions.assertThatExceptionOfType(ArithmeticException.class)
            .isThrownBy(() -> Launcher.main(new String[] {"-2100"}))
            .withMessage("The number of the port is not available (between 1024 and 65535) !");
    }

    @Test
    void OutRange_Argument_False() {
        org.assertj.core.api.Assertions.assertThatExceptionOfType(ArithmeticException.class)
            .isThrownBy(() -> Launcher.main(new String[] {"200000000"}))
            .withMessage("The number of the port is not available (between 1024 and 65535) !");
    }
}
