//Linked List Operation

public class LinkedList {
    public static class Node{
         int data;
         Node next;

         public Node(int data){
            this.data = data;
            this.next = null;
         }

    }
    public static Node head;
    public static Node tail;

    //adding at first
     public void addFirst(int data){
         Node newNode = new Node(data);
        if(head == null){
             head = tail = newNode;
             return;
        }

        newNode.next = head;
        head = newNode;
     }

     //adding at last
     public void addLast(int data){
        Node newNode = new Node(data);
        if(head == null){
            head = tail=newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
     }

     //Displaying Linked List
     public void print(){
        Node temp = head;
        if(head == null){
            System.out.println("Linked List is empty");
            return;
        }
        while( temp != null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
     }
    public static void main(String args[]){
       LinkedList ll = new LinkedList();
        ll.print();
        ll.addFirst(2);
        ll.print();
        ll.addFirst(1);
        ll.print();
        ll.addLast(3);
        ll.print();
        ll.addLast(4);
        ll.print();

    }
}