import java.util.ArrayList;
import java.util.StringTokenizer;


/**
/* Diese Klasse gibt die lange Texte in einem
/* Layout mit fester Spaltenbreite aus.
/* Autors: Myriame Lhaddane, Erik Schneiderer
**/
class TextFormatter{

  private static final String text = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy " +
          "eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et " +
          "accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem " +
          "ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod " +
          "tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et " +
          "justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est " +
          "Lorem ipsum dolor sit amet.";
  private final int maxLineLength;

  public static void main(String[] args) {
    TextFormatter formatter = new TextFormatter(30);
    
    formatter.printLeftText(formatter.cutText(text));
    formatter.printRightText(formatter.cutText(text));
    formatter.printCenterText(formatter.cutText(text));
    formatter.printBlockText(formatter.cutText(text));
  }

  // Es wird eine neue Instanz der Klasse angelegt, mit der anschließend die Formatierung auf die übergebene Spaltenbreite durchgeführt werden kann.
  public TextFormatter(int maxLineLength) {
	    this.maxLineLength = maxLineLength + 1;
  }

  /* 
  public void printCutText(String input) {
    int x = input.length() / maxLineLength;
    int i = 0;
    while (i<=x)
    {
      if (i < x)
      {
      input = input.substring(i*maxLineLength,(i+1)*maxLineLength);
      } else if(i*maxLineLength < text.length())
         {
          input = text.substring(i*maxLineLength,text.length());
         }
         System.out.println(input);
        i++;
    }
  }
  */

  //Diese Methode soll den übergebenen Text entsprechend umformatieren. Der Zeilenumbruch darf aber immer nur an Leerzeichen erfolgen und das letzte Wort beim Erreichen des Zeilenendes wird getrennt.
  public ArrayList<String> cutText(String input)
  {
	  int additiveChars = 0;
	  ArrayList<String> stringsCutter = new ArrayList<String>();
	    while (additiveChars<=input.length())
	    {
	    	if (additiveChars+maxLineLength>=input.length())
	    	{
	    		stringsCutter.add(input.substring(additiveChars, input.length()));
	    		return(stringsCutter);
	    	}
	      String trimmedText = input.substring(additiveChars, additiveChars+maxLineLength);
	      int cutInt = trimmedText.lastIndexOf(" ");
	      if (cutInt != additiveChars+maxLineLength-1)
	      {
	    	  trimmedText = trimmedText.substring(0, cutInt);
	      }
	      additiveChars += trimmedText.length()+1;
	      stringsCutter.add(trimmedText);
	    }
	    return(stringsCutter);
  }
  
  
  public void printLeftText(ArrayList<String> textInStrings) 
  {
    System.out.println("Linksbündiger Flattersatz:\n");
	  for (int i = 0; i<textInStrings.size(); i++)
	  {
		  System.out.println(textInStrings.get(i));
	  }
    System.out.print("\n\n\n\n");
  }
  
  public void printRightText(ArrayList<String> textInStrings)  
  {
    System.out.println("Rechtsbündiger Flattersatz:\n");
	  for (int i = 0; i<textInStrings.size(); i++)
	  {
		  String line = textInStrings.get(i);
		  int spaces = maxLineLength - line.length()-1;
		  
		  for (int j = 0; j<spaces; j++)
		  {
			  System.out.print(" ");
		  }
		  System.out.println(line);
	  }
    System.out.print("\n\n\n\n");
  }
 
  public void printCenterText(ArrayList<String> textInStrings)  
  {
    System.out.println("Zentrierter Flattersatz:\n");
	  for (int i = 0; i<textInStrings.size(); i++)
	  {
		  String line = textInStrings.get(i);
		  int spaces = (maxLineLength - line.length())/2;
		  
		  for (int j = 0; j<spaces; j++)
		  {
			  System.out.print(" ");
		  }
		  System.out.println(line);
	  }
    System.out.print("\n\n\n\n");
  }
  
  public void printBlockText(ArrayList<String> textInStrings)  
  {
    System.out.println("Blocksatz:\n");
	  for (int i = 0; i<textInStrings.size(); i++)
	  {
		  String line = textInStrings.get(i);
      StringTokenizer st = new StringTokenizer(line);
		  float spacesLeft = maxLineLength - line.length()-1;
      float wordCount = st.countTokens();
      float spacesPerWord = spacesLeft/(wordCount-1);

		  for (int j = 0; j<wordCount-1; j++)
		  {
        System.out.print(st.nextToken() + " ");
        for (int k = 0; k<spacesPerWord; k++)
        {
          if (spacesLeft<= 0)
          {
          break;
          }
          System.out.print(" ");
          spacesLeft--;
        }
		  }
		  System.out.print(st.nextToken() + "\n");
		}
  }
}