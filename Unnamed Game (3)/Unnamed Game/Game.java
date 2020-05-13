import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class Game {
   private static Player dude;
   private static ArrayList<Room> map = new ArrayList<Room>();
   private static boolean won = false;
   private static Scanner input = new Scanner(System.in);
   private static Room current, prev;
   private static Random rand = new Random();

   public static void main(String[] args) {
      createMap();
      current = map.get(0);
      createPlayer();
      startGame();
   }

   public static void createPlayer() {
      say("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
      say("********************************************************************* ");
      say("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
      say("Hello there, you are about to embark on a great adventure!");
      say("What shall I refer to you as?");
      String name = input.nextLine();
      dude = new Player(name);
      say("");
      say("Ah! well then, " + dude.name() + ", nice to meet you. ");
   }

   public static void createMap() {
      
      map.add(new Room(1, false, -1, 1, -1, -1, false, -1));  // 0 -- Starting point
      map.add(new Room(3, false, -1, 2, 6, 0, false, -1));  // 1
      map.add(new Room(2, false, -1, -1, 7, 1, false, -1));  // 2
      map.add(new Room(1, true, -1, -1, 8, -1, false, -1));  // 3
      map.add(new Room(1, true, -1, -1, 9, -1, false, -1));  // 4

      map.add(new Room(1, true, -1, 6, -1, -1, false, -1));  // 5
      map.add(new Room(3, false, 1, -1, 11, 5, true, 5));  // 6
      map.add(new Room(2, false, 2, -1, 12, -1, false, -1));  // 7
      map.add(new Room(3, false, 3, 9, 13, -1, false, -1));  // 8
      map.add(new Room(3, false, 4, -1, 14, 8, true, 4));  // 9

      map.add(new Room(2, false, -1, 11, 15, -1, false, -1));  // 10
      map.add(new Room(2, false, 6, -1, -1, 10, false, -1));  // 11
      map.add(new Room(1, true, 7, -1, -1, -1, false, -1));  // 12
      map.add(new Room(2, false, 8, -1, 18, -1, false, -1));  // 13
      map.add(new Room(2, false, 9, -1, 19, -1, false, -1));  // 14

      map.add(new Room(2, false, 10, 16, -1, -1, false, -1));  // 15
      map.add(new Room(3, false, -1, 17, 21, 15, true, 21));  // 16
      map.add(new Room(2, false, -1, -1, 22, 16, false, -1));  // 17
      map.add(new Room(2, false, 13, -1, 23, -1, false, -1));  // 18
      map.add(new Room(2, false, 14, -1, 24, -1, false, -1));  // 19

      map.add(new Room(1, true, -1, 21, -1, -1, false, -1));  // 20
      map.add(new Room(2, false, 16, -1, -1, 20, false, -1));  // 21
      map.add(new Room(2, false, 17, 23, -1, -1, false, -1));  // 22
      map.add(new Room(2, false, 18, -1, -1, 22, false, -1));  // 23
      map.add(new Room(1, true, 19, -1, -1, -1, false, -1));  // 24   ---- Final Boss
      // say("Board made.");

      

  }

   public static void startGame() {
      say("Let the adventure begin...");
      say("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
      say("********************************************************************* ");
      say("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
      say("It's midnight, the moon is shining eerily through the clouds as a storm quickly approaches."); 
      say("You are running through the trees trying to find shelter before it starts to rain.");
      say("You feel drops of water start randomly hitting parts of you body."); 
      say("You again look toward the clouds.  \"Shit..\" you mutter as you resume searching the darkness.");    
      say("Suddenly ahead you see a small hole with a wooden door that is slightly ajar.");
      say("With thunderous booming getting louder and wind raging around you,");
      say("you manage to slip inside the door, which then closes and loudly locks behind you.");
      say("\"Well, at least I\'m out of that storm,\" you say as you breathe a sigh of relief.");
      say("");
      boolean done = false;
      boolean investigated = false;
      int y = 0;
      while (!done) {
          say("What do you want to do now?");
          say("          1: View your stats");
          say("          2: Investigate surroundings");
          say("          3: Move");
          say("          4: View inventory");
          say("          5: Help");
          say("          6: Quit");
          say("          7: Position");
          say("          8: Map");
          say("");
          String x = input.nextLine();
          if (x.equals("1")) {
             dude.stats();
          }
          else if (x.equals("2")) {
             if (current.numDoors() > 1) {
                say("You look around and see that there are " + current.numDoors() + " doors leading out of");
                say("the room.\n"); 
             }
             else {
                say("You look around and see that there is " + current.numDoors() + " door leading out of");
                say("the room.\n"); 
             }
             investigated = true;
          }
          else if (x.equals("3")) {
             if (investigated) {
                boolean doneski = false;
                while (!doneski) {
                   say("Which direction would you like to go?");
                   say("          n: North");
                   say("          e: East");
                   say("          s: South");
                   say("          w: West");
                   say("");
                   say("          b: Go Back");
                   say("          q: Quit\n");
                   x = input.nextLine();
                   if (x.equals("n")) {
                      if (current.n() == -1) {
                         say("You can't go that way, it's a wall.\n");
                      }
                      else {
                         say("You went North.\n");
                         y  = current.n();
                         dude.move(y);
                         prev = current;
                         current = map.get(y);
                         investigated = false;
                        enterRoom(current);
                         doneski = true;
                      }
                   }
                   else if (x.equals("e") ){
                      if (current.e() == -1) {
                         say("You can't go that way, it's a wall.\n");
                      }
                      else {
                         y  = current.e();
                         dude.move(y);
                         prev = current;
                         current = map.get(y);
                         investigated = false;
                        enterRoom(current);
                         doneski = true;
                      }
                   }
                   else if (x.equals("s") ){
                      if (current.s() == -1) {
                         say("You can't go that way, it's a wall.\n");
                      }
                      else {
                         say("You went South.\n");
                         y  = current.s();
                         dude.move(y);
                         prev = current;
                         current = map.get(y);
                         investigated = false;
                        enterRoom(current);
                         doneski = true;
                      }
                   }
                   else if (x.equals("w") ){
                      if (current.w() == -1) {
                         say("You can't go that way, it's a wall.\n");
                      }
                      else {
                         say("You went West.\n");
                         y  = current.w();
                         dude.move(y);
                         prev = current;
                         current = map.get(y);
                         investigated = false;
                         enterRoom(current);
                         doneski = true;
                      }
                   }
                   else if (x.equals("b") ){
                      doneski = true;
                   }
                   else if (x.equals("q") ){
                      say("Quitting...");
                      done =  true;
                      System.exit(0);
                   }
                   else {
                      say("Enter one of the choices please. (n, e, s, w, b, q)\n");
                   }
                }
             }
             else {
                say("You haven't looked around yet.\n");
             }

          }
          else if (x.equals("4")) {
             say("Inventory: ");
             for (int i = 0; i < dude.inventory().size(); i++) {
                 say(dude.inventory().get(i).getName());
             }
             say("");
          }
          else if (x.equals("5")) {
             say("");
             say("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
             say("********************************************************************* ");
             say("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
             say("                            HELP");
             say("");
             say("This is a text based game in which you choose what action you would like to take.");
             say("");
             say("Each room you visit has a chance of spawning an enemy, with which you can either");
             say("fight to gain experience or flee out of the room for a chance at an easier enemy or");
             say("to raise in levels to gain the power to overcome the difficulty.");
             say("");
             say("Gold is dropped by enemies and found in chests.  Gold is used to buy items such as weapons");
             say("and potions (for healing) from a shop available to you anytime -- after level 3 is achieved.");
             say("");
             say("The map includes 5 chests which not only holds gold and items, but also keys.");
             say("All 5 of these keys are required to access the final room to defeat the boss.");
             say("");
             say("Perception is a stat that tells you how well you investigate the rooms you are in.");
             say("The higher the perception, the more you see in each room.  You may even find a ");
             say("hidden door or two if your perception is high enough.");
             say("");
             say("All stats are increased during level ups (perception, health, attack). You get experience from ");
             say("fighting and defeating enemies, as well as a little for for the first time you enter a room.");
             say("Levels are gained every 100 experience points earned.");
             say("");
             say("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
             say("********************************************************************* ");
             say("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - \n");
          }
          else if (x.equals("6")) {
             say("Quitting...");
             done =  true;
             System.exit(0);
          }
          else if (x.equals("7")) {
             say("Current Position: " + dude.position());
             say("");
          }
          else if (x.equals("8")) {
             if (dude.hasMap()) {
                 showMap(dude.position());
                 say("");
             }
             else {
                say("You do not have a map.\n");
             }
          }
          else{
             say("Enter one of the numbered choices please. (1, 2, 3, 4, 5, 6, 7, 8)\n");
          }
      }
   }

   public static void enterRoom(Room cur) {
      if (!cur.visited()) {
         dude.gainExp(25);
         say("You have entered a room in which you haven't been before!");
         say("You gained 25 exp.\n");

      }
      else {
         say("You enter the room.");
         say("You get the feeling that you have been in here before..\n");
      }
      cur.visit();
      Monster monster;
      int x = rand.nextInt(2);
      if (x == 1) {
         monster = new Monster(nameIt(), isBoss());
         fight(monster);
      }

   }

   public static String nameIt() {
      int n = rand.nextint(10) + 1;
      switch(n) {
         case 1: 
            return "Lisa";
            break;
         case 2: 
            return "Jerry";
            break;
         case 3: 
            return "Gary";
            break;
         case 4: 
            return "Boaz";
            break;
         case 5: 
            return "Silas";
            break;
         case 6: 
            return "Mercy";
            break;
         case 7:
            return "Remex";
            break;
         case 8: 
            return "Triexel";
            break;
         case 9: 
            return "Alpha";
            break;
         case 10: 
            return "Trissa";
            break;
      }
   }

   public static Boolean isBoss() {
      if (dude.position() == 24) {
         return true;
      }
      else {
         return false;
      }
   }

   public static void fight(Monster m ) {
      say("You have encountered a monster who goes by " + m.name() + ",");
      say("who has " + m.hp() + " health.");
      say("What would you like to do?\n   a: Attack\n   r: Run\n");
      boolean donzo = false;
      while (!donzo) {
         String ans = input.nextLine();
         if (ans.equals("a")) {
            if (m.hp() < 0 || dude.hp() < 0) {

            }
            else {
               
            }
         else if (ans.equals("r")) {
            say("You retreated to the previous room.");
            donzo = true;
            dude.move(indexOf(prev));
         }
         else {
            say("Please enter \"a\" or \"r\".");
         }

      }      
   }

   public static void showMap(int p) {
      switch (p) {
          case 0:
              say("*********************");
              say("*   *   *   *   *   *");
              say("* X         *   *   *");
              say("*   *   *   *   *   *");
              say("****** *** *** ***/**");
              say("*   *   *   *   *   *");
              say("*   /   *   *       *");
              say("*   *   *   *   *   *");
              say("****** *** *** *** **");
              say("*   *   *   *   *   *");
              say("*       *   *   *   *");
              say("*   *   *   *   *   *");
              say("** *********** *** **");
              say("*   *   *   *   *   *");
              say("*           *   *   *");
              say("*   *   *   *   *   *");
              say("******/*** *** ***+**");
              say("*   *   *   *   *   *");
              say("*       *       *   *");
              say("*   *   *   *   *   *");
              say("*********************");
              break;

          case 1:
              say("*********************");
              say("*   *   *   *   *   *");
              say("*     X     *   *   *");
              say("*   *   *   *   *   *");
              say("****** *** *** ***/**");
              say("*   *   *   *   *   *");
              say("*   /   *   *       *");
              say("*   *   *   *   *   *");
              say("****** *** *** *** **");
              say("*   *   *   *   *   *");
              say("*       *   *   *   *");
              say("*   *   *   *   *   *");
              say("** *********** *** **");
              say("*   *   *   *   *   *");
              say("*           *   *   *");
              say("*   *   *   *   *   *");
              say("******/*** *** ***+**");
              say("*   *   *   *   *   *");
              say("*       *       *   *");
              say("*   *   *   *   *   *");
              say("*********************");
              break;

          case 2:              
              say("*********************");
              say("*   *   *   *   *   *");
              say("*         X *   *   *");
              say("*   *   *   *   *   *");
              say("****** *** *** ***/**");
              say("*   *   *   *   *   *");
              say("*   /   *   *       *");
              say("*   *   *   *   *   *");
              say("****** *** *** *** **");
              say("*   *   *   *   *   *");
              say("*       *   *   *   *");
              say("*   *   *   *   *   *");
              say("** *********** *** **");
              say("*   *   *   *   *   *");
              say("*           *   *   *");
              say("*   *   *   *   *   *");
              say("******/*** *** ***+**");
              say("*   *   *   *   *   *");
              say("*       *       *   *");
              say("*   *   *   *   *   *");
              say("*********************");
              break;

          case 3:              
              say("*********************");
              say("*   *   *   *   *   *");
              say("*           * X *   *");
              say("*   *   *   *   *   *");
              say("****** *** *** ***/**");
              say("*   *   *   *   *   *");
              say("*   /   *   *       *");
              say("*   *   *   *   *   *");
              say("****** *** *** *** **");
              say("*   *   *   *   *   *");
              say("*       *   *   *   *");
              say("*   *   *   *   *   *");
              say("** *********** *** **");
              say("*   *   *   *   *   *");
              say("*           *   *   *");
              say("*   *   *   *   *   *");
              say("******/*** *** ***+**");
              say("*   *   *   *   *   *");
              say("*       *       *   *");
              say("*   *   *   *   *   *");
              say("*********************");
              break;

          case 4:              
              say("*********************");
              say("*   *   *   *   *   *");
              say("*           *   * X *");
              say("*   *   *   *   *   *");
              say("****** *** *** ***/**");
              say("*   *   *   *   *   *");
              say("*   /   *   *       *");
              say("*   *   *   *   *   *");
              say("****** *** *** *** **");
              say("*   *   *   *   *   *");
              say("*       *   *   *   *");
              say("*   *   *   *   *   *");
              say("** *********** *** **");
              say("*   *   *   *   *   *");
              say("*           *   *   *");
              say("*   *   *   *   *   *");
              say("******/*** *** ***+**");
              say("*   *   *   *   *   *");
              say("*       *       *   *");
              say("*   *   *   *   *   *");
              say("*********************");
              break;

          case 5:              
              say("*********************");
              say("*   *   *   *   *   *");
              say("*           *   *   *");
              say("*   *   *   *   *   *");
              say("****** *** *** ***/**");
              say("*   *   *   *   *   *");
              say("* X /   *   *       *");
              say("*   *   *   *   *   *");
              say("****** *** *** *** **");
              say("*   *   *   *   *   *");
              say("*       *   *   *   *");
              say("*   *   *   *   *   *");
              say("** *********** *** **");
              say("*   *   *   *   *   *");
              say("*           *   *   *");
              say("*   *   *   *   *   *");
              say("******/*** *** ***+**");
              say("*   *   *   *   *   *");
              say("*       *       *   *");
              say("*   *   *   *   *   *");
              say("*********************");
              break;

          case 6:              
              say("*********************");
              say("*   *   *   *   *   *");
              say("*           *   *   *");
              say("*   *   *   *   *   *");
              say("****** *** *** ***/**");
              say("*   *   *   *   *   *");
              say("*   / X *   *       *");
              say("*   *   *   *   *   *");
              say("****** *** *** *** **");
              say("*   *   *   *   *   *");
              say("*       *   *   *   *");
              say("*   *   *   *   *   *");
              say("** *********** *** **");
              say("*   *   *   *   *   *");
              say("*           *   *   *");
              say("*   *   *   *   *   *");
              say("******/*** *** ***+**");
              say("*   *   *   *   *   *");
              say("*       *       *   *");
              say("*   *   *   *   *   *");
              say("*********************");
              break;

          case 7:              
              say("*********************");
              say("*   *   *   *   *   *");
              say("*           *   *   *");
              say("*   *   *   *   *   *");
              say("****** *** *** ***/**");
              say("*   *   *   *   *   *");
              say("*   /   * X *       *");
              say("*   *   *   *   *   *");
              say("****** *** *** *** **");
              say("*   *   *   *   *   *");
              say("*       *   *   *   *");
              say("*   *   *   *   *   *");
              say("** *********** *** **");
              say("*   *   *   *   *   *");
              say("*           *   *   *");
              say("*   *   *   *   *   *");
              say("******/*** *** ***+**");
              say("*   *   *   *   *   *");
              say("*       *       *   *");
              say("*   *   *   *   *   *");
              say("*********************");
              break;

          case 8:              
              say("*********************");
              say("*   *   *   *   *   *");
              say("*           *   *   *");
              say("*   *   *   *   *   *");
              say("****** *** *** ***/**");
              say("*   *   *   *   *   *");
              say("*   /   *   * X     *");
              say("*   *   *   *   *   *");
              say("****** *** *** *** **");
              say("*   *   *   *   *   *");
              say("*       *   *   *   *");
              say("*   *   *   *   *   *");
              say("** *********** *** **");
              say("*   *   *   *   *   *");
              say("*           *   *   *");
              say("*   *   *   *   *   *");
              say("******/*** *** ***+**");
              say("*   *   *   *   *   *");
              say("*       *       *   *");
              say("*   *   *   *   *   *");
              say("*********************");
              break;

          case 9:              
              say("*********************");
              say("*   *   *   *   *   *");
              say("*           *   *   *");
              say("*   *   *   *   *   *");
              say("****** *** *** ***/**");
              say("*   *   *   *   *   *");
              say("*   /   *   *     X *");
              say("*   *   *   *   *   *");
              say("****** *** *** *** **");
              say("*   *   *   *   *   *");
              say("*       *   *   *   *");
              say("*   *   *   *   *   *");
              say("** *********** *** **");
              say("*   *   *   *   *   *");
              say("*           *   *   *");
              say("*   *   *   *   *   *");
              say("******/*** *** ***+**");
              say("*   *   *   *   *   *");
              say("*       *       *   *");
              say("*   *   *   *   *   *");
              say("*********************");
              break;

          case 10:              
              say("*********************");
              say("*   *   *   *   *   *");
              say("*           *   *   *");
              say("*   *   *   *   *   *");
              say("****** *** *** ***/**");
              say("*   *   *   *   *   *");
              say("*   /   *   *       *");
              say("*   *   *   *   *   *");
              say("****** *** *** *** **");
              say("*   *   *   *   *   *");
              say("* X     *   *   *   *");
              say("*   *   *   *   *   *");
              say("** *********** *** **");
              say("*   *   *   *   *   *");
              say("*           *   *   *");
              say("*   *   *   *   *   *");
              say("******/*** *** ***+**");
              say("*   *   *   *   *   *");
              say("*       *       *   *");
              say("*   *   *   *   *   *");
              say("*********************");
              break;

          case 11:              
              say("*********************");
              say("*   *   *   *   *   *");
              say("*           *   *   *");
              say("*   *   *   *   *   *");
              say("****** *** *** ***/**");
              say("*   *   *   *   *   *");
              say("*   /   *   *       *");
              say("*   *   *   *   *   *");
              say("****** *** *** *** **");
              say("*   *   *   *   *   *");
              say("*     X *   *   *   *");
              say("*   *   *   *   *   *");
              say("** *********** *** **");
              say("*   *   *   *   *   *");
              say("*           *   *   *");
              say("*   *   *   *   *   *");
              say("******/*** *** ***+**");
              say("*   *   *   *   *   *");
              say("*       *       *   *");
              say("*   *   *   *   *   *");
              say("*********************");
              break;

          case 12:              
              say("*********************");
              say("*   *   *   *   *   *");
              say("*           *   *   *");
              say("*   *   *   *   *   *");
              say("****** *** *** ***/**");
              say("*   *   *   *   *   *");
              say("*   /   *   *       *");
              say("*   *   *   *   *   *");
              say("****** *** *** *** **");
              say("*   *   *   *   *   *");
              say("*       * X *   *   *");
              say("*   *   *   *   *   *");
              say("** *********** *** **");
              say("*   *   *   *   *   *");
              say("*           *   *   *");
              say("*   *   *   *   *   *");
              say("******/*** *** ***+**");
              say("*   *   *   *   *   *");
              say("*       *       *   *");
              say("*   *   *   *   *   *");
              say("*********************");
              break;

          case 13:              
              say("*********************");
              say("*   *   *   *   *   *");
              say("*           *   *   *");
              say("*   *   *   *   *   *");
              say("****** *** *** ***/**");
              say("*   *   *   *   *   *");
              say("*   /   *   *       *");
              say("*   *   *   *   *   *");
              say("****** *** *** *** **");
              say("*   *   *   *   *   *");
              say("*       *   * X *   *");
              say("*   *   *   *   *   *");
              say("** *********** *** **");
              say("*   *   *   *   *   *");
              say("*           *   *   *");
              say("*   *   *   *   *   *");
              say("******/*** *** ***+**");
              say("*   *   *   *   *   *");
              say("*       *       *   *");
              say("*   *   *   *   *   *");
              say("*********************");
              break;

          case 14:              
              say("*********************");
              say("*   *   *   *   *   *");
              say("*           *   *   *");
              say("*   *   *   *   *   *");
              say("****** *** *** ***/**");
              say("*   *   *   *   *   *");
              say("*   /   *   *       *");
              say("*   *   *   *   *   *");
              say("****** *** *** *** **");
              say("*   *   *   *   *   *");
              say("*       *   *   * X *");
              say("*   *   *   *   *   *");
              say("** *********** *** **");
              say("*   *   *   *   *   *");
              say("*           *   *   *");
              say("*   *   *   *   *   *");
              say("******/*** *** ***+**");
              say("*   *   *   *   *   *");
              say("*       *       *   *");
              say("*   *   *   *   *   *");
              say("*********************");
              break;

          case 15:              
              say("*********************");
              say("*   *   *   *   *   *");
              say("*           *   *   *");
              say("*   *   *   *   *   *");
              say("****** *** *** ***/**");
              say("*   *   *   *   *   *");
              say("*   /   *   *       *");
              say("*   *   *   *   *   *");
              say("****** *** *** *** **");
              say("*   *   *   *   *   *");
              say("*       *   *   *   *");
              say("*   *   *   *   *   *");
              say("** *********** *** **");
              say("*   *   *   *   *   *");
              say("* X         *   *   *");
              say("*   *   *   *   *   *");
              say("******/*** *** ***+**");
              say("*   *   *   *   *   *");
              say("*       *       *   *");
              say("*   *   *   *   *   *");
              say("*********************");
              break;

          case 16:              
              say("*********************");
              say("*   *   *   *   *   *");
              say("*           *   *   *");
              say("*   *   *   *   *   *");
              say("****** *** *** ***/**");
              say("*   *   *   *   *   *");
              say("*   /   *   *       *");
              say("*   *   *   *   *   *");
              say("****** *** *** *** **");
              say("*   *   *   *   *   *");
              say("*       *   *   *   *");
              say("*   *   *   *   *   *");
              say("** *********** *** **");
              say("*   *   *   *   *   *");
              say("*     X     *   *   *");
              say("*   *   *   *   *   *");
              say("******/*** *** ***+**");
              say("*   *   *   *   *   *");
              say("*       *       *   *");
              say("*   *   *   *   *   *");
              say("*********************");
              break;

          case 17:              
              say("*********************");
              say("*   *   *   *   *   *");
              say("*           *   *   *");
              say("*   *   *   *   *   *");
              say("****** *** *** ***/**");
              say("*   *   *   *   *   *");
              say("*   /   *   *       *");
              say("*   *   *   *   *   *");
              say("****** *** *** *** **");
              say("*   *   *   *   *   *");
              say("*       *   *   *   *");
              say("*   *   *   *   *   *");
              say("** *********** *** **");
              say("*   *   *   *   *   *");
              say("*         X *   *   *");
              say("*   *   *   *   *   *");
              say("******/*** *** ***+**");
              say("*   *   *   *   *   *");
              say("*       *       *   *");
              say("*   *   *   *   *   *");
              say("*********************");
              break;

          case 18:              
              say("*********************");
              say("*   *   *   *   *   *");
              say("*           *   *   *");
              say("*   *   *   *   *   *");
              say("****** *** *** ***/**");
              say("*   *   *   *   *   *");
              say("*   /   *   *       *");
              say("*   *   *   *   *   *");
              say("****** *** *** *** **");
              say("*   *   *   *   *   *");
              say("*       *   *   *   *");
              say("*   *   *   *   *   *");
              say("** *********** *** **");
              say("*   *   *   *   *   *");
              say("*           * X *   *");
              say("*   *   *   *   *   *");
              say("******/*** *** ***+**");
              say("*   *   *   *   *   *");
              say("*       *       *   *");
              say("*   *   *   *   *   *");
              say("*********************");
              break;

          case 19:               
              say("*********************");
              say("*   *   *   *   *   *");
              say("*           *   *   *");
              say("*   *   *   *   *   *");
              say("****** *** *** ***/**");
              say("*   *   *   *   *   *");
              say("*   /   *   *       *");
              say("*   *   *   *   *   *");
              say("****** *** *** *** **");
              say("*   *   *   *   *   *");
              say("*       *   *   *   *");
              say("*   *   *   *   *   *");
              say("** *********** *** **");
              say("*   *   *   *   *   *");
              say("*           *   * X *");
              say("*   *   *   *   *   *");
              say("******/*** *** ***+**");
              say("*   *   *   *   *   *");
              say("*       *       *   *");
              say("*   *   *   *   *   *");
              say("*********************");
              break;
         
          case 20:              
              say("*********************");
              say("*   *   *   *   *   *");
              say("*           *   *   *");
              say("*   *   *   *   *   *");
              say("****** *** *** ***/**");
              say("*   *   *   *   *   *");
              say("*   /   *   *       *");
              say("*   *   *   *   *   *");
              say("****** *** *** *** **");
              say("*   *   *   *   *   *");
              say("*       *   *   *   *");
              say("*   *   *   *   *   *");
              say("** *********** *** **");
              say("*   *   *   *   *   *");
              say("*           *   *   *");
              say("*   *   *   *   *   *");
              say("******/*** *** ***+**");
              say("*   *   *   *   *   *");
              say("* X     *       *   *");
              say("*   *   *   *   *   *");
              say("*********************");
              break;

          case 21:              
              say("*********************");
              say("*   *   *   *   *   *");
              say("*           *   *   *");
              say("*   *   *   *   *   *");
              say("****** *** *** ***/**");
              say("*   *   *   *   *   *");
              say("*   /   *   *       *");
              say("*   *   *   *   *   *");
              say("****** *** *** *** **");
              say("*   *   *   *   *   *");
              say("*       *   *   *   *");
              say("*   *   *   *   *   *");
              say("** *********** *** **");
              say("*   *   *   *   *   *");
              say("*           *   *   *");
              say("*   *   *   *   *   *");
              say("******/*** *** ***+**");
              say("*   *   *   *   *   *");
              say("*     X *       *   *");
              say("*   *   *   *   *   *");
              say("*********************");
              break;

          case 22:              
              say("*********************");
              say("*   *   *   *   *   *");
              say("*           *   *   *");
              say("*   *   *   *   *   *");
              say("****** *** *** ***/**");
              say("*   *   *   *   *   *");
              say("*   /   *   *       *");
              say("*   *   *   *   *   *");
              say("****** *** *** *** **");
              say("*   *   *   *   *   *");
              say("*       *   *   *   *");
              say("*   *   *   *   *   *");
              say("** *********** *** **");
              say("*   *   *   *   *   *");
              say("*           *   *   *");
              say("*   *   *   *   *   *");
              say("******/*** *** ***+**");
              say("*   *   *   *   *   *");
              say("*       * X     *   *");
              say("*   *   *   *   *   *");
              say("*********************");
              break;

          case 23:              
              say("*********************");
              say("*   *   *   *   *   *");
              say("*           *   *   *");
              say("*   *   *   *   *   *");
              say("****** *** *** ***/**");
              say("*   *   *   *   *   *");
              say("*   /   *   *       *");
              say("*   *   *   *   *   *");
              say("****** *** *** *** **");
              say("*   *   *   *   *   *");
              say("*       *   *   *   *");
              say("*   *   *   *   *   *");
              say("** *********** *** **");
              say("*   *   *   *   *   *");
              say("*           *   *   *");
              say("*   *   *   *   *   *");
              say("******/*** *** ***+**");
              say("*   *   *   *   *   *");
              say("*       *     X *   *");
              say("*   *   *   *   *   *");
              say("*********************");
              break;

          case 24:              
              say("*********************");
              say("*   *   *   *   *   *");
              say("*           *   *   *");
              say("*   *   *   *   *   *");
              say("****** *** *** ***/**");
              say("*   *   *   *   *   *");
              say("*   /   *   *       *");
              say("*   *   *   *   *   *");
              say("****** *** *** *** **");
              say("*   *   *   *   *   *");
              say("*       *   *   *   *");
              say("*   *   *   *   *   *");
              say("** *********** *** **");
              say("*   *   *   *   *   *");
              say("*           *   *   *");
              say("*   *   *   *   *   *");
              say("******/*** *** ***+**");
              say("*   *   *   *   *   *");
              say("*       *       * X *");
              say("*   *   *   *   *   *");
              say("*********************");
              break;

      }
   }

   public static void say(String a) {
      System.out.println(a);
   }
   
} // End class