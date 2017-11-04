package com.file;

import org.apache.commons.lang3.time.StopWatch;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @author wangjf
 * @date 2017/10/14 0014.
 */
public class FileUtil {

    public static void main(String[] args) throws IOException {
        StopWatch timeClock = new StopWatch();

        timeClock.start();
        FileUtil.copyFileByChannel("E:\\movie\\Need.for.Speed.2014.720p.BluRay.x264.DTS-WiKi.mkv", "E:\\test.mp4");
        timeClock.stop();

        System.out.println("总用时>>>>>>: " + timeClock.getTime());
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
