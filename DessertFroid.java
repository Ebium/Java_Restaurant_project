public class DessertFroid extends Dessert{
    private static int minute = 20;

    public DessertFroid(double prix, String nom){
        super(prix,nom);
    }

    public void rechauffer(){
        if (this.minute >0){
            this.minute --;
        }
    }

    public int getTemps(){
        return this.minute;
    }
}