import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class TryWithoutLoom {

    public static void main(String... args) {
        System.out.printf("PID: %s%n", ProcessHandle.current().pid());
        try (var executor = Executors.newFixedThreadPool(50)) {
            IntStream.range(0, 100)
                    .forEach(i -> executor.submit(new Task().getTask(i)));
        }
    }
}
