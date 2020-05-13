import java.util.ArrayList;

public class Player {
   private int position;                                   // Current index of dungeon array where the player currently is
   private String name;                                  // Name of player
   private int perception;                               // Stat that decides how much of the room is revealed
   private int attack;                                      // Damage done by player
   private int hp;
   private int maxHP;                                            // Health of player
   private ArrayList<Item> inventory;        // What items the player is holding  
   private  int gold;                                        // Money
   private  int keys;                                        // Number of keys found
   private  int level;                                        // Player level
   private  int exp;                                          // Exp bar
   private  boolean hasMap = true;

   public Player(String n){
      position = 0; 
      name = n;                                
      perception = 0;            
      attack = 10;            
      hp = 50;
      maxHP = 50;                        
      inventory = new ArrayList<Item>();   
      gold = 0;                                    
      keys = 0;                                
      level = 1;                          
      exp = 0;
   }
   public void gainExp(int a) {
      exp += a;
      while (exp >= 100) {
         level++;
         perception += (level * 5);
         attack += (level  * 10); 
         maxHP += (level * 15);
         hp = maxHP;
         exp -= 100;
         System.out.println("You leveled up! You are now level " + level + ".");
         System.out.println("Your perception increased to " + perception + ".");
         System.out.println("Your attack increased to " + attack + ".");
         System.out.println("Your health increased to " + hp + ".");
         System.out.println("" + (100 - exp) + " exp left until the next level.\n");
      }
   }

   public boolean hasMap() {
      return hasMap;
   }

   public void foundMap() {
      hasMap = true;
   }

   public int position() {
      return position;
   }

   public void move(int i) {
      position = i;
   }

   public String name() {
      return name;
   }

   public int perception() {
      return perception;
   }

   public int attack() {
      return attack;
   }

   public int hp() {
      return hp;
   }

   public ArrayList<Item> inventory() {
      return inventory;
   }



   public  void gainItem(Item a) {
      inventory.add(a);
   }
 
   public  int gold() {
      return gold;
   }

   public  void gainGold(int a) {
      gold += a;
   }

   public  void loseGold(int a) {
      gold -= a;
   }

   public  int keys() {
      return keys;
   }

   public  void foundKey() {
      keys++;
   }

   public  int level() {
      return level;
   }

   public  int exp() {
      return exp;
   }

   public void stats() {
      System.out.println("");
      System.out.println("Player:       " + name);
      System.out.println("- - - - - - - - - -");
      System.out.println("Level:        " + level);
      System.out.println("Perception:   " + perception);
      System.out.println("Attack:       " + attack );
      System.out.println("Health:       " + hp +"/" + maxHP);
      System.out.println("Gold:         " + gold);
      System.out.println("");
   }






} // End class