// Java read file test
//  异常相关的模块

import java.io.FileNotFoundException;
import java.io.IOException;

//  读取文件相关模块
//import java.io.BufferedInputStream;
import java.io.FileInputStream;  // 文件（读）操作模块
import java.io.InputStreamReader;  // 输入流读取模块
import java.io.BufferedReader;  // 用以包装InputStreamReader（输入流读取）

// 写入文件相关模块
//import java.io.FileWriter;   // 写文件
import java.io.FileOutputStream;  // 文件（写）操作模块
import java.io.OutputStreamWriter; //输出流读取模块
import java.io.BufferedWriter;  // buffer writer用以包装OutputStreamWriter

public class BobFile {
 
 public static void main(String[] args) {
  FileInputStream fis = null;
  InputStreamReader isr = null;
  BufferedReader br = null; //用于包装InputStreamReader,提高处理性能。因为BufferedReader有缓冲的，而InputStreamReader没有。
  try {
        String str = "";
        String filePath = "d:\\boban\\123\\readme.txt";
        
        fis = new FileInputStream(filePath); // 从文件系统中的某个文件中获取字节
        isr = new InputStreamReader(fis);   // InputStreamReader 是字节流通向字符流的桥梁,
        br = new BufferedReader(isr);      // 从字符输入流中读取文件中的内容,封装了一个new InputStreamReader的对象
        
        // 或者写成下面
        // br = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)));
        
        while ((str = br.readLine()) != null) {  // 当读取的一行不为空时
            System.out.println("***********************");
            System.out.println(str);// 打印出str
        }
        
  } catch (FileNotFoundException e) {
        System.out.println("文件未找到");
  } catch (IOException e) {
        System.out.println("文件读取失败");
  } finally {
        try {
            br.close();
            isr.close();
            fis.close();
    // 关闭的时候最好按照先后顺序关闭最后开的先关闭所以先关s,再关n,最后关m
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
        String str = "你好吗？我很好！"; //你好吗？  
        String filePath = "d:\\boban\\123\\writeme.txt";
        
       fos = new FileOutputStream(filePath);
       osw = new OutputStreamWriter(fos);
       bufw = new BufferedWriter(osw);  //缓冲 
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
        System.out.println("文件未找到");
  } catch (IOException e) {
        System.out.println("文件写入失败");
  } finally {
        try {
            bufw.flush();
            bufw.close();
            osw.close();
            fos.close();
    // 关闭的时候最好按照先后顺序关闭
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
  
  
 }
}