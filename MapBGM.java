import java.io.File;
import java.util.Random;
import java.lang.Object;
import javafx.beans.property.IntegerProperty;

import javafx.scene.media.AudioClip;
import java.net.MalformedURLException;

public class MapBGM{
    private static int a = 1;
    private static AudioClip ac1;
    private static AudioClip ac2;
    private static AudioClip ac3;
    private static AudioClip ac4;
    private static AudioClip ac5;
    public static void BGM(){
            try{
                ac1 = new AudioClip(new File("bgm/BGM1.1.mp3").toURI().toString());
                ac2 = new AudioClip(new File("bgm/BGM1.2.mp3").toURI().toString());
                ac3 = new AudioClip(new File("bgm/BGM1.3.mp3").toURI().toString());
                ac4 = new AudioClip(new File("bgm/BGM1.4.mp3").toURI().toString());
                ac5 = new AudioClip(new File("bgm/BGM1.5.mp3").toURI().toString());

                Random r = new Random();
                int n = r.nextInt(5);
                if(n == 0){
                    ac1.setCycleCount(AudioClip.INDEFINITE);
                    ac1.cycleCountProperty();
                    ac1.play();
                    ac1.setVolume(3);
                    ac1.setRate(1);
                }
                if(n == 1){
                    ac2.setCycleCount(AudioClip.INDEFINITE);
                    ac2.cycleCountProperty();
                    ac2.play();
                    ac2.setVolume(3);
                    ac2.setRate(1);
                }
                if(n == 2){
                    ac3.setCycleCount(AudioClip.INDEFINITE);
                    ac3.cycleCountProperty();
                    ac3.play();
                    ac3.setVolume(3);
                    ac3.setRate(1);
                }
                if(n == 3){
                    ac4.setCycleCount(AudioClip.INDEFINITE);
                    ac4.cycleCountProperty();
                    ac4.play();
                    ac4.setVolume(3);
                    ac4.setRate(1);
                }
                if(n == 4){
                    ac5.setCycleCount(AudioClip.INDEFINITE);
                    ac5.cycleCountProperty();
                    ac5.play();
                    ac5.setVolume(3);
                    ac5.setRate(1);
                }
            }catch(Exception e){
                System.err.print(e);
            }
        }

    public static void walk(){
        try{
            AudioClip walk = new AudioClip(new File("bgm/1_walk.mp3").toURI().toString());
            walk.play();
            walk.setVolume(4);
            walk.setRate(1);
        }catch(Exception e){
            System.err.print(e);
        }
    }

    public static void wall(){
        try{
            AudioClip wall = new AudioClip(new File("bgm/2_wall.mp3").toURI().toString());
            wall.play();
            wall.setVolume(4);
            wall.setRate(1);
        }catch(Exception e){
            System.err.print(e);
        }
    }

    public static void bouns(){
        try{
            AudioClip bouns = new AudioClip(new File("bgm/3_bouns.mp3").toURI().toString());
            bouns.play();
            bouns.setVolume(4);
            bouns.setRate(1);
        }catch(Exception e){
            System.err.print(e);
        }
    }

    public static void minus(){
        try{
            AudioClip minus = new AudioClip(new File("bgm/4_minus.mp3").toURI().toString());
            minus.play();
            minus.setVolume(4);
            minus.setRate(1);
        }catch(Exception e){
            System.err.print(e);
        }
    }

    public static void key(){
        try{
            AudioClip key = new AudioClip(new File("bgm/3_key.mp3").toURI().toString());
            key.play();
            key.setVolume(4);
            key.setRate(1);
        }catch(Exception e){
            System.err.print(e);
        }
    }

    public static void goal(){
        try{
            ac1.stop();
            ac2.stop();
            ac3.stop();
            ac4.stop();
            ac5.stop();
            
            AudioClip open = new AudioClip(new File("bgm/5_open.mp3").toURI().toString());
            AudioClip goal = new AudioClip(new File("bgm/6_goal.mp3").toURI().toString());
            open.play();
            open.setVolume(4);
            open.setRate(1);
            Thread.sleep(2000);
            open.stop();
            Thread.sleep(500);

            goal.play();
            open.setVolume(4);
            open.setRate(1);
            Thread.sleep(5000);
            goal.stop();;

        }catch(Exception e){
            System.err.print(e);
        }
    }

    public static void locked(){
        try{
            AudioClip locked = new AudioClip(new File("bgm/7_locked.mp3").toURI().toString());
            locked.play();
            locked.setVolume(4);
            locked.setRate(1);
        }catch(Exception e){
            System.err.print(e);
        }
    }

    public static void over(){
        try{
            AudioClip over = new AudioClip(new File("bgm/3_over.mp3").toURI().toString());
            over.play();
            over.setVolume(4);
            over.setRate(1);
        }catch(Exception e){
            System.err.print(e);
        }
    }

    public static void setA(int x){
        a = x;
    }
}
