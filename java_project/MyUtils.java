public abstract class MyUtils{
    public static final String line = "|----------------------------------------------------------------|";

    public static void wait(int ms){
        try {
            Thread.sleep(1000);
        }
        catch (InterruptedException e) {
            System.err.format("IOException: %s%n", e);
        }
    }

    public static void clear(){

        System.out.print("\033[H\033[2J");
        System.out.println(line+"\n");
    }

    public static void line(){
        System.out.println(line);
    }
}