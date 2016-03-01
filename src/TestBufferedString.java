import java.io.BufferedInputStream;  
import java.io.BufferedOutputStream;  
import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileOutputStream;  

public class TestBufferedString {  
  
    public static void main(String[] args) throws Exception {  
        // 指定要读取文件的缓冲输入字节流  
    	
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("D:\\pcre2-10.20.tar.gz"));
        String fileName = "E:\\123123\\pcre.tar.gz";
        File file = new File(fileName);   
        if (file != null) {   // 如果不为空（文件已存在）
            file.createNewFile();   // 新建
            System.out.println("Write new file:" + fileName);
        }  
        // 指定要写入文件的缓冲输出字节流  
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file));  
        byte[] bb = new byte[102400];// 用来存储每次读取到的字节数组  
        int n;// 每次读取到的字节数组的长度  
        while ((n = in.read(bb)) != -1) {
            out.write(bb, 0, n);// 写入到输出流
            String strI = Integer.toString(n);  // 转换整数为字符串
            System.out.println("Writing..." + strI);
        } 
        System.out.println("Write file done!");
        out.close();// 关闭流  
        in.close();  
    }  
  
}  