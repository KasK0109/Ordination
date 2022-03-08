package ordination;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class DagligSkaev extends Ordination {
    // TODO
    private ArrayList<Dosis> dosisser = new ArrayList<>();

    public DagligSkaev(LocalDate startDen, LocalDate slutDen, Patient patient, Laegemiddel laegemiddel,LocalTime[] klokkeSlet, double[] antalEnheder) {
        super(startDen, slutDen, patient, laegemiddel);
        for(int i = 0; i<klokkeSlet.length; i++){
            opretDosis(klokkeSlet[i],antalEnheder[i]);
        }
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


;
    @Override
    public double samletDosis() {
        int antal = 0;
        for(int i = 0; i <dosisser.size();i++) {
            antal += dosisser.get(i).getAntal();
        }
        return ChronoUnit.DAYS.between(getStartDen(),getSlutDen())*antal;

    }

    @Override
    public double doegnDosis() {
        int antal = 0;
        for(int i = 0; i <dosisser.size();i++) {
            antal += dosisser.get(i).getAntal();
        }
        return samletDosis()/ChronoUnit.DAYS.between(getStartDen(),getSlutDen());
    }

    @Override
    public String getType() {
        return "Daglig Skaev";
    }
}
