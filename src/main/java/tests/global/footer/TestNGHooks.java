package tests.global.footer;

import org.testng.annotations.*;

public class TestNGHooks {

    /**
     * BeforeSuite
     * BeforeTest
     * BeforeClass  : chay truoc test group
     **/

    @BeforeSuite
    public void BeforeSuite() {
        System.out.println("\t before suite");

    }

    @BeforeTest
    public void BeforeTest() {
        System.out.println("\t\t before test");

    }

    @BeforeClass
    public void BeforeClass() {
        System.out.println("\t\t\t before class");
    }

    @BeforeMethod
    public void BeforeMethod() {
        System.out.println("\t\t\t\t Before Method");

    }
    @Test
    public void test1() {
        System.out.println("\t\t\t\t Test method 01");
    }   @Test
    public void test2() {
        System.out.println("\t\t\t\t Test method 02");
    }
}
