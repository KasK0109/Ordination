package ordination;

import java.time.LocalTime;

public class Dosis {
    private LocalTime tid;
    private double antal;

    public Dosis(LocalTime tid, double antal) {
        super();
        this.tid = tid;
        this.antal = antal;
    }

    public double getAntal() {
        return antal;
    }

    public void setAntal(double antal) {
        this.antal = antal;
    }

    public LocalTime getTid() {
        return tid;
    }

    public void setTid(LocalTime tid) {
        this.tid = tid;
    }

    @Override
    public String toString(){
        return "Kl: " + tid + "   antal:  " + antal;
    }

    //--------------------------------

    //Enkelrettet til DadligFast

        private String name;
        Dosis(String name) { // OBS: package visibility
            this.name = name;
        }
    }


