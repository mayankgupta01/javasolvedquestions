package udemy.practical_ds_algo;

/**
 * Created by mayank.gupta on 11/02/17.
 */
public class Counter {
    private int counter = 0;
    private String counterName;

    public Counter(String counterInstanceName) {
        this.counterName = counterInstanceName;
    }

    public void increment() {
        this.counter++;
    }

    public int getCurrentValue() {
        return this.counter;

    }

    @Override
    public String toString() {
        return "Counter{" +
                "counter=" + counter +
                ", counterName='" + counterName + '\'' +
                '}';
    }
}
