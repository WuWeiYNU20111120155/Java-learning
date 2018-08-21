package com.lesson1.java;
import java.io.*;


public class FakeFile {
    public static String fileName;

    //设置文件路径
    public void setFilePath(String fileName){
        this.fileName = fileName;
        System.out.println("设置路径成功！");
    }
    //读取文件内容
    public String readToString() {
        FileInputStream input = null;
        String context = "defaul";
        try {
            input = new FileInputStream(this.fileName);
            InputStreamReader reader = new InputStreamReader(input,"UTF-8");
            BufferedReader bufferedReader = new BufferedReader(reader);
            System.out.println("bufferedReader"+reader);
            try {
                String line = null;
                while ((line = bufferedReader.readLine()) != null) {
                    context += line;
                    System.out.println("context"+context);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("请输入正确文件名"+e);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            System.out.println("文件内没有内容"+e);
        }

        return context;

    }
    //写入文件
    public void writeString(String contennt) throws FileNotFoundException, UnsupportedEncodingException {
        FileOutputStream output = new FileOutputStream(this.fileName);
        OutputStreamWriter writer = new OutputStreamWriter(output, "UTF-8");
        PrintWriter printer = new PrintWriter(writer);
    }



}
