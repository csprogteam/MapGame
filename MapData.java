import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import java.util.ArrayList;

public class MapData {
    public static final int TYPE_SPACE = 0;
    public static final int TYPE_WALL = 1;
    public static final int TYPE_KEY = 2;
    public static final int TYPE_FISH1 = 3;
    public static final int TYPE_FISH2 = 4;
    public static final int TYPE_FISH3 = 5;
    public static final int TYPE_PUDDLE = 6;
    public static final int TYPE_GOAL = 7;
    public static final int TYPE_OPEN = 8;
    private static final String mapImageFiles[] = {
        "png/SPACE.png",
        "png/WALL.png",
        "png/KEY.png",
        "png/FISH1.png",
        "png/FISH2.png",
        "png/FISH3.png",
        "png/PUDDLE.png",
        "png/GOAL_FLAG.png",
        "png/GOAL_OPEN.png"
    };

    private Image[] mapImages;
    private ImageView[][] mapImageViews;
    private int[][] maps;
    private int width;
    private int height;
    private int keys;

    MapData(int x, int y, int keys, int fish1s, int fish2s, int fish3s, int puddles){
        mapImages = new Image[9];
        mapImageViews = new ImageView[y][x];
        for (int i=0; i<9; i++) {
            mapImages[i] = new Image(mapImageFiles[i]);
        }

        width = x;
        height = y;
        maps = new int[y][x];

        fillMap(MapData.TYPE_WALL);
        digMap(1, 3);
        setGoal();
        setMultipleItems(MapData.TYPE_KEY, keys);
        setMultipleItems(MapData.TYPE_FISH1, fish1s);
        setMultipleItems(MapData.TYPE_FISH2, fish2s);
        setMultipleItems(MapData.TYPE_FISH3, fish3s);
        setMultipleItems(MapData.TYPE_PUDDLE, puddles);
        setImageViews();
    }

    public int getHeight(){
        return height;
    }

    public int getWidth(){
        return width;
    }

    public int getKeys(){
        return keys;
    }

    public int getMap(int x, int y) {
        if (x < 0 || width <= x || y < 0 || height <= y) {
            return -1;
        }
        return maps[y][x];
    }

    public ImageView getImageView(int x, int y) {
        return mapImageViews[y][x];
    }

    public void setMap(int x, int y, int type){
        if (x < 1 || width <= x-1 || y < 1 || height <= y-1) {
            return;
        }
        maps[y][x] = type;
    }

	// set images based on two-dimentional arrays (maps[y][x])
    public void setImageViews() {
        for (int y=0; y<height; y++) {
            for (int x=0; x<width; x++) {
                mapImageViews[y][x] = new ImageView(mapImages[maps[y][x]]);
            }
        }
    }

	// fill two-dimentional arrays with a given number (maps[y][x])
    public void fillMap(int type){
        for (int y=0; y<height; y++){
            for (int x=0; x<width; x++){
                maps[y][x] = type;
            }
        }
    }

	// dig walls for creating trails
    public void digMap(int x, int y){
        setMap(x, y, MapData.TYPE_SPACE);
        int[][] dl = {{0,1},{0,-1},{-1,0},{1,0}};
        int[] tmp;
        //shuffle
        for (int i=0; i<dl.length; i++) {
            int r = (int)(Math.random()*dl.length);
            tmp = dl[i];
            dl[i] = dl[r];
            dl[r] = tmp;
        }
        //SPACEをセットする
        for (int i=0; i<dl.length; i++){
            int dx = dl[i][0];
            int dy = dl[i][1];
            if (getMap(x+dx*2, y+dy*2) == MapData.TYPE_WALL){
                setMap(x+dx, y+dy, MapData.TYPE_SPACE);
                digMap(x+dx*2, y+dy*2);

            }
        }
    }

    //アイテム1個をマップにランダムに配置する
   public void setItem (int type) {
        int x, y;
        x = (int)(Math.random()*width);
        y = (int)(Math.random()*height);
        if (getMap(x,y) != MapData.TYPE_SPACE) {
            setItem(type);
        } else if (getMap(x,y) == MapData.TYPE_SPACE) {
            setMap(x, y, type);
        }
    }

    public void setMultipleItems (int type, int n) {
        for (int i=0; i<n; i++) {
            setItem(type);
        }
    }

    public void setGoal () {
        ArrayList<int[]> valid = new ArrayList<int[]>();
        for (int j=0; j<height; j++) {
            for (int i=0; i<height; i++) {
                int surround = getMap(i+1,j)+getMap(i-1,j)+getMap(i,j+1)+getMap(i,j-1);
                if (i!=1 && j!=1 && getMap(i,j) == MapData.TYPE_SPACE && surround==3) {
                    int[] pos = {i,j};
                    valid.add(pos);
                }
            }
        }
        int n = (int)(Math.random()*valid.size());
        int[] chosenPos = valid.get(n);
        int x = chosenPos[0];
        int y = chosenPos[1];
        setMap(x,y,MapData.TYPE_GOAL);
    }

}
