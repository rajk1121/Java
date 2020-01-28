import java.util.*;
public class nonDivisibleSubset {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		ArrayList<Integer> ansList = new ArrayList<>();
		int k = sc.nextInt();
		int[] arr =new int[n];
		for(int i=0; i<n ; i++) {
			arr[i]=sc.nextInt();
		}
		int max=0;
		boolean[] arrb = new boolean[n];
		for(int i=0 ; i<n; i++) {

			ArrayList<Integer> tempList = new ArrayList<>(); 
			tempList.add(arr[i]);
			for(int j=i+1;j<n;j++) {
				int size = tempList.size();
				int m;
				for( m=0 ; m<size;m++) {
					if((tempList.get(m)+arr[j])%k==0) {
//						tempList.add(arr[j]);
						break;
					}
				}
				if(m==tempList.size()) {
					tempList.add(arr[j]);
				}
				
			}
			if(tempList.size()>=ansList.size()) {
				ansList = tempList;
			}
		}
		System.out.println();
		System.out.println(ansList.size());
	}

}
