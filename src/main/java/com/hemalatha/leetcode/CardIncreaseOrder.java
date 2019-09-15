package com.hemalatha.leetcode;

import javax.smartcardio.Card;
import java.util.Arrays;
import java.util.LinkedList;

public class CardIncreaseOrder {


	public static void main(String[] args) {
		CardIncreaseOrder increaseOrder = new CardIncreaseOrder();
		System.out.println(Arrays.toString(increaseOrder.deckRevealedIncreasing(new int[]{17,13,11,2,3,5,7})));
	}

	public int[] deckRevealedIncreasing(int[] deck) {

		Arrays.sort(deck);
		int [] res = new int[deck.length];
		LinkedList<Integer> list = new LinkedList<>();
		for(int i=0;i<deck.length;i++){
			list.add(i);
		}
		int i=0;
		while (!list.isEmpty()){
			res[list.removeFirst()] = deck[i++];
			if(!list.isEmpty()) {
				list.add(list.removeFirst());
			}
		}

		return res;
	}

}
