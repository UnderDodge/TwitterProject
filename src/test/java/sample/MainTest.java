package sample;

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import twitter4j.TwitterException;

/**
 * Created by Администратор on 23.11.2017.
 */
public class MainTest {

    TwitterManager twitterManager = null;

    @Before
    public void initTest(){
        try {
            twitterManager = new TwitterManager("XdJgymhQZ3FV7ecVnXRj0nUHB","67glpCgL9epmVr3sejm39m94SarWnfcZXNRhEFDkmbTTYuaV9w", "932883775436087296-ehtoMqyZgnYEaaYDN6nWinEEIFHOp7K" , "83oTKx5R0Q0RLCXfzTNdJqJwmLYAdWZ0fdk60srMKytga");
        } catch (TwitterException e) {
            e.printStackTrace();
        }
    }

    @After
    public void endTest(){
        twitterManager =  null;
    }

    @Test(expected = TwitterException.class)
    public void firstTest(){
        twitterManager.makeTwitterExeprionTest();
    }

    @Test
    public void secondTest(){
        assertTrue(twitterManager.pow(5,5)==25.0);
    }

}
