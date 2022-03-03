package ordination;

import java.time.LocalDate;

public abstract class PN extends Ordination {

    private double antalEnheder;

    private LocalDate startDen;
    private LocalDate slutDen;
    Patient patient;
    Laegemiddel laegemiddel;

    public PN(LocalDate startDen, LocalDate slutDen,
              Patient patient, Laegemiddel laegemiddel, double antal) {
        super(startDen, slutDen);
        this.patient = patient;
        this.laegemiddel = laegemiddel;
        this.antalEnheder = antal;
    }

    /**
     * Registrerer at der er givet en dosis paa dagen givesDen
     * Returnerer true hvis givesDen er inden for ordinationens gyldighedsperiode og datoen huskes
     * Retrurner false ellers og datoen givesDen ignoreres
     * @param givesDen
     * @return
     */
    public boolean givDosis(LocalDate givesDen) {
        // TODO
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
        return-1;
    }

    public double getAntalEnheder() {
        return antalEnheder;
    }

}
