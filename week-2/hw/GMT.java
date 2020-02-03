import java.util.Scanner;

public class GMT {
  public static void main(String[] args) {

    //  Declarations
    Scanner input = new Scanner(System.in);
    int offset;
    long gmtMS, gmtS, ourS, gmtM, ourM, gmtH;
    System.out.print("Enter timezone offset from GMT: ");
    offset = input.nextInt();
    gmtMS = System.currentTimeMillis();

    //  Calculations
    gmtS = gmtMS / 1000;
    ourS = gmtS % 60;
    gmtM = gmtS / 60;
    ourM = gmtM % 60;
    gmtH = gmtM / 60;

    //  Output
    System.out.println("The time in our timezone is: \n" +
                       ((gmtH + offset) % 24) + " : " + ourM + " : " + ourS);
  }
}
