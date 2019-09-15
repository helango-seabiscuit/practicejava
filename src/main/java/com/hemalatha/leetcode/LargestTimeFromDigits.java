package com.hemalatha.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LargestTimeFromDigits {

	public static void main(String[] args) {
		LargestTimeFromDigits timeFromDigits = new LargestTimeFromDigits();
		System.out.println(timeFromDigits.largestTimeFromDigits(new int[]{1,2,3,4}));
		System.out.println(timeFromDigits.largestTimeFromDigits(new int[]{5,5,5,5}));
	}

	public String largestTimeFromDigits(int[] A) {
       int hour[] = new int[]{2,1,0};
       int minute[] = new int[]{3,2,1,0};
       int sec[] = new int[]{5,4,3,2,1,0};
       int sec2[] = new int[]{9,8,7,6,5,4,3,2,1,0};

		Map<Integer,Integer> temp = new HashMap<>();
       for(int a:A){
       	  if(temp.containsKey(a)){
       	  	temp.put(a,temp.get(a)+1);
		  }else{
       	  	temp.put(a,1);
		  }
	   }

	   int i=0;
       String res="";
       while (i<4){

       	  switch (i){
			  case 0: for(int a:hour){
			  	       if(temp.containsKey(a)){
			  	       	checkInMap(temp, a);
			  	       	res +=a;
			  	       	break;
					   }
			           }
			  	      break;
			  case 1:
				  for(int a:minute){
					  if(temp.containsKey(a)){
						  checkInMap(temp, a);
						  res +=a;
						  break;
					  }
				  }
			  	      break;
			  case 2: for(int a:sec){
				        if(temp.containsKey(a)){
					        checkInMap(temp, a);
					        res =res+":"+a;
					        break;
				        }
			           }
			  	      break;
			  case 3: for(int a:sec2){
				        if(temp.containsKey(a)){
					        checkInMap(temp, a);
					        res +=a;
					        break;
				         }
			           }
			  	      break;
		  }
		  i++;

	   }

		if(res.length() != 5){
			return "";
		}
	   return res;
	}

	private void checkInMap(Map<Integer, Integer> temp, int a) {
		int r = temp.get(a);
		if(r>1){
			temp.put(a,r-1);
   }else{
			temp.remove(a);
   }
	}
}
