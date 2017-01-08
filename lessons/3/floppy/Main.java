/**
 * 主入口
 * Created by 王一航 on 2017/1/9.
 */
public class Main {
    public static void main(String args[]){
        // 引导扇区文件名 (汇编编译得到的二进制文件)
        String bootFileName = "../boot/boot";
        // 烧写目标文件名
        String outFileName = "../system.img";
        FloppyManager floppyManager = new FloppyManager();
        Floppy floppy = new Floppy();
        floppyManager.makeFloppy(floppy, bootFileName);
        floppyManager.burnToFile(floppy, outFileName);
    }
}
