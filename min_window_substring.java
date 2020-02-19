import java.util.*;
public class min_window_substring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String t= sc.next();
		String ans = function(s,t);
		System.out.println(ans);
	}
	public static String function(String s,  String t) {
		int ans=0;
		HashMap<Character, Integer> hms = new HashMap<>();
		HashMap<Character, Integer> hmt = new HashMap<>();
		for(int i=0 ; i<t.length();i++) {
			if(hmt.containsKey(t.charAt(i))) {
				hmt.put(t.charAt(i), hmt.get(t.charAt(i))+1);
			}else {
				hmt.put(t.charAt(i), 1);
			}
		}
		int count=0;
		int omin=Integer.MAX_VALUE;
		int ri=0;
		int rj=0;
		int i=0; 
		int j=0;
		while(j<s.length()) {
			if(!hms.containsKey(s.charAt(j)) && hmt.containsKey(s.charAt(j))) {
				hms.put(s.charAt(j), 1);
				count++;
			}else if(hms.containsKey(s.charAt(j)) && hmt.containsKey(s.charAt(j))) {
				int im = hms.get(s.charAt(j));
				if(im<hmt.get(s.charAt(j))) {
					hms.put(s.charAt(j), hms.get(s.charAt(j))+1);
					count++;
				}else {
					hms.put(s.charAt(j), hms.get(s.charAt(j))+1);
				}
			}
			else if(!hmt.containsKey(s.charAt(j))) {
				if(hms.containsKey(s.charAt(j))) {
					hms.put(s.charAt(j), hms.get(s.charAt(j))+1);
				}else {
					hms.put(s.charAt(j), 1);
				}
			}
			if(count==t.length()) {
				break;
			}
			j++;
		}
		if(j>=s.length()) {
			return "";
		}
//		if(j==s.length()-1) {
//			return s.substring(i);
//		}
		ri=i;
		rj=j;
		omin = j-i;
		boolean job=  true;
		while(job || (j<s.length() && i<j && i<s.length() )) {
			if(job && i<s.length()) {
				if(hmt.containsKey(s.charAt(i)) && (hms.get(s.charAt(i)) == hmt.get(s.charAt(i)))) {
					job=false;
					hms.put(s.charAt(i), hms.get(s.charAt(i))-1);
					i++;
//					System.out.println(hms.get(s.charAt(i)));
//					
//					System.out.println(hms);
					count--;
					int min = j-i+1;
					if(min<omin) {
						omin=min;
						ri=i;
						rj=j+1;
					}
				}else if(hms.containsKey(s.charAt(i))) {
					hms.put(s.charAt(i), hms.get(s.charAt(i))-1);
					i++;
				}
			}else {
				j++;
				if(j>=s.length()) {
					break;
				}
				if(hmt.containsKey(s.charAt(j)) && hms.containsKey(s.charAt(j)) && (hms.get(s.charAt(j)) < hmt.get(s.charAt(j)))) {
					count++;
					hms.put(s.charAt(j), hms.get(s.charAt(j))+1);
					if(count==t.length()) {
						job=true;
					}
				}else if(hmt.containsKey(s.charAt(j)) && hms.containsKey(s.charAt(j))) {
					hms.put(s.charAt(j), hms.get(s.charAt(j))+1);
				}else if(!hmt.containsKey(s.charAt(j))) {
					if(hms.containsKey(s.charAt(j))) {
						hms.put(s.charAt(j), hms.get(s.charAt(j))+1);
					}else {
						hms.put(s.charAt(j), 1);
					}
				}
			}
//			System.out.println(i+" "+j);
		}
		if(ri==0) {
			return s.substring(ri,rj+1);
		}
//		System.out.println(ri+" "+rj);
		return s.substring(ri-1,rj);
	}

}
