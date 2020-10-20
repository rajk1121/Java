/*
 * There are 2N people a company is planning to interview. The cost of flying the i-th person to city A is costs[i][0], and the cost of flying the i-th person to city B is costs[i][1].

Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.

 

Example 1:

Input: [[10,20],[30,200],[400,50],[30,20]]
Output: 110
Explanation: 
The first person goes to city A for a cost of 10.
The second person goes to city A for a cost of 30.
The third person goes to city B for a cost of 50.
The fourth person goes to city B for a cost of 20.

The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.

 */
public class two_city_scheduling {
	public static int twoCitySchedCost(int[][] costs) {
        int n = costs.length;
        int prefixOne[] = new int[n+1];
        int prefixTwo[] = new int[n+1];
        prefixOne[0] = 0;
        prefixTwo[0] = 0;
        for(int i=1 ; i<n+1 ; i++){
            prefixOne[i] = prefixOne[i-1] + costs[i-1][0];
            prefixTwo[i] = prefixTwo[i-1] + costs[i-1][1];
        }
//        for(int i=1 ; i<n+1 ; i++){
//            System.out.println(prefixOne[i]);
//        }
//        for(int i=1 ; i<n+1 ; i++){
//            System.out.println(prefixTwo[i]);
//        }
        
        boolean included[]= new boolean[n];
        int index = 0;
        int includedjSum = 0;
        int includediSum = 0;
        int ans = prefixOne[n/2] + prefixTwo[n] - prefixTwo[n/2]; 
        for(int i=n/2-1 ; i>=0 ; i--){
            int iAns= ans;
            int iSum = prefixOne[i];

            for(int j=i+1 ; j<=n ;j++){
//            	System.out.println(iSum + costs[j-1][0] + prefixTwo[j-1] - prefixTwo[i] + prefixTwo[n] - prefixTwo[j] - includedjSum + includediSum);
                if((iSum + costs[j-1][0] + prefixTwo[j-1] - prefixTwo[i] + prefixTwo[n] - prefixTwo[j]  - includedjSum + includediSum <= iAns) && !included[j-1] ){
                    iAns = iSum + costs[j-1][0] + prefixTwo[j-1] - prefixTwo[i] + prefixTwo[n] - prefixTwo[j] - includedjSum + includediSum;
                    index = j-1;
                }
            }
            included[index] = true;
            includedjSum+=costs[index][1];
            includediSum+=costs[index][0];
            ans = iAns;
        }
//        for(int i=1 ; i<n ; i++){
//            System.out.println(included[i]);
//        }
        
        return ans;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] costs ={{10,20},{30,200},{400,50},{30,20}};
		System.out.println(twoCitySchedCost(costs));
		
	}

}
