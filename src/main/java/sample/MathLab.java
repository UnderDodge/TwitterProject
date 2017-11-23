package sample;

/**
 * Created by Администратор on 23.11.2017.
 */
public class MathLab {

    String name;
    MathLab(String name){
        this.name=name;
    }

    public double pow(double a, double b){
        return Math.pow(a,b);
    }

    public void makeExeption(){
        new RuntimeException();
    }
}
