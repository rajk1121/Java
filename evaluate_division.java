import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
class Evaluate_Node{
    String c;
    double time;
   public Evaluate_Node(String a, double b){
        c =a;
        time =b;
    }
}
class evaluate_division {
    public static List<Double> networkDelayTime(List<List<String>> equations, double[] values, List<List<String>> queries) {
     
    	HashMap<String, List<Evaluate_Node>> set = new HashMap<>();
    	for(int i=0 ; i<equations.size() ; i++) {
    		if(set.containsKey(equations.get(i).get(0))) {
    			Evaluate_Node n =new Evaluate_Node(equations.get(i).get(1), values[i]);
    			set.get(equations.get(i).get(0)).add(n);
    		}else {
    			Evaluate_Node n =new Evaluate_Node(equations.get(i).get(1), values[i]);
    			List<Evaluate_Node> temp =  new ArrayList<>();
    			temp.add(n);
    			set.put(equations.get(i).get(0), temp);
    		}
    		if(set.containsKey(equations.get(i).get(1))) {
    			Evaluate_Node n =new Evaluate_Node(equations.get(i).get(0), 1/values[i]);
    			set.get(equations.get(i).get(1)).add(n);
    		}else {
    			Evaluate_Node n =new Evaluate_Node(equations.get(i).get(0), 1/values[i]);
    			List<Evaluate_Node> temp =  new ArrayList<>();
    			temp.add(n);
    			set.put(equations.get(i).get(1), temp);
    		}
    	}
    	HashMap<String, Double> udist = new HashMap<>();
    	for(Map.Entry<String, List<Evaluate_Node>> s: set.entrySet()) {
    		udist.put(s.getKey(), Integer.MAX_VALUE+0.0);
    	}
    	List<Double> fans= new ArrayList<>();
    	for(int j=0 ; j<queries.size() ; j++) {
    		String s = queries.get(j).get(0);
    		String t = queries.get(j).get(1);
    		
    		double qans = -1.0;
			if(!set.containsKey(s) || !set.containsKey(t)) {
			    fans.add(-1.0)	;
			    continue;
    		}
    		if(s == t) {
    			fans.add(1.0);
    			continue;
    			
    		}
    		HashMap<String, Integer>visited = new HashMap<>();
    	    
    		HashMap<String, Double> dist = (HashMap<String, Double>) udist.clone();
    		dist.put(s, 1.0);
    		while(true){
                String ans = find(dist, visited, set);
                if(ans=="")
                    break;
                if(!set.containsKey(ans)) {
                	continue;
                }
                for(int i=0 ; i<set.get(ans).size(); i++){
                    if(dist.get(set.get(ans).get(i).c) > dist.get(ans) * set.get(ans).get(i).time) {
                    	dist.put(set.get(ans).get(i).c, dist.get(ans) * set.get(ans).get(i).time);
                    }
                    if( (set.get(ans).get(i).c == t)) {
                    	qans = (dist.get(set.get(ans).get(i).c));
                    	break;
                    }
                }
                if(qans!=-1.0) {
                	
                	break;
                }
            }
    		fans.add(qans);
    	    
    	}
        
    	double[] d = new double[fans.size()];
    	for(int i=0 ; i<fans.size() ; i++) {
    		d[i] = fans.get(i);
    	}
    	return fans;
    }
    public static String find(HashMap<String, Double> dist, HashMap<String, Integer> visited, HashMap<String, List<Evaluate_Node>> set){
        double min = Integer.MAX_VALUE+0.0;
        String ans  ="";
        for(Map.Entry<String, List<Evaluate_Node>> s: set.entrySet()){
            if(dist.get(s.getKey())<min && !visited.containsKey(s.getKey())){
                ans = s.getKey();
                min = dist.get(s.getKey());
            }
        }
        if(ans!=""){
            visited.put(ans, 1);
        }
        return ans;
        
    }
    public static void main(String[] ar) {
    	List<List<String>> equations = new ArrayList<>();
    	List<String> s = new ArrayList<>();
    	s.add("a");
    	s.add("b");
    	equations.add(s);
    	 s = new ArrayList<>();
     	s.add("b");
     	s.add("c");
     	equations.add(s);
     	 s = new ArrayList<>();
     	s.add("a");
     	s.add("d");
     	equations.add(s);
     	 s = new ArrayList<>();
     	s.add("c");
     	s.add("e");
     	equations.add(s);
     	double[] values = {2.0,4.0,2.0,2.0};
     	List<List<String>> queries = new ArrayList<>();
    	s = new ArrayList<>();
    	s.add("a");
    	s.add("c");
    	queries.add(s);
    	 s = new ArrayList<>();
     	s.add("c");
     	s.add("a");
     	queries.add(s);
     	 s = new ArrayList<>();
     	s.add("a");
     	s.add("d");
     	queries.add(s);
          	 s = new ArrayList<>();
      	s.add("a");
      	s.add("a");
      	queries.add(s);
     	 s = new ArrayList<>();
      	s.add("x");
      	s.add("x");
      	queries.add(s);
//      	System.out.println(values.length);
//      	System.out.println(equations.size());
//      	System.out.println(queries.size());
    	System.out.println(networkDelayTime(equations, values, queries));
    }
}