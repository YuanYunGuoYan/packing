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
    int n;              //容器第几次切割
    String cutway;      //容器被切割的方式

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Container container = (Container) o;

        if (Double.compare(container.lx, lx) != 0) return false;
        if (Double.compare(container.ly, ly) != 0) return false;
        if (Double.compare(container.lz, lz) != 0) return false;
        if (Double.compare(container.x, x) != 0) return false;
        if (Double.compare(container.y, y) != 0) return false;
        if (Double.compare(container.z, z) != 0) return false;
        if (n != container.n) return false;
        return cutway != null ? cutway.equals(container.cutway) : container.cutway == null;
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(lx);
        result = (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(ly);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(lz);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(x);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(z);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + n;
        result = 31 * result + (cutway != null ? cutway.hashCode() : 0);
        return result;
    }

    public String getCutway() {
        return cutway;
    }

    public void setCutway(String cutway) {
        this.cutway = cutway;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

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
