import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        System.out.println("Tere tulemast Rahapäevikusse! ");
        System.out.println("Palun sisestage oma nimi: ");

        Scanner scanner = new Scanner(System. in);
        String nimi = scanner. nextLine();
        String[] eraldi = nimi.split(" ");
        String eesnimi = eraldi[0];
        String perenimi = eraldi[1];

        String kasutajanimi = looKasutajanimi(eesnimi, perenimi);
        String failitee = looFailitee(kasutajanimi);

        java.io.File fail = new java.io.File(failitee);
        if (fail.exists()){
            System.out.println("Kas soovite luua uue faili?");
            Scanner scanner1 = new Scanner(System. in);
            String otsus = scanner. nextLine();
            if (otsus.toUpperCase() == "JAH"){
                fail.createNewFile();
            }
        }

        else {
            fail.createNewFile();
        }
    }
}
