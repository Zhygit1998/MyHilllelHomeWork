package lesson_9;

import java.util.Collection;

public class MyCollection implements MyCustomCollection {

    Node first;
    Node last;
    private int count;
    @Override
    public void print(Node node) {
        Node last = null;
        while (node != null) {
            System.out.print(node.data + ", ");
            last = node;
            node = node.next;
        }
        System.out.println();
    }

    @Override
    public boolean add(String nd) {
        Node new_Node = new Node(nd);
        new_Node.next = first;
        new_Node.previous = null;
        if (first != null) {
            first.previous = new_Node;
        }
        first = new_Node;
        return true;
    }

    @Override
    public boolean addAll(String[] strArr) {
        if (strArr.length != 0) {
            for (String s : strArr) {
                add(s);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean addAll(MyCollection strColl) {
        if (strColl.size() != 0) {
            for (int i = 0; i < strColl.size(); i++) {
                add(strColl.get(i));
            }
            return true;
        }
        return false;
    }
    @Override
    public boolean delete(int index) {
        if (size() > 0) {
            Node given;
            given = first;
            for (int i = 0; i < size(); i++) {
                if (i==index){
                    given.previous.next = given.next;
                    given.next.previous = given.previous;
                }
                given = given.getNext();
            }
        }
        return true;
    }

    @Override
    public boolean delete(String element) {
        Node given = first;
        for (int i = 0; i < size(); i++) {
            given = given.next;
            if (given.data.equals(element)) {
                given.previous.next = given.next;
                given.next.previous = given.previous;
            }
        }
        return true;
    }

    @Override
    public String get(int index) {
            Node given = first;
            for (int i = 0; i < index; i++) {
                given = given.getNext();
            }
            return given.getData();
    }

    @Override
    public boolean contains(String str) {
        if (size() != 0) {
            Node given = first;
            for (int i = 0; i < size(); i++) {
                if (given.getData().equals(str)) {
                    return true;
                }
                given = given.getNext();
            }
        }
        return false;
    }

    @Override
    public boolean clear() {
        if (size() != 0) {
            for (Node node = first; node != null; ) {
                Node next = node.getNext();
                node.setNext(null);
                node.setPrevious(null);
                node = next;
            }
            first = last = null;
            count = 0;
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        Node node = first;
        int result = 0;
       while (node != null) {
            result++;
           node = node.next;
        }
        return result;
    }

    @Override
    public boolean trim() {
        if (size() > 0) {
            Node given;
            given = first;
            for (int i = 1; i < size(); i++) {
                if (given.data == null){
                    given.previous.next = given.next;
                    given.next.previous = given.previous;
                }
                given = given.getNext();
            }
        }
        return true;
    }

    @Override
    public boolean compare(MyCollection coll) {
        if (this.size() != coll.size() || this.size() == 0 || coll.size() == 0) {
            return false;
        }
        for (int i = 0; i < size(); i++) {
            if (!this.get(i).equals(coll.get(i))) {
                return false;
            }
        }
        return true;
    }
}
