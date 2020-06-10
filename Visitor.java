/*

User: Navroze
Date: 09/06/2020
Changes Made: Incorporated Error throwing
*/
import java.util.*;

abstract class Visitor {

    //Fields
    private int id;
    private String firstName;
    private String lastName;
    private int age;
    private Exhibit currentExhibit;
    private Artifact currentArtifact;
    private ArrayList <Exhibit> visitedExhibits;
    private ArrayList <Artifact> visitedArtifacts;

    //Default constructor if no parameters are entered
    public Visitor (){
        id = 0000;
        firstName = "firstName";
        lastName = "lastName";
        age = 0;
    }

    //Main constructor
    public Visitor (int id, String firstName, String lastName, int age, Exhibit currentExhibit, Artifact currentArtifact, ArrayList <Exhibit> visitedExhibits, ArrayList <Artifact> visitedArtifacts){
       
        if (id > 100000 && (id+"").length() == 6)
            this.id = id;
        else
            throw new InputMismatchException();
            
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.currentExhibit = currentExhibit;
        this.currentArtifact = currentArtifact;
        this.visitedExhibits = visitedExhibits;
        this.visitedArtifacts = visitedArtifacts;
    }

    //Accessors
    public int getId (){
        return id;
    }

    public String getFirstName (){
        return firstName;
    }

    public String getLastName (){
        return lastName;
    }

    public int getAge (){
        return age;
    }

    public Exhibit getCurrentExhibit (){
        return currentExhibit;
    }

    public Artifact getCurrentArtifact (){ return currentArtifact; }

    public ArrayList<Exhibit> getVisitedExhibits (){
        return visitedExhibits;
    }

    public ArrayList<Artifact> getVisitedArtifacts (){
        return visitedArtifacts;
    }

    //Mutators
    public void setId (int id){
    
        if (id > 100000 && (id+"").length() == 6)
            this.id = id;
        else
            throw new InputMismatchException();
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
         this.lastName = lastName; 
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCurrentArtifact(Artifact currentArtifact) {
        this.currentArtifact = currentArtifact;
    }

    public void setCurrentExhibit(Exhibit currentExhibit) {
        this.currentExhibit = currentExhibit;
    }

    public void setVisitedArtifacts(ArrayList<Artifact> visitedArtifacts) {
        this.visitedArtifacts = visitedArtifacts;
    }

    public void setVisitedExhibits(ArrayList<Exhibit> visitedExhibits) {
        this.visitedExhibits = visitedExhibits;
    }

    //Compare Visitor Age
    public int compareAge (Visitor other){
        return this.getAge() - other.getAge();
    }

    //Compare the number of exhibits visited by two visitors
    public int compareExhibitVisits (Visitor other){
        int output;
        output = (this.getVisitedExhibits()).size() - (other.getVisitedExhibits()).size();
        return output;
    }

    //Compare the number of artifacts visited by two visitors
    public int compareArtifactVisits (Visitor other){
        int output;
        output = (this.getVisitedArtifacts()).size() - (other.getVisitedArtifacts()).size();
        return output;
    }

    //Compare to see if two visitors are the same
    public boolean visitorEquals (Visitor other){
        if (this.id == other.id){
            return true;
        } else {
            return false;
        }
    }

    //ToString method
    public String toString (){
        String output;
        //Output fields
        output = "ID - " + id + "\n First Name - " + firstName + "\n Last Name - " + lastName + "\n Age - " + age + "\n Current Exhibit - " + currentExhibit + "\n Current Artifact - " + currentArtifact;
        //Output visited artifact and exhibit lists
        output = output + "\n Visited Artifacts - ";
        for (int i = 0; i < visitedArtifacts.size(); i++){
            output = output + ((visitedArtifacts.get(i)).getName() + ", ");
        }
        output = output + "\n Visited Exhibits - ";
        for (int i = 0; i < visitedExhibits.size(); i++){
            output = output + ((visitedExhibits.get(i)).getName() + ", ");
        }
        return output;
    }
    //Identifier ToString method    
    public String identifierToString()
    {
       return ("Full Name: " + firstName + " " + lastName + " ID: " + id);
    }

}
