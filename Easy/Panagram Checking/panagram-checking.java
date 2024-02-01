//{ Driver Code Starts
//Initial template for JAVA

import java.lang.*;
import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function template for JAVA

class Solution
{
    //Function to check if a string is Pangram or not.
    public static boolean checkPangram  (String s) {
        // your code here
        int a[]=new int[26];
        int count=0;
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            if(ch >='A' && ch <='Z') ch = (char)(ch+32);
            if(ch >= 'a' && ch <= 'z' && a[ch-'a']==0){
                a[ch-'a']++;
                count++;
            }
        }
        return count==26;
    }
}

//{ Driver Code Starts.

class GFG
 {
	public static void main (String[] args) throws IOException
	 {
	  BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	  int t=Integer.parseInt(br.readLine());
	  while(t-->0)
	  {
	    String s=br.readLine().trim();
	    
	    System.out.println(new Solution().checkPangram (s)==true?1:0);
	  }
	  
	 }
}
// } Driver Code Ends