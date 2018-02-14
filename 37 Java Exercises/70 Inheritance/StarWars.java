class XWing {

   // Properties of the class...
   private int     shields;
   private int     weapon;
   private boolean dead;

   // Constructor of the class...
   public XWing() {
      shields = 1000;
      weapon  = 10;
   }

   // Methods of the class...
   public int getWeapon() {
      return weapon;
   }
   public boolean isDead() {
      return dead;
   }
   public void hit(int damage) {
      shields = shields - damage;
      if (shields < 0) {
         System.out.println("BOOM!!!");
         dead = true;
      }
   }
}

class Tie {

   // Properties of the class...
   private int shields;
   private int weapon;
   private boolean dead;
  
   // Constructor of the class...
   public Tie() {
      shields = 500;
      weapon  = 20;
   }
   
   // Methods of the class...
   public int getWeapon() {
      return weapon;
   }
   public boolean isDead() {
      return dead;
   }
   public void hit(int damage) {
      shields = shields - damage;
      if (shields < 0) {
         System.out.println("BOOM!!!");
         dead = true;
      }
   }
}

class StarWars {

   private void duel(XWing x, Tie t) {

      for (;;) {
         x.hit(t.getWeapon());       
         if (x.isDead()) {
            System.out.println("X-Wing is dead");
            break;
         }
         t.hit(x.getWeapon());
         if (t.isDead()) {
            System.out.println("Tie fighter is dead");
            break;
         }
      }

   }

   private void battle(XWing[] good, Tie[] evil) {

      int g = 0;
      int e = 0;
      int goodDeaths = 0;
      int evilDeaths = 0;
     
      while (g < good.length && e < evil.length) {
         System.out.println("battling X-Wing #" + g + " versus Tie Fighter #" + e);
         duel(good[g],evil[e]);
         if (good[g].isDead()) {
            g++;
            goodDeaths++;
         }
         if (evil[e].isDead()) {
            e++;
            evilDeaths++;
         }
      }

      int finalGood = good.length - goodDeaths;
      int finalEvil = evil.length - evilDeaths;

      System.out.println();
      System.out.println("Battle Report:\t\tX-Wings\t\tTie Fighters");
      System.out.println("------------------------------------------------------");
      System.out.println();
      System.out.println("Initial ships:\t\t" + good.length + "\t\t" + evil.length);
      System.out.println();
      System.out.println("Killed ships:\t\t"  + goodDeaths  + "\t\t" + evilDeaths);
      System.out.println();
      System.out.println("Final ships:\t\t"   + finalGood   + "\t\t" + finalEvil);
      System.out.println();
      if (finalGood > finalEvil) {
         System.out.println("The rebel alliance is victorious!");
      }
      else {
         System.out.println("The dark side has conquered!");
      }
      System.out.println();
   }

   public void doStuff() {
    
      // defines the goodies array
      XWing[] goodies = new XWing[3];

      // initialises the elements of the goodies array
      for (int i=0; i<goodies.length; i++) {
         goodies[i] = new XWing();
      }
    
      // defines the baddies array
      Tie[] baddies = new Tie[3];

      // initialises the elements of the baddies array
      for (int i=0; i<baddies.length; i++) {
         baddies[i] = new Tie();
      }
    
      battle(goodies,baddies);

   }  

   // The main method is the point of entry into the program...
   public static void main(String[] args) {
      StarWars me = new StarWars();
      me.doStuff();
   }

}

