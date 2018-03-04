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
4、static
 （1）、静态方法
     静态方法不依赖于任何对象就能访问，所以在静态方法中不能访问类的非静态成员变量和非静态成员方法。但是非静态方法可以访问静态方法和变量。
 （2）、静态代码块
    static关键字还有一个比较关键的作用就是 用来形成静态代码块以优化程序性能。static块可以置于类中的任何地方，类中可以有多个static块。在类初次被加载的时候，会按照static块的顺序来执行每个static块，并且只会执行一次
 （3）、静态变量
    static变量也称作静态变量，静态变量和非静态变量的区别是：静态变量被所有的对象所共享，在内存中只有一个副本，它当且仅当在类初次加载时会被初始化。而非静态变量是对象所拥有的，在创建对象的时候被初始化，存在多个副本，各个对象拥有的副本互不影响
5、多线程问题
  （1）、synchronized和lock的区别：
      synchronized是一个关键字，lock是一个类
      lock比synchronized更加灵活。如果使用synchronized关键字，则不需要用户去手动释放锁，方法或者代码执行完毕后系统会让线程自己释放锁。Lock则必须需要用户去释放锁，如果没有及时释放锁，就会造成死锁现象。
      lock可以让等待的线程中断响应，synchronized却不能。
      lock可以知道有没有成功获取到锁。
      lock可以提高多个线程的操作效率。
  （2）、synchronized的使用方法和原理
      synchronized可以修饰普通的方法，修饰静态方法和代码块
      实现原理：每个对象都有一个监视器，当monitor被占用时就会处于锁定状态。线程执行开始时，如果monitor获取到的值为0，则进入到该monitor，即该线程为monitor的所有者，如果检测到其他线程占用monitor则会阻塞，等待monitor的进入数为0，再尝试获取monitor的所有权。
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
 1。什么是IOC
   控制反转，是将原本在程序中手动创建的对象的控制权，交给spring管理。包括构造器注入、注解注入和setter注入。
 2、spring框架中五种bean的作用域：
  singleton : bean在每个Spring ioc 容器中只有一个实例。
  prototype：一个bean的定义可以有多个实例。
  request：每次http请求都会创建一个bean，该作用域仅在基于web的Spring ApplicationContext情形下有效。     
  session：在一个HTTP Session中，一个bean定义对应一个实例。该作用域仅在基于web的Spring ApplicationContext情形下有效。
  global-session：在一个全局的HTTP Session中，一个bean定义对应一个实例。该作用域仅在基于web的Spring ApplicationContext情形下有效。
 3、AOP：面向切面，是一种编程思想，OOP的延续。将系统中非核心的业务提取出来，进行单独处理。比如事务、日志和安全等。
    AOP是面向切面编程，是通过动态代理的方式为程序添加统一功能，集中解决一些公共问题
 
hibernate相关
 1.什么是延迟加载
   延迟加载是真正用到数据的时候才会加载数据，避免一些无谓的性能开销。
springmvc
 1、springmvc和struts2的区别
  springmvc的入口是一个DispatcherServlet即前端控制器，strut2的入口是一个filter。
  
数据库
