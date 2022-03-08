package ordination;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;


public class PN extends Ordination {

    private double antalEnheder;

    private LocalDate startDen;
    private LocalDate slutDen;

    public PN(LocalDate startDen, LocalDate slutDen,
              Patient patient, Laegemiddel laegemiddel, double antal) {
        super(startDen, slutDen, patient, laegemiddel);
        this.antalEnheder = antal;
    }

    /**
     * Registrerer at der er givet en dosis paa dagen givesDen
     * Returnerer true hvis givesDen er inden for ordinationens gyldighedsperiode og datoen huskes
     * Retrurner false ellers og datoen givesDen ignoreres
     * @param givesDen
     * @return
     */

    ArrayList<LocalDate> datoer = new ArrayList<>();

    public boolean givDosis(LocalDate givesDen) {
        // TODO
        if ((givesDen.isAfter(startDen) || givesDen.isEqual(startDen)) &&
                (givesDen.isBefore(slutDen) || givesDen.isEqual(slutDen))) {
            datoer.add(givesDen);
            return true;
        }
        return false;   
    }

    @Override
    public double doegnDosis() {
        // TODO
        double doegnDosis = 0;
        double samletEnheder = (datoer.size() * antalEnheder);
        long dageImellem = ChronoUnit.DAYS.between(datoer.get(0), datoer.get(datoer.size() - 1));
        if (!startDen.isEqual(slutDen)) {
            dageImellem += 1;
        } else if(startDen == slutDen) {
            dageImellem = 1;
        }
        doegnDosis = samletEnheder / dageImellem;
        return doegnDosis;
    }

    @Override
    public double samletDosis() {
        // TODO
        double samletDosis = 0.0;
        for (int i = 0; i < datoer.size(); i++) {
            samletDosis += antalEnheder;
        }
        return samletDosis;
    }

    /**
     * Returnerer antal gange ordinationen er anvendt
     * @return
     */
    public int getAntalGangeGivet() {
        // TODO
        return datoer.size();
    }

    public double getAntalEnheder() {
        return antalEnheder;
    }

    @Override
    public String getType() {
        return "pro necesare";
    }

}
