package Threading;

public class Sync {

    public static void main(String[] args) {
        Sender sender = new Sender();
        Thread t1 = new Thread(new ThreadSync(sender, "Hi"));
        Thread t2 = new Thread(new ThreadSync(sender, "Bye"));
        t1.start();
        t2.start();
    }
}

class Sender {

    void send(String message) {//this is block synchronization

        System.out.println("Sending " + message);
        try {
            Thread.sleep(1000);// created waiting for 1sec b/w sending hi and hi sent
        } catch (Exception e) {
            System.out.println("Thread interrupted");
        }
        System.out.println(message + " Sent");
    }

    synchronized void sendSync(String message) {//this is method synchronization

        System.out.println("Sending " + message);
        try {
            Thread.sleep(1000);// created waiting for 1sec b/w sending hi and hi sent
        } catch (Exception e) {
            System.out.println("Thread interrupted");
        }
        System.out.println(message + " Sent");
    }
}

class ThreadSync implements Runnable {

    Sender sender;// can be used as final Sender sender  to keep the reference same as a thread can change the reference so no synchronization
    String message;

    ThreadSync(Sender sender, String message) {
        this.sender = sender;
        this.message = message;
    }

    @Override
    public void run() {
        synchronized (sender) {//block synchronization can be done like this also
            sender.send(message);
            try {
                Thread.sleep(2000);// created waiting for sending bye for 2 sec
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        // sender.sendSync(message);//method synchronization can be done like this also
    }
}
/*
Sending Hi
Hi Sent
Sending Bye
Bye Sent
 */