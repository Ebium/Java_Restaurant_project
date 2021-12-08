public class DessertFroid extends Dessert{
    private static int minute = 20;
    private static String [] liste_dessert_froid = new String[]{"Glace","Compotte","Yaourt"};

    public DessertFroid(double prix, String nom){
        super(prix,nom);
    }

    public void rechauffer(){
        if (DessertFroid.minute >0){
            DessertFroid.minute --;
        }
    }

    public int getTemps(){
        return DessertFroid.minute;
    }

    public static String[] getListeDessertFroid(){
        return liste_dessert_froid;
    }
}