package com.file;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.filefilter.NameFileFilter;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.regex.Pattern;

/**
 * @author wangjf
 * @date 2017/10/14 0014.
 */
public class FileUtil {

    public static void main(String[] args) throws IOException {
        File dir = new File(".");
        String[] files = dir.list(new NameFileFilter("pom.xml"));
//        String[] files = dir.list();
        for (int i = 0; i < files.length; i++) {
            System.out.println(files[i]);
        }
    }

    /**
     * 通过正则表达式对文件名进行过滤
     *
     * @param filePath 文件路径
     * @param regex 正则表达式
     *
     * @return
     */
    public static String[] filterFileByFilename(String regex, String filePath){
        File path = new File(filePath);
        String[] list = path.list(new FilenameFilter() {
            private Pattern pattern = Pattern.compile("");
            public boolean accept(File dir, String name) {
                return pattern.matcher(name).matches();
            }
        });

        Arrays.sort(list, String.CASE_INSENSITIVE_ORDER);

        return list;
    }

    /**
     * 总用时>>>>>>: 152831
     * 采用字节流的形式拷贝文件
     *
     * @param srcFilePath    原文件路径
     * @param targetFilePath 目标文件路径
     */
    public static void copyFileByByte(String srcFilePath, String targetFilePath) throws IOException {

        FileInputStream fis = new FileInputStream(new File(srcFilePath));

        File targetFile = new File(targetFilePath);

        if(!targetFile.exists()) {
            targetFile.createNewFile();
        }

        FileOutputStream fos = new FileOutputStream(targetFile);

        int n = 0;// 每次读取的字节长度
        byte[] bb = new byte[100 * 1024 * 1024];// 存储每次读取的内容
        while ((n = fis.read(bb)) != -1) {
            fos.write(bb, 0, n);// 将读取的内容，写入到输出流当中
        }

        // 关闭输入输出流
        fos.close();
        fis.close();
    }

    /**
     * 通过字符串的形式拷贝文件
     * */
    public static void copyFileByStr(String srcFilePath, String targetFilePath) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(srcFilePath));
        PrintWriter pw = new PrintWriter(targetFilePath);

        char[] c = new char[100 * 1024 * 1024];
        while (br.read(c) != -1) {
            pw.print(c);
        }

        pw.close();
        br.close();
    }

    /**
     * 总用时>>>>>>: 138 820
     * 通过通道的形式拷贝文件
     * */
    public static void copyFileByChannel(String srcFilePath, String targetFilePath) throws IOException {
        FileChannel read = new RandomAccessFile(srcFilePath,"r").getChannel();
        FileChannel writer = new RandomAccessFile(targetFilePath,"rw").getChannel();

        ByteBuffer bb = ByteBuffer.allocate(100 * 1024 * 1024);

        while(read.read(bb)!=-1){
            bb.flip();
            writer.write(bb);
            bb.clear();
        }

        read.close();
        writer.close();
    }

    /**
     * RandomRead and RandomWrite
     *
     * 55秒
     * */
    public static void copyFileByRandomAccess(String srcFilePath, String targetFilePath) throws IOException {
        RandomAccessFile read = new RandomAccessFile(srcFilePath,"r");
        RandomAccessFile writer = new RandomAccessFile(targetFilePath,"rw");

        byte[] b = new byte[100 * 1024 * 1024];
        while(read.read(b) != -1){
            writer.write(b);
        }

        writer.close();
        read.close();
    }










}
