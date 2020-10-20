import java.util.*;
class stringComp implements Comparator<String>{
	public int compare(String a, String b) {
		return a.compareTo(b);
	}
}
public class reconstruct_itinerary {
	static List<String> ans;
	public static List<String> findItinerary(List<List<String>> tickets) {
       if(tickets.size()==0)
    	   return new ArrayList<>();
       HashMap<String, List<String>> set = new HashMap<>();
       for(int i=0 ; i<tickets.size() ; i++) {
    	   if(set.containsKey(tickets.get(i).get(0))) {
    		   set.get(tickets.get(i).get(0)).add(tickets.get(i).get(1));
    	   }else {
    		   List<String> list = new ArrayList<>();
    		   list.add(tickets.get(i).get(1));
    		   set.put(tickets.get(i).get(0), list);
    	   }
    		   
       }
       for(Map.Entry<String, List<String>> s: set.entrySet()) {
    	   Collections.sort(s.getValue());
       }
       System.out.println(set);
       HashMap<String, HashSet<String>> set2 = new HashMap();
       set2.put("JFK", new HashSet());
       for(int i=0 ; i<set.get("JFK").size();i++) {
    	   set2.get("JFK").add(set.get("JFK").get(i));
    	   
       }
		return ans;
    }
	public static void generate(HashMap<String, PriorityQueue<String>> set,String s,String parent,List<String> toInsert, List<String> ians ) {
		

//		System.out.println(q.size()+" "+child);
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<List<String>> tickets =  new ArrayList<>();
		List<String> a = new ArrayList<>();
		a.add("JFK");
		a.add("SFO");
		tickets.add(a);
		a = new ArrayList<>();
		a.add("JFK");
		a.add("ATL");
		tickets.add(a);
		a = new ArrayList<>();
		a.add("ATL");
		a.add("JFK");
		tickets.add(a);
		a = new ArrayList<>();
		a.add("ATL");
		a.add("SFO");
		tickets.add(a);
		a = new ArrayList<>();
		a.add("JFK");
		a.add("AAA");
		tickets.add(a);
		a = new ArrayList<>();
		a.add("JFK");
		a.add("DDD");
		tickets.add(a);
		System.out.println(findItinerary(tickets));
		

	}

}
