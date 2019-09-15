package com.hemalatha.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class PrisonAfterNDays {

	public static void main(String[] args) {
		PrisonAfterNDays days = new PrisonAfterNDays();
		//int[] cells = new int[]{0, 1, 0, 1, 1, 0, 0, 1};
		int[] cells = new int[]{0, 0, 0, 0, 0, 0, 0, 1};
	//	System.out.println(Arrays.toString(days.prisonAfterNDays(cells,2)));

		System.out.println(5^25);
          //16 8 4 2 1
//		int state = 0;
//		for (int i = 0; i < 8; ++i) {
//			if (cells[i] > 0)
//				state ^= 1 << i;
//		}
//		System.out.println(state);

		Integer x=12;
		System.out.println(Integer.toBinaryString(x));
		int[] res = new int[32];

		int x1=4;
		System.out.println(x1>>>2);

		for(int i=31;i>=0;i--){
			res[31-i]=x>>i & 1;
		}
		System.out.println(Arrays.toString(res));

		int c=0;
		for(int i=0;i<32;i++){
			c = c|((res[i] & 1)<<(31-i));
		}
		System.out.println(c);

	}

		public int[] prisonAfterNDays(int[] cells, int N) {
			Map<Integer, Integer> seen = new HashMap();

			// state  = integer representing state of prison
			int state = 0;
			for (int i = 0; i < 8; ++i) {
				if (cells[i] > 0)
					state ^= 1 << i;
			}

			// While days remaining, simulate a day
			while (N > 0) {
				// If this is a cycle, fast forward by
				// seen.get(state) - N, the period of the cycle.
				if (seen.containsKey(state)) {
					N %= seen.get(state) - N;
				}
				seen.put(state, N);

				if (N >= 1) {
					N--;
					state = nextDay(state);
				}
			}

			// Convert the state back to the required answer.
			int[] ans = new int[8];
			for (int i = 0; i < 8; ++i) {
				if (((state >> i) & 1) > 0) {
					ans[i] = 1;
				}
			}

			return ans;
		}

		public int nextDay(int state) {
			int ans = 0;

			// We only loop from 1 to 6 because 0 and 7 are impossible,
			// as those cells only have one neighbor.
			for (int i = 1; i <= 6; ++i) {
				if (((state >> (i-1)) & 1) == ((state >> (i+1)) & 1)) {
					ans ^= 1 << i;
				}
			}

			return ans;
		}

}
