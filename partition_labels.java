/*
 *  A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

Example 1:

Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.

 */
import java.util.*;
class partNode{
	int i,  j;
	String str ;
	public partNode(int a, int b, String str) {
		i=a;
		j=b;
		this.str=str;
	}
}
class partComp implements Comparator<partNode>{
	public int compare(partNode a, partNode b) {
		return a.i - b.i;
	}
}
public class partition_labels {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "ababcbacadefegdehijhklijsgiwgkehgiehgvknghieogohegherhgernkeigekgrwgikebkvnengojeogeiegbkjebkenoehgengelhgeghiighietheihgehgoegegoehoglnldbdllllllllllll";
		
		HashSet<Character> global = new HashSet<>();
		global.add(s.charAt(0));
		HashMap<String, String> list = new HashMap<>();
		
		String cstr = "";
		cstr = cstr+s.charAt(0);
		list.put(cstr,0+" "+0);
		for(int i=1 ; i<s.length()  ;i++) {
			char x  = s.charAt(i);
			if(cstr.contains(x+"")) {
				String str = list.get(cstr);
				str = str.split(" ")[0];
				list.remove(cstr);
				list.put(cstr+x, str+" "+i);
				cstr = cstr+x;
			}else if(global.contains(x)) {
				for(Map.Entry<String, String> so : list.entrySet()) {
					if(so.getKey().contains(x+"")) {
						cstr = so.getKey();
						break;
					}
				}
				String str = list.get(cstr);
				int a=Integer.parseInt(str.split(" ")[0]);
				int b=Integer.parseInt(str.split(" ")[1]);
				Iterator<String> it = list.keySet().iterator();
				while(it.hasNext()) {
					String m = it.next();
					String val = list.get(m);
					if(Integer.parseInt(val.split(" ")[0])>=a && Integer.parseInt(val.split(" ")[1])<=i) {
						it.remove();
					}
				}
				cstr = cstr+s.substring(b+1, i+1);
				list.put(cstr, a+" "+i);
				
			}else {
				cstr = x+"";
				list.put(cstr, i+" "+i);
				global.add(x);
			}
		}
		List<Integer> ans = new ArrayList<>();
		PriorityQueue<partNode> q = new PriorityQueue<>(new partComp());
		for(Map.Entry<String, String> so : list.entrySet()) {
			partNode p = new partNode(Integer.parseInt(so.getValue().split(" ")[0] ), Integer.parseInt(so.getValue().split(" ")[1]), so.getKey());
			q.add(p);
		}
		while(q.size()!=0) {
			ans.add(q.remove().str.length());
		}
		System.out.println(ans);
		System.out.println(partition("ababcbacadefegdehijhklijsgiwgkehgiehgvknghieogohegherhgernkeigekgrwgikebkvnengojeogeiegbkjebkenoehgengelhgeghiighietheihgehgoegegoehoglnldbdllllllllllll"));
	}
	public static List<Integer> partition(String s) {
		
		
		HashMap<Character, Integer> start = new HashMap<>();
		HashMap<Character, Integer> end = new HashMap<>();
		for(int i=0 ; i<s.length(); i++) {
			if(start.containsKey(s.charAt(i))) {
				end.put(s.charAt(i), i);
			}else {
				start.put(s.charAt(i), i);
				end.put(s.charAt(i), i);
			}
		}
		List<Integer> ans = new ArrayList<>();
		int begin = -1;
		int partition=end.get(s.charAt(0));
		for(int i=0 ; i<s.length() ; i++) {
//			System.out.println(start.get(s.charAt(i))+" "+end.get(s.charAt(i))+" "+s.charAt(i));
			 if(i==partition) {
				ans.add(partition - begin);
				begin = partition;
				if(i!=s.length()-1) {
					partition = end.get(s.charAt(i+1));
				}
			}else {
				if(end.get(s.charAt(i))>partition) {
					partition= end.get(s.charAt(i));
				}
			}
			
		}
		
		
		
		
		return ans;
	}

}
