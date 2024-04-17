//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Recursion {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();//testcases
		while(T-->0)
		{
		    Solution obj=new Solution();
		    
		    int n,k;
		    //taking input n and k
		    n=sc.nextInt();
		    k=sc.nextInt();
		    
		    //calling josephus() function
		    System.out.println(obj.josephus(n,k));
		    
		    
		}
		
	}
}


// } Driver Code Ends


class Solution
{
   public int josephus(int n, int k)
    {
         ArrayList<Integer> list= new ArrayList<>();
        for(int i=1;i<=n;i++)
        {
            list.add(i);
        }
        return helper(n,k-1,0,list);
    }
    int helper(int n,int k,int ci,ArrayList<Integer> list)
    {
        if(list.size()==1)
        {
            return list.get(0);
        }
        int remIn=(ci+k)%list.size();
        list.remove(remIn);
        return helper(n,k,remIn,list);
    }
}