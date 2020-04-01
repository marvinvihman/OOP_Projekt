import javax.swing.*;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Kasutaja k1 = new Kasutaja();
        Päevik p1 = new Päevik();

        JOptionPane.showMessageDialog(null, "Tere tulemast Rahapäevikusse!");
        int vastus = JOptionPane.showConfirmDialog(null, "Kas teil on kasutajanimi olemas?");

        if (vastus == 0) {
            System.out.println("Sisestage oma kasutajanimi: ");
            Scanner sc2 = new Scanner(System.in);
            k1.setKasutajanimi(sc2.nextLine());
        } else if (vastus == 1) {
            System.out.println("Palun sisestage oma nimi: ");

            Scanner scanner = new Scanner(System.in);
            String nimi = scanner.nextLine();
            String[] eraldi = nimi.split(" ");
            String eesnimi = eraldi[0];
            String perenimi = eraldi[1];

            k1.looKasutajanimi(eesnimi, perenimi);

            System.out.println("Kasutajanimi on: " + k1.getKasutajanimi());
        } else {
            System.exit(0);
        }

        String kasutajanimi = k1.getKasutajanimi();
        String failitee = k1.looFailitee(kasutajanimi);

        java.io.File fail = new java.io.File("src/" + failitee);
        if (fail.exists()) {
            System.out.println("Kas soovite luua uue faili?");
            Scanner scanner1 = new Scanner(System.in);
            String otsus = scanner1.nextLine();
            if (otsus.toUpperCase().equals("JAH")) {
                fail.createNewFile();
            } else {
                System.out.println("Sisestage oma kasutajanimi: ");
                Scanner scanner2 = new Scanner(System.in);
                String olemasolevKasutajanimi = scanner2.nextLine();
                k1.setKasutajanimi(olemasolevKasutajanimi);
            }
        } else {
            fail.createNewFile();
        }

        p1.setFailitee("src/" + failitee);
        p1.hetkeKuuKokkuvõte();
        //p1.lisaPäevikusse("920");
        //p1.hetkeKuuKokkuvõte();
        p1.kuuKokkuvõte("02-2020");

    }
}