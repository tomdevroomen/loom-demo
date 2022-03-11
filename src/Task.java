import java.time.Duration;

public class Task {
    public Runnable getTask(int i) {
        return () -> {
            if (i % 10 == 0) {
                System.out.printf("%s %s running and sleeping%n", Thread.currentThread().getName(), i);
            }
            if (i == 1) Thread.dumpStack();
            try {
                Thread.sleep(Duration.ofMinutes(1));
            } catch (InterruptedException interruptedException) {
                interruptedException.printStackTrace();
            }
        };
    }
}
