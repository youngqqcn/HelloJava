package cn.youngqq.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * 节点流FileReader读取字符流
 *
 * @author: yqq
 * @create: 2017-10-17 14:51
 * @email: youngqqcn@163.com
 **/

public class FileDemo3 {

    public static void main(String[] args) throws IOException {

        File file = new File("test.txt");
        if(!file.exists()){
            return; //不存在, 不读
        }

        FileReader fileReader = new FileReader(file);

        char[] buffer = new char[1024];

        int ret = 0;

        while((ret = fileReader.read(buffer)) != -1){
            System.out.print(buffer);
        }

        if(fileReader != null){
            fileReader.close();
        }

    }


}
