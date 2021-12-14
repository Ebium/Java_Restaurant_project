public class DessertFroid extends Dessert{
    private int minute = 20;
    private static String [] liste_dessert_froid = new String[]{"Glace","Compotte","Yaourt"};

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

    public static String[] getListeDessertFroid(){
        return liste_dessert_froid;
    }
}