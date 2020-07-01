package MinStack155;

import java.util.Stack;

/**
 * 两个栈实现最小栈
 */
public class MinStack {
    private Stack<Integer> nomstack = new Stack<>();
    private Stack<Integer> minstack = new Stack<>();
    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        if(minstack.empty() || x <= minstack.peek())
            minstack.push(x);
        nomstack.push(x);
    }

    public void pop() {
        if(nomstack.peek().equals(minstack.peek()))
            minstack.pop();
        nomstack.pop();
    }

    public int top() {
        return nomstack.peek();
    }

    public int getMin() {
        return minstack.peek();
    }
    public static void main(String[] arg){
        MinStack obj = new MinStack();
        obj.push(512);
        obj.push(-1024);
        obj.push(-1024);
        obj.push(512);
        obj.pop();
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());
    }
}

/**
 * 链表实现
 */
class MinStack2 {
    private Node head;

    public void push(int x) {
        if(head == null)
            head = new Node(x, x);
        else
            head = new Node(x, Math.min(x, head.min), head);
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    private class Node {
        int val;
        int min;
        Node next;

        private Node(int val, int min) {
            this(val, min, null);
        }

        private Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
