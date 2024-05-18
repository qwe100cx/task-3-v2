package reverse;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Stack;

class Node {
    String data;
    Node next;

    public Node(String data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;
    private Node tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void addNode(String data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void reverseList() {
        Stack<Node> stack = new Stack<>();
        Node current = head;

        while (current != null) {
            stack.push(current);
            current = current.next;
        }

        head = stack.pop();
        current = head;

        while (!stack.isEmpty()) {
            current.next = stack.pop();
            current = current.next;
        }

        current.next = null;
        tail = current;
    }

    public void clearList() {
        head = null;
        tail = null;
    }

    public void generateRandomList(int size) {
        clearList();
        Random random = new Random();

        for (int i = 0; i < size; i++) {
            addNode(String.valueOf(random.nextInt(100)));
        }
    }

    public void readListFromFile(String filename) {
        clearList();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                addNode(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getListAsString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;

        while (current != null) {
            sb.append(current.data).append(" ");
            current = current.next;
        }

        return sb.toString();
    }
}