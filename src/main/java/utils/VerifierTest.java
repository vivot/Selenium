package utils;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import tests.BaseTest;

public class VerifierTest extends BaseTest {
    @Test
    public void testHardAssertion() {
        // Verifier.assertEquals( "Teo","Ti" );

        Assert.assertEquals( "Teo", "Ti", "Display username is different" );
        Assert.assertTrue( true );
        Assert.assertFalse( false );
        Assert.fail( "" );
        //



    }
@Test
    public void testSoftAssertion() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals( 1, 2 );
        softAssert.assertTrue( true );
        softAssert.assertFalse( true );
        softAssert.fail("I want to");
        softAssert.assertAll();

    }
}
