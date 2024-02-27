
//2.Problem Description
//        Given two integer arrays A and B of size N. There are N gas stations along a circular route, where the amount of gas at station i is A[i].
//
//        You have a car with an unlimited gas tank and it costs B[i] of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.
//
//        Return the minimum starting gas station's index if you can travel around the circuit once, otherwise return -1.
//
//        You can only travel in one direction. i to i+1, i+2, ... n-1, 0, 1, 2.. Completing the circuit means starting at i and ending up at i again.

//        Problem Constraints
//        1 <= |A| <= 5 * 105
//        |A| == |B|
//        0 <= Ai <= 5 * 103
//        0 <= Bi <= 5 * 103

//        Input Format
//        The first argument given is the integer array A. The second argument given is the integer array B.

//        Output Format
//        Example Input
//        A = [1, 2]
//        B = [2, 1]
//        Example Output
//        1
//        Example Explanation
//        If you start from index 0, you can fill in A[0] = 1 amount of gas.
//        Now your tank has 1 unit of gas. But you need B[0] = 2 gas to travel to station 1.
//
//        If you start from index 1, you can fill in A[1] = 2 amount of gas.
//        Now your tank has 2 units of gas. You need B[1] = 1 gas to get to station 0.
//        So, you travel to station 0 and still have 1 unit of gas left over.
//        You fill in A[0] = 1 unit of additional gas, making your current gas = 2. It costs you B[0] = 2 to get to station 1, which you do and complete the circuit.
package DAY_22_Questions;
import java.util.Scanner;
public class Q2_gasStation
{
    public static int calGasAmount(int A[],int B[])
    {
        int amount=0;
        int index=0;
        for(int i=0;i<A.length;i++)
        {
            if(A[i]<B[i] )
            {
                if(amount+A[i]>=B[i])
                {
                    amount-=(B[i]-A[i]);
                }
                else
                {
                    index=i+1;
                }
            }
            else if(A[i]==B[i] || A[i]>B[i])
            {
                amount+=A[i]-B[i];
            }
        }
        if(A[0]<B[0] )
        {
            if(amount+A[0]>=B[0])         //1 +1 =2
            {
                return index;
            }
            else
            {
                return -1;
            }

        }
        return index;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the no. of stations i.e. size of array A");
        int n=sc.nextInt();
        int A[]=new int[n];
        System.out.println("Enter the amount of gas in Stations ie. elements of array A");
        for(int i=0;i<A.length;i++)
        {
            A[i]=sc.nextInt();
        }
        int B[]= new int[n];
        System.out.println("Enter the costs or required amount of gas to go from station one to other i.e. elements of Array B ");
        for(int i=0;i<A.length;i++)
        {
            B[i]=sc.nextInt();
        }
        int index=calGasAmount(A,B);
        System.out.println(index);
    }
}
