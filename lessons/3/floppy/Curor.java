/**
 * 磁头类
 * Created by 王一航 on 2017/1/9.
 */
public class Curor {
    // 定义盘面
    private int DIRECTION_CURSOR = 0; // 0 / 1
    // 定义柱面(磁道)
    private int CYLINDER_CURSOR = 0; // 0 - 79 , 总共 80 个
    // 定义扇区
    private int SECTION_CURSOR = 0; // 0 - 17 , 总共 18 个

    public Curor(int direction, int cylinder, int section){
        setDIRECTION_CURSOR(direction);
        setCYLINDER_CURSOR(cylinder);
        setSECTION_CURSOR(section);
    }

    public int getDIRECTION_CURSOR(){
        return this.DIRECTION_CURSOR;
    }

    public int getCYLINDER_CURSOR(){
        return this.CYLINDER_CURSOR;
    }

    public int getSECTION_CURSOR(){
        return this.SECTION_CURSOR;
    }

    /**
     * 设置盘面
     * @param direction
     */
    public void setDIRECTION_CURSOR(int direction){
        if (direction < 0){
            DIRECTION_CURSOR = 0;
            return;
        }
        int DIRECTION_NUMBER = 2;
        if (direction > DIRECTION_NUMBER - 1){
            DIRECTION_CURSOR = (DIRECTION_NUMBER - 1);
            return;
        }
        DIRECTION_CURSOR = direction;
    }

    /**
     * 设置磁道
     * @param cylinder
     */
    public void setCYLINDER_CURSOR(int cylinder){
        if (cylinder < 0){
            CYLINDER_CURSOR = 0;
            return;
        }
        int CYLINDER_NUMBER = 80;
        if (cylinder > CYLINDER_NUMBER - 1){
            CYLINDER_CURSOR = (CYLINDER_NUMBER - 1);
            return;
        }
        CYLINDER_CURSOR = cylinder;
    }

    /**
     * 设置扇区
     * @param section
     */
    public void setSECTION_CURSOR(int section){
        if (section < 0){
            SECTION_CURSOR = 0;
            return;
        }
        int SECTION_NUMBER = 18;
        if (section > SECTION_NUMBER - 1){
            SECTION_CURSOR = (SECTION_NUMBER - 1);
            return;
        }
        SECTION_CURSOR = section;
    }
}
