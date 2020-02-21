// KAIYIR MINOIA -- 02/18/20-- CSCI165 -- LAB 4
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.swing.JFrame;
import javax.swing.JPanel;
// I  put the Drawer.java file into this file and modified it.
//  Had trouble calling the file separately
class MapDataDrawer extends JPanel {

  private static final long serialVersionUID = 1L;
  private JFrame window = new JFrame();

  public MapDataDrawer() { initUI(); }

  private void initUI() {
    // Window attributes.
    window.add(this);
    window.setTitle("Colorado ElevationMap");
    window.setSize(844, 480);
    window.setLocationRelativeTo(null);
    window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    window.setVisible(true);
  }

  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    drawMap(g);
    indexOfLowestElevPath(g);
  }
  // Filename variable
  String filename = "Colorado_844x408.dat";
  public int[][] map;

  //  Reading map data into a 2D array
  public MapDataDrawer(String filename, int rows, int cols) {
    int[][] map = new int[rows][cols];
    try {
      Scanner s = new Scanner(new File(filename));
      for (int i = 0; i < rows; ++i) {
        for (int j = 0; j < cols; ++j) {
          // Will read integers if there are any available
          if (s.hasNextInt())
            map[i][j] = s.nextInt();
        }
      }
      // File not found
    } catch (FileNotFoundException fnf) {
      System.out.println("!!! ERROR: FILE NOT FOUND !!!");
    }
  }
  // Finding minimum elevation
  public int findMin() {
    int elevMin;
    elevMin = map[0][0];
    // Nested for loop to find minimum by comparing rows and columns
    for (int i = 0; i < map.length; ++i) {
      for (int j = 0; j < map[0].length; ++j) {
        // This checks if the current elevation is less than the previously
        // discovered value
        if (map[i][j] < elevMin)
          elevMin = map[i][j];
      }
    }
    return elevMin;
  }

  public int findMax() {
    int elevMax = map[0][0];
    // Nested for loop to find maximum... Same concept as findMin()
    for (int i = 0; i < map.length; ++i) {
      for (int j = 0; j < map[0].length; ++j) {
        if (map[i][j] > elevMax)
          elevMax = map[i][j];
      }
    }
    return elevMax;
  }
  // Drawing the map
  public void drawMap(Graphics g) {
    int k = 0;
    int elevMax = findMax();
    int elevMin = findMin();
    // greyscale calculations
    int c = (255 / (elevMax - elevMin));
    int[][] drawing = new int[map.length][map[0].length];
    for (int i = 0; i < map.length; ++i) {
      for (int j = 0; j < map[0].length; ++j) {
        drawing[i][j] = ((map[i][j] - elevMin) * c);
      }
    }
    // Drawing and setting colours
    for (int i = 0; i < drawing.length; ++i) {
      for (int j = 0; j < drawing[0].length; ++j) {
        k = drawing[i][j];
        g.setColor(new Color(k, k, k));
        g.fillRect(j, i, 1, 1);
      }
    }
  }
  public int indexOfMinRow(int col) {

    int index = 0;
    int elevMin = map[0][col];
    // Index calculation
    for (int i = 1; i < map.length; ++i) {
      if (map[i][col] < elevMin) {

        index = i;
        elevMin = map[i][col];
      }
    }
    return index;
  }
  int drawLowestElevPath(Graphics g, int row) {
    // 3 directions and 3 change variables for the directions
    int changeEast = 0;
    int changeNorthEast = 0;
    int changeSouthEast = 0;
    int east = 0;
    int elevDiff = 0;
    int elevMax = findMax();
    int northeast = 0;
    int southeast = 0;
    int smallestDiff = 0;
    // Calculating and deciding the best path with the greedy algorithm
    for (int i = 0; i < map[0].length - 1; ++i) {
      g.fillRect(i, row, 1, 1);
      east = map[row][i + 1];
      northeast = -1;
      southeast = -1;

      // Movement based on differences of elevation
      if (row != 0)
        northeast = map[row - 1][i + 1];
      if (row != map.length - 1)
        southeast = map[row + 1][i + 1];
      changeEast = Math.abs(map[row][i - east]);
      changeNorthEast = elevMax + 1;
      changeSouthEast = elevMax + 1;
      if (northeast > -1)
        changeNorthEast = Math.abs(map[row][i] - northeast);
      if (southeast > -1)
        changeSouthEast = Math.abs(map[row][i] - southeast);
      smallestDiff = changeEast;
      if (changeEast > changeNorthEast) {
        if (changeNorthEast > changeSouthEast) {
          smallestDiff = changeSouthEast;
          ++row;
        } else {
          smallestDiff = changeNorthEast;
          --row;
        }
      } else {
        if (changeEast > changeSouthEast) {
          smallestDiff = changeSouthEast;
          ++row;

        } else {
          smallestDiff = changeEast;
        }
      }
      elevDiff += smallestDiff;
    }
    return elevDiff;
  }
  int indexOfLowestElevPath(Graphics g) {
    int elevDiff = 0;
    int smallestDiff = drawLowestElevPath(g, 0);
    int lowestPathIndex = 0;
    // Index calculation
    for (int i = 1; i < map.length; ++i) {
      elevDiff = drawLowestElevPath(g, i);
      if (elevDiff < smallestDiff) {
        smallestDiff = elevDiff;
        lowestPathIndex = i;
      }
    }
    return lowestPathIndex;
  }
  public static void main(String[] args) {
    // Attempting to draw the map.
    MapDataDrawer panel = new MapDataDrawer();
    MapDataDrawer map = new MapDataDrawer("Colorado_844x480.dat", 480, 844);
    Graphics g = panel.getGraphics();
    EventQueue.invokeLater(new Runnable() {
      @Override
      public void run() {
        MapDataDrawer map = new MapDataDrawer("Colorado_844x480.dat", 480, 844);
        panel.setVisible(true);
      }
    }

    );
  }
}
