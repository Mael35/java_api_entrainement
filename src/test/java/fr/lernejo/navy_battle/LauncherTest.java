package fr.lernejo.navy_battle;

import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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

    boolean Check_not_equals(String port1, String port2){
        return !Objects.equals(port1, port2)  ;
    }

    @Test
    void Not_Same_Argument_True() {
        String port1 = "2100";
        String port2 = "2200";
        assertTrue(Check_not_equals(port1, port2));
    }

    @Test
    void Same_Argument_False() {
        String port1 = "2300";
        String port2 = "2300";
        assertFalse(Check_not_equals(port1, port2));
    }

    @Test
    void TooMany_Argument_False() {
        org.assertj.core.api.Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> Launcher.main(new String[] {"2400", "2500", "2600"}))
            .withMessage("Argument error !");
    }
}
