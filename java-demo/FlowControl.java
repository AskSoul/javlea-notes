import java.util.Scanner;

public class FlowControl {
    public static void main(String[] args) {
        // 判断1-100偶数和
        sumEven();

        // 水仙花数：一个三位数，它每一位数字的立方和 = 它本身
        printNarcissisticNumbers();

        // 九九乘法表
        printMultiTable();

        // 输入月份判断季节
        getSeason();
    }

    public static void sumEven(){
        int sum = 0;
        for (int i = 1; i <= 100; i ++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        System.out.println("1-100偶数和：" + sum);
    }

    public static void printNarcissisticNumbers(){
        int ge = 0,shi = 0,bai = 0;
        int cubeSum = 0;
        System.out.print("水仙花数：");
        for(int i = 100; i <= 999; i++) {
            ge = i%10;
            shi = i%100/10;
            bai = i/100;
            cubeSum = ge * ge * ge + shi * shi * shi +  bai * bai * bai;
            if (cubeSum == i){
                System.out.print(cubeSum + " ");
            }
        }
        System.out.println();
    }

    public static void printMultiTable(){
        for(int i = 1; i <= 9; i++){
            for(int j = 1; j <= i; j++){
                System.out.print(j + "*" + i + "=" + j * i + "\t");
            }
            System.out.println();
        }
    }

    public static void getSeason(){
        Scanner input = new Scanner(System.in);
        System.out.print("请输入月份：");
        int n = input.nextInt();
        String season = "";
        boolean flag = true;
        switch (n){
            case 3:
            case 4:
            case 5:
                season = "春";
                break;
            case 6:
            case 7:
            case 8:
                season = "夏";
                break;
            case 9:
            case 10:
            case 11:
                season = "秋";
                break;
            case 12:
            case 1:
            case 2:
                season = "冬";
                break;
            default:
                flag = false;
                System.out.println("无效月份！请输入有效月份。");
        }
        if(flag){
            System.out.println("当前季节是：" + season);
        }
        input.close();
    }
}
