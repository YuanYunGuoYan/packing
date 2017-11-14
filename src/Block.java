import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/11/02.
 */
public class Block {
    double lx;                                                    //块的X维度的长度
    double ly;                                                    //块的Y维度的长度
    double lz;                                                    //块的Z维度的长度
    HashMap<Integer, Integer> require = new HashMap<>();          //箱子需求,map<k,v> k:box.type  v:num[box.type]
    int level;                                                    //复杂度
    double ax;                                                    //可行放置矩形的长
    double ay;                                                    //可行放置矩形的宽
    double x;
    double y;
    double z;
    double fitness;                                                   //块的适应度
    int NO;                                                        //块的编号

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Block block = (Block) o;

        if (Double.compare(block.lx, lx) != 0) return false;
        if (Double.compare(block.ly, ly) != 0) return false;
        if (Double.compare(block.lz, lz) != 0) return false;
        if (level != block.level) return false;
        if (Double.compare(block.ax, ax) != 0) return false;
        if (Double.compare(block.ay, ay) != 0) return false;
        if (Double.compare(block.x, x) != 0) return false;
        if (Double.compare(block.y, y) != 0) return false;
        if (Double.compare(block.z, z) != 0) return false;
        return require != null ? require.equals(block.require) : block.require == null;
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
        result = 31 * result + (require != null ? require.hashCode() : 0);
        result = 31 * result + level;
        temp = Double.doubleToLongBits(ax);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(ay);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(x);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(y);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(z);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    public int getNO() {
        return NO;
    }

    public void setNO(int NO) {
        this.NO = NO;
    }

    public double getFitness() {
        return fitness;
    }

    public void setFitness(double fitness) {
        this.fitness = fitness;
    }

    //设置Block的坐标点(x,y,z)
    public void setCoordinatePoint(double x, double y, double z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public HashMap<Integer, Integer> getRequire() {
        return require;
    }

    public void setRequire(Integer type, Integer num) {
        this.require.put(type, num);
    }

    public void setRequire(HashMap<Integer, Integer> map) {
        this.require = map;
    }

    public double getAx() {
        return ax;
    }

    public void setAx(double ax) {
        this.ax = ax;
    }

    public double getAy() {
        return ay;
    }

    public void setAy(double ay) {
        this.ay = ay;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public double volume() {
        return this.lx * this.ly * this.lz;
    }     //块的体积

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

    //块实际体积，即所有箱子的体积之和
    public double realVolume(List<Box> boxList) {
        HashMap<Integer, Integer> map = this.getRequire();
        double v = 0.0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            for (Box b : boxList) {
                if (b.type == entry.getKey())
                    v += b.volume() * entry.getValue();
            }
        }
        return v;
    }
}
