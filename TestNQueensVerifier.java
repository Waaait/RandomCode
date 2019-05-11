//Name: Weiting Li
//COMP 1731
//Assignment 3, problem 2
//Apr 2.2019
import java.util.*;
import java.io.*;
public class TestNQueensVerifier
{
  public static void main(String[] args)
  {
    Scanner cs = new Scanner(System.in);
    String path = cs.nextLine();
    cs.close();

    int size=0;
    char[][] arr=new char[size][size];
    File f = new File(path);
    
    try
    { 
      Scanner cs2 = new Scanner(f);
      size = cs2.nextInt();
      arr = new char[size][size];
      for(int x = 0;x<arr.length;x++)
      {
        String s = cs2.next();
        char[] newS = s.toCharArray();
        for(int y = 0;y<newS.length;y++)
        {
          arr[x][y]= newS[y];
        }
      }
      cs2.close();
    }
    catch(FileNotFoundException e)
    {
      System.out.print("Something is wrong. There's no other input.");
    }
    NQueensVerifier chess= new NQueensVerifier(size,arr);
    boolean result = chess.isValidSolution();

    if(result == false)
    {
      System.out.println("OOPS! Queens can kill each other!" );
    }
    else
    {
      System.out.println("No queens can attack each other! You protect the peace!");
    }
  }
}
