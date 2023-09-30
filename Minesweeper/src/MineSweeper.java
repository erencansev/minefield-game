import java.util.Random;
import java.util.Scanner;
public class MineSweeper {
    Scanner tara = new Scanner(System.in);
    int adetSatir;
    int adetSutun;
    String[][] mineMap;
    String[][] board;
    int sayac = 0;
    int satirNo;
    int sutunNo;
    boolean win;
    boolean durum;
    MineSweeper(int adetSatir, int adetSutun) { // -5- The project was designed within the MineSweeper class
        this.adetSatir = adetSatir;
        this.adetSutun = adetSutun;
        this.mineMap = new String[adetSatir][adetSutun];
        this.board = new String[adetSatir][adetSutun];
        fill(this.board);
        fill(this.mineMap);
    }
    public void randomSayi() {
        Random rdn = new Random();
        this.satirNo = rdn.nextInt(this.adetSatir);

        Random rdn2 = new Random();
        this.sutunNo = rdn2.nextInt(this.adetSutun);
    }
    public String[][] fill(String[][] dizi) {
        for (int i = 0; i < this.adetSatir; i++) {
            for (int j = 0; j < this.adetSutun; j++) {
                dizi[i][j] = "-";
            }
        }
        return dizi;
    }
    public boolean isFind(String[][] arr, String value) {
        if (arr[this.satirNo][sutunNo] == "B") {
            return false;
        }
        return true;
    }
    public void run() { // -6- Relevant methods in the classroom was done
        for (int j = 0; j < this.adetSatir; j++) {
            for (int k = 0; k < this.adetSutun; k++) {
                if (sayac < (this.adetSutun * this.adetSatir / 4)) {
                    randomSayi();  // -8- Appropriate number of random mines placed in the array
                    sayac++;
                    if (isFind(this.board, "B")) {
                        this.mineMap[satirNo][sutunNo] = "B";
                        this.board[satirNo][sutunNo] = "B";
                    } else sayac--;
                }
            }
        }
        printMineMap();
        fill(this.board);
        printBoard();
        koordinatGir();
    }
    private int durumSayac = 0;
    public void koordinatGir() {
        this.durum = true;
        while (this.durum) {
            int sayac = 0;
            this.durumSayac++;
            boolean kontrol = true;
            int satir = 0;
            int sutun = 0;
            while (kontrol) {// -9- The row and column information that the user wanted to mark was received.

                System.out.print("Açmak istediğiniz satırı giriniz : ");
                satir = tara.nextInt();
                System.out.print("Açmak istediğiniz sütunu giriniz : ");
                sutun = tara.nextInt();  // -10- It is checked whether the point selected by the user is within the boundaries of the array,
                //If not, a warning message is given and you are asked to log in again.
                if ((satir < 0 || satir > (this.adetSatir - 1)) || (sutun < 0 || sutun > (this.adetSutun - 1))) {
                    System.out.println("Hatalı sayı girdiniz lütfen tekrar giriniz ");
                    kontrol = true;
                }
                else if (this.board[satir][sutun].equals("-")) {
                    kontrol = false;
                } else {
                    System.out.println("Bu hücreye daha önce tıkladınız. Lütfen başka bir hücre deneyin ! ");
                }
            }
            System.out.println("====================================");

            if (this.mineMap[satir][sutun].equals("B")) { // -13- Control was made so that if the user steps on a mine they will lose the game.
                System.out.println("Oyunu kaybettiniz ! "); // -15- Appropriate messages are displayed to the user if the user loses or wins the game.
                System.out.println("====================================");
                this.durum = false;
                break;
            }
            for (int i = -1; i < 2; i++) { // -11- The playing field updates every time the user makes a move.
                for (int j = -1; j < 2; j++) {
                    if ((satir + i >= 0 && (satir + i) <= (this.adetSatir - 1)) && (sutun + j >= 0 && (sutun + j) <= (this.adetSutun - 1))) {
                        if (this.mineMap[satir + i][sutun + j].equals("B")) {
                            sayac++;
                            this.board[satir][sutun] = String.valueOf(sayac);
                        }
                        if (sayac == 0) {
                            this.board[satir][sutun] = "0"; // -12- If there are no mines at the entered point, the number of mines around it or the value 0 is written instead.
                        }
                    }
                }
            }
            if (this.durumSayac == this.adetSatir * this.adetSutun - (this.adetSutun * this.adetSatir / 4)) {
                this.win = true;// -14- If all points are selected without mines, the game is checked to win.
            }
            if (this.win == true) {
                this.durum = false;// -15- Appropriate messages are displayed to the user if the user loses or wins the game.
                System.out.println("Tebrikler Oyunu Kazandınız !");
            } else durum = true;
            printBoard();

        }

    }
    public void printMineMap() {
        for (int i = 0; i < this.adetSatir; i++) {
            for (int j = 0; j < this.adetSutun; j++) {
                System.out.print(" " + this.mineMap[i][j]);
            }
            System.out.println("");
        }
        System.out.println("====================================");
        System.out.println("Mayın Tarlası Oyununa Hoşgeldiniz !");
        System.out.println("====================================");
    }
    public void printBoard() {
        for (int i = 0; i < this.adetSatir; i++) {
            for (int j = 0; j < this.adetSutun; j++) {
                System.out.print(" " + this.board[i][j]);
            }
            System.out.println("");
        }
        System.out.println("====================================");
    }
    public void MineCheck(int satirNo, int sutunNo) { // -7- matrix size determined by user.
        this.adetSatir = satirNo;
        this.adetSutun = sutunNo;
    }
}