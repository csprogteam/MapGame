import java.io.File;
import java.util.Random;

import javafx.scene.media.AudioClip;
//import java.net.MalformedURLException;

public class MapBGM{
    private static int a = 1;
    public static void BGM(){
        for(int i = 1; i<=5; i++){
            try{
                AudioClip ac1 = new AudioClip(new File("bgm/BGM1.1.mp3").toURL().toString());
                AudioClip ac2 = new AudioClip(new File("bgm/BGM1.2.mp3").toURL().toString());
                AudioClip ac3 = new AudioClip(new File("bgm/BGM1.3.mp3").toURL().toString());
                AudioClip ac4 = new AudioClip(new File("bgm/BGM1.4.mp3").toURL().toString());
                AudioClip ac5 = new AudioClip(new File("bgm/BGM1.5.mp3").toURL().toString());

                //Random r = new Random();
                //int n = r.nextInt(5);

                //if(n == 0){
                    //do{
                        ac1.setCycleCount(AudioClip.INDEFINITE);
                        ac1.play();
                        ac1.setVolume(3);
                        ac1.setRate(1);
                    //}while(true);
                    //ac1.stop();
                //}
                /*if(n == 1){
                    do{
                        ac2.setCycleCount(AudioClip.INDEFINITE);
                        ac2.play();
                        ac2.setVolume(3);
                        ac2.setRate(1);
                    }while(true);
                    ac2.stop();
                }
                if(n == 2){
                    do{
                        ac3.setCycleCount(AudioClip.INDEFINITE);
                        ac3.play();
                        ac3.setVolume(3);
                        ac3.setRate(1);
                    }while(true);
                    ac3.stop();
                }
                if(n == 3){
                    do{
                        ac4.setCycleCount(AudioClip.INDEFINITE);
                        ac4.play();
                        ac4.setVolume(3);
                        ac4.setRate(1);
                    }while(true);
                    ac4.stop();
                }
                if(n == 4){
                    do{
                        ac5.setCycleCount(AudioClip.INDEFINITE);
                        ac5.play();
                        ac5.setVolume(3);
                        ac5.setRate(1);
                    }while(true);
                    ac5.stop();
                }*/
            }catch(Exception e){
                System.err.print(e);
            }
        }
    }

    public static void walk(){
        try{
            AudioClip walk = new AudioClip(new File("bgm/1_walk.mp3").toURL().toString());
            walk.play();
            walk.setVolume(4);
            walk.setRate(1);
        }catch(Exception e){
            System.err.print(e);
        }
    }

    public static void wall(){
        try{
            AudioClip wall = new AudioClip(new File("bgm/2_wall.mp3").toURL().toString());
            wall.play();
            wall.setVolume(4);
            wall.setRate(1);
        }catch(Exception e){
            System.err.print(e);
        }
    }

    public static void bouns(){
        try{
            AudioClip bouns = new AudioClip(new File("bgm/3_bouns.mp3").toURL().toString());
            bouns.play();
            bouns.setVolume(4);
            bouns.setRate(1);
        }catch(Exception e){
            System.err.print(e);
        }
    }

    public static void minus(){
        try{
            AudioClip minus = new AudioClip(new File("bgm/4_minus.mp3").toURL().toString());
            minus.play();
            minus.setVolume(4);
            minus.setRate(1);
        }catch(Exception e){
            System.err.print(e);
        }
    }

    public static void key(){
        try{
            AudioClip key = new AudioClip(new File("bgm/3_key.mp3").toURL().toString());
            key.play();
            key.setVolume(4);
            key.setRate(1);
        }catch(Exception e){
            System.err.print(e);
        }
    }

    public static void goal(){
        try{
            AudioClip open = new AudioClip(new File("bgm/5_open.mp3").toURL().toString());
            AudioClip goal = new AudioClip(new File("bgm/6_goal.mp3").toURL().toString());
            open.play();
            open.setVolume(4);
            open.setRate(1);
            Thread.sleep(2000);
            open.stop();
            //open.setFramePosition(0);
            Thread.sleep(500);

            goal.play();
            open.setVolume(4);
            open.setRate(1);
            Thread.sleep(5000);
            goal.stop();;
            //goal.setFramePosition(0);

        }catch(Exception e){
            System.err.print(e);
        }
    }

    public static void locked(){
        try{
            AudioClip locked = new AudioClip(new File("bgm/7_locked.mp3").toURL().toString());
            locked.play();
            locked.setVolume(4);
            locked.setRate(1);
        }catch(Exception e){
            System.err.print(e);
        }
    }

    public static void over(){
        try{
            AudioClip over = new AudioClip(new File("bgm/3_over.mp3").toURL().toString());
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
