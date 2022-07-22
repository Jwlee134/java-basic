import java.util.Arrays;
import java.util.Scanner;

public class Function {
    public static Scanner scanner = new Scanner(System.in); // 멤버변수(전역변수), 아래의 모든 메소드에서 선언 없이 사용 가능함

    public static void main(String[] args) {
        sayHello();
        sayHelloTo("Jaewon");
        printSum(1, 2);
        System.out.println(returnSum(1, 2));
        System.out.println(Arrays.toString(addAndMultiply(1, 2)));
    }

    public static void sayHello() {
        System.out.println("Hello");
    }

    public static void sayHelloTo(String name) {
        System.out.println("Hello" + name);
    }

    public static void printSum(int a, int b) {
        System.out.println(a + " + " + b + " = " + returnSum(a, b));
    }

    public static int returnSum(int a, int b) {
        return a + b;
    }

    public static int[] addAndMultiply(int a, int b) {
        int[] result = { a + b, a * b };
        return result;
    }
}
