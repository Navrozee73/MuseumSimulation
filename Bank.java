import java.util.ArrayList;

public class Bank {

    //Fields
    private double lifetimeRevenue;
    private Date currentDate;
    private ArrayList <Double> dailyRevenue;
    private ArrayList <Date> dailyRevenueDates;


    //Accessors
    public double getLifetimeRevenue () {
        return lifetimeRevenue;
    }

    public Date getCurrentDate (){
        return currentDate;
    }

    public ArrayList<Double> getDailyRevenue (){
        return dailyRevenue;
    }

    public ArrayList <Date> getDailyRevenueDates () { 
    return dailyRevenueDates; 
    }

    //Mutators
    public void setLifetimeRevenue (double lifetimeRevenue){
        this.lifetimeRevenue = lifetimeRevenue;
    }

    public void setDailyRevenue (ArrayList<Double> dailyRevenue){
        this.dailyRevenue = dailyRevenue;
    }

    public void setCurrentDate (Date currentDate){
        this.currentDate = currentDate;
    }

    public void setDailyRevenueDates (ArrayList<Date> dailyRevenueDates) {
        this.dailyRevenueDates = dailyRevenueDates;
    }

    //Default Constructor
    public Bank (){
        lifetimeRevenue = 0;
        dailyRevenue = new ArrayList<Double>();
    }

    //Main Constructor
    public Bank (double lifetimeRevenue, ArrayList<Double> dailyRevenue, ArrayList<Date> dailyRevenueDates, Date currentDate){
        this.lifetimeRevenue = lifetimeRevenue;
        this.dailyRevenue = dailyRevenue;
        this.currentDate = currentDate;
        this.dailyRevenueDates = dailyRevenueDates;
    }

    //Prints revenue on a certain date
    public void printRevenue (Date selectedDate){
        //Create necessary variables
        int selectedElement = -1;
        //Find selected element
        for (int i = 0; i < dailyRevenueDates.size(); i++){
            if ((dailyRevenueDates.get(i)).equals(selectedDate)){
                selectedElement = i;
            }
        }
        //Find selected revenue amount
        double selectedRevenue = dailyRevenue.get(selectedElement);
        //Output message
        System.out.println("The revenue on " + selectedDate.identifierToString() + " is $" + selectedRevenue);
    }

    //Prints revenue between a range of dates
    public void printRangeRevenue (Date selectedDate1, Date selectedDate2){
        //Create necessary variables
        int elementRangeStart = -1;
        int elementRangeEnd = -1;
        double totalRevenue = 0;
        //Find starting element
        for (int i = 0; i < dailyRevenueDates.size(); i++){
            if ((dailyRevenueDates.get(i)).equals(selectedDate1)){
                elementRangeStart = i;
            }
        }
        //Find ending element
        for (int i = 0; i < dailyRevenueDates.size(); i++){
            if ((dailyRevenueDates.get(i)).equals(selectedDate2)){
                elementRangeEnd = i;
            }
        }
        //Add revenues together
        for (int i = 0; i < dailyRevenue.size(); i++){
            if (i >= elementRangeStart && i <= elementRangeEnd){
                totalRevenue = totalRevenue + dailyRevenue.get(i);
            }
        }
        //Output message
        System.out.println("Total revenue for the selected period - $" + totalRevenue);
    }

    //Adds revenue to today's amount
    public void addRevenue (double revenue){
        //Calculates new revenue
        double newRevenue = revenue + dailyRevenue.get(dailyRevenue.size() - 1);
        //Adds revenue to today's daily revenue amount
        dailyRevenue.set((dailyRevenue.size() - 1), newRevenue);
        //Updates lifetime revenue amount
        updateLifetimeRevenue(revenue);
    }

    //ToString method
    public String toString (){
        String output;
        output = "Bank Information \n Lifetime Revenue : $" + lifetimeRevenue;
        return output;
    }

    public boolean equals (Bank other){
        boolean isEqual = true;
        if (!(this.lifetimeRevenue == other.lifetimeRevenue)){
            isEqual = false;
        }
        if (!(this.currentDate == other.currentDate)){
            isEqual = false;
        }
        if (!(this.dailyRevenue.equals(other.dailyRevenue))){
            isEqual = false;
        }
        if (!(this.dailyRevenueDates.equals(other.dailyRevenueDates))){
            isEqual = false;
        }
        return isEqual;
    }

    //Update lifetime revenue
    private void updateLifetimeRevenue (double addedRevenue){
        lifetimeRevenue = lifetimeRevenue + addedRevenue;
    }
}
