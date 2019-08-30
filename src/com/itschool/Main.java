package com.itschool;

public class Main
{
    public static double sum1 = 0;
    public static double sum2 = 0;
    public static void main(String[] args)
    {
        double sum = 0;
        long t1 = System.currentTimeMillis();

        for (long i = 0; i < 20000000000l; i++)
            sum += i;
        long t2 = System.currentTimeMillis() - t1;
        System.out.println(t2+" ms");
        System.out.println(sum);

        Thread th1 = new Thread(() -> {
            for (long i = 0; i < 10000000000l; i++)
                sum1 += i;
        });

        Thread th2 = new Thread(() -> {
            for (long i = 10000000000l; i < 20000000000l; i++)
                sum2 += i;
        });

        t1 = System.currentTimeMillis();
        th1.start();
        th2.start();

        do {

        }while (th1.isAlive() && th2.isAlive());

        sum2 += sum1;
        t2 = System.currentTimeMillis() - t1;

        System.out.println(t2+" ms");
        System.out.println(sum2);
        /*
        21884 ms
        -2914184820805067776
        */

    }
}
