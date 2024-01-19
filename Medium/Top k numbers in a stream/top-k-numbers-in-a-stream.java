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


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];

        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            String St[] = br.readLine().split(" ");
            int N = Integer.parseInt(St[0]);
            int K = Integer.parseInt(St[1]);
           
            int[] arr = IntArray.input(br, N);
            
            Solution obj = new Solution();
            ArrayList<ArrayList<Integer>> res = obj.kTop(arr, N, K);
            
            IntMatrix.print(res);
            
        }
    }
}

// } Driver Code Ends



class Solution {
    public static ArrayList<ArrayList<Integer>> kTop(int[] arr, int n, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>(); 
        Map<Integer, Integer> freqMap = new HashMap<>();
        Map<Integer, Set<Integer>> map = new TreeMap<Integer, Set<Integer>>((x, y)->y-x);
        
        for(int i = 0; i<n; i++){
            int val = arr[i];
            int oldVal = freqMap.getOrDefault(val, 0);
            freqMap.put(val, oldVal + 1);
            
            //add in newVal
            Set<Integer> cSet = map.getOrDefault(oldVal + 1, new TreeSet<Integer>((x, y)-> x - y));
            cSet.add(val);
            map.put(oldVal + 1, cSet);
            
            //remove in olderVal
            if(oldVal != 0){
                Set<Integer> set = map.get(oldVal);
                set.remove(val);
            }
            
            //populate list
            ArrayList<Integer> list = new ArrayList<Integer>();
            for(int j = 0; j<k; ){
                for(int freq : map.keySet()){
                    for(int itVal: map.get(freq)){
                        list.add(itVal);
                        j++;
                    }
                }
                break;
            }
            if(list.size() > k){
                while(list.size() > k){
                    list.remove(k);
                }
            }
            res.add(list);
        }
        return res;
    }
}
        
