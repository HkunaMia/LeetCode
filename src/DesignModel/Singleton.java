package DesignModel;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: Administrator
 * \* Date: 2020/7/20
 * \* Time: 19:25
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */

//懒汉式
public class Singleton {
//    私有构造函数
    private Singleton() {}
//    单例对象
    private volatile static Singleton instance = null;

//    饿汉式，在类加载时就创建好对象
//    private volatile static Singleton instance = new Singleton();
//    public static Singleton getInstance(){
//        if(instance==null){
//              instance = new Singleton();
//        }
//        return instance;
//    }

//    静态工厂方法
    public static Singleton getInstance(){
        if(instance==null){
            synchronized (Singleton.class){
                if(instance==null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}


//////    使用静态内部类实现
//public class Singleton{
//    private Singleton() {}
//
//    private static class LaztHolder{
//        private static final Singleton INSTANCE = new Singleton();
//    }
//
////    INSTANCE对象初始化的时机并不是在单例类Singleton被加载的时候，
////    而是在调用getInstance方法，使得静态内部类LazyHolder被加载的时候。
////    因此这种实现方式是利用classloader的加载机制来实现懒加载，并保证构建单例的线程安全。
//    public static Singleton getInstance(){
//        return LaztHolder.INSTANCE;
//    }
//}
