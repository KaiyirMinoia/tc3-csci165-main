import java.util.Scanner;

public class Initials {
  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    System.out.print("Enter your first and last name: ");
    String name = input.nextLine();
    for (int i = 0; i < name.length(); i++) {
      System.out.println(name.charAt(i));
    }
    for (int i = 1; i < name.length() - 1; i++)
      if (name.charAt(i) == ' ')
        System.out.print(" " + name.charAt(i + 1));
  }
}
