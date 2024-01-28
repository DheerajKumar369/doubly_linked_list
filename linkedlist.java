//program for creting and linkedlist 
public class linkedlist
{
    class Node {            //create a class node to repersent node of linked list 
        int data;               // data field
        Node next;              //address field


        Node(int data)      // create a constructor and initialise the default value of data
        {
            this.data = data;
        }

    }

    public Node head = null;
    public Node tail = null;

    public void addNode(int data)       //method to add new node to the list in front
    {
        Node newNode = new Node(data);      //declare a new node 
        if (head == null)
         {
            head = newNode;                 // adding data to the empty list
            System.out.println("node added");
        }
        else
        {
            tail.next = newNode;             //if there is already a data in the list and adding new list
            System.out.println("node added");
        }
        tail = newNode;                       //change tail as newnode
    }

    public void display(){
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
    public void insertInto(int  nextTo, int data)       //adding a new node next to a node
    {
        Node newnNode = new Node(data);
        Node temp = head;
        while(temp !=null && temp.data != nextTo){      // iterating the node
            temp = temp.next;
        }
        if(temp == null){                           //no node is there
            return;
        }
        if(temp == tail){                       // the next node is inserted at last
            temp.next = newnNode;
            tail = newnNode;
            System.out.println("node added");
            return;
        }
        System.out.println("node added");
        newnNode.next = temp.next;              // node is inserted at next to a node
        temp.next = newnNode;
    }
    public void delete(int data)
    {
        Node temp = head;
        Node prev = null;
        if (temp != null && temp.data == data) {    //delete head 
            head = temp.next;
            System.out.println("node deleted");
            return;
        }
         while (temp != null && temp.data != data) {    //delete between nodes
            prev = temp;
            temp = temp.next;
            System.out.println("node deleted");
        }

        if(temp == null){               //no node to delete
            return;
        }
        if (temp == tail) {             //delete end node
            tail = prev;
            tail.next = null;
            System.out.println("node deleted");
            return;
        }
        prev.next = temp.next;
    }

    public static void main(String[] args)
    {
        linkedlist list = new linkedlist();     //creating an object of class linkedlist
        list.addNode(10);                   //calling addNode method
        list.addNode(20);
        list.addNode(30);
        list.display();                         //display method

        list.delete(20);                    // delete method
        list.insertInto(10, 40);        //inserting new node next to the given node
        list.display();
    }
}


