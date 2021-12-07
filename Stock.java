import java.util.ArrayList;

public class Stock{
    private ArrayList<Ingredient> reserve;
    private static int quantite = 0;
    private final int MAX_QUANTITE = 240;
    private final int MIN_QUANTITE = 80;

    private Stock(){
        this.reserve = new ArrayList<Ingredient>();
    }

    private static Stock INSTANCE = new Stock();

    public static Stock getInstance(){
        return INSTANCE;
    }

    public int getQuantite(){
        return quantite;
    }

    public int getQuantitePctg(){
        return (quantite*100)/MAX_QUANTITE;
    }

    public void avoirLivraison(){
        int r = (int)(Math.random()*(101))+0;
        System.out.println(r);
        if (r <= 85){
            int cpt = 0;
            Ingredient test = new Ingredient("Tomate",0,0);
            String [] liste_ingred = test.getString();

            for (String i : liste_ingred){
                for (Ingredient ing : reserve){
                    if(ing.getNom()==i) cpt++;
                }
                for (int j = cpt; j < 30 ; j++){
                    reserve.add(new Ingredient(i,1,1));
                    this.quantite++;
                }
                cpt = 0;
            } 
        }
        else System.out.println("|-| ALERT |-| ACCIDENT DE LA ROUTE, LIVRAISON IMPOSSIBLE !\n");
        /*
        int b = 0;
        for (Ingredient ing : reserve){

            if(ing.getNom() == "Tomate"){
                reserve.remove(b);
                System.out.println("on a enlevé un element");
                break;
            }
            b++;
                
        }
        int a = 0;
        for (Ingredient ing : reserve){
                a++;
                System.out.println(ing.getNom());
        }
        System.out.println(reserve.size());*/
    }

    public void enleverIngredient(Ingredient ingre){
        int b = 0;
        for (Ingredient ing : reserve){
            if(ing.getNom() == ingre.getNom()){
                reserve.remove(b);
                break;
            }
            b++;
                
        }
        if(quantite>0) this.quantite--;
    }
}