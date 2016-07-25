package general;

import java.util.List;

/**
 * Created by thomas on 25/07/2016.
 */
public abstract class AbstractCube implements IMoveable {
    private List<Move> moves;
    private List<Piece> cubeDescriptor;

    private List<Piece> finishedCube;




    @Override
    public List<Move> getListMove(){
        return moves;
    }

    @Override
    public List<Piece> getListPiece(){
        return cubeDescriptor;
    }

    @Override
    public boolean checkOutCondition(List<Piece> cubeOutCondition){
        for(int i = 0; i < cubeDescriptor.size() ; i++) {
            if(cubeOutCondition.get(i).equals(cubeDescriptor.get(i))){
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
}
