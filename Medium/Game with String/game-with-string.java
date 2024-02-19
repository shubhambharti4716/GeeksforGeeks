//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String s = in.readLine();
            int k = Integer.parseInt(in.readLine());
            
            Solution ob = new Solution();
            System.out.println(ob.minValue(s, k));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int minValue(String s, int k){
        // code here
        if(s.length()== 0)return 0;
        if(s.length()==1 && k==1)return 0;
        
        int freq[] = new int[26];
        
        for(char c : s.toCharArray()){
            freq[c - 'a']++;
        }
        
        for(int i=0; i<k; i++){
            Arrays.sort(freq);
            freq[25] -= 1;
        }
        
        int sum = 0;
        for(int i=25; i>=0; i--){
            sum += freq[i]*freq[i];
        }
        
        return sum;
    }
}