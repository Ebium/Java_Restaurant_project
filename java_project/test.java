import java.util.ArrayList;
import java.util.List;

public class test{
    public static void main(String[] args){
        Stock sto = Stock.getInstance();
        
        Ingredient tt = new Ingredient("legume",1.4,50.0);
        System.out.println(sto.getQuantitePctg());
        
        sto.avoirLivraison();
        
    }
}