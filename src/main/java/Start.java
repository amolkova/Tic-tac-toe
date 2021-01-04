import java.util.Random;
import java.util.Scanner;

public class Start {
    
    public static final int SIZE = 3;
    public static final int DOTS_TO_WIN = 3;
    public static final char DOT_EMPTY = '�';
    public static final char DOT_X = 'X';
    public static final char DOT_O = 'O';
    public static char[][] map;
    public static Scanner sc = new Scanner(System.in);
    public static Random rand = new Random();
    
    public static void main(String[] args) {
        initMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("������� �������");
                break;
            }
            if (isMapFull()) {
                System.out.println("�����");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("������� ������������ ���������");
                break;
            }
            if (isMapFull()) {
                System.out.println("�����");
                break;
            }
        }
        System.out.println("���� ���������");
    }
    
    public static void setMapTest(char[][] mapMock) {
        map = mapMock;
    }
    
    public static boolean checkWin(char symb) {
        
        if (isHorizontWin(symb)) {
            return true;
        }
        
        if (isVerticalWin(symb)) {
            return true;
        }
        
        if (isDiagonalOneWin(symb)) {
            return true;
        }
        
        if (isDiagonalTwoWin(symb)) {
            return true;
        }
        
        return false;
    }
    
    private static boolean isHorizontWin(char symb) {
        for (int i = 0; i < SIZE; i++) {
            int count = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == symb) {
                    count++;
                }
                if (count == SIZE) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private static boolean isVerticalWin(char symb) {
        for (int i = 0; i < SIZE; i++) {
            int count = 0;
            for (int j = 0; j < SIZE; j++) {
                if (map[j][i] == symb) {
                    count++;
                }
                if (count == SIZE) {
                    return true;
                }
            }
        }
        return false;
        
    }
    
    private static boolean isDiagonalOneWin(char symb) {
        int count = 0;
        for (int i = 0; i < SIZE; i++) {
            if (map[i][i] == symb) {
                count++;
            }
            if (count == SIZE) {
                return true;
            }
        }
        return false;
    }
    
    private static boolean isDiagonalTwoWin(char symb) {
        int count = 0;
        int j = SIZE - 1;
        for (int i = 0; i < SIZE; i++) {
            if (map[i][j] == symb) {
                count++;
            }
            if (count == SIZE) {
                return true;
            }
            j--;
        }
        return false;
    }
    
    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY)
                    return false;
            }
        }
        return true;
    }
    
    public static void aiTurn() {
        int x, y;
        do {
            x = rand.nextInt(SIZE);
            y = rand.nextInt(SIZE);
        } while (!isCellValid(x, y));
        System.out.println("��������� ������� � ����� " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    }
    
    public static void humanTurn() {
        int x, y;
        do {
            System.out.println("������� ���������� � ������� X Y");
            x = sc.nextInt() - 1;
            y = sc.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }
    
    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE)
            return false;
        if (map[y][x] == DOT_EMPTY)
            return true;
        return false;
    }
    
    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }
    
    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
}
