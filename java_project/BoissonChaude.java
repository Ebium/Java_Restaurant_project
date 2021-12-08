public class BoissonChaude extends Boisson{
    private static int minute = 20;

    public BoissonChaude(double prix, String nom,int quantite){
        super(prix,nom,quantite);
    }

    public void refroidir(){
        if (this.minute >0){
            this.minute --;
        }
    }

    public int getTemps(){
        return this.minute;
    }
    
}