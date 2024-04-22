package runners;

public class Runners {
    public static void main(String[] args) {
        Runner1 runner1 =new Runner1(1);
        Runner1 runner2 =new Runner1(2);

        Thread thread1 = new Thread(runner1);
        Thread thread2 = new Thread(runner2);

        thread1.start();
        thread2.start();

    }
}
class Runner implements Runnable {
    private int index;

    public Runner(int index){
        this.index = index;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Runner "+index+" is running, step "+i);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}