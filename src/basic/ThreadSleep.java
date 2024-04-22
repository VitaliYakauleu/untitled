package basic;

public class ThreadSleep {
    public static void main(String[] args) throws InterruptedException {
        String[] messages = {
                "If you can keep your head when all about you",
                "Are losing theirs and blaming it on you,",
                "If you can trust yourself when all men doubt you,",
                "But make allowance for their doubting too;",
                "If you can wait and not be tired by waiting,",
                "Or being lied about, don’t deal in lies,",
                "Or being hated, don’t give way to hating,",
                "And yet don’t look too good, nor talk too wise."};

        Runnable runnable = () -> {
            for(String message: messages) {
                System.out.println(message);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new IllegalStateException(e);
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
        Thread.sleep(5000);
        thread.suspend();
        thread.resume();
    }
}