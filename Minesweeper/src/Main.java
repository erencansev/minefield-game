import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner Search = new Scanner(System.in);

        boolean repeatGame = true;

        while (repeatGame) {
            System.out.println("====================================");
            System.out.println("Oyunu başlatmak için oynamak istediğiniz ölçüleri girmelisiniz");
            System.out.print("Lütfen satır sayısını giriniz: ");
            int a = Search.nextInt();
            System.out.print("Lütfen sütun sayısını giriniz: ");
            int b = Search.nextInt();
            System.out.println("============ Mayın Konum ===========");


            MineSweeper mayin = new MineSweeper(a, b);
            mayin.run();
            System.out.println("Oyunu tekrar oynamak istiyor musunuz? (E/H): ");
            String cevap = Search.next();
            if (cevap.equalsIgnoreCase("H")) {
                repeatGame = false;
            }
        }
    }
}
