/* Circular Linked List has a loop. Even if there is a single element in the Circular linked list,
 * its next points to itself and is never null. */
class CircularLinkedList
{
    CLLNode head;
    int size;

    void insert(int data, int position)
    {
        CLLNode temp = head;
        CLLNode q = head;
        /* create new Node for insertion */
        CLLNode newNode = new CLLNode(data);
        newNode.next = newNode;
        int k = 1;
        if (position < 1)
        {
            System.out.println("Negative postion is not allowed");
        }
        if (temp == null && position > 1)
        {
            System.out.println("Cannot insert " + data);
        }
        else if (temp == null && position == 1)
        {
            head = newNode;
        }
        /*if (temp != null && position == 1)
        {
            newNode.next = temp;
            head = newNode;
        }*/
        else
        {
            while (k < position && temp.next != head)
            {
                q = temp;
                temp = temp.next;
                k++;
            }
            if (k != position && k != position - 1)
            {
                System.out.println("No such position to insert");
            }
            else
            {
                newNode.next = temp.next == head ? head : temp.next;
                temp.next = newNode;
                if (k == position)
                    head = newNode;
            }
        }

    }

    void delete(int position)
    {

    }

    void printList()
    {
        CLLNode temp = head;
        if (temp == null)
            System.out.println("Empty List");
        else
        {
            while (temp.next != head)
            {
                System.out.print(temp.data + "----->");
                temp = temp.next;
            }
            System.out.print(temp.data + "<------>");
            System.out.print(temp.next.data);
            System.out.println();
        }
    }

    static private class CLLNode
    {
        int data;
        CLLNode next;

        public CLLNode(int data)
        {
            this.data = data;
        }
    }
}

public class CircularLinkedListOperations
{
    public static void main(String[] args)
    {
        CircularLinkedList cll = new CircularLinkedList();
        cll.insert(10, 2);
        cll.insert(10, 1);
        cll.printList();
        cll.insert(11, 2);
        cll.printList();
        cll.insert(12, 3);
        cll.printList();
        cll.insert(13, 4);
        cll.printList();
        cll.insert(14, 2);
        cll.printList();
    }
}
