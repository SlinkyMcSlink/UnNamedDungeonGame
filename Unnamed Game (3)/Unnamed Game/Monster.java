import java.util.Random;

public class Monster {
   private String name;                    // Name of Monster
   private int hp;                              // Health of Monster
   private int attack;                        // Damage done by Monster
   private boolean boss;                    // Boss
   private boolean defeated;             // Whether or not the enemy is defeated
   private int exp;                            // Exp dropped when defeated
   private int gold;                           // Money dropped when defeated
   private static Random rand;

   public Monster(String n, boolean b) {
      name = n;
      boss = b;
      defeated = false;
      if (!boss) {
         hp = rand.nextInt(200) + 1;
         attack = rand.nextInt(30) + 1;
         exp = hp + attack;
         gold = rand.nextInt(100) + 1;
      }
      else {
         hp = (rand.nextInt(200) + 100) * 6;
         attack = (rand.nextInt(30) + 10) * 3;
         exp = hp + attack;
         gold = (rand.nextInt(100) + 1) * 6;
      }
   }
   public String name() {
      return name;
   }

   public int hp() {
      return hp;
   }

   public int attack() {
      return attack;
   }

   public boolean boss() {
      return boss;
   }

   public boolean defeated() {
      return defeated;
   }

   public void defeat() {
      defeated = true;
   }

   public int exp() {
      return exp;
   }

   public int gold() {
      return gold;
   }
  


} // End class