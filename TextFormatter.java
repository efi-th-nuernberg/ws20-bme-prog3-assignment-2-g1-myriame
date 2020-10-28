import java.util.ArrayList;
import java.util.StringTokenizer;

class TextFormatter{

  private static final String text = "Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy " +
          "eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et " +
          "accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem " +
          "ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod " +
          "tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et " +
          "justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est " +
          "Lorem ipsum dolor sit amet.";
    private int maxLineLength;      

  public static void main(String[] args) {
    TextFormatter formatter = new TextFormatter(30);
    
    System.out.println(text);
    //formatter.printCutText(text);
    formatter.printLeftText(formatter.cutText(text));
    formatter.printRightText(formatter.cutText(text));
    formatter.printCenterText(formatter.cutText(text));
    formatter.printBlockText(formatter.cutText(text));
  }

  // Konstruktor
  public TextFormatter(int maxLineLength) {
	//if not +1, line will break if the last word ends on maxLineLength
    this.maxLineLength = maxLineLength + 1;
  }

  // Ausgabe
  public void printCutText(String aText) {
    int x = aText.length() / maxLineLength;
    int i = 0;
    while (i<=x)
    {
      if (i < x)
      {
      aText = text.substring(i*maxLineLength,(i+1)*maxLineLength);
      } else if(i*maxLineLength < text.length())
         {
          aText = text.substring(i*maxLineLength,text.length());
         }
         System.out.println(i + " " + aText);
        i++;
    }
  }

  public ArrayList<String> cutText(String aText)
  {
	  int additiveChars = 0;
	  ArrayList<String> cutStrings = new ArrayList<String>();
	    while (additiveChars<=aText.length())
	    {
	    	if (additiveChars+maxLineLength>=aText.length())
	    	{
	    		cutStrings.add(aText.substring(additiveChars, aText.length()));
	    		//System.out.println(aText.substring(additiveChars, aText.length()));
	    		return(cutStrings);
	    	}
	      String cutText = aText.substring(additiveChars, additiveChars+maxLineLength);
	      int cutInt = cutText.lastIndexOf(" ");
	      if (cutInt != additiveChars+maxLineLength-1)
	      {
	    	  cutText = cutText.substring(0, cutInt);
	      }
	      additiveChars += cutText.length()+1;
	      cutStrings.add(cutText);
	    }
	    return(cutStrings);
  }
  
  public void printLeftText(ArrayList<String> aString) 
  {
	  for (int i = 0; i<aString.size(); i++)
	  {
		  System.out.println(aString.get(i));
	  }
  }
  
  public void printRightText(ArrayList<String> aString)  
  {
	  for (int i = 0; i<aString.size(); i++)
	  {
		  String line = aString.get(i);
		  int spaces = maxLineLength - line.length();
		  
		  for (int j = 0; j<spaces; j++)
		  {
			  System.out.print(" ");
		  }
		  System.out.println(line);
	  }
  }
  
  public void printCenterText(ArrayList<String> aString)  
  {
	  for (int i = 0; i<aString.size(); i++)
	  {
		  String line = aString.get(i);
		  int spaces = (maxLineLength - line.length())/2;
		  
		  for (int j = 0; j<spaces; j++)
		  {
			  System.out.print(" ");
		  }
		  System.out.println(line);
	  }
  }
  
  public void printBlockText(ArrayList<String> aString)  
  {
	  for (int i = 0; i<aString.size(); i++)
	  {
		  String line = aString.get(i);
      StringTokenizer st = new StringTokenizer(line);
		  float spacesLeft = maxLineLength - line.length()-1;
      float wordCount = st.countTokens();
      double roundUp = 0.99;
      float spacesPerWord = (int)(spacesLeft/(wordCount-1)+roundUp);
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
		  //System.out.println(line);
	  }
  }
}

  
  
  /*public void printLeftText(String aText) {
    int x = aText.length() / maxLineLength;
    System.out.println("Amount of used chars: " + text.length());
    System.out.println("Amount of lines: " + x + " divided by: " + maxLineLength);
    int i = 0;
    while (i<=x)
    {
      if (i < x)
      {
      aText = text.substring(i*maxLineLength,(i+1)*maxLineLength);
      } else if(i*maxLineLength < text.length())
         {
          aText = text.substring(i*maxLineLength,text.length());
         }
         System.out.println(i + " " + aText);
        i++;
    }
    i = 0;
    while (i<10)
    {
     
      aText = text.substring(i*maxLineLength,(i+1)*maxLineLength);

      String lastWord =aText.substring(aText.lastIndexOf(" ")+1);
     
      int indexOfLastWord;


      if(i==0){
      aText = text.substring(i*maxLineLength,aText.lastIndexOf(" "));
      
    
      }
       
      else{
          indexOfLastWord = aText.lastIndexOf(" ")+1;
          System.out.println("it is:"+ indexOfLastWord);
        aText = text.substring(indexOfLastWord,aText.lastIndexOf(" "));
      }

      System.out.println(i + " " + aText);
      i++;
    }

    
  }
  }*/



