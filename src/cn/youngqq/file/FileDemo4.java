package cn.youngqq.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 文件的读取通过BufferedReader读取数据。  处理流
 *
 * @author: yqq
 * @create: 2017-10-17 15:01
 * @email: youngqqcn@163.com
 **/

public class FileDemo4 {

    public static void main(String[] args) throws IOException {

        File file = new File("test.txt");
        if(!file.exists()){
            return;
        }

        String str;

        //BufferedReader()需要一个FileReader进行构造
        BufferedReader bufferedReader = new BufferedReader(new FileReader(file));

        while((str = bufferedReader.readLine()) != null){
            System.out.println(str);
        }


        if (bufferedReader != null){
            bufferedReader.close();
        }

    }


}
