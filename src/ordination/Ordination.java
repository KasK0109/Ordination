package ordination;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Ordination {
    private LocalDate startDen;
    private LocalDate slutDen;
    Patient patient;

    // TODO Link til Laegemiddel
    // TODO constructor (med specifikation)
    public Ordination(LocalDate startDen, LocalDate slutDen, Patient patient, Laegemiddel laegemiddel) {
        this.startDen = startDen;
        this.slutDen = slutDen;
        this.patient = patient;
        this.laegemiddel = laegemiddel;
    }

    private Laegemiddel laegemiddel;
    /** Note: Nullable return value. */
    public Laegemiddel getLaegemiddel(){
        return laegemiddel;
    }
    public void setLaegemiddel(Laegemiddel laegemiddel){
        if(this.laegemiddel != laegemiddel){
            this.laegemiddel = laegemiddel;
        }
    }

    public LocalDate getStartDen() {
        return startDen;
    }

    public LocalDate getSlutDen() {
        return slutDen;
    }

    /**
     * Get Patient metode - ikke nødvendigvis nødvendig til test
     * @
     */
//    public Patient getPatient() {
//        return patient;
//    }

    /**
     * Antal hele dage mellem startdato og slutdato. Begge dage inklusive.
     * @return antal dage ordinationen gælder for
     */
    public int antalDage() {
        return (int) ChronoUnit.DAYS.between(startDen, slutDen) + 1;
    }

    @Override
    public String toString() {
        return startDen.toString();
    }

    /**
     * Returnerer den totale dosis der er givet i den periode ordinationen er gyldig
     * @return
     */
    public abstract double samletDosis();

    /**
     * Returnerer den gennemsnitlige dosis givet pr dag i den periode ordinationen er gyldig
     * @return
     */
    public abstract double doegnDosis();

    /**
     * Returnerer ordinationstypen som en String
     * @return
     */
    public abstract String getType();
}
