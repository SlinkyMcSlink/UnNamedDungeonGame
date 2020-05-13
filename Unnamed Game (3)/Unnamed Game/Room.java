import java.util.Random;

public class Room {   
   private int doors;                                             // Number of ways in and out of the room (N, S, E, W)
   private boolean chest;                                      // Room has chest
   private boolean chestOpened;                          // if true, doesn not contain a key
   private boolean enemy;                                   // Room has enemy
   private boolean visited;                                   // Room has enemy
   private boolean hiddenRoom;                         // Room contains door to hidden room
   private int hiddenIndex;
   private int north, east, south, west;                // Index of room (in array) where door leads
   private Random rand;
   
   public Room(int d, boolean c, int n, int e, int s, int w, boolean h, int hi) {
      doors = d;
      chest = c;
      north = n;
      east = e;
      south = s;
      west = w;
      hiddenRoom = h;
      hiddenIndex = hi;
      visited = false;
   }

   public int numDoors() {
      return doors;
   }

   public boolean hasChest() {
      return chest;
   }

   public boolean chestOpened() {
      return chestOpened;
   }

   public boolean visited() {
      return visited;
   }

   public void visit() {
      visited = true;
   }

   public boolean hasEnemy() {
      return enemy;
   }

   public void setEnemy(boolean a) {
      enemy = a;
   }

   public boolean hasHiddenRoom() {
      return hiddenRoom;
   }

   public int n() {
      return north;
   }
   public int e() {
      return east;
   }
   public int s() {
      return south;
   }
   public int w() {
      return west;
   }

} // End class