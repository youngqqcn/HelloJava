package cn.youngqq.file;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

/**
 * 用FileInputStream读取字节流
 *
 * @author: yqq
 * @create: 2017-10-17 14:41
 * @email: youngqqcn@163.com
 **/

public class FileDemo2 {

    public static void main(String[] args) throws IOException {


        File file = new File("test.txt");
        if(!file.exists()){
            return; //如果不存在, 还读啥?
        }

        byte[] bytes = new byte[1024];
        FileInputStream fileInputStream = new FileInputStream(file);

        int ret = 0;
        while ((ret = fileInputStream.read(bytes)) != -1){
            System.out.write(bytes, 0, ret); //输出字节流
            //System.out.println(bytes);
        }

        if(fileInputStream != null){
            fileInputStream.close();
        }


    }


}
