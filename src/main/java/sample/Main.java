package sample;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import twitter4j.TwitterException;


public class Main extends Application {

    BorderPane mainBorderPane = null;

    Button loginButton = new Button("Login");
    Button tagSearchButton = new Button("Search by tag");
    Button viewTimelineButton = new Button("Show Timeline");

    Text creditsText = new Text("Speedwagon team, IO-44 v0.1 ¯\\_(ツ)_/¯");
    Text key1 = new Text("Enter Consumer Key : ");
    Text key2 = new Text("Enter Consumer Key Secret : ");
    Text key3 = new Text("Enter Access Token : ");
    Text key4 = new Text("Enter Access Token Secret : ");
    Text followersCount = new Text();
    Text userName = new Text();
    Text errorExText = new Text();

    TextField consumerKey = new TextField("");
    TextField consumerKeySecret = new TextField("");
    TextField accessToken = new TextField("");
    TextField accessTokenSecret = new TextField("");

    TwitterManager twitter = null;

    GridPane mainCenteredGrid = null;

    Stage primaryStage = null;

    @Override
    public void start(Stage primaryStage) throws Exception{
        this.primaryStage = primaryStage;
        primaryStage.setTitle("Twitter API work,  Speedwagon team");
        primaryStage.setScene(setLoginScene());
        primaryStage.show();
        primaryStage.setFullScreen(true);
        initListener();
    }

    private void initListener(){
        loginButton.setOnMouseClicked((e)->{
            try {
                twitter = new TwitterManager(consumerKey.getText(), consumerKeySecret.getText(), accessToken.getText() , accessTokenSecret.getText());
                primaryStage.setScene(setMainScene());
                primaryStage.setFullScreen(true);
            } catch (TwitterException e1) {
                errorExText.setText("-- Wrong keys! --");
                errorExText.setFill(Color.RED);
                errorExText.setVisible(true);
            }
        });

        viewTimelineButton.setOnMouseClicked((e)->{
            setCenterAsTextField(twitter.getTimeline());
        });
    }


    private void setCenterAsTextField(StringBuffer str){
        //
        //text space for timeline n' shit
        //


        TextArea textArea1 = new TextArea();
        textArea1.setPrefHeight(600);
        textArea1.setPrefWidth(700);
        textArea1.setText(str.toString());

        mainCenteredGrid.add(textArea1,0,0);
    }

    private Scene setMainScene(){
        //-----------------------------------------main scene layout
        BorderPane topBorderPane = new BorderPane();
        GridPane userInfo = new GridPane();
        userInfo.setAlignment(Pos.CENTER);
        userInfo.setVgap(20);
        followersCount.setText("      Followers: " + String.valueOf(twitter.getFollowersCount()));
        followersCount.setFill(Color.WHITE);
        userInfo.add(new ImageView(twitter.getYourProfilePicture()), 0, 0);
        try {
            userName.setText(twitter.twitter.getScreenName());
            userName.setFill(Color.WHITE);
        } catch (TwitterException e) {
            e.printStackTrace();
        }
        userInfo.add(userName,1,0);
        userInfo.add(followersCount,2,0);

        GridPane topGrid = new GridPane();
        topBorderPane.setTop(userInfo);
        topBorderPane.setCenter(topGrid);
        topGrid.setHgap(20);

        topGrid.add(tagSearchButton,0,0);
        topGrid.add(viewTimelineButton,1,0);
        topGrid.setAlignment(Pos.CENTER);
        topGrid.setPadding(new Insets(30,30,30,30));

        mainCenteredGrid = new GridPane();
        mainCenteredGrid.setPadding(new Insets(10,10,10,10));
        mainCenteredGrid.setHgap(10);

        mainCenteredGrid.setAlignment(Pos.CENTER);

        GridPane bottomGrid = new GridPane();

        bottomGrid.setPadding(new Insets(10,10,10,10));
        bottomGrid.add(creditsText,0,0);
        bottomGrid.setAlignment(Pos.BOTTOM_CENTER);

        mainBorderPane = new BorderPane();
        mainBorderPane.setTop(topBorderPane);
        mainBorderPane.setCenter(mainCenteredGrid);
        mainBorderPane.setBottom(bottomGrid);
        mainBorderPane.setStyle("-fx-background: black");

        Scene nextScene = new Scene(mainBorderPane, 400, 500);

        return nextScene;
    }

    private Scene setLoginScene(){
        //------------------------------------------login scene layout
        GridPane topGrid = new GridPane();

        topGrid.add(errorExText,1,0);
        topGrid.setAlignment(Pos.CENTER);
        topGrid.setPadding(new Insets(30,30,30,30));
        topGrid.setVgap(100);

        errorExText.setVisible(false);

        GridPane centerGrid = new GridPane();

        centerGrid.setPadding(new Insets(10,10,10,10));
        centerGrid.setHgap(10);
        centerGrid.add(consumerKey,1,0);
        centerGrid.add(consumerKeySecret,1,1);
        centerGrid.add(accessToken,1,2);
        centerGrid.add(accessTokenSecret,1,3);
        centerGrid.add(key1,0,0);
        centerGrid.add(key2,0,1);
        centerGrid.add(key3,0,2);
        centerGrid.add(key4,0,3);

        HBox hblogin = new HBox(loginButton);
        HBox hbNull = new HBox();
        hbNull.setPadding(new Insets(10,10,10,10));
        loginButton.setPadding(new Insets(5,20,5,20));
        hblogin.setAlignment(Pos.CENTER_RIGHT);
        centerGrid.add(hbNull,1,4);
        centerGrid.add(hblogin,1,5);

        centerGrid.setAlignment(Pos.CENTER);

        GridPane bottomGrid = new GridPane();

        bottomGrid.setPadding(new Insets(10,10,10,10));
        bottomGrid.add(creditsText,0,0);
        bottomGrid.setAlignment(Pos.BOTTOM_CENTER);

        creditsText.setFill(Color.WHITE);
        errorExText.setFill(Color.WHITE);
        key1.setFill(Color.WHITE);
        key2.setFill(Color.WHITE);
        key3.setFill(Color.WHITE);
        key4.setFill(Color.WHITE);

        mainBorderPane = new BorderPane();
        mainBorderPane.setTop(topGrid);
        mainBorderPane.setCenter(centerGrid);
        mainBorderPane.setBottom(bottomGrid);
        mainBorderPane.setStyle("-fx-background: black");

        Scene nextScene = new Scene(mainBorderPane, 400, 500);

        return nextScene;
    }




    public static void main(String[] args) {

        launch(args);
    }
}
