package general;

import java.util.List;

/**
 * Created by thomas on 25/07/2016.
 */
public interface IMoveable {

    List<Move> getListMove();
    List<Piece> getListPiece();

    void executeMove(Move move);

    boolean isFinished();

    boolean checkOutCondition(List<Piece> conditionCube);

    /**
     * @return the max move necessary to finish a rubiks, or a higher bound. If it is unknown,
     */
    int getMaxMoves();
}
