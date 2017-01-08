import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 文件读写工具类
 * Created by 王一航 on 2017/1/9.
 */
public class IOUtil {

    /**
     * 写文件
     * @param filename 文件名
     * @param data 数据
     */
    public static void writeFileByByte(String filename, byte data[]) throws IOException {
        FileOutputStream fos = new FileOutputStream(filename);
        fos.write(data);
        fos.close();
    }

    /**
     * 读取文件的所有字节内容
     * @param filePath 文件路径
     * @return 返回字节数组
     * @throws IOException IO 异常
     */
    public static byte[] readFileByByte(String filePath) throws IOException {
        FileInputStream in = new FileInputStream(filePath);
        ByteArrayOutputStream out = new ByteArrayOutputStream(1024);
        byte[] temp = new byte[1024];
        int size = 0;
        while((size = in.read(temp)) != -1) {
            out.write(temp,0,size);
        }
        in.close();
        byte[] bytes = out.toByteArray();
        return bytes;
    }

    /**
     * 读取文件(可以设置偏移和长度)
     * @param filename 文件名称
     * @param position 偏移量
     * @param length 读取的数据长度(字节)
     * @return 返回读取到的数据
     */
    public static byte[] readFileByByte(String filename, long position, int length){
        byte[] data = new byte[length];
        // TODO 读取文件(可以设置偏移和长度)
        return data;
    }

}
