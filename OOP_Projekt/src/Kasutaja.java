public class Kasutaja {
    private String kasutajanimi;

    public Kasutaja(String kasutajanimi) {
        this.kasutajanimi = kasutajanimi;
    }

    public String getKasutajanimi() {
        return kasutajanimi;
    }

    public String looKasutajanimi (String eesnimi, String perenimi) {
        if (eesnimi.contains("-")) {
            String [] eesnimed = eesnimi.split("-");
            String kasutajanimi = eesnimed[0] + perenimi;
        }
        else {
            String kasutajanimi = eesnimi + perenimi;
        }
        return kasutajanimi;
    }

    public String looFailitee (String kasutajanimi) {
        return kasutajanimi + ".txt";
    }
}