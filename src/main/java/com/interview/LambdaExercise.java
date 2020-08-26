package com.interview;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Java8 快速实现List转map 、分组、过滤等操作
 * @author wangjianfeng
 */
public class LambdaExercise {

    public static void main(String[] args) {
        List<Apple> appleList = new ArrayList<>();//存放apple对象集合

        Apple apple1 =  new Apple(1,"苹果1",new BigDecimal("3.25"),10);
        Apple apple12 = new Apple(1,"苹果2",new BigDecimal("1.35"),20);
        Apple apple2 =  new Apple(2,"香蕉",new BigDecimal("2.89"),30);
        Apple apple3 =  new Apple(3,"荔枝",new BigDecimal("9.99"),40);

        appleList.add(apple1);
        appleList.add(apple12);
        appleList.add(apple2);
        appleList.add(apple3);

        // 1. 分组 以ID分组 Map<integer,list>
        Map<Integer, List<Apple>> groupBy = appleList.stream().collect(Collectors.groupingBy(Apple::getId));
        System.out.println("groupBy:" + groupBy);

        // 2. List转Map，id为key，apple对象为value
        Map<Integer, Apple> appleMap = appleList.stream().collect(Collectors.toMap(Apple::getId, a -> a,(k1,k2)->k1));
        System.out.println("appleMap:" + appleMap);

        // 3. money求和
        BigDecimal totalMoney = appleList.stream().map(Apple::getMoney).reduce(BigDecimal.ZERO, BigDecimal::add);
        System.err.println("totalMoney:"+totalMoney);

        // 4. 查找最大最小值
        Optional<Apple> maxApple = appleList.stream().max(Comparator.comparing(Apple::getMoney));
        maxApple.ifPresent(System.out::println);

        Optional<Apple> minApple = appleList.stream().min(Comparator.comparing(Apple::getMoney));
        minApple.ifPresent(System.out::println);

        // 5. 根据id去重
        List<Apple> unique = appleList.stream().collect(
                Collectors.collectingAndThen(
                        Collectors.toCollection(() -> new TreeSet<Apple>(Comparator.comparingInt(Apple::getId))), ArrayList::new));
        System.out.println(unique);
    }

}

class Apple {
    private Integer id;
    private String name;
    private BigDecimal money;
    private Integer num;
    public Apple(Integer id, String name, BigDecimal money, Integer num) {
        this.id = id;
        this.name = name;
        this.money = money;
        this.num = num;
    }

    public Integer getId() {
        return id;
    }

    public Apple setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Apple setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getMoney() {
        return money;
    }

    public Apple setMoney(BigDecimal money) {
        this.money = money;
        return this;
    }

    public Integer getNum() {
        return num;
    }

    public Apple setNum(Integer num) {
        this.num = num;
        return this;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                ", num=" + num +
                '}';
    }
}