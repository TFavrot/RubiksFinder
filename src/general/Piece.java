package general;

/**
 * Created by thomas on 25/07/2016.
 */
public abstract class Piece {
    protected boolean isDefined = true;

    public abstract boolean equals(Piece piece);

    public boolean isDefined(){
        return isDefined;
    }

    public void setUndefined(){
        isDefined = false;
    }

    public abstract void display();
}
