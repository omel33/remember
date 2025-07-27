package metodclass.abst;

public interface Movable {
   void move(double distance);

   public default void stop(){
       System.out.println("Транспортний засіб зупинився.");
   }
}
