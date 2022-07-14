import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class QueueImpl {

    private List<String> store;

    private Integer maxSize;

    public QueueImpl() {
        this.store = new ArrayList<>();
    }

    public QueueImpl(int maxSize) {
        this.store = new ArrayList<>();
        this.maxSize = maxSize;
    }

    public String element() {
        if (this.store.isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.store.get(this.store.size() - 1);
    }

    public boolean add(String element) {
        if (this.maxSize != null && store.size() == maxSize) {
            throw new IllegalStateException();
        }
        store.add(0, element);
        return true;
    }

    public boolean offer(String element) {
        if (element == null) {
            throw new NullPointerException();
        }
        try {
            return add(element);
        } catch (IllegalStateException e) {
            return false;
        }
    }

    public String remove() {
        if (this.store.isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.store.remove(this.store.size() - 1);
    }

    public String poll() {
        if (this.store.isEmpty()) {
            return null;
        }
        return this.store.remove(this.store.size() - 1);
    }

    public String peek() {
        if (this.store.isEmpty()) {
            return null;
        }
        return this.store.get(this.store.size() - 1);
    }

    public int size(){
        return store.size();
    }
}
