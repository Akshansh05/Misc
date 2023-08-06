package org.example;

public class OddEvenThread {

    static int N;
    int counter = 1;

    public static void main(String[] args) {
        N = 10;
        OddEvenThread oddEvenThread = new OddEvenThread();
        Thread evenThread = new Thread(new Runnable() {
            @Override
            public void run() {
                oddEvenThread.printEven();
            }
        });

        Thread oddThread = new Thread(new Runnable() {
            @Override
            public void run() {
                oddEvenThread.printOdd();
            }
        });

        evenThread.start();
        oddThread.start();
    }


    public void printEven() {
        synchronized (this) {
            while (counter < N) {
                while (counter % 2 == 1) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Thread " + Thread.currentThread().getId() + "is Printing " + counter);
                counter = counter + 1;
                notify();
            }
        }

    }

    public void printOdd() {
        synchronized (this) {
            while (counter < N) {
                while (counter % 2 == 0) {
                    try {
                        wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
                System.out.println("Thread " + Thread.currentThread().getId() + "is Printing " + counter);
                counter = counter + 1;
                notify();
            }
        }
    }

}
