
public class buy_sell_stock_cooldown {
    public static int maxProfit(int[] prices) {
        
        int n = prices.length;
        if(n==1 || n==0)
            return 0;
        if(n==2)
            return Math.max(0, prices[1]-prices[0]);
        int left[] = new int[n];
        boolean cooldown  =false;

        boolean start = false;
        int min = 0;
        left[0] = 0;
        left[1] = Math.max(0, prices[1]-prices[0]);
        if(prices[1]<prices[min])
            min = 1;
        if(prices[2]<prices[1]){
            if(prices[2]<prices[min])
                min = 2;
            cooldown = true;
            left[2] = left[1];
        }else{
            left[2] = left[1]+prices[2]-prices[1];
        }
//            min=4;
//        int min = 0;
        if(prices[0]<prices[1])
        	start = true;
        if(prices[2]>prices[1])
        	start = true;
        boolean minfound = false;
        if(prices[2]<prices[1]) {
        	left[2] = left[1];
            cooldown = true;
            if(prices[min]>=prices[2]) {
                min = 2;
                minfound = true;
            }
        	
        }
        System.out.println(prices[min]);
//        System.out.println(minfound);
        for(int i=3 ; i<n ; i++){
            if(prices[i]>=prices[i-1]){
                if(!cooldown)
                    left[i] = Math.max(prices[i]-prices[min], left[i-1]+prices[i]-prices[i-1]);
                    
                else{
                    
            // System.out.print("hi");
                    if(!start) {
                    	left[i] = Math.max(left[i-2], Math.max(left[i-3]+prices[i]-prices[i-1], prices[i]-prices[min]+left[min]));
                    	start= true;
                    }
                else if(minfound) {
                	System.out.println(left[i-2]+" "+(left[i-3]+prices[i]-prices[i-1]));
                    	left[i] = Math.max(left[i-2], left[i-3]+prices[i]-prices[i-1]);
                    	minfound = false;
                    }
                    else {
                    	if(min>=2)
                    		left[i] = Math.max(left[i-2], Math.max(left[i-3]+prices[i]-prices[i-1], prices[i]-prices[min]+left[min-2]));
                    	else
                    		left[i] = Math.max(left[i-2], Math.max(left[i-3]+prices[i]-prices[i-1], prices[i]-prices[min]+left[min]));
                    	
                    }
                    if(left[i]  == left[i-2])
                        min = i;
                    else if(left[i] == left[i-3]+prices[i]-prices[i-1])
                        min = i-1;
                    cooldown = false;
                }
            }else{
                left[i] = left[i-1];
                cooldown = true;
                if(prices[min]>prices[i]) {
                    min = i;
                    minfound = true;
                }
            }
            System.out.println(prices[min]+" "+left[i]);
        }
//        System.out.println();
        for(int i=0 ; i<n; i++)
            System.out.print(left[i]+" ");
        return left[n-1];
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {25,50,44,100,90,200,250,230,550};
		System.out.println(maxProfit(nums));
	}

}
