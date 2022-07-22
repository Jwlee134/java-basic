import java.util.Random;
import java.util.Scanner;

public class RandomNumGame {
    public static String input;
    public static int randomNumber;
    public static int parsedInput;
    public static int chance = 10;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        randomNumber = random.nextInt(21); // bound: 정수 범위

        System.out.println("0부터 20까지의 숫자를 입력하세요.");

        while (chance >= 0) {
            input = sc.nextLine();

            if (!isInputValid()) {
                continue;
            }
            if (isCorrect() || noMoreChance()) {
                break;
            } else {
                play();
            }

        }
        sc.close();
    }

    public static boolean isCorrect() {
        if (randomNumber == parsedInput) {
            System.out.println("성공! 게임을 종료합니다.");
            chance = 10;
            return true;
        }
        return false;
    }

    public static boolean noMoreChance() {
        if (parsedInput != randomNumber && chance == 1) {
            System.out.println("게임 실패!");
            return true;
        }
        return false;
    }

    public static boolean isInputValid() {
        try {
            parsedInput = Integer.parseInt(input);
            return true;
        } catch (Exception e) {
            System.out.println("숫자를 입력하세요.");
            return false;
        }
    }

    public static void play() {
        chance--;
        if (parsedInput > randomNumber) {
            System.out.println("Down! " + chance + "번의 기회 남음.");
        }
        if (parsedInput < randomNumber) {
            System.out.println("Up! " + chance + "번의 기회 남음.");
        }
    }

}
