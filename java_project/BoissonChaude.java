public class BoissonChaude extends Boisson{
    private static int minute = 20;
    private static String [] liste_boisson_chaude = new String[]{"Cafe","The","Vin"};

    public BoissonChaude(double prix, String nom,int quantite){
        super(prix,nom,quantite);
    }

    public void refroidir(){
        if (BoissonChaude.minute >0){
            BoissonChaude.minute --;
        }
        else System.out.println("Votre boisson s'est refroidie ... Il faut se dépêcher !");
    }

    public int getTemps(){
        return BoissonChaude.minute;
    }
    
    public static String[] getListeBoissonChaude(){
        return liste_boisson_chaude;
    }
}