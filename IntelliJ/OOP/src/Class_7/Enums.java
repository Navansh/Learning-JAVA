package Class_7;

public class Enums {
    enum Week{
        Monday,Tuesday,Wednesday,Thursday,Friday,Saturday,Sunday;
        //these are called enum constants
        //every single one is public, static and final by default
        //since its final, hence you cannot create child enums
        //their type is Week(here)

        Week(){
            System.out.println("Constructor called for "+this.toString());
        }
        //this is not public or protected, only private or package private
        //why ? -> cz if it was allowed to be public or protected it will allow initialization of more than the objects
        //we have defined it for
        //hence internally it is :public static final Week Monday = new Week();
    }
    public static void main(String[] args) {
        Week week;
        week = Week.Monday;

//        for (Week day:Week.values()) {
//            System.out.println(day);
//            //will print out each day
//        }

        System.out.println(week.ordinal());
    }
}
