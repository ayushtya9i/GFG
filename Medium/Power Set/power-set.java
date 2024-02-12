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
        // Code here
        List<String> ans = new ArrayList<>();
        int n=s.length();
        String t="";
        helper(s,ans,0,t,n);
        Collections.sort(ans);
        return ans;
    }
    public static void helper(String s,List<String> ans,int i,String c,int n){
        if(i==n){
            if(c.length()!=0){
                ans.add(c);
            }
            return;
        }
        helper(s,ans,i+1,c+s.charAt(i),n);
        helper(s,ans,i+1,c,n);
    }
}