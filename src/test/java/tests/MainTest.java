package tests;
import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.control.LabeledMatchers.hasText;

import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import com.script0.testfx.Main;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.BeforeClass;
import org.testfx.util.WaitForAsyncUtils;

public class MainTest extends ApplicationTest {
    
    /**
     * Use glass robot.
     * Note: this must happen once before the class is loaded. Otherwise,
     * the very first test run uses the awt robot
     */
    @BeforeClass
    public static void config() throws Exception {
        System.getProperties().put("testfx.robot", "glass");
    }
    
    @Override public void start(Stage stage) {
        Main.startForTests(stage);
    }

    @Test public void should_contain_button() {
        // expect:
        verifyThat(".button", hasText("click me!"));
    }

    @Test public void should_click_on_button() {
        // when:
        clickOn(".button");
        WaitForAsyncUtils.waitForFxEvents();
        // then:
        verifyThat(".button", hasText("clicked!"));
    }
}