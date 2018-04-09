package learning.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallThread implements Callable {

    @Override
    public Integer call() throws Exception {
        // TODO Auto-generated method stub
        System.out.println("Thread has executed");
        return 1;
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Callable oneCall = new CallThread();
        FutureTask<Integer> oneTask = new FutureTask<Integer>(oneCall);
        oneTask.isDone();
        Thread oneThread = new Thread(oneTask);
        System.out.println(oneThread.isAlive());
        oneThread.start();
        System.out.println(oneThread.isAlive());
        System.out.println(oneTask.get());
    }
}
