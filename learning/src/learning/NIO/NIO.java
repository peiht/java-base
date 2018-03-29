package learning.NIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class NIO {

    public static void main(String[] args) throws IOException {
        String inFile = "G:\\work_package\\ÎÄµµ\\qrtz.txt";
        String outFile = "G:\\out.txt";
        
        FileInputStream fi = new FileInputStream(inFile);
        FileOutputStream fo = new FileOutputStream(outFile);
        
        FileChannel fcin = fi.getChannel();
        FileChannel fcout = fo.getChannel();
        
        ByteBuffer buffer = ByteBuffer.allocate(1024);
        
        while(true) {
            buffer.clear();
            int r = fcin.read(buffer);
            if( r == -1) {
                break;
            }
            buffer.flip();
            fcout.write(buffer);
        }
    }
}
