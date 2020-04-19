import java.util.Deque;
import java.util.LinkedList;

public class DequeDemo {

    public static void main(String[] args) {
        oldApi();
        System.out.println("============");
        newApi();
    }

    /**
     * 老 api
     */
    private static void oldApi() {
        Deque<String> deque = new LinkedList<String>();
        deque.push("a");
        deque.push("b");
        deque.push("c");
        System.out.println(deque);
        String str = deque.peek();
        System.out.println(str);
        System.out.println(deque);
        while (deque.size() > 0) {
            System.out.println(deque.pop());
        }
        System.out.println(deque);
    }

    /**
     * 用新 Api 对 老 Api 进行改写
     */
    private static void newApi() {
        Deque<String> deque = new LinkedList<String>();
        deque.addFirst("a");
        deque.addFirst("b");
        deque.addFirst("c");
        System.out.println(deque);
        String str = deque.getFirst();
        System.out.println(str);
        System.out.println(deque);
        while (deque.size() > 0) {
            System.out.println(deque.removeFirst());
        }
        System.out.println(deque);
    }

}