package sample;

import java.io.*;

/**
 * Created by Administrator on 2017/5/9.
 */
public class model {

    public void djjx1(String[] output) throws IOException {
        InputStream djjx1_ = getClass().getResourceAsStream("../information/djjx1");
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(djjx1_));
        String str = null;

        for(int i=0;i<31;i++){
            str = reader.readLine();
            if (str != null) {
//                System.out.println(str);
          output[i]=str;
            } else break;
        }
        djjx1_.close();

    }

    public void djjx(String[] output) throws IOException {
        InputStream djjx_ = getClass().getResourceAsStream("../information/djjx");
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(djjx_));
        String str = null;

        for(int i=0;i<35;i++){
            str = reader.readLine();
            if (str != null) {
//                System.out.println(str);
                output[i]=str;
            } else break;
        }
        djjx_.close();
    }
    public void djjxl(String[] output) throws IOException {
        InputStream djjx_ = getClass().getResourceAsStream("../information/djjxl");
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(djjx_));
        String str = null;

        for(int i=0;i<35;i++){
            str = reader.readLine();
            if (str != null) {
//                System.out.println(str);
                output[i]=str;
            } else break;
        }
        djjx_.close();
    }
//test
//    public static void main(String[] args) throws Exception {
//                 model test=new model();
//                 String[] out=new String[31];
//                 test.djjx1(out);
//                System.out.println();
//    }
}
