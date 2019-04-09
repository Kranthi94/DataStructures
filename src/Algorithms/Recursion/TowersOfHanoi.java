// Created by Kranthi on 2019-04-08.


// Question
// There are three rods. In one rods disks will be arranged in sorted order from lowest to highest. We have to move this disks from one rod to
// another.

// Constraints
// 1) Always keep a lower disk on the higher disk.
// 2) Should move only one disk at a time.

// Things to Learn
// Simple Recursion
//
package Algorithms.Recursion;

import java.util.Stack;

public class TowersOfHanoi {

    public static void main(String[] args) {

        move(3, "A", "B", "C");
    }

    private static void move(int n, String fromRod, String apexRod, String toRod) {

        if(n == 1) {

            System.out.println("Moving disk from " +  fromRod + " " + toRod);

            return;
        }

        move(n - 1, fromRod, toRod, apexRod);

        System.out.println("Moving disk from " + fromRod + " " + toRod);

        move(n - 1, apexRod, fromRod, toRod);

//        System.out.println("Moving " + (n - 1) + " rods from " + fromRod + " " + apexRod);
    }

    private static void iterate(int n) {

        Stack<Integer> fromRod = new Stack<>();

        Stack<Integer> axillaryRod = new Stack<>();

        Stack<Integer> destinationRod = new Stack<>();

        int totalMoves = (int) (Math.pow(2, n) - 1);

        for (int i = 1; i <= n; i++) {

            fromRod.push(i);
        }

        for (int i = 1; i <= totalMoves; i++) {

            int reminder = i%n;

            if(i == 1) {

                if(destinationRod.isEmpty()) {

                    destinationRod.push(fromRod.pop());

                }else {

                    if(destinationRod.peek() > fromRod.peek()) {

                        destinationRod.push(fromRod.pop());

                    }else {

                        fromRod.push(destinationRod.pop());
                    }
                }


            }else if(i == 2) {

                if(destinationRod.isEmpty()) {

                    destinationRod.push(fromRod.pop());

                }else {

                    if(destinationRod.peek() > fromRod.peek()) {

                        destinationRod.push(fromRod.pop());

                    }else {

                        fromRod.push(destinationRod.pop());
                    }
                }
            }
        }
    }
}
