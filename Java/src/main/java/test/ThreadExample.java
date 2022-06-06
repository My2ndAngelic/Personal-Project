package test;

import java.util.stream.LongStream;

public class ThreadExample extends Thread {
    public static void main(String[] args) {
        System.out.println(addSingleThread(1, 99));
        System.out.println(addDoubleThread(1, 99));
    }

    public static long addSingleThread(long start, long end) {
//        int result = 0;
//        for (int i = start; i <= end; i++) {
//            result += i;
//        }
//        return result;
        return LongStream.range(start, end + 1).sum();

    }

    public static long addDoubleThread(long start, long end) {
//        Thread t1 = new Thread(() -> {
//            for (int i = start; i <= end/2; i++) {
//                result[0] += i;
//            }
//        });
//
//        Thread t2 = new Thread(() -> {
//            for (int j = end/2+1; j <= end; j++) {
//                result[0] += j;
//            }
//        });
//
//        t1.start();
//        t2.start();
        return LongStream.range(start, end + 1).parallel().sum();
    }
}
