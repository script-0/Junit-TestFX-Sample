module com.script0.testfx {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.controlsfx.controls;
    requires  javafx.graphics;
    requires org.testfx.junit5;

    exports com.script0.testfx to org.testfx.junit5, javafx.graphics;
    opens com.script0.testfx to org.testfx.junit5,  javafx.graphics;
}