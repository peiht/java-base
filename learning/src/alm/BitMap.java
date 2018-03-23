package alm;


/**
 * ��λͼʵ�ִ��������ļ���
 * @ClassName: BitMap
 * @Description: TODO(���Ҫ�����������Ծ��Ϊ����)
 * @author Administrator
 * @date 2018��3��22��
 */
public class BitMap {

    byte[] tem;
    
    public BitMap(int length) {
        this.tem = new byte[length];
    }
    
    public void add(int num) {
        if(num < tem.length) {
            if(tem[num] != 1) {
                //������ʱ���λ���ó�1
                tem[num] = 1;
            }
        }
    }
    
    //��ѯ����������ʱ��ֻ��Ҫ�鿴��Ӧ��λ���Ƿ���Ϊ1
    public boolean contain(int num) {
        if(num < tem.length) {
            if(tem[num] != 1) {
                return false;
            }
        }
        return true;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        long beforeMemory = Runtime.getRuntime().totalMemory();
        long start1 = System.currentTimeMillis();
        BitMap set = new BitMap(2000000000);
        for(int i = 0;i<2000000000;i++) {
            if(i != 898989) {
                //set.set(i,true);
                set.add(898989);
            }
        }
        
        long afterMemory = Runtime.getRuntime().totalMemory();
        long end1 = System.currentTimeMillis();
        System.out.println("�ܹ�ʹ���ڴ�Ϊ��"+(afterMemory - beforeMemory)/1024/1024 +"MB");
        System.out.println("�ܹ���ʱ��"+(end1 - start1)+"����");
        
        
        long start2 = System.currentTimeMillis();
        boolean isExit1 = set.contain(898989);
        boolean isExit2 = set.contain(900000);
        long end2 = System.currentTimeMillis();
        System.out.println("��ѯ�ܹ���ʱ��"+(end2 - start2)+"����");
        System.out.println(isExit1);
        System.out.println("20������"+(isExit1?"����":"������")+898989);
        System.out.println("20������"+(isExit2?"����":"������")+900000);
    }

}
