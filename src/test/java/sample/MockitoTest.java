package sample;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.instanceOf;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
/**
 * Created by Администратор on 23.12.2017.
 */
public class MockitoTest {
    TwitterManager tm;

    @Before
    public void create(){
        tm = mock(TwitterManager.class);
        when(tm.pow(2,5)).thenReturn(25.0);
        when(tm.getTimeline()).thenReturn(new StringBuffer("not connected to Twitter API, this is just a mock test"));
        when(tm.getFollowersCount()).thenReturn(new Integer(0));
    }

    @Test
    public void powTest(){
        assertTrue(25.0 == tm.pow(2, 5));
    }

    @Test
    public void timeLineTestBeforeConnection(){
        assertThat(tm.getTimeline(),instanceOf(StringBuffer.class));
    }

    @Test
    public void FollowerCount(){
        assertTrue(tm.getFollowersCount()==0);
        assertThat(tm.getFollowersCount(), instanceOf(Integer.class));
    }
}
