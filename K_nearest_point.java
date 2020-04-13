import java.util.*;
class pair{
	int first;
	int second;
	pair(int f, int s){
		this.first = f;
		this.second = s;
	}
}
public class K_nearest_point {
	
	 public static ArrayList<pair> kNeighbourPoints(ArrayList<pair> points, pair P, int K)
	    {
	        
	        ArrayList<pair> ans = new ArrayList<>();
	        if(points.size()==0){
	            return ans;
	        }
	        HashMap<Double, List<pair>> set = new HashMap<>();
	        HashMap<String, Integer> set2 = new HashMap<>();
	        double[] arr = new double[points.size()];
	       Arrays.fill(arr, -1);
//	       System.out.println(arr[0]);
	        int l=0;
	       for(int i=0 ; i<points.size() ; i++){
	            int x = points.get(i).first;
	            int y = points.get(i).second;
	            double dist = Math.sqrt(Math.pow(P.first-x,2) + Math.pow(P.second  - y, 2));
//	            System.out.println(dist);
	            if(set.containsKey(dist)){
	                String s = points.get(i).first + " " + points.get(i).second;
	                if(!set2.containsKey(s)){
	                    set.get(dist).add(points.get(i));
	                    set2.put(s,1);
//	                    arr[l] = dist;
//	                    System.out.println(arr[l]);
//	                    l++;
	                }
	            }else{
	                
	                String s = points.get(i).first + " "+points.get(i).second;
	                List<pair> temp = new ArrayList<>();
	                temp.add(points.get(i));
	                set.put(dist, temp);
	                set2.put(s, 1);
	                arr[l] = dist;
//                    System.out.println(arr/[l]);
	                l++;
	            }
	            
	        }
	        
	        Arrays.sort(arr);
	        int i=arr.length - l ;
	        for(i=0 ; i<arr.length; i++) {
	        	if(set.containsKey(arr[i])) {
	        		ans.addAll(set.get(arr[i]));
	        	}
	        }
	        return ans;
	    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 5;
		ArrayList<pair> q = new ArrayList();
		pair p1 = new pair(-2,-1);
		q.add(p1);
		pair p2 = new pair(0,0);
		q.add(p2);
		pair p3 = new pair(1,4);
		q.add(p3);
		pair p4 = new pair(-1,0);
		q.add(p4);
		pair p5 = new pair(1,1);
		q.add(p5);
		pair a = new pair(0,0);
		List<pair> ans = 		kNeighbourPoints(q, a, 3);
		for(int i=0 ; i<3 ; i++) {
			System.out.println(ans.get(i).first+" "+ans.get(i).second);
		}
		

	}

}
