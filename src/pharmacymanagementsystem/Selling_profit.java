package pharmacymanagementsystem;
/**
 * @author ghada
 */
public class Selling_profit {
    public double Selling_Profit_calc( float total_paid) {
        double profit = 0;
        if(total_paid>0)
        {
            profit = total_paid * 0.05;
        }
        else
        {
            System.out.println("ERROR");
            return -1;
        }
        return profit;
    }
}