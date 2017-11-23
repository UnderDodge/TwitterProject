package sample;

import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

/**
 * Created by Администратор on 19.11.2017.
 */
public class TwitterManager {

    Twitter twitter;

    PagableResponseList<User> followers = null;

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

    public int getFollowersCount(){
        try {
            followers = twitter.getFollowersList(twitter.getId(), -1);
            return followers.size();
        } catch (TwitterException e) {
            e.printStackTrace();
            return 0;
        }
    }

    public String getYourProfilePicture(){
        try {
            return twitter.users().showUser(twitter.getId()).getBiggerProfileImageURL();
        } catch (TwitterException e) {
            return null;
        }
    }

    //this methods are just for Lab3, we need them to add some simple tests
    public void makeTwitterExeprionTest(){
        new TwitterException("test exeption");
    }

    public int quickMathsMultyply(int a, int b){
        return a*b;
    }
    //this one too
    public int quickMathsDevide(int a, int b){
        return a/b;
    }
    //and this one....
    public double pow(double a, double b){
        return Math.pow(a,b);
    }





}
