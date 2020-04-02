public class Kasutaja {
    private String kasutajanimi;
    private Päevik päevik;

    public Kasutaja() {
    }

    public String getKasutajanimi() {
        return kasutajanimi;
    }

    public void setKasutajanimi(String kasutajanimi) {
        this.kasutajanimi = kasutajanimi;
    }

    public Päevik getPäevik() {
        return päevik;
    }

    public void setPäevik(Päevik päevik) {
        this.päevik = päevik;
    }

    /**
     * Kasutatakse kasutajanime loomiseks eesnime ja perenime järgi.
     * Kasutajanimeks saab eesnimi ja perekonnanimi ilma tühikuta ja sellele lisatakse suvaline number vahemikust 1-100
     * @param eesnimi kasutaja sisestatud eesnimi.
     * @param perenimi kasutaja sisestatud perenimi.
     */
    public void looKasutajanimi(String eesnimi, String perenimi) {
        if (eesnimi.contains("-")) {
            String[] eesnimed = eesnimi.split("-");
            this.kasutajanimi = eesnimed[0] + perenimi + (int) (Math.random() * 100 + 1);
        } else {
            this.kasutajanimi = eesnimi + perenimi + (int) (Math.random() * 100 + 1);
        }
    }

    /**
     * Luuakse failitee kasutajanimega ning tekstifaili formaadi lõpuga.
     * @param kasutajanimi antakse ette kasutaja kasutajanimi.
     * @return tagastab failitee.
     */
    public String looFailitee(String kasutajanimi) {
        return kasutajanimi + ".txt";
    }
}