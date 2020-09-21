package com.young.springbootkafka.commontest.langtext;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.FileFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.lang3.ArrayUtils;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.apache.commons.io.IOUtils.LINE_SEPARATOR_WINDOWS;

public class IOtextdemo {

/*
    public static final char DIR_SEPARATOR_UNIX = '/';
    public static final char DIR_SEPARATOR_WINDOWS = '\\';
    public static final char DIR_SEPARATOR;
    public static final String LINE_SEPARATOR_UNIX = "\n";
    public static final String LINE_SEPARATOR_WINDOWS = "\r\n";
    public static final String LINE_SEPARATOR;


    static {
        DIR_SEPARATOR = File.separatorChar;

        StringBuilderWriter buf = new StringBuilderWriter(4);
        PrintWriter out = new PrintWriter(buf);
        out.println();
        LINE_SEPARATOR = buf.toString();
        out.close();
    }
(*/

    File file1=new File("C:"+File.separator+"Users"+File.separator+"Administrator"+File.separator+"Desktop"+File.separator+"abc.txt");
    File file2=new File("C:"+File.separator+"Users"+File.separator+"Administrator"+File.separator+"Desktop"+File.separator+"text");
    File file3=new File("C:"+File.separator+"Users"+File.separator+"Administrator"+File.separator+"Desktop"+File.separator+"aaa");
    File file4=new File("C:"+File.separator+"Users"+File.separator+"Administrator"+File.separator+"Desktop"+File.separator+"bbb.txt");
    File file5=new File("C:"+File.separator+"Users"+File.separator+"Administrator"+File.separator+"Desktop"+File.separator+"ccc");
    File file6=new File("C:"+File.separator+"Users"+File.separator+"Administrator"+File.separator+"Desktop"+File.separator+"ddd");
    File file7=new File("C:"+File.separator+"Users"+File.separator+"Administrator"+File.separator+"Desktop"+File.separator+"123.bmp");
    File file8=new File("C:"+File.separator+"Users"+File.separator+"Administrator"+File.separator+"Desktop"+File.separator+"ccc.txt");

    /**
     * FileUtils:
     * cleanDirectory：清空目录，但不删除目录
     * contentEquals：比较两个文件的内容是否相同
     * copyDirectory：将一个目录内容拷贝到另一个目录。可以通过FileFilter过滤需要拷贝的文件。
     * copyFile：将一个文件拷贝到一个新的地址
     * copyFileToDirectory：将一个文件拷贝到某个目录下
     * copyInputStreamToFile：将一个输入流中的内容拷贝到某个文件
     * deleteDirectory：删除目录
     * deleteQuietly：删除文件
     * listFiles：列出指定目录下的所有文件
     * openInputSteam：打开指定文件的输入流
     * readFileToString：将文件内容作为字符串返回
     * readLines：将文件内容按行返回到一个字符串数组中
     * size：返回文件或目录的大小
     * write：将字符串内容直接写到文件中
     * writeByteArrayToFile: 将字节数组内容写到文件中
     * writeLines：将容器中的元素的toString方法返回的内容依次写入文件中
     * writeStringToFile：将字符串内容写到文件中
     */
    public void fileUtilsDemo(){

        //1.读取文件内容
        String content;
        try {
            content = FileUtils.readFileToString(file1,"gbk");
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //2.文件拷贝到指定目录
        try {
            FileUtils.copyFileToDirectory(file1,file2);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //3.文件拷贝
        try {
            FileUtils.copyFile(file1,file4);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //4.目录拷贝
        try {
            FileUtils.copyDirectory(file2,file3, pathname -> {
                //过滤：拷贝目录活html结为的文件
                if(pathname.isDirectory()||pathname.getName().endsWith("html")){
                    return true;
                }else{
                    return false;
                }

            });
        } catch (IOException e) {
            e.printStackTrace();
        }
        //5.复制文件夹下第一级内容中指定后缀文件
        //后缀文件过滤

        IOFileFilter txtSuffixFilter = FileFilterUtils.suffixFileFilter(".html");
        IOFileFilter txtFiles = FileFilterUtils.and(FileFileFilter.FILE, txtSuffixFilter);
        try {
            FileUtils.copyDirectory(file3,file5, txtFiles);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //6.复制文件目录结构及文佳佳下第一级目录内指定后缀文件
        FileFilter filter = FileFilterUtils.or(DirectoryFileFilter.DIRECTORY, txtFiles);
        //preserveFileDate参数默认为true。
        try {
            FileUtils.copyDirectory(file2,file3, filter,false);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //7.将字节从URL源复制到文件目的地。如果它们还不存在，则将创建到目的地的目录。如果已经存在，文件将被覆盖。
        try {
            URL source = new URL("http://www.pptbz.com/pptpic/UploadFiles_6909/201203/2012031220134655.jpg");
            FileUtils.copyURLToFile(source,file7,1000,1000);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //8.删除文件或目录
        try {
            // 递归删除一个目录(包括内容)。
            FileUtils.deleteDirectory(file5);
            //删除一个文件，不会抛出异常。如果文件是一个目录，删除它和所有子目录。
            FileUtils.deleteQuietly(file3);
            //清理内容而不删除它。
            FileUtils.cleanDirectory(file6);
            //删除一个文件，会抛出异常
            //如果file是文件夹，就删除文件夹及文件夹里面所有的内容。如果file是文件，就删除。
            //如果某个文件/文件夹由于某些原因无法被删除，会抛出异常
            FileUtils.forceDelete(file4);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //9.写入文件
        try {
            //把集合里面的内容写入文件，以指定字符串结束写入
            //void writeLines(File file,Collection<?> lines,String lineEnding,boolean append)
            ArrayList<String> list = new ArrayList<>();
            list.add("Java");
            list.add("JSP");
            FileUtils.writeLines(file4,"UTF-8",list,LINE_SEPARATOR_WINDOWS,true);
            //把字符串写入文件
            //参数1：需要写入的文件，如果文件不存在，将自动创建。  参数2：需要写入的内容
            //参数3：编码格式     参数4：是否为追加模式（ ture: 追加模式，把字符串追加到原内容后面）
            String data1 = "认真";
            FileUtils.writeStringToFile(file4,data1, "UTF-8", true);
            //把字节数组写入文件
            byte[] buf = {13,123,34};
            System.out.println(ArrayUtils.toString(buf));
            FileUtils.writeByteArrayToFile(file4,buf,0,buf.length,true);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        //10.读取文件及获取输入输出流
//        //将文件的内容读入一个字符串中。
//        String str =  FileUtils.readFileToString(file1,"UTF-16" );
//        FileUtils.readFileToByteArray(file8);
//        //把文件读取成字符串集合 ；Charset encoding：编码格式
        List<String> lists = null;
        try {
            lists = FileUtils.readLines(file1,"gbk");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Iterator it = lists.iterator();
        while (it.hasNext()){
            Object obj=it.next();
            System.out.println(obj);
        }
//
//        //获取输入流
//        FileUtils.openInputStream(file1);
//        //获取输出流
//        FileUtils.openOutputStream(file1);


    }

    /**
     * IOUtils:
     * buffer方法：将传入的流进行包装，变成缓冲流。并可以通过参数指定缓冲大小。
     * closeQueitly方法：关闭流
     * contentEquals方法：比较两个流中的内容是否一致
     * copy方法：将输入流中的内容拷贝到输出流中，并可以指定字符编码
     * copyLarge方法：将输入流中的内容拷贝到输出流中，适合大于2G内容的拷贝。
     * lineIterator方法：返回可以迭代每一行内容的迭代器
     * read方法：将输入流中的部分内容读入到字节数组中
     * readFully方法：将输入流中的所有内容读入到字节数组中
     * readLine方法：读入输入流内容中的一行
     * toBufferedInputStream，toBufferedReader：将输入转为带缓存的输入流
     * toByteArray，toCharArray：将输入流的内容转为字节数组、字符数组。
     * toString：将输入流或数组中的内容转化为字符串
     * write方法：向流里面写入内容
     * writeLine方法：向流里面写入一行内容
     */
    public void IOUtilsDemo(){
        //1.读取文件内容
        String content= null;
        try {
            content = IOUtils.toString(new FileInputStream("C:\\Users\\Administrator\\Desktop\\abc.txt"),"gbk");
            System.out.println(content);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //2.从一个流中读取数据
        try{
            byte[] bytes = new byte[10];
            InputStream is = IOUtils.toInputStream("hello world","utf-8");
            IOUtils.read(is, bytes);
            System.out.println(new String(bytes));

            bytes = new byte[10];
            is = IOUtils.toInputStream("hello world","utf-8");
            IOUtils.read(is, bytes, 2, 4);
            System.out.println(new String(bytes));
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //3.从流中读取内容，并转换胃String的list
        InputStream is;
        try {
            is = new FileInputStream(file1);
            List<String> lines=IOUtils.readLines(is,"gbk");
            for(String line:lines){
                System.out.println(line);
            }
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //3.从流中读取内容，并转换胃String的list
        try(InputStream ism = new FileInputStream(file1)) {
            List<String> lines=IOUtils.readLines(ism,"gbk");
            for(String line:lines){
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        //4.跳过指定长度的流
        try {
            InputStream ism=IOUtils.toInputStream("hellow world","utf-8");
            IOUtils.skip(ism,4);
            System.out.println(IOUtils.toString(ism,"utf-8"));
            ism.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //5.把数据写到输出流中
        try {
            OutputStream os=new FileOutputStream(file8,false);
            IOUtils.write("hellow world",os,"utf-8");
            IOUtils.write("\r\n",os,"utf-8");
            IOUtils.write("hellow world!!!!",os,"utf-8");
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //6.把String的List写入到输出流中
        List<String> lines = new ArrayList();
        lines.add("hello");
        lines.add("list");
        lines.add("to");
        lines.add("file");
        OutputStream os = null;
        try {
            os = new FileOutputStream(file8,true);
            IOUtils.write("\r\n",os,"utf-8");
            IOUtils.writeLines(lines, LINE_SEPARATOR_WINDOWS,os,"utf-8");
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //7.比较两个流是否相同
        try {
            InputStream is1=IOUtils.toInputStream("hello123!","utf-8");
            InputStream is2=IOUtils.toInputStream("hello123!","utf-8");
            System.out.println(IOUtils.contentEquals(is1,is2));
            is1.close();
            is2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    public static void main(String[] args){
        IOtextdemo io=new IOtextdemo();
        io.fileUtilsDemo();
        io.IOUtilsDemo();
    }
}
