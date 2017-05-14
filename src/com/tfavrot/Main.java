package com.tfavrot;

import general.IMoveable;
import general.Move;
import rubiks.DebugCube;

import java.util.*;


public class Main {



    public static void main(String[] args) {
        //
        // Main Algorithm : BFS.
        //


        // TODO:
        // Initialize the starting position.
        IMoveable position = new DebugCube();

        // TODO:
        // Initialize the endCondition.
        IMoveable endCondition = position.executeMove(position.getListMove().get(0)).
                                          executeMove(position.getListMove().get(2)).
                                          executeMove(position.getListMove().get(0));

        System.out.println("Initial position : ");
        position.display();
        System.out.println("\n");
        System.out.println("Final position :");
        endCondition.display();


        Queue<IMoveable> mainQueue = new ArrayDeque<>();
        mainQueue.add(position);

        // Key : Son
        // Value : Father
        Map<IMoveable, IMoveable> visitedPosition = new HashMap<>();

        boolean stop = false;

        IMoveable fetcher;

        while((fetcher = mainQueue.poll()) != null && !stop){
            position = fetcher;
            if(position.checkOutCondition(endCondition)){
                stop = true;
                visitedPosition.put(position, position.getFormerPosition());
            }
            else if(!visitedPosition.containsKey(position)){

                visitedPosition.put(position, position.getFormerPosition());
                List<Move> nextMoves = position.getListMove();

                for(int i = 0; i < nextMoves.size(); i++){

                    if (position.getLastMove() == null ||
                            ! position.getLastMove().getForbiddenNextMove().containsKey(nextMoves.get(i).getId()) ) {
                        mainQueue.add(position.executeMove(nextMoves.get(i)));
                    }
                }
            }

        }

        Deque<Move> formula = new LinkedList<>();

        while(visitedPosition.get(position) != null){
            formula.addLast(position.getLastMove());
            position = visitedPosition.get(position);
        }

        System.out.println("\n____________________\nFormula Found : \n");
        for(Move m: formula){
            System.out.println(m.getTag());
            IMoveable showcase = position.executeMove(m);
            showcase.display();
            System.out.println("\n");
        }



    }
}
