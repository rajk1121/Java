import java.util.*;
public class mockvita2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int minLength = sc.nextInt();
		int maxLength = sc.nextInt();
		int minWidth = sc.nextInt();
		int maxwidth = sc.nextInt();
		List<List<Integer>> set = new ArrayList<>();
		for(int i=minLength ; i<=maxLength ; i++) {
			for(int j=minWidth ; j<=maxwidth ; j++) {
				List<Integer> minSet = new ArrayList<>();
				minSet.add(i);
				minSet.add(j);
				set.add(minSet);
			}
		}
//		System.out.println(set);
		int ans = 0;
		for(int i=0 ; i<set.size() ; i++) {
			List<Integer> temp = set.get(i);
			int len = Math.max(temp.get(0), temp.get(1));
			int wid = Math.min(temp.get(0), temp.get(1));
				int j =0;
//				System.out.println(len+" "+wid);
			while(true) {
				ans = ans + (len/wid);
//				System.out.println(len+" "+wid);
//				System.out.println(ans+"******");
				if(len%wid==0)
					break;
				int Temp = wid;
				wid = len-wid*(len/wid);
				len = Temp;
				j++;
			}
//			System.out.println(ans+"//////////////");
//			ans++;
		}
		System.out.println(ans);
	}

}
