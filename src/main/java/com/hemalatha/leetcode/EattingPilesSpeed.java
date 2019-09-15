package com.hemalatha.leetcode;

public class EattingPilesSpeed {

	public static void main(String[] args) {
		EattingPilesSpeed pilesSpeed = new EattingPilesSpeed();
		System.out.println(pilesSpeed.minEatingSpeed(new int[]{30,11,23,4,20},5));// 30
		System.out.println(pilesSpeed.minEatingSpeed(new int[]{30,11,23,4,20},6));//23
		System.out.println(pilesSpeed.minEatingSpeed(new int[]{3,6,7,11},8));//4

	}

	public int minEatingSpeed(int[] piles, int H) {

		int l = 1;
		int h = getMaxPiles(piles);
		//int h = 1000_000_000;

		while (l<h){
			int mid = l+((h-l)/2);

			if(canEatAllPiles(piles,H,mid)){
				h = mid;
			}else{
				l = mid +1;
			}
		}

		return l;
	}

	private boolean canEatAllPiles(int[] piles, int h, int mid) {
		int times = 0;
		for(int i:piles){
			times += (i-1)/mid+1;
		}
		return times <=h;
	}

	private int getMaxPiles(int[] piles) {

		int max = 0;
		for(int i:piles){
			if(max < i){
				max = i;
			}
		}
		return max;
	}


}
