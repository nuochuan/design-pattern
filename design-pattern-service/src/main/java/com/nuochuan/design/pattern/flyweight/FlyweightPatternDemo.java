package com.nuochuan.design.pattern.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * 使用享元模式
 */
public class FlyweightPatternDemo {

    /**
     * 场景
     * （1）我们现在要缓存一些数据，比如说权限，根据权限的ID作为key，权限数据自己本身是value
     * （2）但是我们不需要使用太复杂的ehcache框架之类的去使用，特别特别的简单的
     * （3）我们就想基于自己的Map去实现一套东西
     *
     * 享元模式，从最基本的角度来说，其实就是维护固定数量的对象实例，不同的对象实例，只有一个，然后保存在内部的一个map中。可以算是跟单例模式的一个扩展和结合吧。
     *
     * 这边我可以给大家说一个享元模式的常见使用场景，其实就是jvm内缓存实现，如果我们不想引入ehcache之类缓存框架，就想简单一点，通过自己实现的一个map来缓存对应的一些数据，比如说每个权限的数据，或者每个员工的数据，在内存里自己维护一个缓存工厂，就是基于享元模式的思想来实现的。
     *
     * 这块我们在电商系统里，可以在权限那块，做一个简单的冷数据jvm缓存方案呢，来给大家实践。
     */
    public static void main(String[] args) {
        Flyweight flyweight1 = FlyweightFactory.getFlyweight("对象1");
        flyweight1.execute();

        Flyweight flyweight2 = FlyweightFactory.getFlyweight("对象1");
        flyweight2.execute();

        System.out.println(flyweight1 == flyweight2);

        /**
         * 享受元数据
         * 同一份数据，我认为是一个数据，就会放到缓存里共享数据
         */
    }

    public interface Flyweight {

        void execute();

    }

    public static class ConcreteFlyweight implements Flyweight {

        private String name;

        public String getName() {
            return name;
        }

        public void setName() {

        }

        public void setName(String name) {
            this.name = name;
        }

        public ConcreteFlyweight(String name) {
            this.name = name;
        }

        @Override
        public void execute() {
            System.out.println("执行享元模式的功能逻辑");
        }

    }

    public static class FlyweightFactory {

        private static Map<String, Flyweight> cachePool = new HashMap<>(16);

        public static Flyweight getFlyweight(String key) {
            Flyweight flyweight = cachePool.get(key);

            if (flyweight == null) {
                flyweight = new ConcreteFlyweight(key);
                cachePool.put(key, flyweight);
            }
            return flyweight;
        }

    }


}
