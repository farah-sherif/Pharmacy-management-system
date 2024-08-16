/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacymanagementsystem;

/**
 *
 * @author Dell
 */
public class Company_Services {
    
    public double get_score(String comp_name) throws Exception
    {
        Medicine_repository m = new Medicine_repository();
        Company_repository c = new Company_repository();
        
        int   exp = 0;
        double sum = 0 , score = 0;
        
        for (int i = 1 ; i<=3 ; i++)
        {
            sum += m.get_Sqty_C(comp_name, i);  
        }
        
        exp = c.get_exp(comp_name);
        score = exp * sum;

        return score;
    }
    
}
