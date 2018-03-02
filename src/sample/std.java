package sample;

import java.util.HashMap;

/**
 * Created by Administrator on 2017/5/9.
 */
public class std {
    public HashMap<String,Double> safe_;
    public HashMap<String,Double[]> concret_;
    public HashMap<String,Double[]> steel_;
    public std(){
        safe_=new HashMap<>();
        safe_.put("一级",1.1);
        safe_.put("二级",1.0);
        safe_.put("三级",0.9);
        safe_.put("地震设计",1.0);
        concret_=new HashMap<>();
        Double[] fc_={7.2,9.6,11.9,14.3,16.7,19.1,21.2,23.1,25.3,27.5,29.7,31.8,33.8,35.9},
        ft_={0.91,1.10,1.27,1.43,1.57,1.71,1.80,1.89,1.96,2.04,2.09,2.14,2.18,2.22},
        ecu={0.00330,0.00330,0.00330,0.00330,0.00330,0.00330,0.00330,0.00330,0.00330,0.00325,0.00320,0.00315,0.00310,0.00305},
        beta1={0.8,0.8,0.8,0.8,0.8,0.8,0.8,0.8,0.79,0.78,0.77,0.76,0.75,0.74},
        alpha1={1.0,1.0,1.0,1.0,1.0,1.0,1.0,1.0,0.99,0.98,0.97,0.96,0.95,0.94};
        for(int i=0;i<14;i++){
            String concret="C".concat(String.valueOf(i*5+15));
            Double[] temp={alpha1[i],beta1[i],fc_[i],ft_[i],ecu[i]};
            concret_.put(concret,temp);
        }
        steel_=new HashMap<>();
        String[] steel={"HPB300","HRB335","HRBF335","HRB400","HRBF400","RRB400","HRB500","HRBF500"};
        Double[] fyl_={270.0,300.0,300.0,360.0,360.0,360.0,435.0,435.0},
                 fyy_={270.0,300.0,300.0,360.0,360.0,360.0,410.0,410.0},
                 es={2.1,2.0,2.0,2.0,2.0,2.0,2.0,2.0};

         for(int i=0;i<8;i++){
             Double[] temp={fyl_[i],fyy_[i],es[i]};
             steel_.put(steel[i],temp);
         }
    }
    public void setstd(){

    }
//    test
//    public static void main(String[] args)throws Exception{
//        std test=new std();
//        System.out.println();
//    }
}
