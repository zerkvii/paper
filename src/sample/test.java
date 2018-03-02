//package sample;
//
//import java.io.BufferedReader;
//import java.io.FileInputStream;
//import java.io.InputStream;
//import java.io.InputStreamReader;
//
///**
// * Created by Administrator on 2017/4/30.
// */
//public class test {
//    public static void main(String[] args)throws Exception{
//        try {
////            InputStream is = new FileInputStream("src/information/detail.txt");
//            InputStream is=test.class.getResourceAsStream("../information/detail");
//
//            BufferedReader reader = new BufferedReader(
//                    new InputStreamReader(is));
//            String str = null;
//            while (true) {
//                str = reader.readLine();
//                if(str!=null)
//                    System.out.println(str);
//                else
//                    break;
//            }
//            is.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}
