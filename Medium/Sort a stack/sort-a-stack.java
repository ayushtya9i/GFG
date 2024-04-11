//{ Driver Code Starts
import java.util.Scanner;
import java.util.Stack;
class SortedStack{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			Stack<Integer> s=new Stack<>();
			int n=sc.nextInt();
			while(n-->0)
			s.push(sc.nextInt());
			GfG g=new GfG();
			Stack<Integer> a=g.sort(s);
			while(!a.empty()){
				System.out.print(a.peek()+" ");
				a.pop();
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


/*Complete the function below*/
class GfG{
	public Stack<Integer> sort(Stack<Integer> s)
	{
		//add code here.
		helper(s);
		return s;
		
	}
	void helper(Stack<Integer> s){
	    if(s.isEmpty())
	    {
	        return;
	    }
	    int top=s.pop();
	    helper(s);
	    push(s,top);
	    
	   
	}
	void push(Stack<Integer> s ,int top){
	    if(s.isEmpty()||s.peek()<=top){
	        s.push(top);
	        return;
	    }
	    int p=s.pop();
	    
	    push(s,top);
	    s.push(p);
	    
	    
	}
}