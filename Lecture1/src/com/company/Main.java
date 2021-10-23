package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Example object1= new Example();
        object1.exampleString="object1";

        Example object2= new Example();
        object2.exampleString="object2";

        Singleton exampleSingleton = Singleton.getInstance();
        exampleSingleton.setText("Test");
        exampleSingleton.getText();


        System.out.println(object1.exampleString);
        System.out.println(object2.exampleString);

        char[] ch={'s','t','r','i','n','g'};
        String s=new String(ch);

        int[] arr= {10,20,30,40};
        int smallest=arr[0];
        int secondSmallest=arr[0];
        int numberOfSmallest=0;

        //Find smallest element
        for(int n:arr){
            if (n<=smallest){
                smallest=n;
            }
        }
        //CheckNumber Of Smallest
        for(int n:arr){
            if (n==smallest){
                numberOfSmallest++;
            }
        }

        if(numberOfSmallest>1){
            secondSmallest=smallest;
            System.out.println(smallest);
            System.out.println(secondSmallest);
            System.exit(0);
        }

        //Move second smallest element to the max
        for(int n:arr){
            if (n>smallest){
                secondSmallest=n;
            }
        }


        for(int n:arr){
            if (smallest<n && n<=secondSmallest){
                secondSmallest=n;
            }
        }



        System.out.println(smallest);
        System.out.println(secondSmallest);
    }
}
