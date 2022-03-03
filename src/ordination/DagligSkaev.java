package ordination;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public  abstract class DagligSkaev extends Ordination {
    // TODO
    private ArrayList<Dosis> dosisser = new ArrayList<>();

    public DagligSkaev(LocalDate startDen, LocalDate slutDen, Patient patient, Laegemiddel laegemiddel) {
        super(startDen, slutDen, patient, laegemiddel);
    }

    public ArrayList<Dosis> getDosisser(){
        return new ArrayList<>(dosisser);
    }
    public void opretDosis(LocalTime tid, double antal) {
        Dosis dosis = new Dosis(tid,antal);
        dosisser.add(dosis);
    }
    public void removeDosis(Dosis dosis) {
        if(dosisser.contains(dosis))
            dosisser.remove(dosis);
    }

}
