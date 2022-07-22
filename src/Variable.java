public class Variable {
    public static void main(String[] args) {
        int number = 1;
        number = 10; // 변수 재할당 가능
        number = (int) 1.2; // double -> int 형변환

        System.out.println(number);

        int ratio = 15;
        System.out.println(100 * ratio / 100.0); // .0을 쓰는 이유: 정수끼리 나누면 나머지는 다 버림 따라서 15 / 100 = 0.15가 아니라 0이 됨
                                                 // (정수 / 실수 = 실수)
    }
}
