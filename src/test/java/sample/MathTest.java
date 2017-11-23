package sample;

import sample.*;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by Администратор on 23.11.2017.
 */
public class MathTest {

    MathLab mathLab = null;

    @Before
    public void initTest(){
        mathLab = new MathLab("Hey");
    }

    @After
    public void endTest(){
        mathLab =  null;
    }

    @Test
    public void first(){
        assertTrue(mathLab.pow(5,5)==25.0);
    }

    @Test(expected = RuntimeException.class)
    public void second(){
        mathLab.makeExeption();
    }

    @Test
    public void third(){
        assertTrue(mathLab.name.equals("Hey"));
    }
}
