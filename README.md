# java-base

对java的基础数据结构和算法进行复习和练习

1、jvm的内存模型：
  java虚拟机内存运行时分为几块区域：方法区和堆是线程共有的，虚拟机栈、本地方法栈、程序计数器是线程私有的。
  方法区的作用：用来存放加载类的信息、常量、静态变量、即时编译后的代码等数据。
  堆的作用：存放实例对象。
  虚拟机栈的作用：描述的是java方法执行的内存模型，存储的是局部变量、操作数栈、动态链接、方法出口等信息。每一个方法从开始执行到结束都对应着一个栈帧从入栈到出栈的过程。
  本地方法栈的作用：和虚拟机栈的作用类似，本地方法栈是为了虚拟机的native方法服务。
  程序计数器的作用：可以看做是当前线程执行的字节码的行号指示器。通过改变计数器来确定吓一跳执行的字节码命令。
2、java内存溢出的种类
  java堆溢出、虚拟机栈和本地方法栈溢出、方法区和运行时常量池溢出、本机直接内存溢出。
3、jvm参数配置
  -Xmx –Xms：指定最大堆和最小堆
  -Xmn 设置新生代的大小
  -XX：NewRatio 设置两个新生代Eden和老年代的比值
  -XX：SurvivorRatio 设置两个幸存带和eden代的比值
  -XX:PermSize  -XX:MaxPermSize 设置永久区的厨师空间和最大空间
  -Xss设置栈空间的大小，通常只有几百k
java的集合类：
  1、ArrayList和LinkedList的区别：
    ArrayList是基于动态数组的数据结构，LinkedList是基于链表的数据结构
    对于随机的get和set操作，ArrayList要优于LinkedList，因为LinkedList要移动指针
    对于删除和新增来说，LinkedList要优于ArrayList。
  2、hashset和hashmap的区别
  (1)HashSet是set的一个实现类,hashMap是Map的一个实现类,同时hashMap是hashTable的替代品(为什么后面会讲到). 
  (2)HashSet以对象作为元素,而HashMap以(key-value)的一组对象作为元素,且HashSet拒绝接受重复的对象.HashMap可以看作三个视图：key的Set，value的       Collection，Entry的Set。 这里HashSet就是其实就是HashMap的一个视图。 
HashSet内部就是使用Hashmap实现的，和Hashmap不同的是它不需要Key和Value两个值。 
往hashset中插入对象其实只不过是内部做了
   3、hashmap和hashtable的区别
   （1）、hashtable继承的是dictonary类，hashmap继承的是map类
   （2）、hashtable是线程安全的，hashmap是非线程安全的
   （3）、hashtable中不允许有空值。hashmap可以将null作为key，而且只有一个。
spring相关
hibernate相关
springmvc
数据库
