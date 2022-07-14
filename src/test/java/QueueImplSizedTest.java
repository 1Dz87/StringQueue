import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class QueueImplSizedTest {

    private QueueImpl queue;

    @BeforeEach
    void setup() {
        this.queue = new QueueImpl(0);
    }

    @Test
    void add_shouldThrowException() {
        Assertions.assertThrows(IllegalStateException.class, () -> queue.add("String"));
    }

    @Test
    void offer_shouldThrowException() {
        Assertions.assertThrows(NullPointerException.class, () -> queue.offer(null));
    }

    @Test
    void offer_isFalse() {
        boolean rez = queue.offer("New Element");
        Assertions.assertEquals(0, queue.size());
        Assertions.assertFalse(rez);
    }
}
