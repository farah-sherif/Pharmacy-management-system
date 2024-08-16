/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pharmacymanagementsystem;

/**
 *
 * @author Hp
 */
public class Agents_Services {
     
    int Time1;
    int Time2;
    int Total_Time=0;

    public int getTime1() {
        return Time1;
    }

    public int setTime1(int Time1) {
        this.Time1 = Time1;
        return this.Time1;
    }

    public int getTime2() {
        return Time2;
    }

    public int setTime2(int Time2) {
        this.Time2 = Time2;
        return this.Time2;
    }
    
  public int getTotal_Time() {
        return Total_Time;
    }

    public int setTotal_Time(int Total_Time) {
        this.Total_Time = Total_Time;
        return this.Total_Time;
    }
   public int Calculate_Time(int startTime, int endTime) {
       // startTime = this.Time1;
        //endTime = this.Time2;
        Total_Time = endTime-startTime;
        if (Total_Time>0) {
           
        }
        else if (Total_Time<0) {
            Total_Time = 12 - startTime + endTime;
        }
        else 
                { 
                    Total_Time=12;
                }
       
        return Total_Time;

    }

  

    public int calculateSalary(int startTime, int endTime)  {
       // startTime = this.Time1;
        //endTime = this.Time2;
       Calculate_Time( startTime,  endTime);
        int Salary = 0;

            Salary = Total_Time * 67;
      
        return Salary;

    }

    }


