//{ Driver Code Starts
import java.io.*; 
import java.util.*; 
import java.lang.*;

class Main
{
    public static void main (String[] args) throws IOException  
    {
        
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//testcases
		int t = Integer.parseInt(br.readLine().trim());
		
		while(t-- > 0)
		{
		    String inputLine[] = br.readLine().trim().split(" ");
		    //size of array
		    int n = Integer.parseInt(inputLine[0]);
		    int start[] = new int[n];
		    int end[] = new int[n];
		    
		    //adding elements to arrays start and end
		    inputLine = br.readLine().trim().split(" ");
		    for(int i = 0; i < n; i++)
		     start[i] = Integer.parseInt(inputLine[i]);
		    
		    inputLine = br.readLine().trim().split(" ");
		    for(int i= 0; i < n; i++)
		      end[i] = Integer.parseInt(inputLine[i]);
		    
		    //function call
		    System.out.println(new Solution().activitySelection(start, end, n));
		}
    }
}


// } Driver Code Ends



class meeting {
    int start, end, pos;
    meeting(int s, int e, int p) {
        start = s;
        end = e;
        pos = p;
    }
}
class meetingComparator implements Comparator<meeting> {
@Override
public int compare(meeting o1, meeting o2) {
if (o1.end < o2.end)
return -1;
else if (o1.end > o2.end)
return 1;
else if(o1.pos < o2.pos)
return -1;
return 1;
}
}
class Solution
{
    //Function to find the maximum number of activities that can
    //be performed by a single person.
    public static int activitySelection(int start[], int end[], int n)
    {
        // add your code here
        ArrayList<meeting> meet = new ArrayList<>();
        for(int i=0;i<start.length;i++){
            meet.add(new meeting(start[i],end[i],i+1));
        }
        meetingComparator mc= new meetingComparator();
        Collections.sort(meet,mc);
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(meet.get(0).pos);
        int limit = meet.get(0).end;
        
        for(int i=1;i<start.length;i++){
            if(meet.get(i).start>limit){
                answer.add(meet.get(i).pos);
                limit=meet.get(i).end;
            }
        }
        return answer.size();
    }
}