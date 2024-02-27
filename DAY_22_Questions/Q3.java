//
//3.Given a string A, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.
//
//        Below is one possible representation of A = “great”:
//
//
//        great
//        /    \
//        gr    eat
//        / \    /  \
//        g   r  e   at
//        / \
//        a   t
//
//        To scramble the string, we may choose any non-leaf node and swap its two children.
//
//        For example, if we choose the node “gr” and swap its two children, it produces a scrambled string “rgeat”.
//
//        rgeat
//        /    \
//        rg    eat
//        / \    /  \
//        r   g  e   at
//        / \
//        a   t
//        We say that “rgeat” is a scrambled string of “great”.
//
//        Similarly, if we continue to swap the children of nodes “eat” and “at”, it produces a scrambled string “rgtae”.
//
//        rgtae
//        /    \
//        rg    tae
//        / \    /  \
//        r   g  ta  e
//        / \
//        t   a
//        We say that “rgtae” is a scrambled string of “great”.
//
//
//
//        Given two strings A and B of the same length, determine if B is a scrambled string of S.
//
//
//
//        Input Format:
//
//        The first argument of input contains a string A.
//        The second argument of input contains a string B.
//        Output Format:
//
//        Return an integer, 0 or 1:
//        => 0 : False
//        => 1 : True
//        Constraints:
//
//        1 <= len(A), len(B) <= 50
//        Examples:
//
//        Input 1:
//        A = "we"
//        B = "we"
//
//        Output 1:
//        1
//
//        Input 2:
//        A = "phqtrnilf"
//        B = "ilthnqrpf"
//
//        Output 2:
//        0
package DAY_22_Questions;
import java.util.Arrays;
import java.util.Scanner;
public class Q3
{
    public int isScrambleStr(String s1 , String s2)
    {
        if(s1.equals(s2))
        {
            return 1;
        }
        if(s1.length() != s2.length())
        {
            return 0;
        }
        char c1[] = s1.toCharArray();
        char c2[] = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        if(!Arrays.equals(c1,c2))
        {
            return 0;
        }
        int n= s1.length();
        for(int i=1;i<n;i++)
        {
            String s1left = s1.substring(0,i);
            String s1ryt  = s1.substring(i);
            String s2left = s2.substring(0,i);
            String s2ryt = s2.substring(i);
            String s2rytreversed = s2.substring(n-i);

//            if((isScrambleStr(s1left,s2left) == 1 && isScrambleStr(s1ryt , s2ryt)==1 ||
//            isScrambleStr(s1left , s2rytreversed)==1 && isScrambleStr(s1ryt , s2left)==1))
//            {
//
//                return 1;
//            }
            if ((isScrambleStr(s1left, s2left) == 1 && isScrambleStr(s1ryt, s2ryt) == 1) ||
                    (isScrambleStr(s1left, s2rytreversed) == 1 && isScrambleStr(s1ryt, s2left) == 1))
            {
                return 1;
            }


        }

        return 0;
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the first String");
        String s1 = sc.next();
        System.out.println("enter the second String");
        String s2 = sc.next();
        Q3 obj = new Q3();
        int ans = obj.isScrambleStr(s1 ,s2);
        System.out.println(ans);

    }
}
