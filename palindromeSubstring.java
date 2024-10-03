import java.util.Scanner;

public class palindromeSubstring
{
    static void  method(String s)
        {
            int length = s.length();
            boolean[][] dp = new boolean[length][length];
            int longest_Palindrome = 1;
            for(int iterator = 0; iterator< length; iterator++)
            {
                dp[iterator][iterator] = true;
                // bala -- "b" "a" "l" "a"
                //setting the all base strings as palindrome itself
            }
            int start = 0;
            for(int jterator =0; jterator<length-1;jterator++)
            {
                if(s.charAt(jterator)==s.charAt(jterator+1))
                // bala -- "ba"=="al", "al"=="la"
                {
                    dp[jterator][jterator+1] = true;
                    start = jterator;
                    longest_Palindrome = 2;
                    // checking two consecutive string are palindrome and setting the longest palindrome as 2 length string
                }
            }

            for(int kterator = 3; kterator<=length;kterator++)
            //this loop is for finding the longer substring in the palindrome
            {
                for(int iterator = 0; iterator< length - kterator + 1;iterator ++)
                {
                    int jterator = iterator + kterator - 1 ;
                     if(dp[iterator +1][jterator -1] && s.charAt(iterator)==s.charAt(jterator))
                     {
                         dp[iterator][jterator]=true;

                         if(kterator > longest_Palindrome)
                         {
                             start = iterator;
                             longest_Palindrome = kterator;
                         }
                     }
                }
            }
            System.out.println(s.substring(start,start + longest_Palindrome));
        }

    public static void main(String[] args)
        {
            Scanner sc = new Scanner(System.in);
            String s = sc.nextLine();
            method(s);
        }
}
