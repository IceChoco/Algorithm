package BaekJoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class BJ10828_스택 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        MyStack stack = new MyStack();
        for(int i=0;i<N;i++){
            String[] input = br.readLine().split(" ");
            if(input[0].equals("push")){
                stack.push(Integer.parseInt(input[1]));
            }else if(input[0].equals("pop")){
                System.out.println(stack.pop());
            }else if(input[0].equals("size")){
                System.out.println(stack.size());
            }else if(input[0].equals("empty")){
                System.out.println(stack.empty());
            }else if(input[0].equals("top")){
                System.out.println(stack.top());
            }
        }
    }
}

class MyStack{
    private Node head;//제일 첫번째(제일 아래 노드)
    private Node top;//제일 마지막(제일 위 노드)

    public MyStack() {
        head = top = null;
    }

    private Node createNode(int data){
        return new Node(data);
    }

    public void push(int X){
        if(empty()==1){
            head = createNode(X);
            top = head;
        }else{//스택이 비어있지 않다면 마지막 위치(pointer)를 찾아 새 노드를 연결시킨다.
            Node pointer = head;
            while(pointer.next != null)
                pointer = pointer.next;

            pointer.next = createNode(X);
            top = pointer.next;
        }
    }

    public int pop(){
        int popData;
        if(empty()==0){
            popData = top.data;
            Node pointer = head;

            if(head == top)
                head = top = null;
            else{
                while(pointer.next != top)
                    pointer = pointer.next;

                pointer.next = null;
                top = pointer;
            }
            return popData;
        }
        return -1;
    }

    public int size(){
        if(empty()==1) return 0;

        int cnt=0;
        Node pointer = head;
        while(pointer.next != null){
            cnt++;
            pointer = pointer.next;
        }
        return cnt+1;
    }

    public int empty(){
        return top == null ? 1 : 0;
    }

    public int top(){
        if(empty()==0){
            int topData = top.data;
            return topData;
        }
        return -1;
    }
}

class Node{
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
    }
}
