/**
 * Created by Administrator on 2017/11/02.
 */
public class Container {
    double lx;          //容器的X维度的长度
    double ly;          //容器的Y维度的长度
    double lz;          //容器的Z维度的长度
    double x;
    double y;
    double z;

    //设置Container的坐标点(x,y,z)
    public void setCoordinatePoint(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Container setContainer(double lx, double ly, double lz) {
        this.lx = lx;
        this.ly = ly;
        this.lz = lz;
        return this;
    }

    public double volume() {                //容器的体积
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
