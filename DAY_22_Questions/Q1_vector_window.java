package DAY_22_Questions;
//3.You are processing time series data. You want to write a function called calc_mov_avg that takes three arguments: size (the size of the input vector), vect (a vector of integers) and window_size (an integer representing the size of the window for calculating the moving average). The function should return a vector, result, of moving averages, where each element of the resulting vector is the average of a window of consecutive window_size elements from the input vect. It should also return n, the size of the result vector. If the resulting moving average is a floating- point number, it should be rounded to the nearest integer.
//        Assumptions:
//        • The window size is always a natural number.
//        • The input vector is guaranteed to be non- empty.
//
//        Example 1
//        Input:
//        ⚫ size = 4
//        • vect = 1234
//        ⚫ window_size = 3
//        Output:
//        n = 2
//        • result = 23
//        Explanation:
//        • The first window is 1 2 3 with an average of 2
//        • The second window is 2 3 4 with an average of 3
//        • Hence the output is 2 3
//        Example 2
//        Input:
//        . size = 4
//        • vect = 1234
//        window_size = 2
//        Output:
//        n = 3
//        • result = 234
//
//        Explanation:
//        • The first window is 1 2 with an average of 1.5 which should be rounded to 2
//        • The second window is 2 3 with an average of 2.5 which should be rounded to 3
//        • The third window is 3 4 with an average of 3.5, which should be rounded to 4
//        • Hence the output is 2 3 4
//        You wrote an initial version of the function, but it does not work as expected. Fix the given code to achieve the desired results.
import java.util.Scanner;
import java.util.Vector;
public class Q1_vector_window
{
    public static Vector<Integer> calc_mov_avg(int size, Vector<Integer> vec , int window_size)
    {
        Vector<Integer> newVec =new Vector<>();
        int count=0;   //to keep the index for second round until the last element reaches
        int j=0;       //to keep the index of elements in a round
        int flag=0;  //if flag is zero it means both loops should be running it means until we do not reach at the end of vector
        while(flag!=1)
        {
            float avg=0;
            for(int i=0;i<window_size;i++)
            {
                avg+=vec.get(j);
                if(j+1!=size)
                {
                    j++;
                }
                else
                {
                    flag=1;       // when we reach at the last element our both loops should be terminated so flag should be one to break the while loop
                }
            }
            newVec.add(Math.round(avg/window_size));    //putting the average values to the new vector
            count++;            //to go to one step more except the previous element
            j=count;            // the j element index should be now started from the count element index
        }
        return newVec;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Vector<Integer> vec = new Vector<>();
        System.out.println("Enter how many elements you want to enter in vector");
        int n=sc.nextInt();
        System.out.println("Enter the vec elements");
        for(int i=0;i<n;i++)
        {
            vec.add(i,sc.nextInt());
        }
        System.out.println("Enter the window size");
        int window=sc.nextInt();
        System.out.println(calc_mov_avg(n,vec,window));
    }
}

