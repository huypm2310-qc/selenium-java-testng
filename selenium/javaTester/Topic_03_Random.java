package javaTester;

import java.util.Random;

public class Topic_03_Random {
    public static void main(String[] args) {
        Random ran = new Random();
        System.out.println("donaldtrump" + ran.nextBoolean() + "@gmail.com");
        System.out.println("donaldtrump" + ran.nextDouble() + "@gmail.com");
        System.out.println("donaldtrump" + ran.nextFloat() + "@gmail.com");
        System.out.println("donaldtrump" + ran.nextInt(99999) + "@gmail.com");
        System.out.println("donaldtrump" + ran.nextLong() + "@gmail.com");
//        System.out.println(ran.nextDouble());
//        System.out.println(ran.nextFloat());
//        System.out.println(ran.nextInt(99999));
//        System.out.println(ran.nextLong());
    }
}
