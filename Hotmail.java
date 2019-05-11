//Name: Weiting Li
//Mar 29. 2019
//Assignment 3, Hotmail
import java.util.*;
public class Hotmail
{
  //return true if there's only one @ in the string
  public static boolean countAtSymbol(String test)
  {
    char[] arr = test.toCharArray();
    int count = 0;
    for(int i = 0;i<arr.length;i++)
    {
      if(Character.toString(arr[i]).equals("@"))
      {
        count++;
      }
    }
    if(count !=1)
    {
      return false;
    }
    else
    {
      return true;
    }
   }

  //will check if it's a valid eName(A-Z,a-z,0-9 in ASCII)
  public static boolean isEName(String name)
  {
    char[] arr = name.toCharArray();
    int counter = 0;
    for(int y = 0;y<arr.length;y++)
    {
      int ascii = (int)arr[y];
      if(
        (ascii>=48 && ascii<=57) 
      ||(ascii>=64 && ascii<=90)
      ||(ascii>=97 &&ascii<=122))
      {
        counter++;
        //System.out.println(counter);
      }
      else
      {
        return false;
      }
    }
    
    if(counter<arr.length||arr.length == 0)
    {
      return false;
    }
    else
    {
      return true;
    }
  }
  /********************
  1. Check if there's a @ in the test case; if yes, split the
  test case into two;
  2. Split each cases by ".",and check;
  **********************/
  public static boolean isValidEmail(String test)
  {
    if(countAtSymbol(test))
    {
      String[] newTest = test.split("@",-1);
      //System.out.println("split by @: "+Arrays.toString(newTest));
      String[] beforeAt = newTest[0].split("\\.");
      String[] afterAt = newTest[1].split("\\.");
      //System.out.println("before At: "+Arrays.toString(beforeAt));
      //System.out.println("after At: "+Arrays.toString(afterAt));

      int counter = 0;
      int finalCount = 0;
      if(beforeAt.length>=1 && afterAt.length>=2)
      {
	      for(int a = 0;a<newTest.length;a++)
	      {
	    	  String eName = newTest[a];
          //System.out.println("newTest["+a+"] is: "+eName);
	    	  //https://stackoverflow.com/questions/14833008/java-string-split-with-dot
	    	  String[] lst = eName.split("\\.",-1);
          //System.out.println("split by \\. is: "+Arrays.toString(lst));
	    	  for(int x = 0;x<lst.length;x++)
	    	  {
            if(isEName(lst[x]))
            {
              counter++;
            }
            else
            {
              return false;
            }
	    	  }
          
          if(counter<lst.length||lst.length == 0)
          {
            return false;
          }
          else
          {
            finalCount++;
          }
	      }
        if(counter<newTest.length||newTest.length == 0)
          {
            return false;
          }
          else
          {
            return true;
          }
        
      }
      else{
          return false;
      }
    }
    else
    {
      return false;
    }
  }


  public static void main(String[]args)
  {
    //true
    System.out.println("valid: "+isValidEmail("person@hopper.mta.ca"));
    System.out.println("");
    //false
    System.out.println("invalid: "+isValidEmail("first.last@net"));
    System.out.println("");
    
    System.out.println("invalid : "+isValidEmail("dil@bert.com."));
    System.out.println("");
    
    System.out.println("invalid : "+isValidEmail(".me@gmail.gee@net"));
    System.out.println("");

    System.out.println("invalid : "+isValidEmail("me..you@gmail.org"));
    System.out.println("");

    System.out.println("invalid : "+isValidEmail("surfing.safari.info"));
    System.out.println("");

    System.out.println("invalid : "+isValidEmail("bill.@gates.tv"));
    System.out.println("");

    System.out.println("invalid : "+isValidEmail("warren@.buffett.money"));
    System.out.println("");

    System.out.println("invalid : "+isValidEmail("mark zuckerberg@facebook.com"));
    System.out.println("");

    System.out.println("invalid : "+isValidEmail("bill$$$gates@microsoft.com"));
    System.out.println("");
  }
}
