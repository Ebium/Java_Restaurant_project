import java.util.ArrayList;

public class Stock{
    private ArrayList<Ingredient> reserve_ingredient;
    private ArrayList<Boisson> reserve_boisson;
    private ArrayList<BoissonChaude> reserve_boisson_chaude;
    private ArrayList<Dessert> reserve_dessert;
    private ArrayList<DessertFroid> reserve_dessert_froid;
    private static int quantite = 0;
    private final int MAX_QUANTITE = 570;
    private final int MIN_QUANTITE = 190;

    private Stock(){
        this.reserve_ingredient = new ArrayList<Ingredient>();
        this.reserve_boisson = new ArrayList<Boisson>();
        this.reserve_dessert = new ArrayList<Dessert>();
        this.reserve_boisson_chaude = new ArrayList<BoissonChaude>();
        this.reserve_dessert_froid = new ArrayList<DessertFroid>();
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




    public void avoirLivraison(int chance){
        int r = (int)(Math.random()*(101))+0;
        if (chance == 1) r = 50;
        System.out.println(r);
        if (r <= 85){
            int cpt = 0;
            String [] liste_ingred = Ingredient.getListeIngredient();
            String [] liste_boisson = Boisson.getListeBoisson();
            String [] liste_boisson_chaude = BoissonChaude.getListeBoissonChaude();
            String [] liste_dessert = Dessert.getListeDessert();
            String [] liste_dessert_froid = DessertFroid.getListeDessertFroid();

            //-----INGREDIENT-----
            for (String i : liste_ingred){
                for (Ingredient ing : reserve_ingredient){
                    if(ing.getNom()==i) cpt++;
                }
                for (int j = cpt; j < 30 ; j++){
                    reserve_ingredient.add(new Ingredient(i,1,1));
                    Stock.quantite++;
                }
                cpt = 0;
            } 

            //-----BOISSON-----
            for (String i : liste_boisson){
                for (Boisson ing : reserve_boisson){
                    if(ing.getNom()==i) cpt++;
                }
                for (int j = cpt; j < 30 ; j++){
                    reserve_boisson.add(new Boisson(3,i,33));
                    Stock.quantite++;
                }
                cpt = 0;
            } 

            //-----BOISSON CHAUDE-----
            for (String i : liste_boisson_chaude){
                for (BoissonChaude ing : reserve_boisson_chaude){
                    if(ing.getNom()==i) cpt++;
                }
                for (int j = cpt; j < 30 ; j++){
                    reserve_boisson_chaude.add(new BoissonChaude(5,i,15));
                    Stock.quantite++;
                }
                cpt = 0;
            } 

            //-----DESSERT-----
            for (String i : liste_dessert){
                for (Dessert ing : reserve_dessert){
                    if(ing.getNom()==i) cpt++;
                }
                for (int j = cpt; j < 30 ; j++){
                    reserve_dessert.add(new Dessert(2.99,i));
                    Stock.quantite++;
                }
                cpt = 0;
            } 

            //-----DESSERT FROID-----
            for (String i : liste_dessert_froid){
                for (DessertFroid ing : reserve_dessert_froid){
                    if(ing.getNom()==i) cpt++;
                }
                for (int j = cpt; j < 30 ; j++){
                    reserve_dessert_froid.add(new DessertFroid(4.99,i));
                    Stock.quantite++;
                }
                cpt = 0;
            } 
        }
        else System.out.println("|-| ALERT |-| ACCIDENT DE LA ROUTE, LIVRAISON IMPOSSIBLE !\n");
    }

    public Ingredient getIngredient(String nom){
        Ingredient myingredient = new Ingredient("NONE",0,0);
        int b = 0;
        for (Ingredient ing : reserve_ingredient){
            if(ing.getNom() == nom){
                myingredient = reserve_ingredient.get(b);
                reserve_ingredient.remove(b);
                break;
            }
            b++;      
        }
        if(quantite>0) Stock.quantite--;
        return myingredient;
    }


    public Dessert getDessert(String nom){
        Dessert mydessert = new Dessert(0,"NONE");
        int b = 0;
        for (Dessert ing : reserve_dessert){
            if(ing.getNom() == nom){
                mydessert = reserve_dessert.get(b);
                reserve_dessert.remove(b);
                break;
            }
            b++;      
        }
        if(quantite>0) Stock.quantite--;
        return mydessert;
    }


    public DessertFroid getDessertFroid(String nom){
        DessertFroid mydessertfroid = new DessertFroid(0,"NONE");
        int b = 0;
        for (Dessert ing : reserve_dessert_froid){
            if(ing.getNom() == nom){
                mydessertfroid = reserve_dessert_froid.get(b);
                reserve_dessert_froid.remove(b);
                break;
            }
            b++;      
        }
        if(quantite>0) Stock.quantite--;
        return mydessertfroid;
    }


    public Boisson getBoisson(String nom){
        Boisson myboisson = new Boisson(0,"NONE",0);
        int b = 0;
        for (Boisson ing : reserve_boisson){
            if(ing.getNom() == nom){
                myboisson = reserve_boisson.get(b);
                reserve_boisson.remove(b);
                break;
            }
            b++;      
        }
        if(quantite>0) Stock.quantite--;
        return myboisson;
    }


    public BoissonChaude getBoissonChaude(String nom){
        BoissonChaude myboissonchaude = new BoissonChaude(0,"NONE",0);
        int b = 0;
        for (BoissonChaude ing : reserve_boisson_chaude){
            if(ing.getNom() == nom){
                myboissonchaude = reserve_boisson_chaude.get(b);
                reserve_boisson_chaude.remove(b);
                break;
            }
            b++;      
        }
        if(quantite>0) Stock.quantite--;
        return myboissonchaude;
    }

    
}