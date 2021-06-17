package byog.Core;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;

public class Game {
    TERenderer ter = new TERenderer();
    /* Feel free to change the width and height. */
    public static final int WIDTH = 80;
    public static final int HEIGHT = 30;

    /**
     * Method used for playing a fresh game. The game should start from the main menu.
     * 此方法从键盘获取输入，并将每次按键的结果绘制到屏幕上
     */
    public void playWithKeyboard() {
    }

    /**
     * Method used for autograding and testing the game code. The input string will be a series
     * of characters (for example, "n123sswwdasdassadwas", "n123sss:q", "lwww". The game should
     * behave exactly as if the user typed these characters into the game after playing
     * playWithKeyboard. If the string ends in ":q", the same world should be returned as if the
     * string did not end with q. For example "n123sss" and "n123sss:q" should return the same
     * world. However, the behavior is slightly different. After playing with "n123sss:q", the game
     * should save, and thus if we then called playWithInputString with the string "l", we'd expect
     * to get the exact same world back again, since this corresponds to loading the saved game.
     * @param input the input string to feed to your program
     * @return the 2D TETile[][] representing the state of the world
     *
     * 此方法将一系列键盘输入作为输入，并在处理输入中提供的所有按键（如下所述）后返回表示宇宙状态的 2D TETile 数组
     * https://github.com/stg1205/CS61B/blob/master/proj2/byog/Core/Game.java
     */
    public TETile[][] playWithInputString(String input) {
        // TODO: Fill out this method to run the game using the input passed in,
        // and return a 2D tile representation of the world that would have been
        // drawn if the same inputs had been given to playWithKeyboard().
        //第一个数字是N(NEW GAME)、l(LOAD GAME)、q(QUIT GAME)
        //数字之后的都是表示方向：w、a、s、d,如果是以:q结尾表示结束
        long seed = Long.parseLong(input.replaceAll("[^0-9]", ""));
        //用种子去生成迷宫世界
        
        TETile[][] finalWorldFrame = null;
        return finalWorldFrame;
    }
}
