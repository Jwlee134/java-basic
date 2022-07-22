import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileOutput {
    public static void main(String[] args) {
        FileWriter writer = null;
        Scanner sc = new Scanner(System.in);
        try {
            writer = new FileWriter("src/output.txt", true);
        } catch (IOException e) {
            System.out.println("파일 생성에 실패했습니다.");
            System.exit(1);
        }

        System.out.println("입력을 마치려면 엔터를 누르세요.");
        while (true) {
            String input = sc.nextLine();
            if (input.equals("")) {
                System.out.println("입력을 종료합니다.");
                break;
            }
            try {
                writer.write(input + "\n");
            } catch (IOException e) {
                System.out.println("파일에 데이터를 쓰는 데 실패했습니다.");
                System.exit(2);
            }
        }
        try {
            writer.close();
        } catch (IOException e) {
            System.out.println("파일을 닫는 데 실패했습니다.");
            System.exit(2);
        }

    }
}
