package learning.thread;

/**
 * �ֹ�����ʵ��
 * @ClassName: OptimisticLock
 * @Description: TODO(���Ҫ�����������Ծ��Ϊ����)
 * @author Administrator
 * @date 2018��4��3��
 */
public class OptimisticLock {

    public static int value = 0;
    
    /**
     * A�߳�Ҫִ�еķ���
     * @Title: invoke
     * @Description: TODO(������Ҫ�����������Ծ��Ϊ����)
     * @author: Administrator
     * @since: (��ʼʹ�õİ汾)
     * @param a_value
     * @param i
     * @throws InterruptedException 
     */
    public static void invoke(int a_value,String i) throws InterruptedException {
        Thread.sleep(1000);
        if(a_value != value) {
            System.out.println(a_value+":"+value+" ֵ��һ����������ִ��");
            value --;
        }else {
            a_value++;
            value = a_value;
            System.out.println(i+":"+value);
        }
    }
    
    /**
     * b�̵߳��õķ���
     * @Title: invoke2
     * @Description: TODO(������Ҫ�����������Ծ��Ϊ����)
     * @author: Administrator
     * @since: (��ʼʹ�õİ汾)
     * @param b_value
     * @param i
     * @throws InterruptedException 
     */
    public static void invoke2(int b_value,String i) throws InterruptedException {
        Thread.sleep(1000);
        if(b_value != value) {
            System.out.println(b_value+":"+value+" b�汾��һ�£�������");
        }else {
            System.out.println("B:����value����,value="+b_value);
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
