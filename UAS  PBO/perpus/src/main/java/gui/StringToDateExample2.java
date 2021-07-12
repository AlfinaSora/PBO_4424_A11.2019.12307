package gui;

import java.text.SimpleDateFormat;  /**/
import java.time.Duration;/**/
import java.time.LocalDate;/**/
import java.time.Period;/**/
import java.time.format.DateTimeFormatter;/**/
import java.util.Calendar;/**/
import java.util.Date; /**/ 
public class StringToDateExample2 {  
public static void main(String[] args)throws Exception {  
    
    Date harusKembali = new Date();
     Calendar c = Calendar.getInstance();
       c.setTime(harusKembali);
       c.add(Calendar.DATE, 7);
    Date kembali = c.getTime();

    
     if(kembali.after(harusKembali)){
       
        
     }
  SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
  String str1 = formatter.format(harusKembali);
  String str2 = formatter.format(kembali);
     
     LocalDate d1 = LocalDate.parse(str1, DateTimeFormatter.ISO_LOCAL_DATE);
        LocalDate d2 = LocalDate.parse(str2, DateTimeFormatter.ISO_LOCAL_DATE);
        
        Duration diff = Duration.between(d1.atStartOfDay(), d2.atStartOfDay());

        long diffDays = diff.toDays();
        System.out.println("Diffrence between dates is : "+diffDays + "days");
}
}  