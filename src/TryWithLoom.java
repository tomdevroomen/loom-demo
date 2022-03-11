import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class TryWithLoom {

    public static void main(String... args) {
        System.out.printf("PID: %s%n", ProcessHandle.current().pid());
        try (var executor = Executors.newThreadPerTaskExecutor(
                Thread.ofVirtual().name("my-virtual-thread-factory").factory())
        ) {
            IntStream.range(0, 1000)
                    .forEach(i -> executor.submit(new Task().getTask(i)));
        }

    }
}
