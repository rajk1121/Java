import java.util.*;
public class mockvita1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		String bride = sc.next();
		String groom = sc.next();
		HashMap<Character, Integer> g = new HashMap<>();
		for(int i=0 ; i<n ; i++) {

			if(groom.charAt(i)=='r') {
				if(!g.containsKey('r'))
					g.put('r', 1);
				else
					g.put('r', g.get('r')+1);
			}else {

				if(!g.containsKey('m'))
					g.put('m', 1);
				else
					g.put('m', g.get('m')+1);
			}
		}
		int ans = 0;
//		System.out.println(g);
		for(int i=0 ; i< n; i++) {
			if(g.containsKey(bride.charAt(i))) {
				g.put(bride.charAt(i), g.get(bride.charAt(i))-1);
				if(g.get(bride.charAt(i))==0)
					g.remove(bride.charAt(i));
			}else {
				ans = n - i;
				break;
			}
//			System.out.println(g);
		}
	System.out.println(ans);
	}

}
