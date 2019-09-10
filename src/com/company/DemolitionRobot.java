package com.company;

import java.util.Stack;

public class DemolitionRobot {
    private int[][] lot;
    private Integer numRows;
    private Integer numCols;
    private boolean[][] visited;
    private Integer minDistance;

    public DemolitionRobot(Integer numRowsIn, Integer numColsIn, int[][] lotIn){
        visited = new boolean[numRowsIn][numColsIn];
        numRows = numRowsIn;
        numCols = numColsIn;
        lot = lotIn.clone();
        minDistance = null;
    }

    public Integer findMinDistance(Integer row, Integer col, int distance){
        Integer retVal = -1;

        if(visited[row][col]){
            retVal = -1;
        }else if(lot[Integer.valueOf(row)][Integer.valueOf(col)] == 9) {
            if (minDistance == null || distance < minDistance) {
                minDistance = distance;
            }
            retVal = distance;
        }else if(lot[Integer.valueOf(row)][Integer.valueOf(col)] == 0){
            visited[row][col] = true;
            retVal = -1;
        } else{
            if(minDistance==null || distance<minDistance) {
                visited[row][col] = true;
                int[] first = {row, col - 1};
                int[] second = {row - 1, col};
                int[] third = {row, col + 1};
                int[] forth = {row + 1, col};
                retVal = minOfFourValue(first, second, third, forth, distance + 1);
            }else{
                retVal = -1;
            }
        }

        return retVal;
    }

    private Integer minOfFourValue(int[] first, int[] second, int[] third, int[] forth, int distance) {
        int firstRetVal=-1,secondRetVal=-1,thirdRetVal=-1, forthRetVal=-1;
        Stack s = new Stack();
        int minVal = 10000;
        //check to make sure we stay inside the grid
        if(checkLotBoundary(first)){
            firstRetVal = findMinDistance(first[0],first[1],distance);
        }
        if(checkLotBoundary(second)){
            secondRetVal = findMinDistance(second[0],second[1],distance);
        }
        if(checkLotBoundary(third)){
            thirdRetVal = findMinDistance(third[0],third[1],distance);
        }
        if(checkLotBoundary(forth)){
            forthRetVal = findMinDistance(forth[0],forth[1],distance);
        }

        if(firstRetVal>-1&&firstRetVal<minVal){
            minVal = firstRetVal;
        }
        if(secondRetVal>-1&&secondRetVal<minVal){
            minVal = secondRetVal;
        }
        if(thirdRetVal>-1&&thirdRetVal<minVal){
            minVal = thirdRetVal;
        }
        if(forthRetVal>-1&&forthRetVal<minVal){
            minVal = forthRetVal;
        }
        if(minVal == 10000){
            minVal = -1;
        }
        return minVal;
    }

    private boolean checkLotBoundary(int[] param) {
        boolean retVal = true;
        if(param[0]<0 || param[1]<0 || param[0]>=numRows || param[1]>=numCols){
            retVal = false;
        }
        return retVal;
    }


}
