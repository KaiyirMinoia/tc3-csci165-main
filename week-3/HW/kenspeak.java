import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
public class kenspeak {
  public static void main(String[] args) {
    int lineNumber;
    String[] numeral = new String[3];
    String userSeq;
    int lengthof;
    char[] encryption = {'*', 'B', 'E', 'A', '@', 'F', 'K', '%', 'R', 'M'};
    try {
      File text = new File("numbers.txt");
      Scanner scanner = new Scanner(text);
      Scanner input = new Scanner(System.in);
      lineNumber = 1;
      // test
      //      for (int i = 0; i < 10; i++)
      //       System.out.println(encryption[i]);
      System.out.println("Enter sequence of base 10 digits: ");
      System.out.println("=================================");
      userSeq = input.nextLine();
      Character[] encrypted =
          userSeq.chars().mapToObj(c -> (char)c).toArray(Character[] ::new);
      for (int i = 0; i < userSeq.length(); i++) {
        for (int j = 0; j < userSeq.length(); j++)
          encrypted[j] = encryption[i];
      }
      for (int i = 0; i < userSeq.length(); i++)
        System.out.print(encrypted[i]);
      System.out.print("\n");
      // Scanning menu file
      String encrypted2 = "";
      while (scanner.hasNextLine()) {
        String line = scanner.nextLine();
        encrypted2 += line;
        lineNumber++;
      }
      Character[] encrypted2arr =
          encrypted2.chars().mapToObj(c -> (char)c).toArray(Character[] ::new);

      System.out.println(encrypted2);
      // test
      for (int i = 0; i < encrypted2.length(); i++)
        System.out.println(encrypted2arr[i]);
      for (int i = 0; i < encrypted2.length(); i++) {
        for (int j = 0; j < encrypted2.length(); j++)
          encrypted2arr[j] = encryption[i];
      }
      lengthof = encrypted2.length();
      // test
    } catch (FileNotFoundException filenotfound) {
      System.out.println("!!! FILES NOT FOUND !!!");
    }
    //
    /*
    try {
      FileWriter fw = new FileWriter("encodedNumbers.txt");

      for (int i = 0; i < lengthof; i++) {
        fw.write(encrypted2arr[i]);
      }
      fw.close();
    } catch (FileNotFoundException filenotfound) {
      System.out.println("!!! FILES NOT FOUND !!!");

    }
    */
  }
}
