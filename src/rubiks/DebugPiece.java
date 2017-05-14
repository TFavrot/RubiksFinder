package rubiks;

import general.Piece;


public class DebugPiece extends Piece {

    private int num;

    public DebugPiece(int num){
        this.num = num;
    }

    @Override
    public boolean equals(Piece piece) {
        if(! (piece instanceof DebugPiece)) {
            try {
                throw new Exception();
            } catch (Exception e) {
                System.err.println("Comparing uncomparable pieces is forbidden");
            }
        }

        if(piece.isDefined() && ((DebugPiece)piece).num == this.num ){
            return true;
        }
        return false;
    }

    @Override
    public void display() {
        System.out.print(num);
    }
}
