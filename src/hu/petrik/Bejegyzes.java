package hu.petrik;

import java.time.LocalDateTime;

public class Bejegyzes {
    private String szerzo;
    private String tartalom;
    private int likeok;
    private LocalDateTime letrejott;
    private LocalDateTime szerkesztve;

    public Bejegyzes(String szerzo, String tartalom) {
        this.szerzo = szerzo;
        this.tartalom = tartalom;
        this.likeok = 0;
        this.letrejott = LocalDateTime.now();
        this.szerkesztve = letrejott;
    }

    public void like(){
        this.likeok ++;
    }

    public String getSzerzo() {
        return szerzo;
    }

    public String getTartalom() {
        return tartalom;
    }

    public void setTartalom(String tartalom) {
        this.tartalom = tartalom;
        this.szerkesztve = LocalDateTime.now();
    }

    public int getLikeok() {
        return likeok;
    }

    public LocalDateTime getLetrejott() {
        return letrejott;
    }

    public LocalDateTime getSzerkesztve() {
        return szerkesztve;
    }

    @Override
    public String toString() {
        String szerkesztveString = "";
        if (szerkesztve.toLocalTime() != letrejott.toLocalTime()) {
            szerkesztveString = "Szerkesztve: " + szerkesztve + "\n";
        }
        return szerzo + " - " + likeok + " - " + letrejott + "\n" +
                szerkesztveString +
                tartalom;
    }
}
