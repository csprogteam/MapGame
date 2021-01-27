import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.scene.Group;
import javafx.scene.layout.Pane;

public class MapGameController implements Initializable {
    public Label scoreLabel;
    public Label restmovesLabel;
    public MapData mapData;
    public MoveChara chara;
    public GridPane mapGrid;
    public ImageView[] mapImageViews;

    private int mMax = 50;
    private int moves = 0;
    private int restmoves = mMax;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mapData = new MapData(21, 15, 1, 3, 2, 1, 5);
        chara = new MoveChara(1, 1, mapData);
        mapImageViews = new ImageView[mapData.getHeight()*mapData.getWidth()];
        drawMap(chara, mapData);
    }

    // Draw the map
    public void drawMap(MoveChara c, MapData m){
        int cx = c.getPosX();
        int cy = c.getPosY();
        scoreLabel.setText("Score: " + c.getScore());
        restmovesLabel.setText("Moves left: " + restmoves);
        mapGrid.getChildren().clear();
        for(int y=0; y<mapData.getHeight(); y++){
            for(int x=0; x<mapData.getWidth(); x++){
                int index = y*mapData.getWidth() + x;
                mapImageViews[index] = mapData.getImageView(x,y);
                if (x==cx && y==cy) {
                    mapGrid.add(c.getCharaImageView(), x, y);
                } else {
                    mapGrid.add(mapImageViews[index], x, y);
                }
            }
        }
    }

    // Get users key actions
    public void keyAction(KeyEvent event){
        KeyCode key = event.getCode(); System.out.println("keycode:"+key);
        if (key == KeyCode.H){
            leftButtonAction();
        }else if (key == KeyCode.J){
            downButtonAction();
        }else if (key == KeyCode.K){
            upButtonAction();
        }else if (key == KeyCode.L){
            rightButtonAction();
        }else if (key == KeyCode.O) {
            openGoalAction();
        }

        if ((key == KeyCode.H || key == KeyCode.J || key == KeyCode.K || key == KeyCode.L) &&  restmoves > 0){
            moves = moves + 1;
            restmoves -= 1;
            mMax = restmoves;
            System.out.println("restmoves " + restmoves + moves);
        }

    }

    // Operations for going the cat down
    public void upButtonAction(){
        printAction("UP");
        chara.setCharaDirection(MoveChara.TYPE_UP);
        chara.move(0, -1);
        drawMap(chara, mapData);
        MapBGM.walk();
    }

    // Operations for going the cat down
    public void downButtonAction(){
        printAction("DOWN");
        chara.setCharaDirection(MoveChara.TYPE_DOWN);
        chara.move(0, 1);
        drawMap(chara, mapData);
        MapBGM.walk();
    }

    // Operations for going the cat right
    public void leftButtonAction(){
        printAction("LEFT");
        chara.setCharaDirection(MoveChara.TYPE_LEFT);
        chara.move(-1, 0);
        drawMap(chara, mapData);
        MapBGM.walk();
    }

    // Operations for going the cat right
    public void rightButtonAction(){
        printAction("RIGHT");
        chara.setCharaDirection(MoveChara.TYPE_RIGHT);
        chara.move(1, 0);
        drawMap(chara, mapData);
        MapBGM.walk();
    }

    // Operation for opening the goal flag
    public void openGoalAction () {
        if (mapData.getMap(chara.getPosX(),chara.getPosY()) == MapData.TYPE_GOAL) {
            if (isOpenable()) {
                MapBGM.goal();
                printAction("OPEN");
            	 if (GoalWindow.onOpen()) {
                    int currentScore = chara.getScore();
                    chara.setScore(currentScore + 200);
                    mapData.setMap(chara.getPosX(),chara.getPosY(),MapData.TYPE_OPEN);
                    mapData.setImageViews();
                    drawMap(chara, mapData);
            	 }
                //ここでゴールを定義
            } else {
                printAction("OPENING FAIL");
                //ここで鍵不足メッセージの表示を定義
            	GoalWindow.onOpenFail();
                MapBGM.locked();
            }
        }
    }

    // Check if the requirements for opening are met
    public boolean isOpenable () {
        if (chara.getItem(MapData.TYPE_KEY) == mapData.getKeys()) {
            MapBGM.key();
            return true;
        } else {
            return false;
        }
    }

    public void func1ButtonAction(ActionEvent event) {
        System.out.println("func1: Nothing to do");
    }

    // Print actions of user inputs
    public void printAction(String actionString) {
        System.out.println("Action: " + actionString);
    }
}
