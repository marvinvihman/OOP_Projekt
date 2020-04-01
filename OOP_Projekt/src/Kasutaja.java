public class Kasutaja {
    private String kasutajanimi;
    private String failitee;

    public Kasutaja() {
    }

    public String getKasutajanimi() {
        return kasutajanimi;
    }

    public void setKasutajanimi(String kasutajanimi) {
        this.kasutajanimi = kasutajanimi;
    }

    public void looKasutajanimi (String eesnimi, String perenimi) {
        if (eesnimi.contains("-")) {
            String [] eesnimed = eesnimi.split("-");
            this.kasutajanimi = eesnimed[0] + perenimi + (int) (Math.random() * 100 + 1);
        }
        else {
            this.kasutajanimi = eesnimi + perenimi + (int) (Math.random() * 100 + 1);
        }
    }


    public String looFailitee (String kasutajanimi) {
        return kasutajanimi + ".txt";
    }
}
