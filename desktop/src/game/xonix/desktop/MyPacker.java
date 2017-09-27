package game.xonix.desktop;

import com.badlogic.gdx.tools.texturepacker.TexturePacker;
public class MyPacker {
    public static void main (String[] args) throws Exception {
        String inputDir = "/Users/jura/Desktop/Учеба/Курсач/XONIX/android/assets/button";
        String outputDir = "/Users/jura/Desktop/Учеба/Курсач/XONIX/android/assets/button";
        String packFileName = "buttons";
        TexturePacker.process(inputDir, outputDir, packFileName);
    }
}