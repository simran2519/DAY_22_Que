package DAY_22_Questions;

import java.util.Scanner;

class Strings
{
    private String str;
    public Strings(String str){
        this.str=str;
    }
    //function of concatenation
    public String conc(String str)
    {
        return this.str+str;
    }
}
public class Question_4
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the string 1");
        String str1=sc.next();
        Strings str= new Strings(str1);
        System.out.println("Enter the string 2");
        String str2=sc.next();
        String ans=str.conc(str2);
        System.out.println(ans);
    }
}
