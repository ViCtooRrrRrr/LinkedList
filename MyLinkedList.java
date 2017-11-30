public class MyLinkedList<E> {

    private Node<E> firstNode;
    private Node<E> lastNode;
    private boolean isFirstInit = true;

    public void addLast(E obj) {
        if (isFirstInit) {
            firstInit(obj);
            return;
        }
        Node<E> newLastNode = new Node<>();
        newLastNode.obj = obj;
        newLastNode.previous = this.lastNode;
        this.lastNode.next = newLastNode;
        this.lastNode = newLastNode;
    }

    public void addFirst(E obj) {
        if (isFirstInit) {
            firstInit(obj);
            return;
        }
        Node<E> newFirstNode = new Node<>();
        newFirstNode.obj = obj;
        newFirstNode.next = this.firstNode;
        this.firstNode.previous = newFirstNode;
        this.firstNode = newFirstNode;
    }

    public E removeFirst() {
        if(this.firstNode == null) return null;
        Node<E> node = this.firstNode;
        if(this.lastNode == this.firstNode){
            this.lastNode = this.firstNode = null;
            isFirstInit = true;
        }
        this.firstNode = this.firstNode.next;
        this.firstNode.previous = null;
        return node.obj;
    }

    public E removeLast() {
        if(this.lastNode == null) return null;
        Node<E> node = this.lastNode;
        if(this.lastNode == this.firstNode){
            this.lastNode = this.firstNode = null;
            isFirstInit = true;
        }
        this.lastNode = this.lastNode.previous;
        this.lastNode.next = null;
        return node.obj;
    }

    public E getFirst(){
        return this.firstNode.obj;
    }

    public E getLast(){
        return this.lastNode.obj;
    }

    private void firstInit(E obj) {
        firstNode = lastNode = new Node<>();
        lastNode.obj = obj; //апдейтим сразу оба из-за предыдущей строки, ибо там обе переменные хранят ссылку на один и тот же объект
        isFirstInit = false;
    }

    private class Node<E> {
        public Node next;
        public Node previous;
        public E obj;
    }
}