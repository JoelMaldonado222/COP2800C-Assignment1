// This class represents a shared Water resource used by multiple contenders
public class Water {

    // This method ensures only one contender drinks at a time
    public synchronized void waterBreak(String teamName) {
        System.out.println(teamName + " is taking a water break...");

        try {
            Thread.sleep(50); // Simulating the time taken for a water break
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(teamName + " finished their water break!");
    }
}
