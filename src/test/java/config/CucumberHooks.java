package config;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;

public class CucumberHooks {

    @BeforeAll
    public static void beforeAll(){
        BaseTest.setup();
    }

    @AfterAll
    public static void afterAll(){
        BaseTest.closeSession();
    }

    @After
    public static void after(){
        BaseTest.resetApp();
    }
}

