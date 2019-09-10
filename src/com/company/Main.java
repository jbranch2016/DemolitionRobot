package com.company;


public class Main {

    /*
        -Test case:
        Input:
        numRows= 3
        numColumns= 3
        lot=
        [[1, 0, 0],
        [1, 0, 0],
        [1, 9, 1]]
     */
    public static void main(String[] args){
        int[][] lotIn = {
                {1,0,0,1,1},
                {1,1,0,1,1},
                {0,1,1,1,1},
                {1,1,0,1,0},
                {1,1,1,9,0},
                {1,1,0,0,0},
                {0,1,1,1,1}
        };
        /*
        int[][] lotIn ={
                {1,0,0},
                {1,0,0},
                {1,9,1}
        };
        */

        com.company.DemolitionRobot dRobot = new com.company.DemolitionRobot(7,5,lotIn);
        Integer distance = dRobot.findMinDistance(0,0,0);
        System.out.println("distance="+String.valueOf(distance));

    }

}
