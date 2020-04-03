/*
 * 
A player can win only when his/her beyblade power is strictly greater than the opponents beyblade power.
 Team G-Revolution wants to win at any cost and for that, they need the order in which they have to fight optimally to win the maximum number of battles.
 * The first line of input consists of the number of test cases, T

The first line of each test case consists of the number of members each team can have, N.

The second line of each test case consists of N space-separated integers representing the power of beyblades of Team G-Revolution members.

The third line of each test case consists of N space-separated integers representing the power of beyblades of opponent team members.
 */
import java.util.*;
public class tech_gladiator_II {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

    	Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while(T>0){
        	int N = sc.nextInt();
        	int[] arr1 = new int[N];
        	for(int i=0 ; i<N; i++)
        		arr1[i] = sc.nextInt();
        	int arr2[] = new int[N];
        	for(int i=0 ; i<N ; i++)
        		arr2[i] = sc.nextInt();
        	Arrays.sort(arr1);
        	Arrays.sort(arr2);
        	int i=N-1;
        	int j = N-1;
        	int answer=0;
        	while(i>=0 && j>=0) {
        		if(arr1[i]>arr2[j]) {
        			answer++;
        			i--;
        			j--;
        		}else {
        			j--;
        		}
        	}
        	System.out.println(answer);
        	
            T--;
        }
        sc.close();

	}

}
