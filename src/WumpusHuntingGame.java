import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.IntStream;

public class WumpusHuntingGame {
    public static int[] rooms = IntStream.range(0, 20).toArray();
    public static int[][] links = { { 1, 7, 4 }, { 0, 9, 2 }, { 1, 11, 3 }, { 2, 13, 4 }, { 3, 0, 5 }, { 4, 14, 6 },
            { 5, 16, 7 }, { 6, 0, 8 }, { 7, 17, 9 }, { 8, 1, 10 }, { 9, 18, 11 }, { 10, 2, 12 }, { 11, 19, 13 },
            { 12, 3, 14 }, { 13, 5, 15 }, { 14, 19, 6 }, { 15, 6, 17 }, { 16, 8, 18 }, { 17, 10, 19 }, { 18, 12, 15 } };

    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random();

    public static int currentRoom;
    public static int wumpusRoom;
    public static int numOfArrows = 5;
    public static Map<Integer, String> roomsDetail = new HashMap<>();
    public static Map<String, String> roomsPreview = new HashMap<>();

    public static String WUMPUS = "wumpus";
    public static String BAT = "bat";
    public static String HOLE = "hole";
    public static String EMPTY = "empty";

    public static Boolean gameOver = false;
    public static Boolean shouldPrintIntro = true;

    public static void main(String[] args) {
        if (shouldPrintIntro) {
            printIntro();
            shouldPrintIntro = false;
        }
        play();
    }

    public static void shootArrow() {
        System.out.println("\n몇번 방에 화살을 쏘시겠습니까?");
        System.out.println(Arrays.toString(links[currentRoom]));
        int chosenNum = scanner.nextInt();
        delay(1000);
        System.out.println("슝~");
        delay(1000);
        if (roomsDetail.get(chosenNum).equals(WUMPUS)) {
            System.out.println("푸슉!");
            delay(1000);
            System.out.println("꾸에에에에에에에엑!");
            delay(1000);
            System.out.println("축하합니다. 당신은 움퍼스를 죽였습니다!");
            gameOver = true;
        } else {
            numOfArrows--;
            System.out.println("(...)\n");
            delay(1000);
            System.out.println("\"화살만 낭비했군.\"");
            if (random.nextInt(4) != 0) {
                System.out.println("당신은 움퍼스를 깨웠습니다.\n움퍼스가 도망갔습니다.");
                roomsDetail.put(wumpusRoom, EMPTY);
                while (true) {
                    int num = random.nextInt(rooms.length);
                    if (roomsDetail.get(num).equals(EMPTY) && num != currentRoom) {
                        roomsDetail.put(num, WUMPUS);
                        break;
                    } else {
                        continue;
                    }
                }
            }
            if (numOfArrows == 0) {
                System.out.println("남은 화살이 없습니다.");
                gameOver = true;
            }
        }
    }

    public static void showConnectedRooms() {
        System.out.println("\n현재 방에 연결된 통로는 다음과 같습니다.");
        System.out.println(Arrays.toString(links[currentRoom]));
    }

    public static void move() {
        System.out.println("\n" + currentRoom + "번 방으로 이동했습니다.\n");
        String result = roomsDetail.get(currentRoom);
        if (result == WUMPUS) {
            delay(1000);
            System.out.println("크아아아아아아아악! 우드득 쩝쩝...");
            delay(1000);
            System.out.println("움퍼스가 당신을 잡아먹었습니다.");
            gameOver = true;
        } else if (result == BAT) {
            delay(1000);
            System.out.println("쿵!");
            delay(1000);
            System.out.println("박쥐가 당신을 잡아 다른 방에 떨어트렸습니다.");
            roomsDetail.put(currentRoom, EMPTY);
            while (true) {
                int num = random.nextInt(rooms.length);
                if (roomsDetail.get(num).equals(EMPTY)) {
                    roomsDetail.put(num, BAT);
                    break;
                } else {
                    continue;
                }
            }
            currentRoom = random.nextInt(rooms.length);
            move();
        } else if (result == HOLE) {
            delay(1000);
            System.out.println("으아아아아아아아아~");
            delay(1000);
            System.out.println("쿵!\n\n당신은 구덩이에 빠졌습니다.\n더 이상 움퍼스를 사냥할 수 없습니다.");
            gameOver = true;
        } else {
            delay(1000);
            System.out.println("(연결되어 있는 통로를 살핀다.)\n");
            delay(1000);
            int[] connectedRooms = links[currentRoom];
            Collections.shuffle(Arrays.asList(connectedRooms));
            for (int room : connectedRooms) {
                String target = roomsDetail.get(room);
                System.out.println(roomsPreview.get(target));
            }
        }
    }

    public static void play() {
        initialize();

        delay(1000);
        System.out.println("...");
        delay(1000);
        System.out.println("...");
        delay(1000);
        System.out.println("동굴에 들어왔습니다...");
        delay(1000);
        System.out.println("\n섬뜩한 곳이군.\n");

        while (true) {
            if (gameOver) {
                break;
            }
            System.out.println("\n당신은 " + currentRoom + "번 방에 있습니다.\n행동을 선택하세요.");
            System.out.println("1. 이동\n2. 화살 쏘기\n3. 통로 목록\n4. 플레이 종료");

            int chosenNum = scanner.nextInt();
            if (chosenNum == 1) {
                System.out.println("\n몇번 방으로 이동하시겠습니까?\n" + Arrays.toString(links[currentRoom]));
                currentRoom = scanner.nextInt();
                move();
                continue;
            } else if (chosenNum == 2) {
                shootArrow();
            } else if (chosenNum == 3) {
                showConnectedRooms();
                continue;
            } else if (chosenNum == 4) {
                System.out.println("게임을 종료합니다.");
                gameOver = true;
                continue;
            } else {
                System.out.println("잘못된 선택입니다.");
                continue;
            }
        }
        System.out.println("\n게임이 끝났습니다. 다시 플레이하시겠습니까?\n(0: 종료, 1: 다시 플레이)");
        int chosenNum = scanner.nextInt();
        if (chosenNum == 0) {
        } else if (chosenNum == 1) {
            System.out.println("게임을 다시 플레이합니다.");
            gameOver = false;
            play();
        } else {
            play();
        }
    }

    public static void initialize() {
        for (int i = 0; i < rooms.length; i++) {
            roomsDetail.put(i, EMPTY);
        }
        currentRoom = random.nextInt(rooms.length);
        String[] eventTargets = { WUMPUS, HOLE, HOLE, BAT, BAT, BAT };
        for (String target : eventTargets) {
            while (true) {
                int num = random.nextInt(rooms.length);
                if (roomsDetail.get(num).equals(EMPTY) && num != currentRoom) {
                    roomsDetail.put(num, target);
                    if (target.equals(WUMPUS)) {
                        wumpusRoom = num;
                    }
                    break;
                } else {
                    continue;
                }
            }

        }
        roomsPreview.put(WUMPUS, "어디선가 끔찍한 냄새가 난다.");
        roomsPreview.put(EMPTY, "저 방에는 아무것도 없는 것 같다.");
        roomsPreview.put(BAT, "어디선가 부스럭거리는 소리가 들린다.");
        roomsPreview.put(HOLE, "바람이 부는 소리가 들리는 것 같다.");
    }

    public static void printIntro() {
        try {
            FileInputStream stream = new FileInputStream("src/intro.txt");
            Scanner sc = new Scanner(stream);
            while (sc.hasNextLine()) {
                System.out.println(sc.nextLine());
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("인트로를 불러올 수 없어 생략하고 진행합니다.");
        }
    }

    public static void delay(int millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
