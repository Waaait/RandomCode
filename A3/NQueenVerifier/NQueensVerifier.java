//Name: Weiting Li
//Assignment 3, problem 2
//Apr 2.2019
import java.util.*;

public class NQueensVerifier
{
  private static final char QUEEN = 'Q';
  private static final char BLANK = 'B';
  private static int size;
  char[][] board;

  public NQueensVerifier(int inSize,char[][] inBoard)
  {
    if(inSize <= 0)
    {
      throw new IllegalArgumentException("Size can't be zero or negative!");
    }
    if(checkBoardBasics(inSize, inBoard) !=true)
    {
      throw new IllegalArgumentException("Something is wrong with the board.");
    }
    size= inSize;
    board = new char[size][size];
    for (int i = 0;i<inSize;i++ )
    {
        for (int y = 0;y<inSize;y++ )
        {
          board[i][y] = inBoard[i][y];
        }
    }
  }

  private boolean forQ(char[][] bo)
  {
    int countQ = 0;
    for(int x = 0;x<bo.length;x++)
    {
      for(int y = 0;y<bo[0].length;y++)
      {
        //System.out.println("point is "+bo[x][y]);
        if (bo[x][y] == QUEEN)
        {
          countQ++;
        }
      }
    }
    //System.out.println("Q is "+countQ);
    if(countQ==0)
    {
      return false;
    }
    return true;
  }

  private boolean checkBoardBasics(int inSize,char[][] inBoard)
  {
    if(inBoard==null && inBoard.length != inSize)
    {
      return false;
    }
    else
    {
      for (int x = 0;x<inBoard.length ;x++ )
      {
        if(inBoard[0].length!=inSize)
        {
          //System.out.println("Yeah inBoard[0].length!=inSize");
          return false;
        }
        for (int y = 0;y<inBoard[0].length ;y++ )
        {
          if((Character.toString(inBoard[x][y])==null))
          {
            //System.out.print(inBoard[x][y]);
            return false;
          }
          else if(forQ(inBoard)==false)
          {
            //System.out.print("here!");
            return false;
          }
          else if((inBoard[x][y]!=QUEEN)&&(inBoard[x][y]!=BLANK))
          {
            //System.out.print("both");
            return false;
          }
        }
      }
    }
    return true;
  }

  //true if one row has only one queen
  private boolean oneQueenPerRow()
  {
    for (int x = 0;x<size; x++)
    {
      int counter = 0;
      for (int y = 0;y<size; y++)
      {
        if(board[x][y]==QUEEN)
        {
          counter++;
        }
      }
      if(counter>1)
      {
        return false;
      }
    }
    return true;
  }

  //true if one column has only one queen
  private boolean oneQueenPerColumn()
  {
    for (int x = 0;x<size; x++)
    {
      int counter = 0;
      for (int y = 0;y<size; y++)
      {
        if(board[y][x]==QUEEN)
        {
          counter++;
        }
      }
      if(counter>1)
      {
        return false;
      }
    }
    return true;
  }

  //check diagonal
  /*    
        x x x x
        / / / x
        / / / x
        / / / X
   */
    private static boolean ExRightToLeft(char[][] board)
    {
      for(int x = board.length-1;x>0;x--)
      {
        int counter = 0;
        for(int i = 0;i<=x;i++)
        {
          if(board[i][x-i]==QUEEN)
          {
            counter++;
            //System.out.println("point is "+i+" "+(x-i));
            //System.out.println("counter is "+counter);
          }
          if(counter>1)
          {
            return false;
          }
        }
      }
      for(int y = 1;y<=board.length-1;y++)
        {
            int count = 0;
            for(int i = 0;i<board.length-1-y;i++)
            {
                if(board[y+i][board.length-1-i]==QUEEN)
                {
                    count++;
                    //System.out.println("point is "+(y+i)+" "+(board.length-1-i));
                    //System.out.println("count is "+count);
                }
                if(count>1)
                {
                    return false;
                }
            }
        }
        return true;
    }

  //check diagonal from left right to left
  /*    
        x x x x
        x \ \ \
        x \ \ \
        X \ \ \
   */
     private static boolean ExLeftToRight(char[][] board)
     {
         for(int x = 0;x<board.length-1;x++)
        {
            int counter = 0;
            for(int i = 0;i<=board.length-1-x;i++)
            {
                if(board[i][x+i]==QUEEN)
                {
                    counter++;
                    //System.out.println("point is "+i+" "+(x+i));
                    //System.out.println("counter is "+counter);
                }
                if(counter>1)
                {
                    return false;
                }
            }
        }
        for(int y = 1;y<board.length-1;y++)
        {
            int count = 0;
            for(int i = 0;i<board.length-y;i++)
            {
                if(board[y+i][i]==QUEEN)
                {
                    count++;
                    //System.out.println("point is "+(y+i)+" "+(i));
                    //System.out.println("count is "+count);
                }
                if(count>1)
                {
                    return false;
                }
            }
        }
        return true;
    }
  
  //return result 
  private boolean noDiagonalAttacks()
    {
      if(ExLeftToRight(board) == false)
      {
        return false;
      }
      else if(ExRightToLeft(board)== false)
      {
        return false;
      }
      return true;
    }

  //summary
  public boolean isValidSolution()
  {
    //System.out.println("row "+oneQueenPerRow());
    //System.out.println("column "+oneQueenPerColumn());
    //System.out.println("dia "+noDiagonalAttacks());
    if(oneQueenPerColumn()==false)
    {
      return false;
    }
    else if(oneQueenPerRow()==false)
    {
      return false;
    }
    else if(noDiagonalAttacks()==false)
    {
      return false;
    }
    else
    {
      return true;
    }
  }
}
