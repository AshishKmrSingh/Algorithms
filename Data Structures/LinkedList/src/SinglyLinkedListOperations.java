/** Practice code for Singly Linked List */
class SinglyLinkedList
{
    private Node head;

    private int size;

    void insert(int data, int position)
    {
        Node temp = head;
        Node q = null;
        int k = 1;
        Node newNode = new Node(data);
        if (position == 1)
        {
            newNode.next = head;
            head = newNode;
            size++;
        }
        else
        {
            while (k < position && temp != null)
            {
                q = temp;
                temp = temp.next;
                k++;
            }

            if (k != position)
            {
                System.out.println("No such position " + position + " to insert.");
            }
            else
            {
                size++;
                newNode.next = temp;
                q.next = newNode;
            }
        }
    }

    void delete(int position)
    {
        Node temp = head;
        if (position > size)
        {
            System.out.println("Aukaat se bahaar ho gaya");
        }
        else
        {
            if (position == 1)
            {
                head = temp.next;
                temp.next = null;
                temp = null;
                size--;
            }
            else
            {
                Node q = null;
                int k = 1;

                while (k < position && temp != null)
                {
                    q = temp;
                    temp = temp.next;
                    k++;
                }

                if (k != position)
                {
                    System.out.println("No such position to delete " + position);
                }
                else
                {
                    if (temp != null)
                    {
                        q.next = temp.next;
                        temp.next = null;
                        temp = null;
                    }
                    else
                    {
                        q.next = null;
                    }
                    size--;
                }
            }
        }
    }

    void printList()
    {
        Node temp = head;
        while (temp != null)
        {
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }

        System.out.print("null");
        System.out.println();
    }

    public int getSize()
    {
        return size;
    }

    private static class Node
    {
        int data;
        Node next;

        public Node(int data)
        {
            this.data = data;
        }

        @Override public String toString()
        {
            return "[" + data + " ---> " + next + ']';
        }
    }
}

public class SinglyLinkedListOperations
{
    public static void main(String[] args)
    {
        /** Insert operations */
        // create an empty list
        // output: 14-->10-->15-->11-->13-->null
        SinglyLinkedList list = new SinglyLinkedList();
        list.insert(22, 2);
        list.insert(10, 1);
        list.insert(11, 2);
        list.insert(12, 10);
        list.insert(20, 0);
        list.insert(13, 3);
        list.insert(14, 1);
        list.insert(15, 3);

        list.printList();

        /** Delete operations */

        list.delete(0);
        list.delete(100);
        list.delete(3);
        list.printList();
        list.delete(list.getSize() - 1);
        list.printList();
        list.delete(1);
        list.delete(1);
        list.delete(2);

        list.printList();

    }
}
