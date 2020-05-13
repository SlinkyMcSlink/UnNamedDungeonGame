public class Item {
   private String type;                        //  Item Type (Consumable, weapon, treasure)
   private String name;                      //  What the item is 
   private String description;             //  What the item does
   private int worth;                           //  What the item is worth is sold/bought
   private int sellPrice;
   private int effectNum;                   //   How much an item heals or the damage it does
   private int rarity;                          //   Rarity from 1 to 5; 1 being common, 5 being epic

   public Item(String t, String n, String d,  int w, int e, int r) {
      type = t;
      name = n;
      description = d;
      worth = w;
      sellPrice = (int)(w * 0.75) ;
      effectNum = e;
      rarity = r;
   }

   public String getType () {
      return type;
  }

   public String getName () {
      return name;
  }

   public String getDescription () {
      return description;
  }

   public int getWorth () {
      return worth;
  }

   public int getEffectNum () {
      return effectNum;
  }

   public int getRarity () {
      return rarity;
  }

} // End class