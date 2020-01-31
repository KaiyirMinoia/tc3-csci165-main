public class HelloWorld2 {
  public static void main(String[] args) {
    /*
     * I decided to add a system for this program to account for people
     * with as many names someone has. With me having four names "Kaiyir Maurice
     * David Minoia" I decided to write this program to account for as many
     * names as their are arguments. The for loop will determine the amount of
     * arguments fed into the array, and format the welcome printout correctly
     * depending on how many name arguments are given. The if statement allows
     * for usage of this program with only one name e.g. (Hello Kaiyir. Nice
     * work processing arguments)
     * The code that only accounts for two names is commented at the bottom.
     */
    System.out.print("Hello");
    if (args.length != 1) {
      for (int i = 0; i < args.length; i++) {
        System.out.print(" " + args[i]);
      }
    } else if (args.length == 1)
      System.out.print(" " + args[0]);

    System.out.print(". Nice work processing the arguments");
  }
}

/*
    System.out.println("Hello " + args[0] + " " + args[1] +
                       ". Nice work processing the arguments");
                       */
