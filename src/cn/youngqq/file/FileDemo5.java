package cn.youngqq.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 向文件中写入数据（字节流FileOutputStream）
 *
 * @author: yqq
 * @create: 2017-10-17 15:09
 * @email: youngqqcn@163.com
 **/

public class FileDemo5 {

    public static void main(String[] args) throws IOException {


        String outStr = "你好世界啊!";

        File file = new File("test1.txt");
        if(!file.exists()){
            file.createNewFile();
        }

        FileOutputStream fileOutputStream = new FileOutputStream(file);
        byte[] bytes = outStr.getBytes();

        fileOutputStream.write(bytes);
        fileOutputStream.flush(); //及时刷新缓冲区
        fileOutputStream.close();

        if(fileOutputStream != null){
            fileOutputStream.close();
        }





    }


}
