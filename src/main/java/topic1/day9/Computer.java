package topic1.day9;

public class Computer {
    void print(){
        String massageService="Massage Service";
        class Printer{
            void printMessage(){
                System.out.println("Printer say: "+massageService);
            }

        }
        Printer printer = new Printer();
        printer.printMessage();
    }

    static class Ram{
        static int size = 8;
        static String type = "DDR4";
        public static void printRam(){
            System.out.println("Ram size: " + size + "GB");
            System.out.println("Ram type: " + type);
        }
    }
    class Processor{
        int cores = 4;
        String brand = "Intel";
        public void printDetails(){
            System.out.println("Processor cores: " + cores);
            System.out.println("Processor brand: " + brand);
        }
    }


}
