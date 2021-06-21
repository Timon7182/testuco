package kz.uco.testwork.web.screens.account;

import com.haulmont.cuba.gui.screen.ScreenOptions;

import java.util.UUID;

public class ScreenOptionsOrder implements ScreenOptions {

    private UUID message;

    public ScreenOptionsOrder(UUID message) {
        this.message = message;
    }

    public UUID getMessage() {
        return message;
    }
}
