import java.util.Scanner;

public class IfElse {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("계란의 수를 입력하세요.");
        try {
            String input = sc.nextLine();
            int eggs = Integer.parseInt(input);

            if (eggs < 30) {
                System.out.println("계란판이 필요하지 않습니다.");
                return;
            }
            System.out.println(eggs / 30 + "개의 계란판이 필요합니다.");
        } catch (Exception e) {
            System.out.println("숫자를 입력하세요.");
        }

        try {
            System.out.println("몸무게를 입력하세요.");
            String input1 = sc.nextLine();
            System.out.println("키를 입력하세요.");
            String input2 = sc.nextLine();
            double weight = Double.parseDouble(input1);
            double height = Double.parseDouble(input2) / 100.0;
            double bmi = weight / (height * height);
            if (bmi < 18.5) {
                System.out.println("저체중");
            } else if (bmi >= 23) {
                System.out.println("과체중");
            } else {
                System.out.println("정상");
            }
        } catch (Exception e) {
            System.out.println("숫자를 입력하세요.");
        }

    }
}
