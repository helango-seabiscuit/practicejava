package com.hemalatha.IK.recursion;


public class SubsetTest {

   public static void subset(Object[] origSet,int read,Object[] copySet,int write){
       if(read == origSet.length){
           System.out.print("{");
           for(int i=0;i<write;i++){
               System.out.print(copySet[i]);
               if(i+1!=write){
                   System.out.print(",");
               }
           }
           System.out.print("}");
           System.out.println();
           return;
       }
       subset(origSet,read+1,copySet,write); //form set by removing first element in each iteration
       copySet[write]=origSet[read]; //form set by adding it
       subset(origSet,read+1,copySet,write+1); //call recursion after adding it
   }

    public static void main(String[] args) {
        Integer [] arr = new Integer[]{1,2,3};
        Integer [] res = new Integer[arr.length];
        subset(arr,0,res,0);
       // recSubsets("","123");
    }

    public static  void recSubsets(String res,String remaining){

        if(remaining.length()==0){
            System.out.println(res);
        }else{
            recSubsets(res+remaining.substring(0,1),remaining.substring(1));
            recSubsets(res,remaining.substring(1));
        }
    }
}
