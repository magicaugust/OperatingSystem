import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 软驱管理类
 *      主要用于将软驱对象中的数据写入到文件中
 * Created by 王一航 on 2017/1/9.
 */
public class FloppyManager {


    /**
     * 用内核文件创建一个软盘
     * @param bootFileName
     */
    public void makeFloppy(Floppy floppy, String bootFileName){
        try {
            byte[] buffer = new byte[512];
            byte[] data = IOUtil.readFileByByte(bootFileName);
            for (int i = 0; i < data.length; i++){
                buffer[i] = data[i];
            }
            buffer[510] = 0x55;
            buffer[511] = (byte) 0xAA;
            floppy.setCursor(0,0,0);
            floppy.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将一个软盘对象烧写到一个文件中
     * @param floppy 软驱对象
     */
    public void burnToFile(Floppy floppy, String fileName) {
        try {
    		/*
    		 * 虚拟软盘是存粹的二进制文件，它的逻辑结构如下：
    		 * 前512*18 字节的内容对应盘面0，柱面0的所有扇区内容
    		 * 接着的512*18字节的内容对应盘面1，柱面0的所有扇区内容
    		 * 再接着的512*18字节的内容对应盘面0，柱面1所有扇区内容
    		 * 再接着512*18字节的内容对应盘面1，柱面1所有扇区内容
    		 * 以此类推
    		 */
            DataOutputStream out = new DataOutputStream(new FileOutputStream(fileName));
            for (int cylinder = 0; cylinder < 80; cylinder++){
                for (int direction = 0; direction < 2; direction++){
                    for (int section = 0; section < 18; section++){
                        floppy.setCursor(direction, cylinder, section);
                        byte[] buffer = floppy.read();
                        out.write(buffer);
                    }
                }
            }
            out.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
