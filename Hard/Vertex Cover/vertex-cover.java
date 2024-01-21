//{ Driver Code Starts
import java.io.*;
import java.util.*;


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
            
            int n; 
            n = Integer.parseInt(br.readLine());
            
            
            int m; 
            m = Integer.parseInt(br.readLine());
            
            
            int[][] edges = IntMatrix.input(br, m, 2);
            
            Solution obj = new Solution();
            int res = obj.vertexCover(n, m, edges);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int vertexCover(int n, int m, int[][] edges) {
        //int vertices=n+1;
        List<Integer>[] lst=new ArrayList[n+1];
        for(int i=0;i<n+1;i++)
            lst[i]=new ArrayList<Integer>();
        for(int i=0;i<edges.length;i++)
        {
            lst[edges[i][0]].add(edges[i][1]);
            lst[edges[i][1]].add(edges[i][0]);
        }
        boolean[] visited=new boolean[n+1];
        Arrays.fill(visited,false);
        return vertex(lst,visited,1,0,n,m);
    }
    public static int vertex(List<Integer>[] adj,boolean[] vis,int i
    ,int cnt,int vertices,int edges)
    {
        if(cnt>edges)
            return 10000;
        if(cnt==edges)
            return 0;
        if(i>vertices)
            return 10000;
        int nottake=vertex(adj,vis,i+1,cnt,vertices,edges);
        vis[i]=true;
        for(int j=0;j<adj[i].size();j++)
        {
            if(!vis[adj[i].get(j)])
                cnt++;
        }
        int take=1+vertex(adj,vis,i+1,cnt,vertices,edges);
        vis[i]=false;
        cnt--;
        //System.out.println(take);
        return Math.min(nottake,take);
    }
}
        
