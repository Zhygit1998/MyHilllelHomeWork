package lesson_9;

public class Node {
    public String data;
    Node previous;
    Node next;
    public Node(String data) {
        this.data = data;
        this.previous = null;
        this.next = null;
    }

    public String getData() {
        return data;
    }

    public Node getPrevious() {
        return previous;
    }

    public Node getNext() {
        return next;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
