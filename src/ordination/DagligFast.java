package ordination;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class DagligFast extends Ordination {


        // composition -> 0..* dosis
        private final ArrayList<Dosis> dosiser = new ArrayList<>();
        public ArrayList<Dosis> getDoser() {
            return new ArrayList<>(dosiser);
        }

        public Dosis createDosis(String name) {
            Dosis dosis = new Dosis(name);
            dosiser.add(dosis);
            return dosis;
        }




        //-----------------------------------------


    public DagligFast(LocalDate startDen, LocalDate slutDen, Patient patient, Laegemiddel laegemiddel) {
        super(startDen, slutDen, patient, laegemiddel);
    }


    }


    // TODO


