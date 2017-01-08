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
    
    
    
    private void writeFileToFloppy(String fileName) {
    	File file = new File(fileName);
    	InputStream in = null;
    	
    	try {
    		in = new FileInputStream(file);
    		byte[] buf = new byte[512];
    		buf[510] = 0x55;
    		buf[511] = (byte) 0xaa;
    		if (in.read(buf) != -1) {
    			//将内核读入到磁盘第0面，第0柱面，第1个扇区
    			floppyDisk.writeFloppy(Floppy.MAGNETIC_HEAD.MAGNETIC_HEAD_0, 0, 1, buf);
    		}
    	} catch(IOException e) {
    		e.printStackTrace();
    		return;
    	}
    }
    
    public OperatingSystem(String s) {
    	writeFileToFloppy(s);
    }
    
    public void makeFllopy()   {
    	String s = "This is a text from cylinder 0 and sector 2";
    	floppyDisk.writeFloppy(Floppy.MAGNETIC_HEAD.MAGNETIC_HEAD_0, 0, 2, s.getBytes()); // 向第二个扇区中写入需要被读取的数据
    	
    	floppyDisk.makeFloppy("../system.img");
    }
    
   

    public static void main(String[] args) {
    	OperatingSystem op = new OperatingSystem("../boot/boot");
    	op.makeFllopy();
    }
}
