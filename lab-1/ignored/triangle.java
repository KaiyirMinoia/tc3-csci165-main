

public class Triangle {
  public static void main(String[] args) { size(4); }

  public static void size(int starnum) {
    int i;
    int j;
    int k;
    for (i = 0; i < starnum - 1; i++) {
      for (j = 0; j < i; j++) {
        System.out.print(" ");
      }
      for (k = starnum - i; k > 0; k--) {
        System.out.print("* ");
      }
      System.out.println();
    }
    for (i = 0; i < starnum; i++) {
      for (j = starnum - i; j > 1; j--) {
        System.out.print(" ");
      }
      for (k = 0; k < i + 1; k++) {
        System.out.print("* ");
      }
      System.out.println();
    }
  }
}
