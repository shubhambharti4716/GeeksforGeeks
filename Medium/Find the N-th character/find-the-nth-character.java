//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;


class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String S = sc.next();
                    int R = sc.nextInt();
                    int N = sc.nextInt();
                    Solution obj = new Solution();
                    System.out.println(obj.nthCharacter(S,R,N));
                }
                
        }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public char nthCharacter(String s, int r, int n)
    {
        //code here
        
        int l=s.length();
        for(int i=0; i<r; i++){
            StringBuilder sb=new StringBuilder();
            for(char c:s.toCharArray()){
                
                if(c=='1') sb.append("10");
                else sb.append("01");
                if(sb.length()>s.length()) break;
            }
            s=sb.toString();
        }
        return s.charAt(n);
    }
}