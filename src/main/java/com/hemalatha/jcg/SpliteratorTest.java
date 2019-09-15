package com.hemalatha.jcg;

import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Spliterator;

public class SpliteratorTest {

    public static void main(String[] args) {
        List<String> list = Arrays.asList("hello","greeting","power","one","two","three");
        Spliterator<String> s = list.spliterator();
      //  System.out.println(s.characteristics());
        System.out.println(s.estimateSize());
        Spliterator<String> temp = s.trySplit();
        System.out.println(s.estimateSize());
        System.out.println(temp.estimateSize());

        Spliterator<String> temp2 = s.trySplit();
        System.out.println(s.estimateSize());
        System.out.println(temp2.estimateSize());
        testParamValidation(LocalDate.now(),0,null);
        testShuffle();
        testDate();
    }

    @NotNull
    @Size(min = 1)
    public static  List<String> testParamValidation(@NotNull @Future LocalDate begin,
                                    @Min(1) int duration, @Size(min = 5 , max = 50) @NotNull String customer){
        return null;

    }

    public static void testShuffle(){
        List<String> names = Arrays.asList("John","Mark","Jason","Brad");
        System.out.println(names);
        Collections.shuffle(names);
        System.out.println(names);
        int seedValue = 10;
        List<String> names2 = new ArrayList<>(names);
        Collections.shuffle(names, new Random(seedValue));
        System.out.println(names);
        Collections.shuffle(names2, new Random(seedValue));
        System.out.println(names2);
    }

    public static void testDate(){
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
    }
}
