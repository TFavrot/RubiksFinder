package general;

import java.util.List;
import java.util.Map;

/**
 * Created by thomas on 25/07/2016.
 */
public class Move {
    private Map<Integer, Move> forbiddenNextMove;
    private int id;
    private String tag;

    public Move(Map<Integer, Move> forbiddenNextMove, int id, String tag) {
        this.forbiddenNextMove = forbiddenNextMove;
        this.id = id;
    }

    public Map<Integer, Move> getForbiddenNextMove() {
        return forbiddenNextMove;
    }

    public int getId() {
        return id;
    }

    public String getTag(){
        return tag;
    }
}
