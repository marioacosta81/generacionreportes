/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testpa;

import java.math.BigDecimal;
import java.text.NumberFormat;

/**
 *
 * @author frengifo
 */
public class test {

    public static void main(String args[]) {
        
        
        String numeroId="8530003542";
            String temp="";
            long numeroIdLong=0;
            
            temp=numeroId.replaceAll("\\.", "");
            System.out.println("temp = "+temp);
            int i=temp.indexOf("-");
            System.out.println("i = "+i);
            if (i>=1)
                temp=temp.substring(0,i);
            numeroIdLong=Long.valueOf(temp);
            System.out.println(numeroIdLong);
            /*
        BigDecimal bd = BigDecimal.valueOf(.925802394);

        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(java.util.Locale.US);//getNumberInstance(java.util.Locale.US);
        numberFormat.setMaximumFractionDigits(2);
        numberFormat.setMinimumFractionDigits(2);
        String format = numberFormat.format(bd);
        format = format.substring(0, 1) + " " + format.substring(1);
        System.out.println(format);

        String ea = "4,549.497% E.A.";  //9.11% E.A.
        
           ea= ea.replaceAll(",", "");
        
        int i = ea.indexOf('.');
        int f = ea.indexOf('%');
      
        Float fl= Float.parseFloat(ea.substring(0, f).trim());
        
         NumberFormat numberFormat2 = NumberFormat.getCurrencyInstance(java.util.Locale.US);//getNumberInstance(java.util.Locale.US);
        numberFormat2.setMaximumFractionDigits(2);
        numberFormat2.setMinimumFractionDigits(2);
        String format2 = numberFormat.format(fl);
        if (format2.charAt(0)=='$')
        {
        format2=format2.substring(1);
        }
          System.out.println(format2+ea.substring(f));
//        if (i > 0 && f > 0) {
//                 System.out.println(f-i-1);
//                 if ((f-i-1)>=2)
//                 {
//                 System.out.println(ea.substring(0, f-((f-i-1)-2)));
//                 ea=ea.substring(0, f-((f-i-1)-2))+ea.substring(f);
//                 System.out.println(ea);
//                 }
//                 else
//                 {
//                     if (f-i-1>0)
//                  ea=ea.substring(0, f-((f-i-1)-1))+"0"+ea.substring(f);
//                     if (f-i-1==0)
//                ea=ea.substring(0, f-((f-i-1)-0))+"00"+ea.substring(f);
//                 System.out.println(ea);
//                 }
//        }*/
        
    }
}
