import java.util.*;
class Network_Node{
    int c;
    int time;
   public Network_Node(int a, int b){
        c =a;
        time =b;
    }
}
class network_delay {
    public static int networkDelayTime(int[][] times, int N, int K) {
     
        boolean visited[] = new boolean[N+1];
        int dist[] = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        HashMap<Integer, List<Network_Node>> set = new HashMap<>();
        for(int i=0 ; i<times.length ; i++){
            if(set.containsKey(times[i][0])){
                Network_Node n = new Network_Node(times[i][1], times[i][2]);
                set.get(times[i][0]).add(n);
            }else{
                List<Network_Node> temp = new ArrayList<>();
                  Network_Node n = new Network_Node(times[i][1], times[i][2]);
                temp.add(n);
                set.put(times[i][0], temp);
            }
        }
        dist[K] = 0;
        while(true){
            int ans = find(dist, visited);
            if(ans==-1)
                break;
            if(!set.containsKey(ans)) {
            	continue;
            }
            for(int i=0 ; i<set.get(ans).size(); i++){
                if(dist[set.get(ans).get(i).c]>dist[ans] + set.get(ans).get(i).time){
                    dist[set.get(ans).get(i).c] = dist[ans] + set.get(ans).get(i).time;
                }
            }
        }
        int ans = 0;
        for(int i=1 ; i<=N ; i++){
            if(dist[i]==Integer.MAX_VALUE){
                return -1;
            }else{
                ans = Math.max(ans, dist[i]);
            }
        }
        return ans;
    }
    public static int find(int[] dist, boolean[] visited){
        int min = Integer.MAX_VALUE;
        int ans  =-1;
        for(int i=0 ; i<dist.length; i++){
            if(dist[i]<min && !visited[i]){
                ans = i;
                min = dist[i];
            }
        }
        if(ans!=-1){
            visited[ans]= true;
        }
        return ans;
        
    }
    public static void main(String[] ar) {
    	int[][] times = {{2,1,1},{2,3,1},{3,4,1}};
    	int K =2;
    	int N=  4;
    	System.out.println(networkDelayTime(times, N, K));
    }
}