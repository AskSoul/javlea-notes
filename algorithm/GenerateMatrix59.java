import java.util.Scanner;

public class GenerateMatrix59 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("打印n×n顺时针螺旋排列的矩阵，请输入n的值：");
        int n = sc.nextInt();
        int[][] matrix = generateMatrix(n);
        int[][] matrix2 = generateMatrix2(n);
        System.out.println("Test1:");
        printMatrix(matrix, n);
        System.out.println("Test2:");
        printMatrix(matrix2, n);
    }

    public static int[][] generateMatrix(int n) {
        int endNum = n * n;
        int curNum = 1;
        int row = 0, col = 0;
        int[][] matrix = new int[n][n];
        int[][] directions = {{0, 1},{1, 0},{0, -1},{-1, 0}};
        int directionIndex = 0;
        while(curNum <= endNum) {
            matrix[row][col] = curNum;
            curNum++;
            int nextRow = row + directions[directionIndex][0];
            int nextCol = col + directions[directionIndex][1];
            if(nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n || matrix[nextRow][nextCol] != 0) {
                directionIndex = (directionIndex + 1) % 4;
            }
            row += directions[directionIndex][0];
            col += directions[directionIndex][1];
        }
        return matrix;
    }

    public static int[][] generateMatrix2(int n) {
        int[][] matrix = new int[n][n];
        int left = 0, right = n - 1;
        int top = 0, bottom = n - 1;
        int row = 0, col = 0;
        int counter = 1;
        int loop = 1;
        while (loop <= n / 2) {
            // 顶端 从左到右
            for (int i = left; i < right; i++) {
                matrix[row][col++] = counter++;
            }
            // 右侧 从上到下
            for (int i = top; i < bottom; i++) {
                matrix[row++][col] = counter++;
            }
            // 底端 从右到左
            for (int i = right; i > left; i--) {
                matrix[row][col--] = counter++;
            }
            // 左侧 从下到上
            for (int i = bottom; i > top; i--) {
                matrix[row--][col] = counter++;
            }
            top++;
            bottom--;
            left++;
            right--;
            row = top;
            col = left;
            loop++;
        }
        if(n % 2 == 1) {
            matrix[row][col] = counter;
        }
        return matrix;
    }

    public static void printMatrix(int[][] matrix, int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(matrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
