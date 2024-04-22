package basic;

public class ThreadDemo extends Thread{
    public static void main(String[] args) {
        System.out.println("main"+Thread.currentThread().getName());
        System.out.println("creat child thread");
        Thread thread = new ThreadDemo();
        System.out.println("child start");
        thread.start();




        System.out.println("finish"+ Thread.currentThread().getName());
    }
    @Override
    public void run(){
        for (int i = 0; i < 3; i++) {

        }
    }

}
