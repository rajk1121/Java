import java.util.*;
public class name {
public static boolean isLongPressedName(String name, String typed) {
        
        int i=0, j=0;
        while(i+1<name.length() && j+1<typed.length()){
            if(name.charAt(i)==name.charAt(i+1)){
               if(typed.charAt(j) == name.charAt(i)){
                    if(typed.charAt(j)==typed.charAt(j+1)){
                    i = i+2;
                    j = j+2;
                }else{
                    return false;
                }
               }else{
                   return false;
               }
            }else{
                if(typed.charAt(j) == name.charAt(i)){
                    while(j<typed.length() && typed.charAt(j)==name.charAt(i)){
                        j++;
                    }
                    i++;
                }else{
                    return false;
                }
            }
        }
        if(i==name.length()-1) {
        	if(j<typed.length()) {
        		while(j<typed.length() ){
                    if(typed.charAt(j)==name.charAt(name.length()-1))
                        j++;
                    else
                        return false;
                }
        	}else {
        		return false;
        	}
        }else if(j==typed.length()-1) {
        	return false;
        }
        if(i>name.length() && j>typed.length())
        	return true;
        if(i>=name.length()) {
        	while(j<typed.length() ){
                if(typed.charAt(j)==name.charAt(name.length()-1))
                    j++;
                else
                    return false;
            }
        }
        if(j>=typed.length()) {
        	return false;
        }
        return true;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isLongPressedName("alex", "aaleex"));
	}

}
