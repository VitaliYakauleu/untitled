package printer;

public class PrinterBeep {
    public static void main(String[] args) {

        Printer printer = new Printer();
        printer.start();

        for (int i=10; i<15; i++){
            System.out.println("Calculate: "+i);
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        synchronized (printer){
            try {


                printer.wait();
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }
        }

        System.out.println("Beep! Total: "+printer.count);
    }
}

class Printer extends Thread{
    public int count = 0;

    @Override
    public void run(){
        while (count<5) {
            String s ="print page#";
            try {
                Thread.sleep(100);
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }


            System.out.println("Printing page #" + count++);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}