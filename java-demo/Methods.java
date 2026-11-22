public class Methods {
    public static void main(String[] args) {
        // 三max重载
        check("case1", max(1, 7) == 7);
        check("case2",max(11, 22, 2026) == 2026);
        check("case3", max(15.26, 9.45) == 15.26);
        System.out.println();

        // 打印2-100的全部质数
        System.out.print("2-100的全部质数：");
        for (int i = 2; i <=100 ; i++) {
            if(isPrime(i))
                System.out.print(i + " ");
        }
        System.out.println();
        System.out.println();

        // 数组打印
        printArray(new int[]{1, 3, 5, 7, 9});
        printArray(new int[]{7, 6, 8, 1});
        printArray(new int[]{6});
        printArray(new int[]{});
    }

    public static int max(int a, int b){
        if(a>b){
            return a;
        } else {
            return b;
        }
    }

    public static int max(int a, int b, int c){
        if(a>=b && a>=c){
            return a;
        }  else if(b>=a && b>=c){
            return b;
        } else {
            return c;
        }
    }

    public static double max(double a, double b){
        if(a>b){
            return a;
        }  else {
            return b;
        }
    }

    public static boolean isPrime(int n){
        for (int i = 2; i*i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void printArray(int[] arr) {
        String str = "";
        for(int num : arr) {
            str += num + ", ";
        }
        String actualStr =  arr.length > 0 ? "[" + str.substring(0, str.length() - 2) + "]" : "[]";
        System.out.println(actualStr);
    }

    public static void check(String name, boolean expression) {
        if (expression){
            System.out.println(name + ":" + "pass");
        } else System.out.println(name + ":" + "fail");
    }
}
