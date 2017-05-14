package general;

import java.util.List;

/**
 * Created by thomas on 25/07/2016.
 */
public abstract class AbstractCube implements IMoveable {
    protected static List<Move> moves;
    protected List<Piece> cubeDescriptor;
    protected List<Piece> finishedCube;

    private Move lastMove;
    private IMoveable formerPosition;


    public AbstractCube(List<Move> moves, List<Piece> cubeDescriptor, List<Piece> finishedCube) {
        this.moves = moves;
        this.cubeDescriptor = cubeDescriptor;
        this.finishedCube = finishedCube;
    }

    @Override
    public final IMoveable executeMove(Move move){
        IMoveable nextPosition = executeConcreteMove(move);
        nextPosition.setFormerPosition(this);
        nextPosition.setLastMove(move);
        return nextPosition;
    }

    abstract public void displayCube();

    protected abstract IMoveable executeConcreteMove(Move move);

    @Override
    public IMoveable getFormerPosition(){
        return formerPosition;
    }

    @Override
    public void setFormerPosition(IMoveable position){
        formerPosition = position;
    }

    @Override
    public Move getLastMove() {
        return lastMove;
    }

    @Override
    public void setLastMove(Move move){
        lastMove = move;
    }

    @Override
    public List<Move> getListMove(){
        return moves;
    }

    @Override
    public List<Piece> getListPiece(){
        return cubeDescriptor;
    }

    @Override
    public boolean checkOutCondition(IMoveable cubeOutCondition){
        return checkOutCondition(cubeOutCondition.getListPiece());
    }

    public boolean checkOutCondition(List<Piece> cubeOutCondition){

        for(int i = 0; i < cubeDescriptor.size() ; i++) {
            if(!cubeOutCondition.get(i).equals(cubeDescriptor.get(i))){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean isFinished(){
        return checkOutCondition(finishedCube);
    }

    @Override
    public int getMaxMoves(){
        return -1;
    }

    @Override
    public void display(){
        displayCube();
    }
}
