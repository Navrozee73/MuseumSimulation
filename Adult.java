import java.util.ArrayList;

public class Adult extends Visitor {

    //Fields
    final static int MIN_AGE = 18;
    final static int MAX_AGE = 64;
    final static double ENTRANCE_FEE = 20;

    //Constructor
    public Adult (int id, String firstName, String lastName, int age, Exhibit currentExhibit, Artifact currentArtifact, ArrayList<Exhibit> visitedExhibits, ArrayList<Artifact> visitedArtifacts){
        super(id,firstName, lastName, age, currentExhibit, currentArtifact, visitedExhibits, visitedArtifacts);
    }

    public Adult (int id, String firstName, String lastName, int age, Exhibit currentExhibit, Artifact currentArtifact){
        super(id,firstName, lastName, age, currentExhibit, currentArtifact);
    }
}
