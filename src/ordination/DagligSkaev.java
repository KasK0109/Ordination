package ordination;

import java.time.LocalTime;
import java.util.ArrayList;

public class DagligSkaev {
    // TODO
    private ArrayList<Dosis> dosisser = new ArrayList<>();


    public void opretDosis(LocalTime tid, double antal) {
        Dosis dosis = new Dosis(tid,antal);
        dosisser.add(dosis);
    }
    public void removeDosis(Dosis dosis) {
        if(dosisser.contains(dosis))
            dosisser.remove(dosis);
    }
}
