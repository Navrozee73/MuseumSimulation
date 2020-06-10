import java.util.ArrayList;

public class Senior extends Visitor {

    //Fields
    final static int MIN_AGE = 65;
    final static double ENTRANCE_FEE = 15;

    //Constructor
    public Senior (int id, String firstName, String lastName, int age, Exhibit currentExhibit, Artifact currentArtifact, ArrayList<Exhibit> visitedExhibits, ArrayList<Artifact> visitedArtifacts){
        super(id,firstName, lastName, age, currentExhibit, currentArtifact, visitedExhibits, visitedArtifacts);
    }

}
