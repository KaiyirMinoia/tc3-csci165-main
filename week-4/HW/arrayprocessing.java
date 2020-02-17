/*
 * KAIYIR MINOIA
 * 02/13/2020
 * CSCI165
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class arrayprocessing {
  /*
   * I struggled to get the matrices working, but
   * I managed to get the arrays to be read in.
   * However, it appends a bunch of zeroes to the end of the array when
   * printed. I will be coming into class on February 17th to ask you personally
   * for your advice.
   */
  public static void main(String[] args) {
    int max = 0;
    int min = 0;
    try {
      // Temporary length value
      int length = 0;
      Scanner s = new Scanner(new File("number_list.txt"));
      Scanner s2 = new Scanner(new File("number_list.txt"));
      int[] array = new int[s.nextInt()];
      // int[][] matrix = new int[50][20];
      int[] arrayPC;
      fillArray(array, s, length);
      max = findMax(array);
      min = findMin(array);
      // Print Array
      for (int element : array)
        System.out.println(element);
      System.out.println(max);
      System.out.println(min);
      arrayPC = percentChange(array);
      // Print Percent Change Array
      for (int element : arrayPC)
        System.out.println(element);
    } catch (FileNotFoundException fnf) {
      System.out.println("");
    }
  }

  public static void fillArray(int[] array, Scanner s, int length) {
    while (s.hasNextInt())
      array[length++] = s.nextInt();
    s.close();
  }

  // Here is the broken matrix.
  /*
  public static void fillArray(int[][] matrix, Scanner s2, int length) {
    length = 0;
    while (s2.hasNextInt())
      matrix[length++] = s2.nextInt();
    s2.close();
  }
  */

  public static int findMax(int[] array) {
    int max = 0;
    for (int i = 0; i < array.length; i++) {
      if (array[i] > max) {
        max = array[i];
      }
    }
    System.out.println(max);
    return max;
  }

  public static int findMin(int[] array) {
    int min = array[0];
    for (int i = 1; i < array.length; i++) {
      if (array[i] < min) {
        min = array[i];
      }
    }
    return min;
  }
  public static int[] percentChange(int[] array) {
    for (int i = 0; i < array.length; i++) {
      // I also couldn't avoid getting divide-by-zero errors here, even though I
      // had an if-statement to eliminate zeroes
      if (i != 0 || (i + 1) != 0)
        array[i] /= array[i + 1] * 100;
    }
    return array;
  }
}
