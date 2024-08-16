/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacymanagementsystem;

import javax.swing.JOptionPane;

/**
 *
 * @author hanaa
 */
public class Selling_Price_Service {
    
    Selling_repository sc = new Selling_repository();
    public float Selling_Price_calc(String medName, int medQty) {
        Selling S = new Selling();
        float selling_price;
        int old_Qty=0 ;
        old_Qty = sc.getMed_Qty(medName);
        if(old_Qty==0){
            JOptionPane.showMessageDialog(S,"No Available Quantity");
            return (float) 0.0 ;
        }else if(medQty<=0){ 
            JOptionPane.showMessageDialog(S,"Wrong in required Quantity");
            return (float) 0.0 ;
        }else if(medQty>old_Qty){ 
            JOptionPane.showMessageDialog(S,"The Available Quantity is " + old_Qty +",you can get this only");
            medQty=old_Qty;
        }
        
        float price = sc.getMed_Price(medName);
        selling_price = (float) (price + (price * 0.10))* medQty ;
        return selling_price;
    }

}