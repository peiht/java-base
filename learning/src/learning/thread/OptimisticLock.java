package learning.thread;

/**
 * 乐观锁的实现
 * @ClassName: OptimisticLock
 * @Description: TODO(类简要描述，必须以句号为结束)
 * @author Administrator
 * @date 2018年4月3日
 */
public class OptimisticLock {

    public static int value = 0;
    
    /**
     * A线程要执行的方法
     * @Title: invoke
     * @Description: TODO(方法简要描述，必须以句号为结束)
     * @author: Administrator
     * @since: (开始使用的版本)
     * @param a_value
     * @param i
     * @throws InterruptedException 
     */
    public static void invoke(int a_value,String i) throws InterruptedException {
        Thread.sleep(1000);
        if(a_value != value) {
            System.out.println(a_value+":"+value+" 值不一样，不继续执行");
            value --;
        }else {
            a_value++;
            value = a_value;
            System.out.println(i+":"+value);
        }
    }
    
    /**
     * b线程调用的方法
     * @Title: invoke2
     * @Description: TODO(方法简要描述，必须以句号为结束)
     * @author: Administrator
     * @since: (开始使用的版本)
     * @param b_value
     * @param i
     * @throws InterruptedException 
     */
    public static void invoke2(int b_value,String i) throws InterruptedException {
        Thread.sleep(1000);
        if(b_value != value) {
            System.out.println(b_value+":"+value+" b版本不一致，不继续");
        }else {
            System.out.println("B:利用value运算,value="+b_value);
        }
    }
    
    public static void main(String[] args) {
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                for(int i=0;i<3;i++) {
                    int a_value = OptimisticLock.value;
                        OptimisticLock.invoke(a_value, "A");
                }
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                
            }
            
        }).start();

        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    for(int i=0;i<3;i++) {
                        int b_value = OptimisticLock.value;
                        OptimisticLock.invoke2(b_value, "B");
                    }
                }catch(Exception e) {
                    e.printStackTrace();
                }
                
            }
            
        }).start();
    }

}
