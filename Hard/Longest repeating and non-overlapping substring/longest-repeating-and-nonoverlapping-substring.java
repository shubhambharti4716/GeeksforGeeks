//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            int N = Integer.parseInt(read.readLine());
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.longestSubstring(S, N));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    static String longestSubstring(String s, int n) {
        // code here
        int lcsRe[][] =new int[n+1][n+1];
        // String res="";
        // int resL=0;
        // int i,index=0;
        int max=0,end=-1;
        for(int i=1;i<=n;i++){
            for(int j=i+1;j<=n;j++){
                if(s.charAt(i-1)==s.charAt(j-1)&&lcsRe[i - 1][j - 1] < (j - i)){
                    lcsRe[i][j]=lcsRe[i-1][j-1]+1;
                    // if(lcsRe[i][j]>resL){
                    //     resL=lcsRe[i][j];
                    //     index=Math.max(i,index);
                    // }
                    if(max<Math.min(j-i,lcsRe[i][j])){
                        end=j;
                        max=Math.min(j-i,lcsRe[i][j]);
                        
                    }
                    // else{
                    //     lcsRe[i][j]=0;
                    // }
                }
            }
        }
        if(end==-1)
        return "-1";
        return s.substring(end-max,end);
            // return max>0 ? s.substring(end-max,end):"-1";
            // if(resL>0){
            //     for(i=index-resL+1;i<=index;i++){
            //         res+=s.charAt(i-1);
            //     }
            // }
            // return res;
        }
};