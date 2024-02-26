//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            Solution ob = new Solution();
            List<String> ans = ob.AllPossibleStrings(s);
            for(String i: ans)
                System.out.print(i + " ");
            System.out.println();
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    public List<String> AllPossibleStrings(String s)
    {
        List<String> list = new ArrayList<>();
        subSet(s,list,"",0);
        Collections.sort(list);
        return list;
    }
    public static void subSet(String s,List<String> list,String str,int pos){
        
        if(pos == s.length()){
            return ;
        }
        
        String curr = str;
        str += s.charAt(pos);
        list.add(str);
        subSet(s,list,str,pos+1);
        
        str = curr;
        subSet(s,list,str,pos+1);
    }
}