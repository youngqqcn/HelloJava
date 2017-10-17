package cn.youngqq.file;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 向文件中写数据（FileWriter）
 *
 * @author: yqq
 * @create: 2017-10-17 15:17
 * @email: youngqqcn@163.com
 **/

public class FileDemo6 {

    public static void main(String[] args) throws IOException {

        String outStr = "中中中中果果果果";

        File file = new File("test2.txt");
        if(!file.exists()){
            file.createNewFile();
        }

        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write(outStr);
        fileWriter.flush(); //要成及时刷新缓冲区的习惯

        if (fileWriter != null){
            fileWriter.close();
        }



    }


}
