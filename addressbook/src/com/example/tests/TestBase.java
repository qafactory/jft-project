package com.example.tests;

import com.example.framework.ApplicationManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class TestBase {
    protected ApplicationManager app;

    @BeforeTest
    public void setUp() throws Exception {
        app = new ApplicationManager();
    }

    @AfterTest
    public void tearDown() throws Exception {
        app.stop();
    }
}
