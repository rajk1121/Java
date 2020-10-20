//In a forest, each rabbit has some color. Some subset of rabbits (possibly all of them) tell you how many other rabbits have the same color as them. Those answers are placed in an array.

//Return the minimum number of rabbits that could be in the forest.
import java.util.*;
public class Rabbits_in_forest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i=0 ; i<n; i++) {
			arr[i]=sc.nextInt();
		}
		int ans=0;
		HashMap<Integer, Integer> checkMap = new HashMap<>(); 
		for(int i= 0 ;i<n ; i++) {
			if (arr[i]==0) {
				ans++;
			}
			else if(checkMap.containsKey(arr[i])) {
				int val = checkMap.get(arr[i]);
				val=val-1;
				if(val!=0) {

					checkMap.put(arr[i], val);	
				}else {
					ans = ans+arr[i]+1;
					checkMap.remove(arr[i]);
				}
			}else {
				checkMap.put(arr[i], arr[i]);
			}
		}
		for(Map.Entry<Integer, Integer> entry : checkMap.entrySet()) {
			ans = ans + entry.getKey()+1;
		}
		System.out.println(ans);
	}

}
