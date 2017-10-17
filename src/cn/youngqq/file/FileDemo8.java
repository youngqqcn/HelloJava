package cn.youngqq.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

/**
 * 用Scanner读取文件
 *
 * @author: yqq
 * @create: 2017-10-17 15:37
 * @email: youngqqcn@163.com
 **/



public class FileDemo8 {




    /*
`   delimiter()
          Returns the Pattern this Scanner is currently using to match delimiters.
    hasNext()
          Returns true if this scanner has another token in its input.
          Returns true if the next complete token matches the specified pattern.
          Returns true if the next token matches the pattern constructed from the specified string.
    hasNextLine()
          Returns true if there is another line in the input of this scanner.
    next()
          Finds and returns the next complete token from this scanner.
          Returns the next token if it matches the specified pattern.
          Returns the next token if it matches the pattern constructed from the specified string.
    nextLine()
          Advances this scanner past the current line and returns the input that was skipped.
     */

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("test1.txt");
        if(!file.exists()){
            return;
        }

        FileReader fileReader = new FileReader(file);

        //Scanner是处理流, 需要节点流作为构造参数
        Scanner scanner = new Scanner(fileReader);

        for (;scanner.hasNext();)
        {
            //System.out.println(scanner.next());
            System.out.println(scanner.nextLine());
        }

        if(scanner != null){
            scanner.close();
        }

    }


}
