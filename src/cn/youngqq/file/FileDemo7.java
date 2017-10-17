package cn.youngqq.file;

import java.io.*;

/**
 * 采用BufferedWriter向文件中写数据
 *
 * @author: yqq
 * @create: 2017-10-17 15:22
 * @email: youngqqcn@163.com
 **/

public class FileDemo7 {

    public static void main(String[] args) throws IOException {

        File file = new File("test3.txt");

        if(!file.exists()){
            file.createNewFile();
        }

        String outStr = "六六六六六六六";

        FileWriter fileWriter = new FileWriter(file);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        bufferedWriter.write(outStr);
        bufferedWriter.flush(); //养成及时刷新缓冲区的习惯!

        if(bufferedWriter != null){
            bufferedWriter.close();
        }

    }


}
