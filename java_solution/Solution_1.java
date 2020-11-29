//note: The given array contains 5 values
// My Approach
// * Find out the number of times a score occurs 
// * If a score count reaches three, assign the appopriate points and subtract 3 from count
// * check if the scores 1 and 5 have occurences greater than one and assign appopriate points

public class Solution_1{
    public static int greedy(int[] dice){

        // > FINDING OUT THE NUMBER OF TIMES A SCORE OCCURS
        // I need a variable to represent each score and hold it's value
        // I chose to use an array called 'count', so each score's is represented by the index of score-1
        int[] count = new int[5];
        // so inversely the variable for each score => count[score-1]
        // I handled the count process with a foreach loop
        // it iterates the values of the given array, checks scores and assigns count using a switch case
        for (int score: dice) {
            switch (score){
                case 1:
                    count[0]++;
                    break;
                case 2:
                    count[1]++;
                    break;
                case 3:
                    count[2]++;
                    break;
                case 4:
                    count[3]++;
                    break;
                case 5:
                    count[4]++;
                    break;
                case 6:
                    count[5]++;
            }
        } 

        // > CHECKING IF THERE'S A COUNT OF 3 AND ASSIGNING POINTS
        // A variable to hold the points is needed
        int points = 0;
        //check if there is a count of 3 in the count array, using a fori loop to keep track of the score value being iterated
        for (int i = 0, score = i+1 ; i < count.length; i++) {
            //if found
            if(count[i] > 2){
            // assign points
            // * points system for 3 occurrences
            //      Three 1's => 1000 points
            //      Three 6's =>  600 points
            //      Three 5's =>  500 points
            //      Three 4's =>  400 points
            //      Three 3's =>  300 points
            //     - score 1's point is a special case
            //     - for the rest, points awarded = score*100
                if(score == 1){
                    points += 1000;
                    count[i] -= 3;
                }else{
                    points += (score *100);
                    count[i] -= 3;
                }
            }
        }
        
        // > CHECKING IF THE SCORE 1 AND 5 HAVE OCCURRENCES > 0 AND ASSIGNING POINTS IF TRUE
        //if true
        if(count[0] > 0)
            points += (100* count[0]);
        if(count[4] > 0)
            points += (50 * count[4]);
        return points;
    }

    public static void main(String[] args){
        // > Some test cases
        // // 5 1 3 4 1   250:  50 (for the 5) + 2 * 100 (for the 1s)
        // // 1 1 1 3 1   1100: 1000 (for three 1s) + 100 (for the other 1)
        // 2 4 4 5 4   450:  400 (for three 4s) + 50 (for the 5)

        int[] test = {5,1,3,4,1};

        System.out.println(greedy(test));

    }

}