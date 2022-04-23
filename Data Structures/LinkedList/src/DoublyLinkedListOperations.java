/** Practice code for Doubly Linked list */
/* The extra previous pointer q to keep track of previous to a node is not required.*/
class DoublyLinkedList
{
    DLLNode head;
    private int size;

    void insert(int data, int position)
    {
//        System.out.println("Inserting DLLNode at position " + position);
        DLLNode temp = head;

        if (temp == null && position > 1)
        {
            System.out.println("List is empty. Need to enter at position 1");
            return;
        }
        DLLNode newNode = new DLLNode(data);
        if (position == 1)
        {
            newNode.next = temp;
            if (temp != null)
            {
                temp.previous = newNode;
            }
            head = newNode;
            size++;
        }
        else
        {
            int k = 1;
            while (k < position - 1 && temp.next != null)
            {
                temp = temp.next;
                k++;
            }
            if (k != position - 1)
            {
//                System.out.println("Aukaat se bahaar ho gaya.");
            }
            //Either it is at the last or in the middle.
            else
            {
                newNode.next = temp.next;
                temp.next = newNode;
                newNode.previous = temp;
                size++;
            }
        }
    }

    void printList()
    {
        System.out.println("Printing List.........");
        DLLNode temp = head;
        if (temp != null)
        {
            while (temp.next != null)
            {
                System.out.print(temp.data + "<--->");
                temp = temp.next;
            }
            System.out.print(temp.data + "--->" + temp.next);
        }
        else
        {
            System.out.println("List is Empty!!");
        }
        System.out.println();  // Add line b/w subsequent prints
    }

    void delete(int position)
    {
//        System.out.println("Deleting at position: " + position);
        DLLNode temp = head;
        int k = 1;
        if (temp == null)
        {
//            System.out.println("List is empty");
            return;
        }

        while (temp.next != null && k < position)
        {
            temp = temp.next;
            k++;
        }
        if (k != position)
        {
//            System.out.println("No such position. Backe ki jaan lega kya?");
        }
        // Positions: Front -> Correct. End -> Correct. Middle -> Correct
        else
        {
            if (k == 1)
            {
                head = temp.next;
                temp = null;
            }
            else
            {
                temp.previous.next = temp.next;
                if (temp.next != null)
                    temp.next.previous = temp.previous.next;
                temp.next = null;
                temp.previous = null;
                temp = null;
            }
            size--;
        }
    }

    private static class DLLNode
    {
        int data;
        DLLNode next;
        DLLNode previous;

        public DLLNode(int data)
        {
            this.data = data;
            this.next = null;
            this.previous = null;
        }
    }
}

public class DoublyLinkedListOperations
{
    public static void main(String[] args)
    {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.insert(10, 2);
        dll.insert(10, 1);
        dll.printList();
        dll.insert(11, 3);
        dll.printList();
        dll.insert(12, 10);
        dll.printList();
        dll.insert(9, 1);
        dll.printList();
        dll.insert(11, 3);
        dll.printList();
        dll.insert(13, 4);
        dll.insert(14, 5);
        dll.insert(12, 4);
        dll.printList();

        dll.delete(10);
        dll.delete(1);
        dll.printList();
        dll.delete(20);
        dll.delete(3);
        dll.printList();
        dll.delete(4);
        dll.printList();
        dll.delete(5);
        dll.printList();
        dll.delete(4);
        dll.printList();
        dll.delete(2);
        dll.delete(1);
        dll.printList();
        dll.delete(1);
        dll.printList();
    }
}
