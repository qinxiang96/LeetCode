package com.flora.test.designPattern.bulidPattern.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author qinxiang
 * @Date 2022/10/18-上午10:10
 */
public class BuilderFactoryDemo {
    public static void main(String[] args) {
        MealBuilder mealBuilder = new MealBuilder();
        Meal meal = mealBuilder.chickenMealOrder();
        meal.showItems();
        //meal.getPrices();
        System.out.println("Cost:" +meal.getPrices());
    }
}
//获取套餐的类
class MealBuilder{
    public Meal vegMealOrder(){
        Meal meal = new Meal();
        meal.addItem( new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }
    public Meal chickenMealOrder(){
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new Pepsi());
        return meal;
    }
}
//套餐 用一个ArrayList存储
class Meal{
    private List<Item> items = new ArrayList<>();
    public void addItem(Item item){
        items.add(item);
    }
    public float getPrices(){
        float prices = 0.0f;
        for(Item item:items){
            prices += item.price();
        }
        return prices;
    }
    public void showItems(){
        for(Item item: items){
            System.out.println("Item:" +item.name());
            System.out.println("Packing:" +item.packing().pack());
            System.out.println("Price:" +item.price());
        }
    }
}
//构建Burger和ColdDrink的实体类
class VegBurger extends Burger{

    @Override
    public String name() {
        return "VegBurger";
    }

    @Override
    public float price() {
        return 25.0f;
    }
}
class ChickenBurger extends Burger{

    @Override
    public String name() {
        return "ChickenBurger";
    }

    @Override
    public float price() {
        return 50.0f;
    }
}
class Coke extends ColdDrink{

    @Override
    public String name() {
        return "Coke";
    }

    @Override
    public float price() {
        return 8.0f;
    }
}
class Pepsi extends ColdDrink{

    @Override
    public String name() {
        return "Pepsi";
    }

    @Override
    public float price() {
        return 9.0f;
    }
}
//实现Item接口的抽象类
abstract class Burger implements Item{
    @Override
    public Packing packing() {
        return new Wrapper();
    }

    @Override
    public abstract float price();
}
abstract class ColdDrink implements Item{
    @Override
    public Packing packing() {
        return new Bottle();
    }

    @Override
    public abstract float price();
}
//实现packing接口的实体类
class Wrapper implements Packing{

    @Override
    public String pack() {
        return "Wrapper";
    }
}
class Bottle implements Packing{

    @Override
    public String pack() {
        return "Bottle";
    }
}
//食物条目
interface Item{
    public String name();
    public Packing packing();
    public float price();
}
//食物包装
interface Packing{
    public String pack();
}
