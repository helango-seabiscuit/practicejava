package com.hemalatha.pandora.BaseTest;


import java.io.File;
import java.io.FileFilter;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Date;
import java.util.Random;
import java.util.stream.IntStream;

public class BasicTests {

	public static void main(String[] args) {
		Boolean result = false;
		result = result || true;
		System.out.println(result);
		result = result || false;
		System.out.println(result);
		ZonedDateTime dateTime = ZonedDateTime.of(2017,9,25,11,12,20,200, ZoneId.systemDefault());
		ZonedDateTime dateTime2 = ZonedDateTime.now().minusDays(365);

		System.out.println(dateTime);
		System.out.println(dateTime2);
		System.out.println(dateTime.compareTo(dateTime2)<0);
		System.out.println(dateTime.compareTo(dateTime2)>0);


		System.out.println(String.format("Used plus date=%s and premium trial date=%s for listenerId=%d",ZonedDateTime.now(), ZonedDateTime.now(),16));


		File[] txtFiles = new File(".").listFiles(f-> f.getAbsolutePath().endsWith(".txt"));


		String[] innerplanets = {"Mercury","Venus","Earth","Mars"};
		bubbleSort(innerplanets,(e1,e2)-> e1.compareTo(e2));
		System.out.println(Arrays.deepToString(innerplanets));

		bubbleSort(innerplanets,(o1,o2) ->o2.compareTo(o1));
		System.out.println(Arrays.deepToString(innerplanets));

		new Random().ints(0,11).limit(10).filter(x->x%2 == 0).forEach(System.out::println);
		System.out.println();
		String [] cities = {
				"New York",
				"London",
				"Paris",
				"Berlin",
				"Brasilia",
				"Tokyo",
				"Beijing",
				"Jerusalem",
				"Cairo",
				"Riyadh",
				"Moscow"
		};

		IntStream.range(0,11).mapToObj(i-> cities[i]).forEach(System.out::println);
		System.out.println();
		System.out.println(IntStream.range(0,10).reduce(0,(x,y)-> x+y));
		System.out.println(IntStream.range(0,10).reduce(0,Integer::sum));
		int[] arr = new int[]{1,5,7,8,10,12};
		sum(arr);
		System.out.println(Arrays.toString(arr));
	}

	public static void bubbleSort(String [] planets, Comparator<String> comp){
		for(int pass =0;pass < planets.length -1;pass++){
			for(int i=planets.length-1;i> pass;i--){
				if(comp.compare(planets[i],planets[pass]) <0){
					String temp = planets[i];
					planets[i] = planets[pass];
					planets[pass] = temp;
				}
			}
		}
	}

	public static  void sum(int[] arr){
		if(arr != null && arr.length > 1) {
			 sum(arr, 1);
		}
	}

	public static void sum(int[] arr,int i){
		if(i >= arr.length){
			return;
		}
		arr[i] = arr[i]+arr[i-1];
		sum(arr,i+1);
		return;
	}


}
