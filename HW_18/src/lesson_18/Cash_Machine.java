package lesson_18;

import java.util.Random;

public class Cash_Machine {
    public static void main(String[] args) {
        Thread thread_0 = new ATM_Thread("Pavel");
        Thread thread_1 = new ATM_Thread("Den");
        Thread thread_2 = new ATM_Thread("Alex");
        Thread thread_3 = new ATM_Thread("Mihail");
        Thread thread_4= new ATM_Thread("Vasya");
        Thread thread_5 = new ATM_Thread("Lilya");
        Thread thread_6 = new ATM_Thread("Egor");
        Thread thread_7 = new ATM_Thread("Valya");
        Thread thread_8 = new ATM_Thread("Jeka");
        thread_0.start();
        thread_1.start();
        thread_2.start();
        thread_3.start();
        thread_4.start();
        thread_5.start();
        thread_6.start();
        thread_7.start();
        thread_8.start();
    }
}
class ATM_Thread extends Thread {
    Integer res = 1;

    public ATM_Thread(String name) {
        super(name);
    }

    public void run() {
        synchronized (res) {
            res = 1;
            System.out.println("Client " + getName() + " works with an ATM");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            final Random random = new Random();
            int count = random.nextInt(2);
            int money = random.nextInt(1000);
            if (count == 1) {
                System.out.println("Client " + getName() + " take off " + money + "$");
            } else {
                System.out.println("Client " + getName() + " put " + money + "$");
            }
        }
    }
}
