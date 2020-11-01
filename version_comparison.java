
public class version_comparison {
	 public int compareVersion(String version1, String version2) {
	        String[] arr1 = version1.split("\\.");
	        String[] arr2 = version2.split("\\.");
	        int i=0, j=0;
	            // System.out.println(arr1.length+" "+arr2.length);
	        while(i<arr1.length && j<arr2.length){
	            int x1 = Integer.parseInt(arr1[i]);
	            int x2 = Integer.parseInt(arr2[j]);
	            // System.out.println(x1+" "+x2);
	            if(x1>x2){
	                return 1;
	            }
	            if(x1<x2)
	                return -1;
	            i++;
	            j++;
	        }
	        while(i<arr1.length){
	            if(Integer.parseInt(arr1[i])>0)
	                return 1;
	            i++;
	        }
	        while(j<arr2.length){
	            if(Integer.parseInt(arr2[j])>0)
	                return -1;
	            j++;
	        }
	        return 0;
	    }
}
