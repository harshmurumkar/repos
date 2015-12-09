package hackerrank;

/*
 * Insert Node at a given position in a linked list head can be NULL First element in the
 * linked list is at position 0 Node is defined as class Node { int data; Node next; }
 */
class InsertAtNth
{

    public static void main(String[] args)
    {
        
    }
    
    Node InsertNth(Node head, int data, int position) {
        //Will Need to Return Head Node 
        Node n1 = head;
        
        Node n2 = new Node(); 
        n2.data = data;
        
        //Empty List - Returned newly created node or null
        if (head==null){return n2;}
        
        //Inserting a Node ahead of the List
        if (position == 0){n2.next = head; return n2;}    
        
        //Traverse the Singly Linked List to 1 Position Prior
        //Stop traversing if you reached the end of the List
        int curr = 0;
        
        while (curr < position -1 && head.next != null){
            head = head.next;        
            curr++;       
        }

        //Inserting a Node in-between a List or at the end of of a List
        Node nAtPosition = head.next;
        head.next = n2;
        head = head.next;
        head.next = nAtPosition;
            
        return n1;
    }
    
    private static class Node
    {
        Node next;
        int data;
    }
}
