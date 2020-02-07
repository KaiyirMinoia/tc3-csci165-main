/* I think I got the hang of the inputting and arrays, but I had alot of trouble
 * with outputting. I will consult you in class about this*/
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;
public class FoodTruck {
  public static void main(String[] args) {
    int lineNumber;

    String name;
    ArrayList<String> menu = new ArrayList<String>();
    ArrayList<Double> prices = new ArrayList<Double>();
    int[] quantity = new int[3];
    try {
      File text = new File("menu.txt");
      File text2 = new File("prices.txt");
      Scanner scannerMenu = new Scanner(text);
      Scanner scannerPrices = new Scanner(text2);
      lineNumber = 1;
      // Scanning menu file
      while (scannerMenu.hasNextLine()) {
        String line = scannerMenu.nextLine();
        menu.add(line);
        lineNumber++;
      }
      menu.forEach(line -> { System.out.println(line); });
      while (scannerPrices.hasNextDouble()) {
        Double line2 = scannerPrices.nextDouble();
        prices.add(line2);
        lineNumber++;
      }
      prices.forEach(line2 -> { System.out.println(line2); });
      System.out.println("Enter your name: ");
      Scanner input = new Scanner(System.in);
      name = input.nextLine();
      System.out.println("Enter the quantity of each item: ");
      System.out.println("=================================");
      for (int i = 0; i < 3; i++) {
        System.out.printf(menu.get(i) + " - $" + (prices.get(i)) + ": ");
        quantity[i] = input.nextInt();
      }

      double total = (prices.get(0) * quantity[0]) +
                     (prices.get(1) * quantity[1]) +
                     (prices.get(2) * quantity[2]);
      total = total + (total * 0.0625);
      DecimalFormat df = new DecimalFormat("#,###,##0.00");
      System.out.println(df.format(total));
      /* This is the major part I struggled with
       I will be rereading the material to try to get a grasp on
       Outputting and formatting. */
      /* try {

         String content = "Testwrite";
         File file = new File("output.txt");
         FileWriter fw = new FileWriter(file.getAbsoluteFile());
         BufferedWriter bw = new BufferedWriter(fw);
         bw.write(content);
         bw.close(); // Be sure to close BufferedWriter

       } catch (FileNotFoundException filenotfound) {

         System.out.println("!!! FILES NOT FOUND !!!");
       } // handle
       */
    } catch (FileNotFoundException filenotfound) {
      System.out.println("!!! FILES NOT FOUND !!!");
    }
  }
}
