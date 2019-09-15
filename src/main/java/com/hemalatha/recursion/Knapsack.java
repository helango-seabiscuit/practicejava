package com.hemalatha.recursion;

import java.util.LinkedList;
import java.util.List;

public class Knapsack {

	public static void main(String[] args) {
		Item[] items = new Item[4];
		items[0] = new Item(5,10);
		items[1] = new Item(4,40);
		items[2] = new Item(6,30);
		items[3] = new Item(3,50);

		int[] val = new int[1];
		List<List<Item>> res = knapsack(items,0,10,0,val,0);
		for (List<Item> i:res){
			System.out.print(i +" ");
		}

		items[0] = new Item(1,15);
		items[1] = new Item(5,10);
		items[2] = new Item(3,9);
		items[3] = new Item(4,5);

		val = new int[1];
		 res = knapsack(items,0,8,0,val,0);
		for (List<Item> i:res){
			System.out.print(i +" ");
		}
	}

	public static  List<List<Item>> knapsack(Item[] item,int i, int targetWeight, int currentWeight,int[] val,int currentValue){
		if(currentWeight > targetWeight){
			return new LinkedList<>();
		}
		if(i == item.length && currentWeight !=targetWeight){
			return new LinkedList<>();
		}
		if(currentWeight == targetWeight && currentValue > val[0]){
			val[0] = currentValue;
			List<List<Item>> result = new LinkedList<>();
			result.add(new LinkedList<>());
			return result;
		}

		if(i == item.length){
			return new LinkedList<>();
		}

		List<List<Item>> r = new LinkedList<>();
		List<List<Item>> include = knapsack(item, i+1,targetWeight,currentWeight+item[i].weight,val,currentValue+item[i].value);
		List<List<Item>> exclude = knapsack(item, i+1,targetWeight,currentWeight,val,currentValue);
		for (List<Item> l:include){
			l.add(item[i]);
		}
		r.addAll(include);
		r.addAll(exclude);
		return r;
	}
}

class Item {
	int weight;
	int value;

	public Item(int weight, int value) {
		this.weight = weight;
		this.value = value;
	}

	@Override
	public String toString() {
		return "Item{" +
				"weight=" + weight +
				", value=" + value +
				'}';
	}
}
