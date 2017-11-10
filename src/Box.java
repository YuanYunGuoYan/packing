/**
 * Created by Administrator on 2017/11/01.
 */
public class Box {
    double lx;          //箱子的X维度的长度
    double ly;          //箱子的Y维度的长度
    double lz;          //箱子的Z维度的长度
    int type;           //箱子的类型
    int NO;             //箱子的编号
//    double L;           //箱子的长
//    double W;           //箱子的宽
//    double H;           //箱子的高
//    int LX, LY, LZ = 0;
//    int WX, WY, WZ = 0;
//    int HX, HY, HZ = 0;

    public Box setBox(double lx,double ly,double lz){
        this.lx=lx;
        this.ly=ly;
        this.lz=lz;
        return this;
    }

//    public Box setBox(double L, double W, double H, int type) {
//        this.L = L;
//        this.W = W;
//        this.H = H;
//        this.type = type;
//        return this;
//    }

//    public Box setSurface(String surface) {
//        switch (surface) {
//            case "X/Z":
//                this.LX = 1;
//                this.WZ = 1;
//                this.HY = 1;
//                this.lx = L;
//                this.ly = H;
//                this.lz = W;
//                break;
//            case "X/Y":
//                this.LX = 1;
//                this.WY = 1;
//                this.HZ = 1;
//                this.lx = L;
//                this.ly = W;
//                this.lz = H;
//                break;
//            case "Y/Z":
//                this.LY = 1;
//                this.WZ = 1;
//                this.HX = 1;
//                this.lx = H;
//                this.ly = L;
//                this.lz = W;
//                break;
//            case "Y/X":
//                this.LY = 1;
//                this.WX = 1;
//                this.HZ = 1;
//                this.lx = W;
//                this.ly = L;
//                this.lz = H;
//                break;
//            case "Z/X":
//                this.LZ = 1;
//                this.WX = 1;
//                this.HY = 1;
//                this.lx = W;
//                this.ly = H;
//                this.lz = L;
//                break;
//            case "Z/Y":
//                this.LZ = 1;
//                this.WY = 1;
//                this.HX = 1;
//                this.lx = H;
//                this.ly = W;
//                this.lz = L;
//                break;
//        }
//        return this;
//    }

//    public int getLX() {
//        return LX;
//    }
//
//    public void setLX(int LX) {
//        this.LX = LX;
//    }
//
//    public int getLY() {
//        return LY;
//    }
//
//    public void setLY(int LY) {
//        this.LY = LY;
//    }
//
//    public int getLZ() {
//        return LZ;
//    }
//
//    public void setLZ(int LZ) {
//        this.LZ = LZ;
//    }
//
//    public int getWX() {
//        return WX;
//    }
//
//    public void setWX(int WX) {
//        this.WX = WX;
//    }
//
//    public int getWY() {
//        return WY;
//    }
//
//    public void setWY(int WY) {
//        this.WY = WY;
//    }
//
//    public int getWZ() {
//        return WZ;
//    }
//
//    public void setWZ(int WZ) {
//        this.WZ = WZ;
//    }
//
//    public int getHX() {
//        return HX;
//    }
//
//    public void setHX(int HX) {
//        this.HX = HX;
//    }
//
//    public int getHY() {
//        return HY;
//    }
//
//    public void setHY(int HY) {
//        this.HY = HY;
//    }
//
//    public int getHZ() {
//        return HZ;
//    }
//
//    public void setHZ(int HZ) {
//        this.HZ = HZ;
//    }

    public int getNO() {
        return NO;
    }

    public void setNO(int NO) {
        this.NO = NO;
    }

//    public double getL() {
//        return L;
//    }
//
//    public void setL(double l) {
//        L = l;
//    }
//
//    public double getW() {
//        return W;
//    }
//
//    public void setW(double w) {
//        W = w;
//    }
//
//    public double getH() {
//        return H;
//    }
//
//    public void setH(double h) {
//        H = h;
//    }

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

    public double getLy() {
        return ly;
    }

    public double getLz() {
        return lz;
    }

}
