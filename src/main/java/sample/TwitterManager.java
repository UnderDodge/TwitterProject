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


    public void setNewTweet(String text){
        int delayCount = 1;
        while(true) {
            try {
                twitter.updateStatus(text);
                break;
            } catch (TwitterException e) {
                System.out.println("Error");
                try {
                    Thread.sleep((int)(1000*Math.pow(delayCount,delayCount)));
                    if(delayCount>=5){
                        break;
                    }else{
                        delayCount++;
                    }
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }



    public StringBuffer getTimeline(){
        ResponseList<Status> list = null;
        StringBuffer str = new StringBuffer();
        int count = 0;
        int delayCount = 1;
        while(true){
            try {
                list = twitter.getHomeTimeline();
                for (Status st: list){
                    count++;
                    str.append("\n");
                    str.append("Tweet №"+count+": \n");
                    str.append(st.getUser().getName()+"\n"+st.getText());
                    System.out.println(st.getUser().getName() + "--------------" + st.getText());
                    str.append("\n");
                    return str;
                }
            } catch (TwitterException e) {
                System.out.println("Error");
                try {
                    Thread.sleep((int)(1000*Math.pow(delayCount,delayCount)));
                    if(delayCount>=5){
                        return null;
                    }else{
                        delayCount++;
                    }
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    public int getFollowersCount(){
        int delayCount = 1;
        while(true) {
            try {
                followers = twitter.getFollowersList(twitter.getId(), -1);
                return followers.size();
            } catch (TwitterException e) {
                System.out.println("Error");
                try {
                    Thread.sleep((int) (1000 * Math.pow(delayCount, delayCount)));
                    if (delayCount >= 5) {
                        return 0;
                    } else {
                        delayCount++;
                    }
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
            }
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
