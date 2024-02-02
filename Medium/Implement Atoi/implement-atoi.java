//{ Driver Code Starts
//Initial template for JAVA

import java.util.Scanner;

class aToi
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String str = sc.nextLine();
			
			Solution obj = new Solution();
			int num = obj.atoi(str);
			
			System.out.println(num);
		t--;
		}
	}
}
// } Driver Code Ends


//User function template for JAVA

/*You are required to complete this method */
class Solution
{
    int atoi(String s) {
	// Your code here
	int ans=0,c=0,a=1;
	String s1[]=s.split("");
	if(s1.length==1)
	{
	    if(s1[0].equals("-"))
	    {
	        ans=0;
	    }
	    else if(s1[0].contains("0")|| s1[0].contains("1") || s1[0].contains("2") || s1[0].contains("3") || s1[0].contains("4") || s1[0].contains("5") ||s1[0].contains("6") ||s1[0].contains("7") ||s1[0].contains("8") ||s1[0].contains("9"))
	    {
	        ans=Integer.parseInt(String.valueOf(s1[0]));
	    }
	}
	else if(s1.length!=1){
	    if(s1[0].equals("-"))
	    {
	        for(int i=1;i<s1.length;i++)
	        {
	            if(s1[i].contains("0")|| s1[i].contains("1") || s1[i].contains("2") || s1[i].contains("3") || s1[i].contains("4") || s1[i].contains("5") ||s1[i].contains("6") ||s1[i].contains("7") ||s1[i].contains("8") ||s1[i].contains("9"))
	            {
	                c++;
	            }
	            
	        }
	        if(c==s1.length-1)
	        {
	            for(int i=s1.length-2;i>=1;i--)
	            {
	                a=a*10;
	                ans=ans+(a*(Integer.parseInt(String.valueOf(s1[i]))));
	           // System.out.println(Integer.parseInt(String.valueOf(s1[i])));
	            }    
	        
	        ans=ans+(Integer.parseInt(String.valueOf(s1[s1.length-1])));
	       // System.out.println(Integer.parseInt(String.valueOf(s1[s1.length-1])));
	        ans=ans*-1;
	        }
	        else{
	            ans=-1;
	        }
	    }
	    else
	    {
	        for(int i=0;i<s1.length;i++)
	        {
	            if(s1[i].contains("0")|| s1[i].contains("1") || s1[i].contains("2") || s1[i].contains("3") || s1[i].contains("4") || s1[i].contains("5") ||s1[i].contains("6") ||s1[i].contains("7") ||s1[i].contains("8") ||s1[i].contains("9"))
	            {
	                c++;
	            }
	            
	        }
	        if(c==s1.length)
	        {
	            for(int i=s1.length-2;i>=0;i--)
	            {
	                a=a*10;
	                ans=ans+(a*Integer.parseInt(String.valueOf(s1[i])));
	            
	            }    
	        
	        ans=ans+(Integer.parseInt(String.valueOf(s1[s1.length-1])));
	        }
	        else{
	            ans=-1;
	        }
	    }
	    
	}
	//System.out.println(s1.length+" "+c+" "+a);
	return ans;
    }
}
