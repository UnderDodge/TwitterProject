package sample;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import twitter4j.TwitterException;
import sample.*;

/**
 * Created by Администратор on 23.11.2017.
 */
public class MainTest {


    /*
    @Before
    public void initTest(){
        try {
            TwitterManager twitterManager = new TwitterManager("XdJgymhQZ3FV7ecVnXRj0nUHB","67glpCgL9epmVr3sejm39m94SarWnfcZXNRhEFDkmbTTYuaV9w", "932883775436087296-ehtoMqyZgnYEaaYDN6nWinEEIFHOp7K" , "83oTKx5R0Q0RLCXfzTNdJqJwmLYAdWZ0fdk60srMKytga");
        } catch (TwitterException e) {
            e.printStackTrace();
        }
    }

    @After
    public void endTest(){
        twitterManager =  null;
    }
    */

    

    @Test(expected = TwitterException.class)
    public void firstTest(){
        TwitterManager twitterManager = null;
        try {
            twitterManager =  new TwitterManager("XdJgymhQZ3FV7ecVnXRj0nUHB","67glpCgL9epmVr3sejm39m94SarWnfcZXNRhEFDkmbTTYuaV9w", "932883775436087296-ehtoMqyZgnYEaaYDN6nWinEEIFHOp7K" , "83oTKx5R0Q0RLCXfzTNdJqJwmLYAdWZ0fdk60srMKytga");
        } catch (TwitterException e) {
            e.printStackTrace();
        }

        twitterManager.makeTwitterExeprionTest();

    }

    @Test
    public void secondTest(){
        TwitterManager twitterManager = null;
        try {
            twitterManager =  new TwitterManager("XdJgymhQZ3FV7ecVnXRj0nUHB","67glpCgL9epmVr3sejm39m94SarWnfcZXNRhEFDkmbTTYuaV9w", "932883775436087296-ehtoMqyZgnYEaaYDN6nWinEEIFHOp7K" , "83oTKx5R0Q0RLCXfzTNdJqJwmLYAdWZ0fdk60srMKytga");
        } catch (TwitterException e) {
            e.printStackTrace();
        }
        assertTrue(twitterManager.pow(5,5)==25.0);
    }
	
	@Test
    public void stringCheckTest(){
        TwitterManager twitterManager = null;
        try {
            twitterManager =  new TwitterManager("XdJgymhQZ3FV7ecVnXRj0nUHB","67glpCgL9epmVr3sejm39m94SarWnfcZXNRhEFDkmbTTYuaV9w", "932883775436087296-ehtoMqyZgnYEaaYDN6nWinEEIFHOp7K" , "83oTKx5R0Q0RLCXfzTNdJqJwmLYAdWZ0fdk60srMKytga");
        } catch (TwitterException e) {
            e.printStackTrace();
        }
        assertNotNull(twitterManager);
    }

    @Test(expected = ArithmeticException.class)
    public void stringCheckMulty(){
        TwitterManager twitterManager = null;
        try {
            twitterManager =  new TwitterManager("XdJgymhQZ3FV7ecVnXRj0nUHB","67glpCgL9epmVr3sejm39m94SarWnfcZXNRhEFDkmbTTYuaV9w", "932883775436087296-ehtoMqyZgnYEaaYDN6nWinEEIFHOp7K" , "83oTKx5R0Q0RLCXfzTNdJqJwmLYAdWZ0fdk60srMKytga");
        } catch (TwitterException e) {
            e.printStackTrace();
        }
        twitterManager.quickMathsDevide(10,0);
    }
    
}
