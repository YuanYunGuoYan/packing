/**
 * Created by Administrator on 2017/11/02.
 */
public class Container {
    double lx;
    double ly;
    double lz;

    public Container setContainer(double lx, double ly, double lz) {
        this.lx = lx;
        this.ly = ly;
        this.lz = lz;
        return this;
    }

    public double volume() {
        return this.lx * this.ly * this.lz;
    }
    public double getLx() {
        return lx;
    }

    public void setLx(double lx) {
        this.lx = lx;
    }

    public double getLy() {
        return ly;
    }

    public void setLy(double ly) {
        this.ly = ly;
    }

    public double getLz() {
        return lz;
    }

    public void setLz(double lz) {
        this.lz = lz;
    }
}
