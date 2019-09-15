package com.hemalatha.srm;

import java.util.regex.Pattern;

public class SurveillanceCameras {
	
	public static void main(String args[]){
		System.out.println("Surveilance : "+getContainerInfo("-X--XX", new int[]{1,2}, 3));
	}
	
	public static String getContainerInfo(String containers, int[] reports, int L){		
		String regex= "";
		int oneMatch = 0;
		int arr[] = new int[containers.length()];
		char[] result = new char[containers.length()];
		for(int i = 0;i<arr.length;i++){
			arr[i] = 0;
			result[i]='-';
		}
		for(int i=0;i< reports.length;i++){
			int monitors = reports[i];
			regex = "";
			oneMatch = 0;
			for(int l = 0;l<monitors;l++)
			 regex = regex+"-*X-*";
			Pattern pat = Pattern.compile(regex);
			System.out.println("Regex: "+regex);
			for(int j = 0 ;j<=containers.length()-L;j++){				
				String sub = containers.substring(j,j+L);				
				if(sub.matches(regex)){
					oneMatch++;
					System.out.println("String "+sub+" Matches for regex: "+regex);
					for(int k=j;k<j+L;k++)
						arr[k]=arr[k]+1;
				}
				
			}
			int cameras = reports.length;
			for(int k = 0 ;k<arr.length;k++){
				if(arr[k] == cameras || oneMatch ==1 ){
					result[k]='+';
				}
				else if (arr[k]> 0 && arr[k]<cameras && result[k]!='+'){
					result[k]='?';				
				}else if(arr[k]==0 && (result[k]!='+' || result[k]!='?')){
					result[k]='-';
				}
			}
		}
		
		
		
		return new String(result);
	}

}
