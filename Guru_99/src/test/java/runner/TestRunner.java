package runner;

import java.util.Collections;

import org.testng.TestNG;

public class TestRunner {

    public static void main(String[] args) {

        TestNG testng = new TestNG();

        testng.setTestSuites(Collections.singletonList(System.getProperty("user.dir")+ "/testng.xml"));

        testng.run();
    }
}