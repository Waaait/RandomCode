//name: Weiting Li
//COMP 1731
//assignment 2, problem 3
//Mar 12,2019

import java.util.*;

public class ArrayPlay
{
    private ArrayPlay()
    {
        super();
    }

    final static int MAX = 999;

    public static void fillRandom(int[] arr)
    {
        Random ran = new Random();
        for(int i = 0;i < arr.length;i++)
        {
            arr[i] = ran.nextInt(MAX);
        }
        return;
    }

    public static void printArray(int[] arr)
    {
        System.out.print("[");
        for(int i = 0;i < arr.length-1;i++)
        {
            System.out.print(arr[i]+",");
        }
        System.out.print(arr[arr.length-1]+"]");
        return;
    }

    /*
    -Should use a loop to scan through the entries
    in the input arry begginning at index start and
    ending at index end.
    -!!return the index of the smallest value, not the
    value itself!!
     */
    public static int findIndexOfSmallest(int[]arr,int start,int end)
    {
        //find the smallest, record its position
        for(int i = start;i<end;i++)
        {
            if(arr[i]<arr[start])
            {
                start = i;
            }
        }
        return start;
    }

    public static void sort(int[] arr)
    {
        for(int y = 0;y < arr.length; y++)
        {
            int swap = arr[y];
            int mini_position = findIndexOfSmallest(arr, y, arr.length);
            arr[y] = arr[mini_position];
            arr[mini_position] = swap;
        }
        return;
    }
}
