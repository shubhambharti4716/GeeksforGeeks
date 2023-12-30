//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            String arr[] = new String[n];
            
            for(int i = 0; i < n; i++)
                arr[i] = sc.next();
            
            Solution obj = new Solution();    
            String result[] = obj.winner(arr, n);
            System.out.println(result[0] + " " + result[1]);
            
           
        }
        
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to return the name of candidate that received maximum votes.
    public static String[] winner(String arr[], int n)
    {
        // add your code
  TreeMap<String, Integer> tm = new TreeMap<>();
        
        for(String str : arr)  tm.put(str, tm.getOrDefault(str, 0)+1);
        
        String winnerName = "";
        int winnerVotes = Integer.MIN_VALUE;
        for(String key : tm.keySet()){
            if(tm.get(key) > winnerVotes){
                winnerName = key;
                winnerVotes = tm.get(key);
            }
        }
        
        return new String[]{winnerName, String.valueOf(winnerVotes)};
    }
}

