package pharmacymanagementsystem;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;

public class Medicine_services {
     
    public int search_medicine(String medicine_name){
    
    Medicine_repository c = new Medicine_repository();
    Medicine M = new Medicine();
    int flag = 0;
    if (c.search(medicine_name) == 1)  {
        JOptionPane.showMessageDialog(M, "medicine found ! ");
        flag =1 ;
    }
    else if (c.search(medicine_name) == 0)  {
        JOptionPane.showMessageDialog(M, "medicine not found ! ");
        flag = 0 ;
    }
    else {
        JOptionPane.showMessageDialog(M,"invalid Empty field ! " );
        flag = -1 ;
    }
    
        return flag;
    }
    

    public String check_expiry(String exp_date , String current_date) {
      String s = null;
      Medicine M = new Medicine();
      try{
          
      SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
      Date d1 = sdformat.parse(exp_date);
      Date d2 = sdformat.parse(current_date);

      if(d1.compareTo(d2) > 0) {
         s = "Medicine hasn't expired yet !";
         JOptionPane.showMessageDialog(M,s);
      } 
      else if(d1.compareTo(d2) < 0) {
         s = "Medicine has expired !";
         JOptionPane.showMessageDialog(M,s);
      } 
      else {
         s = "Medicine expires today !";
         JOptionPane.showMessageDialog(M,s);
      }}
      catch(ParseException e){System.out.println(e.getMessage());}
      return s;
    }
    
}
