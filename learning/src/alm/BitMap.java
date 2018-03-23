package alm;


/**
 * 用位图实现大数据量的计算
 * @ClassName: BitMap
 * @Description: TODO(类简要描述，必须以句号为结束)
 * @author Administrator
 * @date 2018年3月22日
 */
public class BitMap {

    byte[] tem;
    
    public BitMap(int length) {
        this.tem = new byte[length];
    }
    
    public void add(int num) {
        if(num < tem.length) {
            if(tem[num] != 1) {
                //有数的时候把位设置成1
                tem[num] = 1;
            }
        }
    }
    
    //查询包不包含的时候只需要查看对应的位上是否被置为1
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
        System.out.println("总共使用内存为："+(afterMemory - beforeMemory)/1024/1024 +"MB");
        System.out.println("总共耗时："+(end1 - start1)+"毫秒");
        
        
        long start2 = System.currentTimeMillis();
        boolean isExit1 = set.contain(898989);
        boolean isExit2 = set.contain(900000);
        long end2 = System.currentTimeMillis();
        System.out.println("查询总共耗时："+(end2 - start2)+"毫秒");
        System.out.println(isExit1);
        System.out.println("20个亿中"+(isExit1?"包含":"不包含")+898989);
        System.out.println("20个亿中"+(isExit2?"包含":"不包含")+900000);
    }

}
