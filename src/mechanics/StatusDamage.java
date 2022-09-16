package mechanics;

public class StatusDamage {
    private String status;
    private double slash;
    private double impact;
    private double fire;
    private double ice;


    public StatusDamage(String status, double slash, double impact, double fire, double ice) {
        this.status = status;
        this.slash = slash;
        this.impact = impact;
        this.fire = fire;
        this.ice = ice;
    }


    public String getStatus() {
        return status;
    }

    public double getSlash() {
        return slash;
    }

    public double getImpact() {
        return impact;
    }

    public double getFire() {
        return fire;
    }

    public double getIce() {
        return ice;
    }
}
