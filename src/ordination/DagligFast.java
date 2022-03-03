package ordination;

import java.time.LocalDate;
import java.util.ArrayList;

public abstract class DagligFast extends Ordination {


        // composition -> 0..* dosis
        private final ArrayList<Dosis> dosisArrayList = new ArrayList<>();
        public ArrayList<Dosis> getDosisArrayList() {
            return new ArrayList<>(dosisArrayList);
        }

        public Dosis createDosis(String name) {
            Dosis dosis = new Dosis(name);
            dosisArrayList.add(dosis);
            return dosis;
        }




        //-----------------------------------------

    public DagligFast() {
    }

    public DagligFast opretDaligFast(LocalDate startDen, LocalDate slutDen, Patient patient, Laegemiddel laegemiddel,
                                     double morgenAntal, double middagAntal, double aftenAntal,
                                     double natAntal) {




    }


    // TODO
}
