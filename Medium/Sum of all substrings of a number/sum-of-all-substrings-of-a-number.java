//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
	    
	    //taking input using Scanner class
		Scanner sc=new Scanner(System.in);
		
		//taking total testcases
		int t=sc.nextInt();
		sc.nextLine();
		while(t-->0)
		{
		    //taking the String
		    String s=sc.nextLine();
		    Solution ob = new Solution();
		    //calling method sumSubstrings() 
		    System.out.println(ob.sumSubstrings(s));
		}
	}
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    // Function to find sum of all possible substrings of the given string.
    public static long sumSubstrings(String s) {
        int MOD = 1000000007;
        int n = s.length();
        
        // Initialize variables to store the result
        long result = 0;
        long current = 0;
        
        // Iterate through the string
        for (int i = 0; i < n; i++) {
            // Update current value by appending digit at current position
            current = (current * 10 + (i + 1) * (s.charAt(i) - '0')) % MOD;
            
            // Add current value to result
            result = (result + current) % MOD;
        }
        
        // Return the final result
        return result;
    }
}
