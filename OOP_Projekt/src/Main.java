import javax.swing.*;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Kasutaja k1 = new Kasutaja();
        Päevik p1 = new Päevik();
        k1.setPäevik(p1);
        String mes = "Rahapäevik on aktiivne. Valige alt valikust, mida teha soovite.\n" +
                "1 - Kuva käesoleva kuu kokkuvõtet.\n" +
                "2 - Saad valida kuud, millest soovid kokkuvõtet.\n" +
                "3 - Tee päevikusse sissekanne.\n" +
                "4 - Sule rakendus.";

        JOptionPane.showMessageDialog(null, "Tere tulemast Rahapäevikusse!");
        int vastus = JOptionPane.showConfirmDialog(null, "Kas teil on kasutajanimi olemas?");

        if (vastus == 0) {
            String kasutajanimi = JOptionPane.showInputDialog("Sisestage oma kasutajanimi: ");
            k1.setKasutajanimi(kasutajanimi);
        } else if (vastus == 1) {
            String nimi = JOptionPane.showInputDialog("Palun sisestage oma nimi: ");
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
        p1.setFailitee("src/" + failitee);

        java.io.File fail = new java.io.File(k1.getPäevik().getFailitee());
        if (fail.exists()) {
            int uusFail = JOptionPane.showConfirmDialog(null, "Kas soovite luua uue faili?");

            if (uusFail == 0) {
                fail.delete();
                fail.createNewFile();
            } else if (uusFail == 1) {
                String olemasolevKasutajanimi = JOptionPane.showInputDialog("Sisestage oma kasutajanimi: ");
                k1.setKasutajanimi(olemasolevKasutajanimi);
            }

        } else {
            fail.createNewFile();
        }

        while (true) {
            String tegu = JOptionPane.showInputDialog(null, mes);
            if (tegu.equals("1")) {
                p1.hetkeKuuKokkuvõte();
            } else if (tegu.equals("2")) {
                String kuupäev = JOptionPane.showInputDialog(null, "Sisesta kuupäev kujul \"mm-yyyy\".");
                p1.kuuKokkuvõte(kuupäev);
            } else if (tegu.equals("3")) {
                String summa = JOptionPane.showInputDialog(null, "Sisesta tulu või kulu.");
                p1.lisaPäevikusse(summa);
            } else if (tegu.equals("4")) {
                System.exit(0);
            }
        }
    }
}