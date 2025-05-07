// This class contains the attributes for each team and the run() method that dictates the behavior
// of each contender thread.

public class Contender implements Runnable {
    private String teamName;
    private int pointsScored = 0;
    private int actionAmount; // Represents how many points are scored per action
    private int maxRest; // Represents the max amount of time the contender rests
    private Water drink; // Shared Water object

    // Constructor
    public Contender(String teamName, int actionAmount, int maxRest, Water drink) {
        this.teamName = teamName;
        this.actionAmount = actionAmount; // New parameter that determines how much is scored per action
        this.maxRest = maxRest; // New parameter to determine rest time
        this.drink = drink; // Uses the shared Water object
    }

    // Getters
    public String getTeamName() {
        return teamName;
    }

    public int getPointsScored() {
        return pointsScored;
    }

    // run method class is implemented from the Runnable interface,
    public void run() {
        try {
            while (pointsScored < 200 && !UltimateBattleApp.gameFinished) { // Stop if the game is finished
                int restTime = (int) (Math.random() * maxRest); // Randomized rest time up to maxRest
                Thread.sleep(restTime); // The contender rests before performing an action

                pointsScored += actionAmount; // The contender scores points
                System.out.println(teamName + " scores! Total: " + pointsScored + " points");

                // Declare the winner when 200 points are reached
                if (pointsScored >= 200) {
                    UltimateBattleApp.gameFinished = true; // Stops all threads
                    System.out.println( teamName + " wins the basketball game!");
                    break;
                }

                // Once points reach 75, teams will go for a water break
                if (pointsScored >= 75 && pointsScored <= 80) { // break is taken around 75 points
                     // only one team drinks at a time
                        drink.waterBreak(teamName);
                    }
                }

        } catch (InterruptedException e) {
            System.out.println(teamName + " was interrupted.");
        }
    }
}
