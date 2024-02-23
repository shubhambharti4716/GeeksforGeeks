//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);
        
        return a;
    }
    
    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
    
    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine().trim());
        while(t-- > 0){
            
            int n; 
            n = Integer.parseInt(br.readLine().trim());
            
            
            int[] price = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.maxProfit(n, price);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int maxProfit(int n, int[] price) {
        int[] profit = new int[n];
        
        // Get the maximum profit with only one transaction allowed
        int maxPrice = price[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            if (price[i] > maxPrice)
                maxPrice = price[i];
            
            profit[i] = Math.max(profit[i + 1], maxPrice - price[i]);
        }
        
        // Get the maximum profit with two transactions allowed
        int minPrice = price[0];
        for (int i = 1; i < n; i++) {
            if (price[i] < minPrice)
                minPrice = price[i];
            
            profit[i] = Math.max(profit[i - 1], profit[i] + (price[i] - minPrice));
        }
        
        return profit[n - 1];
    }
}
        
