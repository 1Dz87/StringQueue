import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

public class QueueImplUnsizedTest {

    private QueueImpl queue;

    @BeforeEach
    void setup() {
        this.queue = new QueueImpl();
    }

    @Test
    void remove_ok() {
        queue.add("123");
        String str = queue.remove();
        Assertions.assertEquals("123", str);
        Assertions.assertEquals(0, queue.size());
    }

    @Test
    void element_shouldThrowException() {
        Assertions.assertThrows(NoSuchElementException.class, () -> queue.element());
    }

    @Test
    void element_ok() {
        queue.add("some string");
        Assertions.assertEquals("some string", queue.element());
    }

    @Test
    void remove_shouldThrowException() {
        Assertions.assertThrows(NoSuchElementException.class, () -> queue.remove());
    }

    @Test
    void add_isOk() {
        queue.add("New Element");
        Assertions.assertEquals(1, queue.size());
        Assertions.assertEquals("New Element", queue.peek());

    }

    @Test
    void offer_isOk() {
        boolean rez = queue.offer("New Element");
        Assertions.assertEquals(1, queue.size());
        Assertions.assertEquals("New Element", queue.peek());
        Assertions.assertTrue(rez);
    }

    @Test
    void poll_shouldReturnNull() {
        Assertions.assertEquals(0, queue.size());
        String str = queue.poll();
        Assertions.assertNull(str);
    }

    @Test
    void poll_ok() {
        queue.add("123");
        String str = queue.poll();
        Assertions.assertEquals("123", str);
        Assertions.assertEquals(0, queue.size());
    }

    @Test
    void peek_shouldReturnNull() {
        Assertions.assertEquals(0, queue.size());
        String str = queue.peek();
        Assertions.assertNull(str);
    }

    @Test
    void peek_ok() {
        queue.add("123");
        Assertions.assertEquals("123",queue.peek());
        Assertions.assertEquals(1,queue.size());

    }
}