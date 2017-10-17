package cn.youngqq.file;


import java.io.*;

/**
 * 文件操作demo1
 *
 * @author: yqq
 * @create: 2017-10-17 11:48
 * @email: youngqqcn@163.com
 **/

public class FileDemo1 {


    public static void main(String[] args) throws IOException {

//        File file = new File("test");
        File file = new File("test.txt");
        if(file.exists()){
            file.delete();
        }
        if(!file.exists()){

              //创建文件
//            if(file.createNewFile()){
//                System.out.println("create successful!\n");
//            }

              //创建目录
//            if(file.mkdir()){
//                System.out.println("mkdir successful!\n");
//            }



            //创建文件, 写入文件
//            if(!file.exists()){
//                file.createNewFile();
//            }
//
//            FileWriter fileWriter = new FileWriter(file);
//            PrintWriter printWriter = new PrintWriter(fileWriter);
//            printWriter.println("你好,世界!\n");


            //写文件
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
//            fileWriter.write("你好!\n");  //不会自动换行
//            fileWriter.write("Hola!\n");
//            fileWriter.write("Hello!\n");
//            fileWriter.flush();
            bufferedWriter.write("你好啊!\n");
            bufferedWriter.write("oHaYo!\n");
            bufferedWriter.write("Hala!\n");
            bufferedWriter.close();
            fileWriter.close();




            //读文件
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            System.out.println(bufferedReader.readLine());
            System.out.println(bufferedReader.readLine());
            System.out.println(bufferedReader.readLine());

            bufferedReader.close();
            fileReader.close();

        }

//        //删除文件
//        file.delete();









        System.out.println();

    }




}
