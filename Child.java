import java.util.ArrayList;

public class Child extends Visitor{

    //Fields
    final static int MIN_AGE = 1;
    final static int MAX_AGE = 17;
    final static double ENTRANCE_FEE = 10;

    //Constructor
    public Child (int id, String firstName, String lastName, int age, Exhibit currentExhibit, Artifact currentArtifact, ArrayList<Exhibit> visitedExhibits, ArrayList<Artifact> visitedArtifacts){
        super(id, firstName, lastName, age, currentExhibit, currentArtifact, visitedExhibits, visitedArtifacts);
    }

}
