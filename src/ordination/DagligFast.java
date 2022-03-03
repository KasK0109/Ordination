
        package ordination;

        import java.time.LocalDate;
        import java.time.LocalTime;

        public abstract class DagligFast extends Ordination {


    // composition -> 0..* dosis
    private final Dosis[] dosisser = new Dosis[4];

    public void opretDosis(LocalTime tid, double antal, int index) {
        Dosis dosis = new Dosis(tid,antal);

        dosisser[index] = dosis;

    }
    //-----------------------------------------


    public DagligFast(LocalDate startDen, LocalDate slutDen, Patient patient, Laegemiddel laegemiddel, int morgenAntal, int middagsAntal, int aftensAntal, int NatAntal) {
        super(startDen, slutDen, patient, laegemiddel);
        if(morgenAntal>0)
            opretDosis(LocalTime.of(8,0), morgenAntal, 0);
        if (middagsAntal > 0)
            opretDosis(LocalTime.of(12,0), middagsAntal, 1);
        if (aftensAntal > 0)
            opretDosis(LocalTime.of(18,0), aftensAntal, 2);
        if(NatAntal > 0)
            opretDosis(LocalTime.of(24,0), NatAntal, 3);

    }

}


// TODO
