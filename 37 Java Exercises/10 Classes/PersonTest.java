class Person {

   // Properties of the class...
   private String name;
   private int    age;
    
   // Constructor of the class...
   public Person(String aName, int anAge) {
      name = aName;
      age  = anAge;
   }

   // Methods of the class...
   public void talk() {
      System.out.println("Hi, my name's " + name);
      System.out.println("and my age is " + age);
      System.out.println();
   }
   public void commentAboutAge() {
      if (age < 5) {
         System.out.println("baby");
      }
      if (age == 5) {
         System.out.println("time to start school");
      }
   }

}

class PersonTest {

   // The main method is the point of entry into the program...
   public static void main(String[] args) {

      Person ls = new Person("Luke Skywalker",34);
      Person wp = new Person("Winston Peters",48);

      ls.talk();
      wp.talk();

   }

}

