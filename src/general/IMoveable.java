package general;

import java.util.List;

/**
 * Created by thomas on 25/07/2016.
 */
public interface IMoveable {

    Move getLastMove();

    List<Move> getListMove();
    List<Piece> getListPiece();

    IMoveable executeMove(Move move);

    boolean isFinished();

    boolean checkOutCondition(IMoveable conditionCube);

    /**
     * @return the max move necessary to finish a rubiks, or a higher bound. If it is unknown,
     */
    int getMaxMoves();

    IMoveable getFormerPosition();
    void setFormerPosition(IMoveable position);

    void setLastMove(Move move);
}
