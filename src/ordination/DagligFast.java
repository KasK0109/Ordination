
package ordination;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

public class DagligFast extends Ordination {


    // composition -> 0..* dosis
    private final Dosis[] dosisser = new Dosis[4];

    public Dosis[] getDoser(){
        return dosisser;
    }
    public void opretDosis(LocalTime tid, double antal, int index) {
        Dosis dosis = new Dosis(tid, antal);
        dosisser[index] = dosis;
    }
    //-----------------------------------------


    public DagligFast(LocalDate startDen, LocalDate slutDen, Patient patient, Laegemiddel laegemiddel, double morgenAntal, double middagsAntal, double aftensAntal, double NatAntal) {
        super(startDen, slutDen, patient, laegemiddel);
        if (morgenAntal > 0)
            opretDosis(LocalTime.of(8, 0), morgenAntal, 0);
        if (middagsAntal > 0)
            opretDosis(LocalTime.of(12, 0), middagsAntal, 1);
        if (aftensAntal > 0)
            opretDosis(LocalTime.of(18, 0), aftensAntal, 2);
        if (NatAntal > 0)
            opretDosis(LocalTime.of(24, 0), NatAntal, 3);

    }

    @Override
    public double samletDosis() {
        double antal = 0.0;
        for(int i = 0; i < dosisser.length; i++)
            antal += dosisser[i].getAntal();
        return ChronoUnit.DAYS.between(getStartDen(),getSlutDen())*antal;
    }

    @Override
    public double doegnDosis() {
        double antal = 0.0;
        for(int i = 0; i < dosisser.length; i++)
            antal += dosisser[i].getAntal();
        return antal/dosisser.length;
    }

    @Override
    public String getType() {
        return "DagligFast";
    }
}


// TODO
