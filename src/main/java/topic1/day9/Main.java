package topic1.day9;

public class Main {
    public static void main(String[] args) {
        Computer.Ram ram = new Computer.Ram();
        ram.printRam();

        Computer computer = new Computer();
        Computer.Processor processor = computer.new Processor();
        processor.printDetails();
        computer.print();
        ButtonClickListener buttonClickListener = new ButtonClickListener() {
            @Override
            public void onClick() {
                System.out.println("Button clicked");
            }
        };
        buttonClickListener.onClick();


    }
}
