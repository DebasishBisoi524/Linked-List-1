package main;

import node.Node;

public class Main {
    public static void main(String[] args) {
        Node one = new Node(1);
        Node two = new Node(2);
        Node three = new Node(3);
        Node four = new Node(4);
        Node five = new Node(5);
        Node six = new Node(6);
        Node seven = new Node(7);

        Node head = one;
        one.setNext(two);
        two.setNext(three);
        three.setNext(four);
        four.setNext(five);
        five.setNext(six);
        six.setNext(seven);
        seven.setNext(null);

        head = insertAtFront(head, 0);
        head = insertAtEnd(head, 8);
        head = deleteAtFront(head);
        head = deleteFromEnd(head);
        head = insertAtFront(head, 10);
        head = deleteAtFront(head);
        head = insertAtPosition(head, 12, 3);
        head = deleteAtPosition(head, 3);
        head = insertAtEnd(head, 8);
        head = insertAtEnd(head, 9);
        head = insertAtEnd(head, 5);
        head = insertAtEnd(head, 5);
        head = insertAtEnd(head, 5);
        head = insertAtEnd(head, 9);
        head = insertAtEnd(head, 9);
        head = insertAtEnd(head, 2);
        head = insertAtEnd(head, 2);
        head = insertAtEnd(head, 2);
        head = removeDuplicateNode(head);
        head = insertAtMiddle(head, 0);
        head = deleteFromEnd(head);
        head = deleteFromEnd(head);
        printList(head);
    }

    public static void printList(Node head) {
        if (head == null) {
            System.out.println("The Linked List is Empty");
        } else {
            Node current = head;
            int length = 0;
            System.out.print("The Linked List is: ");
            while (current != null) {
                System.out.print(current.getData() + " -> ");
                current = current.getNext();
                length++;
            }
            System.out.print("null.\n");

            System.out.println("The Length of the Linked List is: " + length);
        }
    }

    public static Node insertAtPosition(Node head, int data, int position) {
        Node pos = new Node(data);

        if (head == null || position <= 0) {
            pos.setNext(head);
            return pos;
        } else {
            Node temp = head;
            int currentPosition = 0;
            int addData = pos.getData();
            while (temp.getNext() != null && currentPosition < position - 1) {
                temp = temp.getNext();
                currentPosition++;
            }
            pos.setNext(temp.getNext());
            temp.setNext(pos);
            System.out.println("The Added Node is: " + addData + " and the Position of new node is: " + position);
        }
        return head;
    }

    public static Node insertAtFront(Node head, int data) {
        Node front = new Node(data);
        front.setNext(null);
        if (head == null) {
            head = front;
        } else {
            int addData = front.getData();
            front.setNext(head);
            System.out.println("The Node which is added in the front is: " + addData);
            head = front;
        }
        return head;
    }

    public static Node insertAtEnd(Node head, int data) {
        Node end = new Node(data);
        end.setNext(null);
        if (head == null) {
            System.err.println("The List is Empty");
            return end;
        } else {
            int addData = end.getData();
            Node point = head;
            while (point.getNext() != null) {
                point = point.getNext();
            }
            point.setNext(end);
            System.out.println("The Node which is added in the end is: " + addData);
            return head;
        }
    }

    public static Node insertAtMiddle(Node head, int data) {
        Node mid = new Node(data);
        mid.setNext(null);
        if (head == null) {
            System.out.println("The list is empty. New node becomes the head.");
            return mid;
        }
        if (head.getNext() == null) {
            System.out.println("The list has only one node. Inserting new node after head.");
            mid.setNext(head.getNext());
            head.setNext(mid);
            return head;
        }
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.getNext() != null) {
            slow = slow.getNext();
            fast = fast.getNext().getNext();
        }
        System.out.println("Middle node found with data: " + slow.getData());
        System.out.println("Inserting new node with data: " + data + " after node with data: " + slow.getData());
        mid.setNext(slow.getNext());
        slow.setNext(mid);
        return head;
    }

    public static Node deleteAtPosition(Node head, int position) {
        if (head == null) {
            System.out.println("The List is Empty");
        } else if (position == 0) {
            int deletedData = head.getData();
            head = head.getNext();
            System.out.println("The Deleted Node is: " + deletedData);
        } else {
            Node temp = head;
            int currentPosition = 0;
            while (temp.getNext() != null && currentPosition < position - 1) {
                temp = temp.getNext();
                currentPosition++;
            }
            if (temp.getNext() != null) {
                int deletedData = temp.getNext().getData();
                temp.setNext(temp.getNext().getNext());
                System.out.println(
                        "The Deleted Node is: " + deletedData + " and the Position of that node is: " + position);
            }
        }
        return head;
    }

    public static Node deleteAtFront(Node head) {
        if (head == null) {
            System.out.println("The List is Empty.");
            return null;
        } else {
            int deletedData = head.getData();
            head = head.getNext();
            System.out.println("The Deleted Node from the front is: " + deletedData);
            return head;
        }
    }

    public static Node deleteFromEnd(Node head) {
        if (head == null) {
            System.out.println("The List is Empty.");
            return null;
        } else {
            Node temp = head;
            while (temp.getNext().getNext() != null) {
                temp = temp.getNext();
            }
            int deletedData = temp.getNext().getData();
            temp.setNext(null);
            System.out.println("The Deleted Node from the end is: " + deletedData);
            return head;
        }
    }

    public static Node removeDuplicateNode(Node head) {
        Node curr = head;
        while (curr != null && curr.getNext() != null) {
            if (curr.getData() == curr.getNext().getData()) {
                System.out.println("Removing duplicate node with data: " + curr.getNext().getData());
                curr.setNext(curr.getNext().getNext());
            } else {
                curr = curr.getNext();
            }
        }
        if (head == null || head.getNext() == null) {
            System.out.println("No duplicates found.");
        }
        return head;
    }

}