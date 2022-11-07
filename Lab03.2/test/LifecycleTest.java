import org.junit.*;

public class LifecycleTest {

    @Before
    public void beforeTest() {
        System.out.println("beforeTest");
    }

    @After
    public void afterTest() {
        System.out.println("afterTest");
    }

    @BeforeClass
    public static void beforeTestRun() {
        System.out.println("beforeTestRun");
    }

    @AfterClass
    public static void afterTestRun() {
        System.out.println("afterTestRun");
    }

    @Test
    public void test1() {
        System.out.println("test1");
    }

    @Test
    public void test2() {
        System.out.println("test2");
    }
}
