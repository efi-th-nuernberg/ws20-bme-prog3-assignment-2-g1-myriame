class TextFormatter {

  private static final String text = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy " +
          "eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et " +
          "accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem " +
          "ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod " +
          "tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et " +
          "justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est " +
          "Lorem ipsum dolor sit amet.";

  public static void main(String[] args) {
    TextFormatter formatter = new TextFormatter(30);
    formatter.print(text);
  }

  // Konstruktor
  public TextFormatter(int maxLineLength) {
    int x = text.length()/ maxLineLength;
    for (int i = 0; i<x; i++)
    {
      String a = text.substring(i*maxLineLength,(i+1)*maxLineLength);
      System.out.println(a);
    }
  }

   

  // Ausgabe
  public void print(String aText) {
    System.out.println(aText);
  }

}