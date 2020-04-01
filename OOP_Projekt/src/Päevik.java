import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Päevik {
    private String failitee;

    public Päevik(String failitee) {
        this.failitee = failitee;
    }

    public Päevik() {
        this.failitee = failitee;
    }

    public String getFailitee() {
        return failitee;
    }

    public void setFailitee(String failitee) {
        this.failitee = failitee;
    }

    public void lisaPäevikusse(){

    }

    public void hetkeKuuKokkuvõte(){

        List<Double> hetkeKuuKokkuvõte = new ArrayList<Double>();

        try {
            FileReader lugeja = new FileReader(failitee);
            BufferedReader bufferedReader = new BufferedReader(lugeja);

            LocalDate date = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-yyyy");

            Stream<String> sisu = bufferedReader.lines();
            List<String> sisuAr = sisu.collect(Collectors.toList());
            lugeja.close();

            for (int i = 0; i < sisuAr.size(); i++) {
                if (sisuAr.get(i).equals(date.format(formatter))){
                    System.out.println("\n" + sisuAr.get(i));
                    int j = i;
                    while (!sisuAr.get(j+1).equals("")){
                        System.out.println(sisuAr.get(j+1));
                        hetkeKuuKokkuvõte.add(Double.parseDouble(sisuAr.get(j+1)));
                        if(sisuAr.size()-1 == j+1) break;
                        j++;
                    }
                }
            }

            System.out.println("Kuu hetkeseis on " + hetkeKuuKokkuvõte.stream().mapToDouble(Double::doubleValue).sum() + " eurot.");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
