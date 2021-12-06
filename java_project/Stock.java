import java.util.ArrayList;

public class Stock{
    private ArrayList<Ingredient> reserve;
    private static int quantite = 0;
    private final int MAX_QUANTITE = 240;
    private final int MIN_QUANTITE = 80;

    public Stock(){
        this.reserve = new ArrayList<Ingredient>();
    }

    public int getQuantite(){
        return quantite;
    }

    public int getQuantitePctg(){
        return (quantite*100)/MAX_QUANTITE;
    }
    public void avoirLivraison(){
        String [] liste_ingred = Ingredient.getString();
        //for (String ing : liste_ingred){
          //  long count = liste_ingred.stream().filter(liste_ingred -> ing.equals(liste_ingred)).count();
         //   System.out.println(count);
        //}


        //for (int i = this.quantite; i<MAX_QUANTITE; i++){
         //   Ingredient ingrandom = new Ingredient("tes",1,1);
        //    this.reserve.add(ingrandom);
        //}
    }
}