package general;

import java.util.List;

/**
 * Created by thomas on 25/07/2016.
 */
public class Move {
    private List<Move> forbiddenNextMove;
    private int id;

    public Move(List<Move> forbiddenNextMove, int id) {
        this.forbiddenNextMove = forbiddenNextMove;
        this.id = id;
    }

    public List<Move> getForbiddenNextMove() {
        return forbiddenNextMove;
    }

    public int getId() {
        return id;
    }
}
