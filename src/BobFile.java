// Java read file test
//  �쳣��ص�ģ��

import java.io.FileNotFoundException;
import java.io.IOException;

//  ��ȡ�ļ����ģ��
//import java.io.BufferedInputStream;
import java.io.FileInputStream;  // �ļ�����������ģ��
import java.io.InputStreamReader;  // ��������ȡģ��
import java.io.BufferedReader;  // ���԰�װInputStreamReader����������ȡ��

// д���ļ����ģ��
//import java.io.FileWriter;   // д�ļ�
import java.io.FileOutputStream;  // �ļ���д������ģ��
import java.io.OutputStreamWriter; //�������ȡģ��
import java.io.BufferedWriter;  // buffer writer���԰�װOutputStreamWriter

public class BobFile {
 
 public static void main(String[] args) {
  FileInputStream fis = null;
  InputStreamReader isr = null;
  BufferedReader br = null; //���ڰ�װInputStreamReader,��ߴ������ܡ���ΪBufferedReader�л���ģ���InputStreamReaderû�С�
  try {
        String str = "";
        String filePath = "d:\\boban\\123\\readme.txt";
        
        fis = new FileInputStream(filePath); // ���ļ�ϵͳ�е�ĳ���ļ��л�ȡ�ֽ�
        isr = new InputStreamReader(fis);   // InputStreamReader ���ֽ���ͨ���ַ���������,
        br = new BufferedReader(isr);      // ���ַ��������ж�ȡ�ļ��е�����,��װ��һ��new InputStreamReader�Ķ���
        
        // ����д������
        // br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
        
        while ((str = br.readLine()) != null) {  // ����ȡ��һ�в�Ϊ��ʱ
            System.out.println("***********************");
            System.out.println(str);// ��ӡ��str
        }
        
  } catch (FileNotFoundException e) {
        System.out.println("�ļ�δ�ҵ�");
  } catch (IOException e) {
        System.out.println("�ļ���ȡʧ��");
  } finally {
        try {
            br.close();
            isr.close();
            fis.close();
    // �رյ�ʱ����ð����Ⱥ�˳��ر���󿪵��ȹر������ȹ�s,�ٹ�n,����m
        } catch (IOException e) {
            e.printStackTrace();
   }
  }


  
// Test write.
  FileOutputStream fos = null;
  OutputStreamWriter osw = null;
  BufferedWriter bufw = null;
  try {
        // String str = "";
        String str = "������Һܺã�"; //�����  
        String filePath = "d:\\boban\\123\\writeme.txt";
        
       fos = new FileOutputStream(filePath);
       osw = new OutputStreamWriter(fos);
       bufw = new BufferedWriter(osw);  //���� 
       int trig = 0 ;
       String tet = "";
       while (str != null){
            if (trig > 10){
                break;
            }
            System.out.println("*** Write content:\r\n" + str);
            tet += (str + "\r\n"); 
            System.out.println(trig);
            trig++;
       }
       bufw.write(tet);
        
  } catch (FileNotFoundException e) {
        System.out.println("�ļ�δ�ҵ�");
  } catch (IOException e) {
        System.out.println("�ļ�д��ʧ��");
  } finally {
        try {
            bufw.flush();
            bufw.close();
            osw.close();
            fos.close();
    // �رյ�ʱ����ð����Ⱥ�˳��ر�
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
  
  
 }
}