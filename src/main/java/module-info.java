module pl.twisz.javafxclientapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires lombok;
    requires spring.web;

    opens pl.twisz.javafxclientapp to javafx.fxml;
    opens pl.twisz.javafxclientapp.controller to javafx.fxml;

    exports pl.twisz.javafxclientapp;
    exports pl.twisz.javafxclientapp.controller;
    exports pl.twisz.javafxclientapp.dto;
    exports pl.twisz.javafxclientapp.table;
}