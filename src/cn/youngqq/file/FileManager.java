package cn.youngqq.file;

/**
 * 文件操作封装类
 *
 * @author: yqq
 * @create: 2017-10-17 11:53
 * @email: youngqqcn@163.com
 **/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.SequenceInputStream;
import java.net.URL;
import java.util.ArrayList;



public class FileManager {

    //实现文件复制功能，将src文件内容复制到des文件中
    public static void copy(File src,File des){
        try {
            FileReader fr = new FileReader(src);
            FileWriter fw = new FileWriter(des);
            int rs;
            while((rs=fr.read())!=-1){
                fw.write(rs);
            }
            System.out.println("复制成功！");
            fr.close();
            fw.close();
        }catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }

    }

    //实现文件删除功能，将src文件删除掉
    public static void delete(File src){
        if(src.isFile()){
            src.delete();
        }if(src.isDirectory()){
            File[] f= src.listFiles();
            for(int i=0;i<f.length;i++){
                if(f[i].isFile()){
                    f[i].delete();
                }if(f[i].isDirectory()){
                    delete(f[i]);     //递归
                    f[i].delete();    //将空文件夹删除，若不加这句，文件夹是删不掉的
                }
            }
        }
        System.out.println("OK");
    }

    //对单个文件进行重命名
    public static void rename(File src,String newName){
        File newFile = new File(newName);
        if(src.exists()){
            src.renameTo(newFile);
            System.out.println("重命名成功！");
        }else{
            System.out.print("该文件不存在！");
        }
    }

    //对目录里面的所有文件按照数字方式进行重命名
    public static void rename(File src){
        if(src.isDirectory()){
            File[] f = src.listFiles();
            for(int i=0;i<f.length;i++){
                String path = f[i].getAbsolutePath(); //获得文件的绝对路径
                //System.out.println(path);
                int index = path.lastIndexOf(".");  //获得“.”在原字符串path中最后一次出现的位置
                String s = path.substring(index);   //截取字符串
                int index2 = path.indexOf("//");    //获取制定字符串在原字符串中第一次出现的位置
                String s2 = path.substring(0,index2+1);
                String newname = s2+i+s;
                f[i].renameTo(new File(newname));
            }
            System.out.println("OK!");
        }else{
            System.out.println("wrong");
        }
    }



    //列出src中的所有文件，返回一个List

    static ArrayList<String> filename = new ArrayList<String>();
    //定义链表必须在listFile(File src)外
    //否则使用递归是无法列出多级目录下的所有文件的
    //写在函数里面的话，每次递归就会产生一个新的ArrayList<String> filename
    //这样得到的内容将会是最后一次生成的内容
    public static ArrayList<String> listFile(File src){
        File[] f = src.listFiles();
        for(int i=0;i<f.length;i++){
            String name = f[i].getName();
            filename.add(name);
            if(f[i].isDirectory()){
                listFile(f[i]);

            }
        }
        return filename;
    }

    //将一个序列化的类写到指定的文件中
    public static void writeObjectToFile(User u,File f){
        User user = null;
        try {
            FileOutputStream fos = new FileOutputStream(f);
            ObjectOutputStream obs = new ObjectOutputStream(fos);
            obs.writeObject(u);
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            user = (User)ois.readObject();
            System.out.println(user.name);
            System.out.println(user.password);
            System.out.println(user.age);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    //从文件中读出这个类
    public static Object readObjectFromFile(File f){
        User u = null;
        try {
            FileInputStream fis = new FileInputStream(f);
            ObjectInputStream ois = new ObjectInputStream(fis);
            u = (User)ois.readObject();
            System.out.println(u.name);
            System.out.println(u.password);
            System.out.println(u.age);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return u;
    }

    //将文件组合在一个文件中
    public static void compposite(File f1,File f2,File f3){
        try {
            FileInputStream fis1 = new FileInputStream(f1);
            FileInputStream fis2 = new FileInputStream(f2);
            SequenceInputStream sis = new SequenceInputStream(fis1,fis2);
            FileOutputStream fos = new FileOutputStream(f3);
            int rs = 0;
            while((rs=sis.read())!=-1){
                fos.write(rs);
            }
            System.out.println("文件合并成功！");
            fis1.close();
            fis2.close();
            sis.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    //显示指定网页的源代码
    public static String getCode(String strUrl)
    {
        try{
            URL url=new URL(strUrl);
            BufferedReader br=new BufferedReader(new InputStreamReader(url.openStream()));
            String s="";
            StringBuffer sb=new StringBuffer("");
            while((s=br.readLine())!=null)
            {
                sb.append(s+"/r/n");
            }
            br.close();
            return sb.toString();
        } catch(Exception e){
            return "无法显示网页"+strUrl;
        }
        //return "无法显示网页"+strUrl;
    }



    /**
     * @param args
     */
    public static void main(String[] args) {



        String html  =  getCode("http://www.baidu.com");
        System.out.println(html);








        //rename(new File("D:/temp"));
//        File src = new File("D://test");
//        File des = new File("D://2.txt");
//        File tmp = new File("D:/userinfo.txt");
//        File prc = new File("D:/1.txt");
//        try {
//            if(!src.exists()){
//                src.createNewFile();
//            }
//            if(!des.exists()){
//                des.createNewFile();
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        //System.out.println(getCode("http://www.hao1.com"));
        //compposite(des,tmp,prc);
        //readObjectFromFile(des);
            /*User user = new User("hao","123",20);
            writeObjectToFile(user,des);*/
            /*ArrayList<String> f = listFile(src);
            for(int i=0; i<f.size(); i++) {
                System.out.println("文件名："+f.get(i));

            }*/
        //rename(src);
        //listFile(src);
        //rename(des,"D://3.txt");
        //delete(src);
        //copy(src,des);

    }

}


class User
{
    public String name;
    public String password;
    public int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

















