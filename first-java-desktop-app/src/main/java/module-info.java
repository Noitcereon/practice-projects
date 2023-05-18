module me.noitcereon.firstjavadesktopapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens me.noitcereon.firstjavadesktopapp to javafx.fxml;
    exports me.noitcereon.firstjavadesktopapp;
}