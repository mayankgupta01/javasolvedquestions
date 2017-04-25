package hiredintech_topcoder.dynamic_programming.multithreading;

/**
 * Created by mayank.gupta on 16/04/17.
 */
public class TestSyncrhonized {
    private Lock lock = new Lock();

    public synchronized void doSynchornized() {
        System.out.println("Inside syncronized" + Thread.currentThread().getName());
    }

    public void syncWithLock() throws InterruptedException {
        lock.doLock();

        /*Do ur stuff*/

        lock.unLock();
    }
}

class Lock {

    private boolean isLocked = false;
    private Thread lockingThread  = null;

    public synchronized void doLock() throws InterruptedException {

            while(isLocked) {
                    this.wait();
            }

            isLocked = true;
            lockingThread = Thread.currentThread();
    }

    public synchronized void unLock() {

        if(Thread.currentThread() != lockingThread) {
            throw new IllegalMonitorStateException(
                    "Calling thread has not locked this lock");
        }
        isLocked = false;
        lockingThread = null;
        notify();
    }
}