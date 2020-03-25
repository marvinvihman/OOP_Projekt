import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Kasutaja k1 = new Kasutaja();

        System.out.println("Tere tulemast Rahapäevikusse! ");
        System.out.println("Palun sisestage oma nimi: ");

        Scanner scanner = new Scanner(System. in);
        String nimi = scanner. nextLine();
        String[] eraldi = nimi.split(" ");
        String eesnimi = eraldi[0];
        String perenimi = eraldi[1];

        String kasutajanimi = k1.getKasutajanimi();
        String failitee = k1.looFailitee(kasutajanimi);

        java.io.File fail = new java.io.File(failitee);
        if (fail.exists()){
            System.out.println("Kas soovite luua uue faili?");
            Scanner scanner1 = new Scanner(System. in);
            String otsus = scanner. nextLine();
            if (otsus.toUpperCase() == "JAH"){
                fail.createNewFile();
            }
            else {
                System.out.println("Sisestage oma kasutajanimi: ");
                Scanner scanner2 = new Scanner(System. in);
                String olemasolevKasutajanimi = scanner. nextLine();
                k1.setKasutajanimi(olemasolevKasutajanimi);
            }
        }

        else {
            fail.createNewFile();
        }
    }
}