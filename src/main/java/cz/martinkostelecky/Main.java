package cz.martinkostelecky;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //prints out the tower of given number of floors
        System.out.println(Arrays.toString(towerBuilder(5)));
    }

    public static String[] towerBuilder(int nFloors) {
        //declaring and initializing variables, StringBuilder and String array
        String[] tower = new String[nFloors];
        int lessSpacesLeft = nFloors-1;
        int lessSpacesRight = nFloors-1;
        int moreStars = 1;
        StringBuilder builder = new StringBuilder();
        //appending chars according to given conditions and counts in repeat methods
        for(int i = 0; i < nFloors; i++) {
            if(i == 0) {
                builder.append(" ".repeat(nFloors-1));
                builder.append("*".repeat(moreStars));
                builder.append(" ".repeat(nFloors-1));
                //adding new floor to the tower on a new line
                tower[i] = "\n" + builder;
                //setting length of a new floor to 0
                builder.setLength(0);
                //incrementing count of stars
                moreStars = moreStars + 2;
            } else {
                builder.append(" ".repeat(lessSpacesLeft-1));
                builder.append("*".repeat(moreStars));
                builder.append(" ".repeat(lessSpacesRight-1));

                tower[i] = "\n" + builder;
                builder.setLength(0);
                //decrementing count of repeat method on left side of the floor
                lessSpacesLeft -= 1;
                //decrementing count of repeat method on right side of the floor
                lessSpacesRight -= 1;
                moreStars += 2;
            }
        }
        return tower;
        }
    }