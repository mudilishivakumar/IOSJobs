package testcases;

import org.testng.annotations.AfterSuite;

import java.io.IOException;

public class SuiteTearDown {

    @AfterSuite
    public void globalTearDown() throws IOException {
        BaseTest base = new BaseTest();
        base.globalTearDown();
    }
}


