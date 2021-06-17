package byog.lab5;
import org.junit.Test;
import static org.junit.Assert.*;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.awt.*;
import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {

    private static final int WIDTH = 60;
    private static final int HEIGHT = 30;

    public static void main(String[] args) {

        TERenderer ter = new TERenderer();
        //初始化宽度和高度,宽度和高度要根据块数量给出
        ter.initialize(WIDTH, HEIGHT);
        TETile[][] world = new TETile[WIDTH][HEIGHT];
        for (int x = 0; x < WIDTH; x += 1) {
            for (int y = 0; y < HEIGHT; y += 1) {
                world[x][y] = Tileset.NOTHING;
            }
        }

        addHexagon(6, 10, 20, world);
        ter.renderFrame(world);
    }

    /**
     *
     * @param n: 六边形大小
     * @param x: 起始位置
     * @param y: 起始位置
     */
    public static void addHexagon(int n, int x, int y, TETile[][] world ) {
        //生成上半部分的六边形
        for(int i=0; i<n; i++) {

            int size = n + 2*i;
            int startX = x-i;//调整起始位置,不调整就是每行都是对齐的

            for(int j=0; j<size; j++) {
                world[startX+j][y-i] = new TETile('a', Color.WHITE, Color.BLACK, "nothing");
            }
        }
        //生成下半部分的六边形,重新计算x和y
        y = y - (2 * n - 1);

        for(int i=0; i<n; i++) {

            int size = n + 2*i;
            int startX = x-i;
            for(int j=0; j<size; j++) {
                world[startX+j][y+i] = new TETile('a', Color.WHITE, Color.BLACK, "nothing");
//                world[startX+j][y+i] = Tileset.FLOOR;
            }
        }
    }
}
