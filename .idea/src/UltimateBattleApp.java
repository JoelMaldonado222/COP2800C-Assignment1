// ultimate battle will create several team threads and sim a basketball game
// first team to score 200 points wins

public class UltimateBattleApp {

    public static volatile boolean gameFinished = false; // Keeps track of when the game is over

    public static void main(String[] args) {

        // creates several Contender objects
        Water drink = new Water(); // Shared Water object to be used by both contenders

        Contender[] competitors = new Contender[]{
                new Contender("Knicks", 2, 100, drink),  // Scores 2 points, max rest 100ms
                new Contender("Celtics", 1, 50, drink)   // Scores 1 point, max rest 50ms
        };

        // creates array of threads, one for each competitor
        Thread[] competitorsThreads = new Thread[competitors.length];

        for (int i = 0; i < competitors.length; i++) {
            competitorsThreads[i] = new Thread(competitors[i]); // Each contender gets a separate thread
        }

        // starts the basketball game
        for (Thread score : competitorsThreads) {
            score.start(); // Starts the individual threads
        }

        System.out.println(" The Basketball Game Has Begun! ");

        // determine the winner of the game
        while (!gameFinished) { // Continues checking until a team reaches 200 points
            try {
                Thread.sleep(500); // Allows time for game updates without overwhelming the console
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        // stops remaining threads if game is over
        for (int i = 0; i < competitors.length; i++) {
            if (competitors[i].getPointsScored() < 200) { // Interrupts threads that haven't reached 200
                competitorsThreads[i].interrupt();
            }
        }

        System.out.println(" Game Over!");
    }
}
