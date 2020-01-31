class Circle {
  static void print_rectangle(int a, int b) {
    int i;
    int j;
    for (i = 1; i <= a; i++) {
      for (j = 1; j <= b; j++) {
        if (i == 1 || i == a)
          System.out.print("*");
        else if (j == 1 || j == b)
          System.out.print("*");
        else
          System.out.print(" ");
      }
      System.out.println();
    }
  }
  public static void main(String args[]) { print_rectangle(5, 10); }
}
