import static java.lang.Thread.sleep;

public class Main {
    public static void main(String[] args) {
        Class1 c1 = new Class1();
        Class2 c2 = new Class2();

        c1.setDeath2(c2);
        c2.setDeath1(c1);
        c1.start();
        c2.start();
    }
}

class Class1 extends Thread {
    Thread death2;

    public Class1() {
        System.out.println("Class1 creates");
    }

    public void run() {
        System.out.println("Class1 starts");
        try {
            sleep(2000);
        }catch (Exception e) {
        }
        try {
            System.out.println("Class1 interrupts Class2 finish...");
            death2.join();
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Class1 finished");
    }

    public void setDeath2(Thread t) {
        this.death2 = t;
    }
}

class Class2 extends Thread {
    Thread death1;

    public Class2() {
        System.out.println("Class2 creates");
    }

    public void run() {
        System.out.println("Class2 starts");
        try {
            System.out.println("Class2 interrupts Class1 finish...");
            death1.join();
        } catch (Exception e) {
        }
        try {
            sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Class2 finished");
    }

    public void setDeath1(Thread t) {
        this.death1 = t;
    }
}