package com.flora.test.dataStructure;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * @Author qinxiang
 * @Date 2022/11/17-下午12:04
 * 栈与队列
 * 栈：先进后出
 * 队列：先进先出
 */
public class q2 {
    public static void main(String[] args) {
        MyStack<Integer> s = new MyStack<>();
        s.push(1);
        s.push(2);
        System.out.println("栈中的元素个数：" + s.size);
        System.out.println("栈顶的元素为："+s.pop());
        System.out.println("栈顶的元素为："+s.pop());

        MyStack1 myStack1 = new MyStack1();
        myStack1.push(3);
        myStack1.push(7);
        myStack1.push(2);
        MyStack<Integer> min = myStack1.min;
        System.out.println("最小元素为："+min.pop());
        MyQueue<Integer> queue = new MyQueue<>();
        queue.put(1);
        queue.put(2);
        queue.put(3);
        System.out.println("队列的长度："+queue.size());
        System.out.println("队列的首元素："+queue.pop());
        System.out.println("队列的首元素："+queue.pop());
    }
}

/**
 * 用数组实现栈
 * @param <E>
 */
class MyStack<E>{
    private Object[] stack;
    int size;
    public MyStack(){
        stack = new Object[10];//初始长度为10
    }
    //判断栈是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    public E peek(){
        if(isEmpty()){
            return null;
        }
        return (E)stack[size - 1];
    }
    //弹栈
    public E pop(){
        E e = peek();
        stack[size - 1] = null;
        size --;
        return e;
    }
    //压栈
    public E push(E item){
        ensureCapacity(size + 1);//检查容量
        stack[size++] = item;
        return item;
    }
    private void ensureCapacity(int size){
        int len = stack.length;
        if(size > len){
            int newLen = 10;//每次数组扩充的容量
            stack = Arrays.copyOf(stack, newLen);
        }
    }
}
/**
 * 用链表的方式实现栈
 * @param <E>
 */
class Node2<E>{
    Node2<E> next = null;
    E data;
    public Node2(E data){
        this.data = data;
    }
}

class Stack<E>{
    Node2<E> top = null;
    public boolean isEmpty(){
        return top == null;
    }
    public void push(E data){
        Node2<E> newNode = new Node2<>(data);
        newNode.next = top;
        top = newNode;
    }
    public E pop(){
        if(this.isEmpty()){
            return null;
        }
        E data = top.data;
        top = top.next;
        return data;
    }
    public E peek(){
        if(isEmpty()){
            return null;
        }
        return top.data;
    }
}

/**
 * 求栈中最小元素
 * 时间复杂度o(n)：遍历栈中所有元素找到最小值
 * 时间复杂度o(1):使用两个栈结构，一个栈用来存储数据，一个用来存储栈的最小元素
 *
 */
class MyStack1{
    MyStack<Integer> elem;
    MyStack<Integer> min;
    public MyStack1(){
        elem = new MyStack<>();
        min = new MyStack<>();
    }
    public void push(int data){
        elem.push(data);
        if(min.isEmpty()){
            min.push(data);
        }else{
            if(data < min.peek()){
                min.push(data);
            }
        }
    }
    public int pop(){
        int topData = elem.peek();
        elem.pop();
        if(topData == this.min()){
            min.pop();//如果当前出栈的元素恰好为当前栈中的最小值，保存最小值的栈顶元素也出栈
        }
        return topData;
    }
    public int min(){
        if(min.isEmpty()){
            return Integer.MAX_VALUE;
        }else{
            return min.peek();
        }
    }


}
/**
 * 如何实现队列
 * 采用链表的方式实现队列
 */
class MyQueue<E>{
    private Node2<E> head = null;
    private Node2<E> tail = null;
    public boolean isEmpty(){
        return head == tail;
    }
    public void put(E data){
        Node2<E> newNode = new Node2<>(data);
        if(head == null && tail == null){
            head = tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
    }
    public E pop(){
        if(this.isEmpty()){
            return null;
        }
        E data = head.data;
        head = head.next;
        return data;
    }
    public int size(){
        Node2<E> tmp = head;
        int n = 0;
        while(tmp != null){
            n ++;
            tmp = tmp.next;
        }
        return n;
    }


}
/**
 * 如何实现队列
 * 采用数组的方式实现队列
 */
class MyQueue2<E>{
    private LinkedList<E> list = new LinkedList<E>();
    private int size = 0;
    public synchronized void put(E e){
        list.addLast(e);
        size ++;
    }
    public synchronized E pop(){
        size --;
        return list.removeFirst();
    }
    public synchronized boolean empty(){
        return size == 0;
    }
    public synchronized int size(){
        return size;
    }

}

/**
 * 如何用两个栈模拟队列操作
 * 栈A提供入队列的功能，栈B提供出队列的功能
 * 入队列入栈A即可
 * 出队列有2种情况
 * 1.栈B不为空，弹出栈B的数据
 * 2、栈B为空，依次弹出栈A的数据，放入栈B中，再弹出栈B的数据
 * @param <E>
 */
class MyQueue3<E>{
    private Stack<E> s1 = new Stack<>();
    private Stack<E> s2 = new Stack<>();
    public synchronized void put(E e){
        s1.push(e);
    }
    public synchronized E pop(){
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.push(s1.pop());
            }
        }
        return s2.pop();
    }
    public synchronized boolean empty(){
        return s1.isEmpty()&&s2.isEmpty();
    }

}


