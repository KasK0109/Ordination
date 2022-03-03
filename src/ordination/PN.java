package ordination;

import java.time.LocalDate;
import java.util.ArrayList;


public abstract class PN extends Ordination {

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

    public double doegnDosis() {
        // TODO
        return 0.0;
    }


    public double samletDosis() {
        // TODO
        return 0.0;
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

}
