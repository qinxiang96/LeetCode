package com.flora.test.dataStructure;


import java.util.Hashtable;

/**
 * @Author qinxiang
 * @Date 2022/11/17-上午10:35
 * 如何实现单链表的增删操作
 */
public class q1 {
    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();
        list.addNode(5);
        list.addNode(3);
        list.addNode(1);
        list.addNode(3);
        System.out.println("list的长度：" + list.length());
        System.out.println("before order:");
        list.printList();
        list.orderList();
        System.out.println("after order:");
        list.printList();
        list.deleteNode(1);
        System.out.println("after delete");
        list.printList();

        list.deleteDuplicate(list.head);
        System.out.println("after delete duplicate");
        list.printList();
        Node elem = list.findElem(list.head, 2);
        System.out.println("倒数第2个元素为："+elem);
        list.reverse(list.head);
        System.out.println("反转之后");
        list.printList();
        System.out.println("从尾到头输出");
        list.printList2();//此时链表本身已经发生了反转
        System.out.println("使用递归的方式从尾到头输出");
        list.printListReversely(list.head);
        System.out.println("此时的链表顺序");
        list.printList();


    }
}
class MyLinkedList{
    Node head = null;

    /**
     * 向链表中插入数据
     * @param d 插入数据的内容
     */
    public void addNode(int d){
        Node newNode = new Node(d);
        if(head == null){
            head = newNode;
            return;
        }
        Node tmp = head;
        while(tmp.next != null){
            tmp = tmp.next;
        }
        tmp.next = newNode;
    }
    /**
     * 删除第index个节点
     * 成功返回true,失败返回false
     */
    public boolean deleteNode(int index){
        //删除元素的位置不合理
        if(index < 1 || index > length()){
            return false;
        }
        //删除链表第一个元素
        if(index == 1){
            head = head.next;
            return true;
        }
        int i = 2;
        Node preNode = head;
        Node curNode = preNode.next;
        while(curNode!=null){
            if(i == index){
                preNode.next = curNode.next;
                return true;
            }
            preNode = curNode;
            curNode = curNode.next;
            i++;
        }
        return true;
    }

    /**
     * 返回节点的长度
     * @return
     */
    public int length(){
        int length = 0;
        Node tmp = head;
        while(tmp != null){
            length ++;
            tmp = tmp.next;
        }
        return length;
    }

    /**
     * 对链表进行排序
     * 返回排序后的头节点
     * @return
     */
    public Node orderList(){
        Node nextNode = null;
        int temp = 0;
        Node curNode = head;
        while (curNode.next != null){
            nextNode = curNode.next;
            while (nextNode != null){
                if(curNode.data > nextNode.data){
                    temp = curNode.data;
                    curNode.data = nextNode.data;
                    nextNode.data = temp;
                }
                nextNode = nextNode.next;
            }
            curNode = curNode.next;

        }
        return head;
    }
    public void printList(){
        Node tmp = head;
        while(tmp != null){
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
    }

    /**
     * 从尾到头输出
     */
    public void printList2(){
        reverse(head);
        Node tmp = head;
        while(tmp != null){
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
    }

    /**
     * 如何从链表中删除重复数据
     * 方法一：优点：时间复杂度较低
     * 缺点：遍历过程中需要额外的存储空间保存已遍历的值
     * @param head
     */
    public void deleteDuplicate(Node head){
        Hashtable<Integer, Integer> table = new Hashtable<>();
        Node tmp = head;
        Node pre = null;
        while(tmp != null){
            if(table.containsKey(tmp.data)){
                pre.next = tmp.next;
            }else{
                table.put(tmp.data, 1);
                pre = tmp;

            }
            tmp = tmp.next;
        }

    }

    /**
     * 如何从链表中删除重复数据
     * 方法二：对链表进行双重循环遍历，
     * 外循环正常遍历链表，假设外循环当前遍历的节点为cur,内循环从cur开始遍历，若碰到与cur所指向节点值相同，则删除这个重复的节点
     * 优点：不需要额外的存储空间
     * 缺点：时间复杂度高
     * @param head
     */
    public void deleteDuplicate2(Node head){
        Node p = head;
        while(p != null){
            Node q = p;
            while(q.next != null){
                if(p.data == q.next.data){
                    q.next = q.next.next;
                }else{
                    q=q.next;
                }
            }
            p = p.next;
        }
    }

    /**
     * 如何找出单链表中的倒数第k个元素
     * @param head
     * @param k
     * @return
     */
    public Node findElem(Node head, int k){
        if(k < 1 || k > length()){
            return null;
        }
        int i = 0;
        while(head != null){

            i ++;
            if(i == length() + 1 - k){
                return head;
            }
            head = head.next;
        }
        return null;
    }

    /**
     * 如何找出单链表中的倒数第k个元素
     * 方法二：
     * @param head
     * @param k
     * @return
     */
    public Node findElem2(Node head, int k){
        if(k < 1){
            return null;
        }
        Node p1 = head;
        Node p2 = head;
        for(int i = 0; i < k - 1 && p1 != null; i ++){//前移k-1步
            p1 = p1.next;
        }
        if(p1 == null){
            System.out.println("k不合法");
            return null;
        }
        while(p1.next != null){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }

    /**
     * 如何实现链表的反转
     * @param head
     */
    public void reverse(Node head){
        Node cur = head;
        Node pre = null;
        Node reverseHead = head;
        while(cur != null){
            Node next = cur.next;//假设相邻的三个节点为i,m,n,当前遍历到m,在将m指向i之前需要把n保存下来
            if(next == null){
                reverseHead = cur;//反转后的头节点就是原始链表的尾节点，即next为空的当前指针的节点
            }
            cur.next = pre;//将m指向i
            pre = cur;//当前节点变成已经处理过的前一个节点
            cur = next;//将当前遍历的节点前移
        }
        this.head = reverseHead;
    }

    /**
     * 如何从尾到头输出单链表
     * 使用递归的方法
     * @param head
     */
    public void printListReversely(Node head){
        if(head != null){
            printListReversely(head.next);
            System.out.println(head.data);//输出节点本身必须在完成上面的方法之后，从而实现链表反转输出
        }
    }

    /**
     * 如何寻找单链表的中间节点
     * 采用双指针法，快指针P一次走2步，慢指针q一次走一步，当快指针到链表尾部，慢指针恰好到达链表中部
     * @param head
     * @return
     */
    public Node searchMid(Node head){
        Node p = this.head;
        Node q = this.head;
        while(p != null && p.next != null && p.next.next != null){
            p = p.next.next;
            q = q.next;
        }
        return q;
    }

    /**
     * 如何检验一个链表是否有环
     * 快指针p走2步，慢指针走1步，当p=q，表示带环
     * @param head
     * @return
     */
    public boolean isLoop(Node head){
        Node p = head;
        Node q = head;
        while(p != null && p.next != null && p.next.next != null){
            p = p.next.next;
            q = q.next;
            if(p == q){
                return true;
            }
        }
        return false;
    }

    /**
     * 如何在不知道头指针的情况下删除指定节点
     * 如果待删除的节点为链表尾节点，无法删除，因为无法使前驱节点的next指针置为空
     * 如果待删除的节点不是尾节点，则可以通过交换该节点与后继节点的值，然后删除后继结点
     * @param n
     * @return
     */
    public boolean deleteNode(Node n){
        if(n == null || n.next == null){
            return false;
        }
        int tmp = n.data;//保存当前节点的值
        n.data = n.next.data;//当前节点的值=后继节点的值
        n.next.data = tmp;//后继节点的值=当前节点的值
        n.next = n.next.next;//删除后继节点
        return true;

    }

    /**
     * 如何判断两个链表是否相交
     * 规则：如果两个链表相交，那么他们一定有着相同的尾节点
     * @param head1
     * @param head2
     * @return
     */
    public boolean isIntersect(Node head1, Node head2){
        if(head1 == null || head2 == null){
            return false;
        }
        Node tail1 = head1;
        while(tail1.next != null){
            tail1 = tail1.next;
        }
        Node tail2 = head2;
        while(tail2.next != null){
            tail2 = tail2.next;
        }
        return tail1 == tail2;
    }



}
class Node{
    Node next = null;
    int data;
    public Node(int data){
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "next=" + next +
                ", data=" + data +
                '}';
    }
}
