public class Main {
    public static void main(String[] args) {
        MyLinkedList<String> list = new MyLinkedList<>();
        list.addLast("pew");
        list.addLast("wob");
        list.addLast("shit");
        System.out.println(list.getFirst());
        System.out.println(list.getLast());
    }
}