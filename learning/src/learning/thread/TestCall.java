package learning.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class TestCall {
    public static void main(String[] args) {
        
    ExecutorService executor = Executors.newCachedThreadPool();
    Task task = new Task();
    FutureTask<Integer> futureTask = new FutureTask<Integer>(task);
    executor.submit(futureTask);
    executor.shutdown();
    
    try {
        Thread.sleep(1000);
    }catch(Exception e) {
        e.printStackTrace();
    }
    System.out.println("主线程在执行任务");
    
    try {
        System.out.println("task运行结果"+futureTask.get());
    }catch(Exception e ) {
        e.printStackTrace();
    }
    System.out.println("所有任务执行完毕");
    }
    
}

class Task implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        System.out.println("子线程正在计算");
        Thread.sleep(3000);
        int sum = 0;
        for(int i=0;i<100;i++) {
            sum += i;
        }
        return sum;
    }
    
}