import java.util.ArrayList;
import java.util.HashMap;

/**
 * 软驱类
 * Created by 王一航 on 2017/1/9.
 */
public class Floppy implements FloppyInterface{
    // 定义数据
    private HashMap<Integer,ArrayList<ArrayList<byte[]>> > floppyData = new HashMap<Integer,ArrayList<ArrayList<byte[]>> >(); //一个磁盘两个面
    // 定义磁头
    Curor curor;

    public Floppy(){
        // 初始化磁头
        curor = new Curor(0,0,0);
        // 初始化数据
        initFloppyData();
    }
    private void initFloppyData() {
        //一个磁盘有两个盘面
        floppyData.put(0, initFloppyDisk());
        floppyData.put(1, initFloppyDisk());
    }

    private ArrayList<ArrayList<byte[]>> initFloppyDisk() {
        ArrayList<ArrayList<byte[]>> floppyDisk = new ArrayList<ArrayList<byte[]>>(); //磁盘的一个面
        //一个磁盘面有80个柱面
        for(int i = 0; i < 80; i++) {
            floppyDisk.add(initCylinder());
        }
        return floppyDisk;
    }

    private ArrayList<byte[]> initCylinder() {
        //构造一个柱面，一个柱面有18个扇区
        ArrayList<byte[]> cylinder = new ArrayList<byte[]> ();
        for (int i = 0; i < 18; i++) {
            byte[] sector = new byte[512];
            cylinder.add(sector);
        }
        return cylinder;
    }

    /**
     * 向指定的扇区写入数据
     * @param data 数据
     */
    @Override
    public void write(byte[] data) {
        int direction = this.curor.getDIRECTION_CURSOR();
        int cylinder = this.curor.getCYLINDER_CURSOR();
        int section = this.curor.getSECTION_CURSOR();
        floppyData.get(direction).get(cylinder).set(section, data);
    }

    /**
     * 从指定的扇区读入数据
     * @return 读取到的数据
     */
    @Override
    public byte[] read() {
        int direction = this.curor.getDIRECTION_CURSOR();
        int cylinder = this.curor.getCYLINDER_CURSOR();
        int section = this.curor.getSECTION_CURSOR();
        return floppyData.get(direction).get(cylinder).get(section);
    }

    /**
     * 设置磁头位置
     * @param direction 盘面
     * @param cylinder 磁道
     * @param section 扇区
     */
    @Override
    public void setCursor(int direction, int cylinder, int section){
        curor.setDIRECTION_CURSOR(direction);
        curor.setCYLINDER_CURSOR(cylinder);
        curor.setSECTION_CURSOR(section);
    }
}
