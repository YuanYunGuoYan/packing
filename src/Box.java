/**
 * Created by Administrator on 2017/11/01.
 */
public class Box {
    double lx;          //箱子的X维度的长度
    double ly;          //箱子的Y维度的长度
    double lz;          //箱子的Z维度的长度
    int type;           //箱子的类型

    public Box setBox(double lx, double ly, double lz, int type) {
        this.lx = lx;
        this.ly = ly;
        this.lz = lz;
        this.type = type;
        return this;
    }

    public double volume() {
        return this.lx * this.ly * this.lz;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
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
