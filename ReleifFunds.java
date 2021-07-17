import java.util.*;
class set 
{
    int parent, rajRank;
};
public class ReleifFunds {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int []arr = new int[n+1];
		for(int i=1 ; i<=n ; i++){
			arr[i] = sc.nextInt();
          //System.out.println(arr[i]);
        }
		set[] cycleArr = new set[n+1];
		for(int i=1 ; i<=n ; i++) {
			cycleArr[i] = new set();
			cycleArr[i].parent = i;
			
		}
		int p = sc.nextInt();
		for(int i=0 ; i<p ; i++) {
			int x1 = sc.nextInt();
			int x2 = sc.nextInt();
			if(x1>x2) {
				int temp = x1;
				x1 = x2;
				x2 = temp;
			}
			System.out.println(x1+" "+x2);
			Union(cycleArr, x1, x2);
		}
		int[] members = new int[n+1];
		int ans = 0, countMem = Integer.MAX_VALUE, ansP = -1;
		int[] funds = new int[n+1];
		for(int i=1 ; i<=n ; i++) {
			System.out.println(cycleArr[i].parent);
			setParent(cycleArr, i);
		}

		System.out.println("**************");
		for(int i=1 ; i<=n ; i++) {
			System.out.println(cycleArr[i].parent);
			int par = cycleArr[i].parent;
			funds[par] += arr[i];
			members[par]++;
		}
		for(int i=1 ; i<=n ; i++) {
			System.out.println(funds[i]+ " "+members[i]);
			if(ans==funds[i] && countMem>members[i]) {
				ans = funds[i];
				countMem = members[i];
				ansP = i;
			}else if(ans<funds[i]) {
				ans = funds[i];
				countMem = members[i];
				ansP = i;
			}
		}
		String ansStr = "";
		for(int i=1;  i<=n ; i++){
			if(cycleArr[i].parent==ansP) {
				ansStr = ansStr+i+" ";
			}
		}
      System.out.print(ansStr+" "+countMem);		
	}
	 static int setParent(set[] cycleArr, int i) {
		// TODO Auto-generated method stub
		 if(cycleArr[i].parent==i) {
			 return i;
		 }
		 cycleArr[i].parent = setParent(cycleArr, cycleArr[i].parent);
		 return cycleArr[i].parent;
	}
	static int find(set rajSubset[], int p)
    {
        
        if (rajSubset[p].parent != p)
            rajSubset[p].parent
                = find(rajSubset, rajSubset[p].parent);
 
        return rajSubset[p].parent;
    }
 
	static void Union(set rajSubset[], int x, int y)
    {
      	
        int yroot = find(rajSubset, y);
        int xroot = find(rajSubset, x);
 
        if (rajSubset[xroot].rajRank 
            < rajSubset[yroot].rajRank)
            rajSubset[xroot].parent = yroot;
        else if (rajSubset[xroot].rajRank 
                 > rajSubset[yroot].rajRank)
            rajSubset[yroot].parent = xroot;
 
        else {
            rajSubset[yroot].parent = xroot;
            rajSubset[xroot].rajRank++;
        }
    }

}
