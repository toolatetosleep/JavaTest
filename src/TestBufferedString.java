import java.io.BufferedInputStream;  
import java.io.BufferedOutputStream;  
import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileOutputStream;  

public class TestBufferedString {  
  
    public static void main(String[] args) throws Exception {  
        // ָ��Ҫ��ȡ�ļ��Ļ��������ֽ���  
    	
        BufferedInputStream in = new BufferedInputStream(new FileInputStream("D:\\pcre2-10.20.tar.gz"));
        String fileName = "E:\\123123\\pcre.tar.gz";
        File file = new File(fileName);   
        if (file != null) {   // �����Ϊ�գ��ļ��Ѵ��ڣ�
            file.createNewFile();   // �½�
            System.out.println("Write new file:" + fileName);
        }  
        // ָ��Ҫд���ļ��Ļ�������ֽ���  
        BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(file));  
        byte[] bb = new byte[102400];// �����洢ÿ�ζ�ȡ�����ֽ�����  
        int n;// ÿ�ζ�ȡ�����ֽ�����ĳ���  
        while ((n = in.read(bb)) != -1) {
            out.write(bb, 0, n);// д�뵽�����
            String strI = Integer.toString(n);  // ת������Ϊ�ַ���
            System.out.println("Writing..." + strI);
        } 
        System.out.println("Write file done!");
        out.close();// �ر���  
        in.close();  
    }  
  
}  