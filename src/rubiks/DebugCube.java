package rubiks;

import general.AbstractCube;
import general.IMoveable;
import general.Move;
import general.Piece;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by thomas on 26/07/2016.
 * This cube is like this :
 *
 *   1 2 3 4
 *   5 6 7 8
 *
 * You can make a move to permute (1,2,3,4) to (2,3,4,1)    (x-Permutation1)
 * (And you can also do it with the second line)            (x-Permutation2)
 * Or you can make a move to turn (1,5) into (5,1)          (y-Permutation)
 * (Since it is a debug cube, I'm too lazy to code the 3 other y-Permutations)
 *
 */
public class DebugCube extends AbstractCube {

    public DebugCube() {
        super(new ArrayList<Move>(){
            {
                add(new Move(new HashMap<>(), 0, "x-Permutation0"));
                add(new Move(new HashMap<>(), 1, "x-Permutation1"));
                add(new Move(new HashMap<>(), 2, "y-Permutation"));
            }
        }, new ArrayList<Piece>(){
            {
                add(new DebugPiece(1));
                add(new DebugPiece(2));
                add(new DebugPiece(3));
                add(new DebugPiece(4));
                add(new DebugPiece(5));
                add(new DebugPiece(6));
                add(new DebugPiece(7));
                add(new DebugPiece(8));
            }
        }, null);
    }

    private DebugCube(List<Piece> pieces){
        super(new ArrayList<Move>(){
            {
                add(new Move(new HashMap<>(), 0,  "x-Permutation0"));
                add(new Move(new HashMap<>(), 1,  "x-Permutation1"));
                add(new Move(new HashMap<>(), 2,  "y-Permutation"));
            }
        }, pieces, null);
    }

    @Override
    public void displayCube() {

        List<Piece> line1 = cubeDescriptor.subList(0,4);
        List<Piece> line2 = cubeDescriptor.subList(4,8);

        line1.forEach(Piece::display);
        System.out.println("");
        line2.forEach(Piece::display);
    }

    @Override
    protected IMoveable executeConcreteMove(Move move) {

        List<Piece> line1 = cubeDescriptor.subList(0,4);
        List<Piece> line2 = cubeDescriptor.subList(4,8);

        List<Piece> newPieces = new ArrayList<>();

        if (move.getTag() == "x-Permutation0") {

            for(int i = 1; i < line1.size(); i++) {
                newPieces.add(line1.get(i));
            }
            newPieces.add(line1.get(0));

            for (int i = 0; i < line2.size(); i++) {
                newPieces.add(line2.get(i));
            }
            return new DebugCube(newPieces);
        }



        else if (move.getTag() == "x-Permutation1") {
            for(int i = 0; i < line1.size(); i++) {
                newPieces.add(line1.get(i));
            }

            for (int i = 1; i < line2.size(); i++) {
                newPieces.add(line2.get(i));
            }
            newPieces.add(line2.get(0));

            return new DebugCube(newPieces);
        }




        else if (move.getTag() == "y-Permutation") {


            newPieces.add(line2.get(0));
            newPieces.add(line1.get(1));
            newPieces.add(line1.get(2));
            newPieces.add(line1.get(3));
            newPieces.add(line1.get(0));
            newPieces.add(line2.get(1));
            newPieces.add(line2.get(2));
            newPieces.add(line2.get(3));
            return new DebugCube(newPieces);
        }
        return null;
    }
}
