import java.util.*;
public class valid_IP {
	public static String validIPAddress(String IP) {
//		System.out.println(IP);
        String[] arr = IP.split("\\.");
//        System.out.println(arr.length);
        if(arr.length>=2){
            if(arr.length<4)
                return "Neither";
            for(int i=0 ; i<4 ; i++){
                String toCheck = arr[i];
                if(!ipv4Valid(toCheck))
                    return "Neither";
            }
            return "IPv4";
        }else{
            arr = IP.split(":");
            if(arr.length<8 || arr.length>8)
                return "Neither";
            
            for(int i=0 ; i<8 ; i++){
                String toCheck = arr[i];
                
                if(!ipv6Valid(toCheck))
                    return "Neither";
            }
            return "IPv6";
        }
    }
    public static boolean ipv4Valid(String toCheck){
        
        if(toCheck.length()>3 || toCheck.length()==0)
            return false;
        try{
         int n = Integer.parseInt(toCheck);
         if(n<0 && n>255)
        	 return false;
        }catch(Exception e){
            return false;
        }
        
        return true;
    }
    
    public static boolean ipv6Valid(String toCheck){
//     System.out.println(toCheck);
    	if(toCheck.length()==0 || toCheck.length()>4)
    		return false;
//    	boolean isZero = toCheck.charAt(0)=='0'?true:false;
    	for(int i=0 ; i<toCheck.length() ; i++) {
    		
//    		System.out.println(toCheck.charAt(i)>=48 && toCheck.charAt(i)<=57);
//    		System.out.println(toCheck.charAt(i)>=65 && toCheck.charAt(i)<=70);
//    		System.out.println(toCheck.charAt(i)>=97 && toCheck.charAt(i)<=102);
//    		
    		if((toCheck.charAt(i)>=48 && toCheck.charAt(i)<=57) || (toCheck.charAt(i)>=65 && toCheck.charAt(i)<=70) || (toCheck.charAt(i)>=97 && toCheck.charAt(i)<=102))
    			continue;
    		return false;
    	}
    	
    	
        return true;   
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(validIPAddress("2001:0db8:85a3:00:00:8A2E:0370:7334"));
	}

}
