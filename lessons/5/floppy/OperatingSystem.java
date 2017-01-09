import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;


public class OperatingSystem {
   
    private Floppy floppyDisk = new Floppy();
    
    private void writeFileToFloppy(String fileName, boolean boot, int cylinder, int section) {
    	File file = new File(fileName);
    	InputStream in = null;
    	
    	try {
    		in = new FileInputStream(file);
    		byte[] buf = new byte[512];
			if (boot){ // 只有引导扇区才需要将最后两个字节设置为 0x55 , 0xAA
				buf[510] = 0x55;
				buf[511] = (byte) 0xaa;
			}
			if (in.read(buf) != -1) {
    			//将内核读入到磁盘第0面，第0柱面，第1个扇区
    			floppyDisk.writeFloppy(Floppy.MAGNETIC_HEAD.MAGNETIC_HEAD_0, cylinder, section, buf);
    		}
    	} catch(IOException e) {
    		e.printStackTrace();
    		return;
    	}
    }
    
    public OperatingSystem(String s) {
    	writeFileToFloppy(s, true, 0, 1);
    }
    
    public void makeFllopy()   {
		writeFileToFloppy("../boot/kernel", false, 1, 2); // 这里有一个疑问 : 为什么是第二个扇区而不是第一个扇区 ?
    	floppyDisk.makeFloppy("../system.img");
    }
    
   

    public static void main(String[] args) {
    	OperatingSystem op = new OperatingSystem("../boot/boot");
    	op.makeFllopy();
    }
}
