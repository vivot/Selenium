package utils;

public class Verifier {
    public static void assertEquals(String actual, String expected){
        //handle exception for date
        if(! actual.equals( expected ))
        {
            throw new RuntimeException("[Assertion error] Expecting "+actual+"to be equal: "+expected);
        }

    }
}
