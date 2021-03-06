import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Päevik {
    private String failitee;

    public Päevik(String failitee) {
        this.failitee = failitee;
    }

    public Päevik() {
    }

    public String getFailitee() {
        return failitee;
    }

    public void setFailitee(String failitee) {
        this.failitee = failitee;
    }

    /**
     * Funktsioon failitee failist faili sisu  kättesaamiseks List kujul.
     *
     * @return List<String> tüüpi listi, kus on faili sisu sees.
     * @throws IOException
     */
    public List<String> failiSisu() throws IOException {
        FileReader lugeja = new FileReader(failitee);
        BufferedReader bufferedReader = new BufferedReader(lugeja);

        Stream<String> sisu = bufferedReader.lines();
        List<String> sisuAr = sisu.collect(Collectors.toList());
        lugeja.close();

        return sisuAr;
    }

    /**
     * Funktsioon kulutuse või tulu sisestamiseks faili.
     *
     * @param summa Kulutus või tulu String kujul, mis kirjutatakse faili.
     * @throws IOException
     */
    public void lisaPäevikusse(String summa) throws IOException {
        FileWriter kirjutaja = new FileWriter(failitee, true);
        BufferedWriter bw = new BufferedWriter(kirjutaja);
        List<String> sisuAr = failiSisu();

        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-yyyy");

        if (sisuAr.contains(date.format(formatter))) {
            bw.write(summa + "\n");
        } else {
            if (sisuAr.isEmpty()) {
                bw.write(date.format(formatter) + "\n");
            } else {
                bw.write("\n" + date.format(formatter) + "\n");
            }
            bw.write(summa + "\n");
        }
        bw.close();
    }

    /**
     * Funktsioon etteantud kuu kokkuvõtte kuvamiseks, kui tolle kuu andmeid on olemas.
     *
     * @param kuupäev "MM-yyyy" kujul etteantud kuupäev.
     * @throws IOException
     */
    public void kuuKokkuvõte(String kuupäev) throws IOException {
        List<Double> kuuKokkuvõte = new ArrayList<Double>();
        List<String> sisuAr = failiSisu();

        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-yyyy");

        //Kui kuupäev on failis olemas, siis toimib, vastasel korral väljastab sõnumi selle kohta.
        if (sisuAr.contains(kuupäev)) {
            int i = sisuAr.indexOf(kuupäev);
            System.out.println("\n" + sisuAr.get(i));
            i++;

            //Kui otsitav kuupäev on hetke kuu.
            if (date.format(formatter).equals(kuupäev)){
                while (sisuAr.size() > i) {
                    try{
                        kuuKokkuvõte.add(Double.parseDouble(sisuAr.get(i)));
                    } catch (NumberFormatException e){
                        break;
                    }
                    System.out.println(sisuAr.get(i));
                    i++;
                }
            }
            //Kui otsitav kuu on muu kuu.
            else {
                //Kuid eraldab tühi rida.
                while (!sisuAr.get(i).equals("")) {
                    try{
                        kuuKokkuvõte.add(Double.parseDouble(sisuAr.get(i)));
                    } catch (NumberFormatException e){
                        break;
                    }
                    System.out.println(sisuAr.get(i));
                    i++;
                }
            }
            System.out.println("Kuu kokkuvõte on " + kuuKokkuvõte.stream().mapToDouble(Double::doubleValue).sum() + " eurot.");
        } else {
            System.out.println("\nEtteantud kuu, \"" + kuupäev + "\", kohta ei leitud failist andmeid.");
        }
    }

    /**
     * Funktsioon hetkel oleva kuu kokkuvõtte väljastamiseks.
     *
     * @throws IOException
     */
    public void hetkeKuuKokkuvõte() throws IOException {
        List<Double> hetkeKuuKokkuvõte = new ArrayList<Double>();
        List<String> sisuAr = failiSisu();

        LocalDate date = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-yyyy");

        for (int i = 0; i < sisuAr.size(); i++) {
            if (sisuAr.get(i).equals(date.format(formatter))) {
                System.out.println("\n" + sisuAr.get(i));
                int j = i;
                while (!sisuAr.get(j + 1).equals("")) {
                    System.out.println(sisuAr.get(j + 1));
                    hetkeKuuKokkuvõte.add(Double.parseDouble(sisuAr.get(j + 1)));
                    if (sisuAr.size() - 1 == j + 1) break;
                    j++;
                }
            }
        }
        System.out.println("Kuu hetkeseis on " + hetkeKuuKokkuvõte.stream().mapToDouble(Double::doubleValue).sum() + " eurot.");
    }
}