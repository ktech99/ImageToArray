import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;

public class ImgTest {

  public static void main(String[] args) throws IOException, AWTException, InterruptedException {
    Robot robot = new Robot();
    BufferedImage hugeImage = robot.createScreenCapture(new Rectangle(0, 0, 2000, 2000));
    Set<Integer> str = new TreeSet<Integer>();
    int[][] result = convertTo2DUsingGetRGB(hugeImage);
    for (int p = 0; p < result.length; p++) {
      for (int j = 0; j < result[p].length; j++) {
        // str.add(result[p][j]);
        int blue = result[p][j] & 0xff;
        int green = (result[p][j] & 0xff00) >> 8;
        int red = (result[p][j] & 0xff0000) >> 16;
      }
    }
  }

  private static int[][] convertTo2DUsingGetRGB(BufferedImage image) {
    int width = image.getWidth();
    int height = image.getHeight();
    int[][] result = new int[height][width];

    for (int row = 0; row < height; row++) {
      for (int col = 0; col < width; col++) {
        result[row][col] = image.getRGB(col, row);
        int blue = result[row][col] & 0xff;
        int green = (result[row][col] & 0xff00) >> 8;
        int red = (result[row][col] & 0xff0000) >> 16;
        if (red >= 254 && blue <= 100 && green <= 100) {
          System.out.println(red + " " + row + " " + col);
        }
      }
    }

    return result;
  }
}
