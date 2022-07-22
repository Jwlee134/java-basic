import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class Data {
    public static void main(String[] args) {
        // 과거의 잔재 = 메모리가 부족했던 옛날에만 사용했음, 지금은 사용하지 않음

        // numbers

        byte byteInt = 10; // 1byte, 과거의 잔재
        short shortInt = 20; // 2byte, 과거의 잔재
        int intInt = 30; // 4byte
        long longInt = 30; // 8byte

        float floatNum = 1.2f; // 4byte
        double doubleNum = 1.2; // 8byte

        float floatSum = 0.001f + 0.001f + 0.0001f;
        System.out.println(floatSum); // 0.0021000002, 실수 계산은 정확하게 하지 못함

        // char

        char character = '차'; // 2byte, 과거의 잔재

        // string

        String string1 = "나는";
        String string2 = " 문자열이다.";

        String connectedStr = string1 + string2; // 문자열 연결

        System.out.println(connectedStr); // 나는 문자열이다.
        System.out.println(connectedStr.length()); // 9
        System.out.println(connectedStr.replaceAll("다", " 아니다")); // 나는 문자열이 아니다.
        System.out.println(connectedStr.substring(0, 6)); // 나는 문자열

        // boolean

        boolean trueValue = true;
        boolean question = 5 > 3;

        // wrapper 타입 = String처럼 int나 boolean에도 메소드를 사용 가능할 수 있게 해주는 타입
        // int를 제외하고는 모두 첫 번째 문자를 대문자로 바꾸면 됨

        Integer intNum = 3;
        Long longNum = 3L;
        Float floatNumWrap = 3.0f;
        Double doubleNumWrap = 3.0d;
        Boolean boolValue = true;

        // 배열과 달리 리스트는 length가 정해져 있지 않음

        // 리스트 생성하는 방법 3가지
        List<String> list = new ArrayList<>();
        List<Integer> list2 = new ArrayList<Integer>();
        ArrayList<Integer> list3 = new ArrayList<>();

        // Create
        list.add("1");
        list.add("2");

        // Delete
        list.remove("1");
        list.remove(0);

        list.add("1");

        // Update
        list.set(0, "다");

        // Read
        System.out.println(list.get(0)); // 다

        // Element check
        System.out.println(list.contains("10")); // false

        list.add("나");
        list.add("가");

        // 오름차순 정렬
        Collections.sort(list); // [가, 나, 다]
        // 뒤집기
        Collections.reverse(list); // [다, 나, 가]
        // 셔플
        Collections.shuffle(list);

        System.out.println(list);

        // 배열을 리스트로 변환
        List<String> names = Arrays.asList("이", "재", "원");
        System.out.println(names); // [이, 재, 원]

        // forEach 사용 가능
        for (String el : list) {
            System.out.println(el);
        }

        // Array의 length와 같음
        if (list.size() != 0) {
            System.out.println("비어있지 않음");
        }
        // 이것도 사용 가능
        if (list.isEmpty()) {
            System.out.println("비어있음");
        }

        // 중복을 허용하지 않는 List, 또한 특정 위치의 값을 추가하거나 제거하지 못함
        Set<String> set = new HashSet<>();

        set.add("치킨");
        set.add("치킨");
        set.add("피자");

        System.out.println(set); // [치킨, 피자]

        // Javascript의 Map과 비슷함
        Map<String, String> map = new HashMap<>();

        // key value 쌍 첨가
        map.put("chicken", "닭");
        map.put("pig", "돼지");

        System.out.println(map); // {chicken=닭, pig=돼지}

        // key로 value 가져오기
        System.out.println(map.get("chicken")); // 닭
        System.out.println(map.get("ㅁㄴㅇㄹ")); // null

        // Object.keys()
        System.out.println(map.keySet());
        // Object.values()
        System.out.println(map.values());

        Set<Entry<String, String>> entries = map.entrySet();
        System.out.println(entries);

        for (Entry<String, String> entry : entries) {
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }
    }
}
