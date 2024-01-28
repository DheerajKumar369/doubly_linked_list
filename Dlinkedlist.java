public class Dlinkedlist {
    class Node{
        int data;
        Node next;                      // have address of next node
        Node prev;                     //have address of previous node

        Node(int data)                // create a constructor and initialise the default value of data
        {
            this.data = data;
        }

    }
    public Node head = null;
    public Node tail = null;

    public void addNode(int data)           // method for adding node
    {
        Node newnode = new Node(data);
        if(head == null)
        {
            head = newnode;
            System.out.println("node added");
        }
        else
        {
            tail.next = newnode;
            newnode.prev = tail;
            System.out.println("node added");
        }
        tail = newnode;
    }
    public void display()
    {
        if(head == null){                       //check for null head
            System.out.println("empty list");
            return;
        }
        Node temp = head;
        while (temp != null) {
          System.out.println(temp.data);  
          temp = temp.next;
        }
    }
    public void inserAfter(int nextTo, int data)            //insert a node after mentioned node
    {
        Node newnode = new Node(data);
        Node temp = head;
        while(temp != null && temp.data != nextTo){              //traverse the node
            temp = temp.next;   
        }
        if(temp == null){
            return;
        }
        if(temp == tail){                               // adding node at tail
            temp.next = newnode;
            newnode.prev = tail;
            tail = newnode;
            System.out.println("node added");
            return;
        }
        System.out.println("node added");
        newnode.next = temp.next;                       // adding node after
        newnode.prev = temp;
        temp.next = newnode;
    }
    public void insertBefore(int nextTo, int data){    //insert a node before the mentioned node
        Node newnode = new Node(data);
        Node temp = head;
        while(temp != null && temp.data != nextTo){         //traverse the node
            temp = temp.next;   
        }
        if(temp == null){
            return;
        }
        if(temp == head){                           //adding the new node as head node
            newnode.next = temp;
            newnode.prev = null;
            head = newnode;
            System.out.println("node added");
            return;
        }
        if(temp == tail){                       //insert the new node before tail node
            newnode.next = temp;
            newnode.prev = temp.prev;
            temp.prev.next = newnode;
            temp.prev = newnode;
            System.out.println("node added");
            return;
        }
        newnode.next = temp;
        newnode.prev =temp.prev;                //insert a node before the mention node 
        temp.prev.next = newnode;
        temp.prev = newnode;

        System.out.println("node added");
    }
    public void delete(int data){
        Node temp = head;
        
        if(temp != null && temp.data == data){
            if(temp.next != null){                      
                temp.next.prev = null;
            }
            head = temp.next;
            head.prev = null;
            System.out.println("node deleted");
            return;
        }
        while(temp != null && temp.data != data){            //traverse the node
            temp = temp.next;
        }
        if (temp == null) {
            return;
        }
        if(temp == tail){
            tail = temp.prev;
            tail.next = null;
            System.out.println("node deleted");
            return;
        }
        temp.prev.next = temp.next;
        temp.next.prev = temp.prev;
        temp.prev = null;
        temp.next = null;
        System.out.println("node deleted");
    }

    public static void main(String[] args)
    {
        Dlinkedlist list = new Dlinkedlist();     //creating an object of class linkedlist
        list.addNode(10);                   //calling addNode method
        list.addNode(20);
        list.addNode(30);
        list.addNode(40);
        list.insertBefore(20, 25);
        list.insertBefore(40, 50);
        list.inserAfter(30,60);
        list.display();                         //display method 
        list.delete(20);                   //deleting the node value
        list.delete(40);
        list.display();
    }
    
    
}
