
# Java IO

## 知识点
- 1.字节流和字符流选择
    - 字节流：字节流读取的时候，读到一个字节就返回一个字节；  主要用于读取图片，MP3，AVI视频文件。
    - 字符流：字符流使用了字节流读到一个或多个字节，如读取中文时，就会一次读取2个字节。只要是处理纯文本数据，就要优先考虑使用字符流。

 
- 2.处理流和节点流
    - 节点流：和操作系统紧密连接的流。该层的与文件输入输出的操作都比较原始，没有进过优化，功能比较单一。
（FileReader，FileWriter和FileInputStream，FileOutStream都是输入节点流。）
 
    - 处理流：该层流是对节点流的封装，对节点流中进行优化，加入缓冲器，提供更加丰富的API等。我们一般都使用处理流，在创建处理流对象的时候一般都需要节点流对象作为其构造参数。
（BufferedInPutStream，BufferedOutPutStream和BufferedWriter，BufferedReader）
对于这种带缓冲器的处理流与对应的节点流的最大区别可以参考：http://fjding.iteye.com/blog/2311233


## 总结

- 处理流需要用节点流来创建 
- 处理纯文本文件,用处理流(Buffered)字符流(Reader,Writer)


 对于我来说，一般使用io来操作文件比较多一些，一般都喜欢用BufferedReader和BufferedWriter，
 使用它们的一般流程是，先创建File对象（可以对路径和文件进行更多的操作），然后通过File对象创
 建FileReader（FileWriter）【当然在这里也可以通过创建InputStreamReader（new InputStream）
 来获取reader对象，看个人爱好】，然后通过FileReader（FileWriter）获得BufferedReader（BufferedWriter）
 对象。对于读入文件，还可以使用Scanner对读取的文件进行操作，这个比较方便，Scanner也是处理流，因此也是需要
 节点流作为其参数的。