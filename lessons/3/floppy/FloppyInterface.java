/**
 * 软驱接口
 *      定义了软驱需要实现的所有操作
 * Created by 王一航 on 2017/1/9.
 */
interface FloppyInterface {
    void write(byte[] data);
    byte[] read();
    void setCursor(int direction, int cylinder, int section);
}
