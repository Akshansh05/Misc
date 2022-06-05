package Threading;

public class ThreadPrint extends Thread {

    public void run() {
        try {
            System.out.println("Thread " + Thread.currentThread().getId() + " is running");
        } catch (Exception e) {
            System.out.println("Exception is caught");
        }
    }
}

class Print {
    public static void main(String[] args) {

        for (int i = 0; i < 8; i++) {
            ThreadPrint thread = new ThreadPrint();
            thread.start();
        }
    }
}
/*
Thread 11 is running
Thread 14 is running
Thread 13 is running
Thread 12 is running
Thread 15 is running
Thread 16 is running
Thread 17 is running
Thread 18 is running

 */
