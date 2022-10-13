package model;

import core.Constants;

import java.util.ArrayList;
import java.util.Hashtable;

public class Node {
    Board board;
    Node parent;
    Movement previousMovement;
    private Hashtable<String, Boolean> repeatedStates;


    public Node(Board board, Node parent, Movement previousMovement, Hashtable<String, Boolean> repeated) {
        this.parent = parent;
        this.board = board;
        this.previousMovement = previousMovement;
        Hashtable<String, Boolean> hashtableTemp = new Hashtable<String, Boolean>(repeated);
        hashtableTemp.put(this.hash(), true);
        this.repeatedStates = hashtableTemp;
    }

    public ArrayList<Node> successor() {
        ArrayList<Node> result = new ArrayList<Node>();
        result.add(new Node(board.moveLeft(), this, Movement.LEFT, repeatedStates));
        result.add(new Node(board.moveRight(), this, Movement.RIGHT, repeatedStates));
        result.add(new Node(board.moveDown(), this, Movement.DOWN, repeatedStates));
        result.add(new Node(board.moveUp(), this, Movement.UP, repeatedStates));
        return result;
    }


    public void drawState() {
        System.out.println("moved to : " + this.previousMovement);
        for (int i = 0; i < board.row; i++) {
            for (int j = 0; j < board.col; j++) {
                System.out.print(Constants.ANSI_BRIGHT_GREEN + board.cells[i][j] + spaceRequired(board.cells[i][j]));
            }
            System.out.println();

        }
        System.out.println("-----------------------------------------");

    }

    public boolean isGoal() {
        return board.isGoal();
    }

    public int pathCost() {
        //todo
        return 1;
    }

    public int heuristic() {
        // TODO: 2/16/2022 implement heuristic function
        return 0;
    }

    public String hash() {
        StringBuilder hash = new StringBuilder();
        hash.append(board.hash()).append("/PM=").append(previousMovement.toString());
        return hash.toString();
    }

    private String spaceRequired(int cell) {
        int length = String.valueOf(cell).length();
        String result = " ".repeat(5 - length);
        result += " ";
        return result;
    }

    public Node getParent() {
        return parent;
    }
}
