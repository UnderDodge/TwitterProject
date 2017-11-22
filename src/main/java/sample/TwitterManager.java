package sample;

import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

/**
 * Created by Администратор on 19.11.2017.
 */
public class TwitterManager {

    Twitter twitter;

    TwitterManager(String key1, String key2, String key3, String key4) throws TwitterException{
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
                .setOAuthConsumerKey(key1)
                .setOAuthConsumerSecret(key2)
                .setOAuthAccessToken(key3)
                .setOAuthAccessTokenSecret(key4);
        TwitterFactory tf = new TwitterFactory(cb.build());
        twitter = tf.getInstance();
    }



    public StringBuffer getTimeline(){
        ResponseList<Status> list = null;
        StringBuffer str = new StringBuffer();
        int count = 0;
        try {
            list = twitter.getHomeTimeline();
            for (Status st: list){
                count++;
                str.append("\n");
                str.append("Tweet №"+count+": \n");
                str.append(st.getUser().getName()+"\n"+st.getText());
                System.out.println(st.getUser().getName() + "--------------" + st.getText());
                str.append("\n");
            }
        } catch (TwitterException e) {
            e.printStackTrace();
        }
        return str;
    }




}
