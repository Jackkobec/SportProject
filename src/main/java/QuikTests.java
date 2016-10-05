import java.io.File;

/**
 * QuikTests
 */
public class QuikTests {
    public static void main(String[] args) {
        File[] froots = File.listRoots();
        for (int i = 0; i <froots.length ; i++) {
            System.out.println(froots[i].getPath());
        }
    }
}
