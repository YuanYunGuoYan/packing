import java.util.HashMap;

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
}
