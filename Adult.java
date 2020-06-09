import java.util.ArrayList;

public class Adult extends Visitor {

    //Fields
    final int MIN_AGE = 18;
    final int MAX_AGE = 64;
    final double ENTRANCE_FEE = 20;

    //Constructor
    public Adult (int id, String firstName, String lastName, int age, Exhibit currentExhibit, Artifact currentArtifact, ArrayList<Exhibit> visitedExhibits, ArrayList<Artifact> visitedArtifacts){
        super(id,firstName, lastName, age, currentExhibit, currentArtifact, visitedExhibits, visitedArtifacts);
    }

}
