public class StaticCounter {

    private static int count = 0;

    public static int getCount() {
        return count;
    }

    public static void addStaticCounter() {
        count++;
    }

    StaticCounter() {
        count++;
        System.out.println("Current count: " + count);
    }

    public static void main(String[] args) {
        System.out.println("Start: " + count);
        for (int i = 0; i < 3; i++) {
            new StaticCounter();
        }
        System.out.println("End: " + count);
    }
}
