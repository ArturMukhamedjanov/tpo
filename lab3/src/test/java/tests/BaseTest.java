package tests;

import core.TestContext;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public abstract class BaseTest {
    protected TestContext context;

    @BeforeEach
    public void setUp() {
        context = new TestContext("chrome");
    }

    @AfterEach
    public void tearDown() {
        if (context != null) {
            context.close();
        }
    }
}