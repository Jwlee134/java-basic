import java.util.Arrays;

public class Array {
    public static void main(String[] args) {
        String[] days = { "월", "화", "수", "목", "금", "토", "일" };

        for (String day : days) {
            System.out.println(day);
        } // forEach

        String[] days2 = Arrays.copyOf(days, 8); // java 배열은 생성할 때 length가 고정되므로 요소 추가 시 새로운 배열 생성해야 함
        days2[7] = "일";
        for (String day : days2) {
            System.out.println(day);
        }

        System.out.println(Arrays.toString(days2)); // 배열 출력

        String[][] nestedDays = { { "월", "화", "수", "목", "금", "토", "일" }, { "월", "화", "수", "목", "금", "토", "일" } };
    }
}
