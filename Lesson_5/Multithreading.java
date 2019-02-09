package Lesson_5;

import java.util.Arrays;


public class Multithreading {

    static final int SIZE = 10_000_000;
    static final int THREADS = 3;
    static final int H = SIZE / THREADS;


    public static void main(String[] args) throws InterruptedException {
        float[] arr = new float[SIZE];
        Arrays.fill(arr, 1.0f);

        long timeStart = System.currentTimeMillis();

        arrCalc(arr, 0);
        long timeEnd = System.currentTimeMillis()-timeStart;
        System.out.println("Однопоточный режим :" + timeEnd);

        float[][] arrHalf = new float[THREADS][H];

        long timeSepBegin = System.currentTimeMillis();
        for (int i = 0; i < THREADS; i++) {
            System.arraycopy(arr, H * i, arrHalf[i], 0, H);
        }

        long timeSepEnd = System.currentTimeMillis() - timeSepBegin;
        System.out.println("Время разделения массива: " + timeSepEnd);

        long timeTrBegin = System.currentTimeMillis();
        Thread[] thrd = new Thread[THREADS];
        for (int i=0; i<THREADS; i++) {
            thrd[i] = new Thread(new arrTrCalc(arrHalf[i], H * i));
            thrd[i].start();
        }

        for (int i=0; i<THREADS; i++) {
            thrd[i].join();
        }
        long timeTrEnd = System.currentTimeMillis() - timeTrBegin;
        System.out.println("Время обработки формулы в потоке: " + timeTrEnd);

        long timeJoinBegin = System.currentTimeMillis();
        for (int i=0; i<THREADS; i++) {
            System.arraycopy(arrHalf[i], 0, arr, H * i, H);
        }
        long timeJoinEnd = System.currentTimeMillis() - timeJoinBegin;
        System.out.println("Время соединения массивов: " + timeJoinEnd);
    }
    static class arrTrCalc implements Runnable {

        private final float[] arr;
        private final int shift;

        public arrTrCalc(float[] arr, int shift) {
            this.arr = arr;
            this.shift = shift;
        }

        @Override
        public void run() {
            arrCalc(arr, shift);
        }
    }

    static void arrCalc(float[] arr, int shift) {
        for (int i = 0; i < arr.length; i++) {
            int ix = i + shift;
            arr[i] = (float) (arr[i] * Math.sin(0.2f + ix / 5) *  Math.cos(0.2f + ix / 5) * Math.cos(0.4f + ix / 2));
        }
    }
}
