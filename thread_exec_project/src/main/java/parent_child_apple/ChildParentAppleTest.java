package parent_child_apple;

/**
 * Created by User on 25.06.2017.
 */
public class ChildParentAppleTest {
    public static void main(String[] args) {
        GlobalStorage globalStorage = new GlobalStorage();
        new ParentThread(globalStorage).start();
        new ChildThread(globalStorage).start();
    }
}
