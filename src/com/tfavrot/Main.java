package com.tfavrot;

import general.IMoveable;
import general.Move;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        //
        // Main Algorithm : BFS.
        //


        // TODO:
        // Initialize the starting position.
        IMoveable position = null;

        // TODO:
        // Initialize the endCondition.
        IMoveable endCondition = null;

        Queue<IMoveable> mainQueue = new ArrayDeque<>();
        mainQueue.add(position);

        // Key : Son
        // Value : Father
        Map<IMoveable, IMoveable> visitedPosition = new HashMap<>();

        boolean stop = false;

        while((position = mainQueue.poll()) != null && !stop){

            if(position.checkOutCondition(endCondition)){
                stop = true;
            }
            else if(!visitedPosition.containsKey(position)){

                visitedPosition.put(position, position.getFormerPosition());
                List<Move> nextMoves = position.getListMove();

                for(int i = 0; i < nextMoves.size(); i++){

                    if (! position.getLastMove().getForbiddenNextMove().containsKey(nextMoves.get(i).getId()) ) {
                        mainQueue.add(position.executeMove(nextMoves.get(i)));
                    }
                }
            }

        }

        Deque<Move> formula = new LinkedList<>();

        while(visitedPosition.get(position) != null){
            formula.addLast(position.getLastMove());
        }

        System.out.println("\n\nFormula Found : \n");
        for(Move m: formula){
            System.out.println(m.getTag());
        }

    }
}
