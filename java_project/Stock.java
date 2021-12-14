import java.util.ArrayList;

public class Stock{
    private ArrayList<Ingredient> reserve_ingredient;
    private ArrayList<Boisson> reserve_boisson;
    private ArrayList<BoissonChaude> reserve_boisson_chaude;
    private ArrayList<Dessert> reserve_dessert;
    private ArrayList<DessertFroid> reserve_dessert_froid;
    private static int quantite = 0;
    private final int MAX_QUANTITE = 600;

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
        if (chance == 2) r = 100;
        if (r <= 85){
            int cpt = 0;
            String [] liste_ingred = Ingredient.getListeIngredient();
            String [] liste_boisson = Boisson.getListeBoisson();
            String [] liste_boisson_chaude = BoissonChaude.getListeBoissonChaude();
            String [] liste_dessert = Dessert.getListeDessert();
            String [] liste_dessert_froid = DessertFroid.getListeDessertFroid();

            //-----INGREDIENT-----
            for (String i : liste_ingred){
                double prix = 0;
                double poids = 0;
                switch(i){
                    case "Tomate": prix = 0.5; poids = 0.4; break;
                    case "Salade": prix = 0.5; poids = 0.1; break;
                    case "Oignon": prix = 0.6; poids = 0.2; break;
                    case "Fromage": prix = 0.8; poids = 0.5; break;
                    case "Beacon": prix = 1; poids = 0.4; break;
                    case "Steak": prix = 2; poids = 0.5; break;
                    case "Sauce": prix = 1; poids = 0.3; break;
                    case "Pain": prix = 1; poids = 0.4; break;
                    default: prix = 0; poids = 0; break;
                }

                for (Ingredient ing : reserve_ingredient){
                    if(ing.getNom()==i) cpt++;
                }
                for (int j = cpt; j < 30 ; j++){
                    reserve_ingredient.add(new Ingredient(i,poids,prix));
                    Stock.quantite++;
                }
                cpt = 0;
            } 


            //-----BOISSON-----
            for (String i : liste_boisson){
                double prix = 0;
                int cl = 0;
                switch(i){
                    case "Jus": prix = 2.5; cl = 33; break;
                    case "Eau": prix = 2; cl = 50; break;
                    case "Coca": prix = 3; cl = 33; break;
                    default: prix = 0; cl = 0; break;
                }

                for (Boisson ing : reserve_boisson){
                    if(ing.getNom()==i) cpt++;
                }
                for (int j = cpt; j < 30 ; j++){
                    reserve_boisson.add(new Boisson(prix,i,cl));
                    Stock.quantite++;
                }
                cpt = 0;
            } 

            //-----BOISSON CHAUDE-----
            for (String i : liste_boisson_chaude){
                double prix = 0;
                int cl = 0;
                switch(i){
                    case "Cafe": prix = 2.5; cl = 15; break;
                    case "The": prix = 2.5; cl = 33; break;
                    case "Vin": prix = 4.5; cl = 20; break;
                    default: prix = 0; cl = 0; break;
                }
                for (BoissonChaude ing : reserve_boisson_chaude){
                    if(ing.getNom()==i) cpt++;
                }
                for (int j = cpt; j < 30 ; j++){
                    reserve_boisson_chaude.add(new BoissonChaude(prix,i,cl));
                    Stock.quantite++;
                }
                cpt = 0;
            } 

            //-----DESSERT-----
            for (String i : liste_dessert){
                double prix = 0;
                switch(i){
                    case "Donut": prix = 3; break;
                    case "Brownie": prix = 3; break;
                    case "Cookie": prix = 3; break;
                    default: prix = 0; break;
                }
                for (Dessert ing : reserve_dessert){
                    if(ing.getNom()==i) cpt++;
                }
                for (int j = cpt; j < 30 ; j++){
                    reserve_dessert.add(new Dessert(prix,i));
                    Stock.quantite++;
                }
                cpt = 0;
            } 

            //-----DESSERT FROID-----
            for (String i : liste_dessert_froid){
                double prix = 0;
                switch(i){
                    case "Glace": prix = 3.5; break;
                    case "Compotte": prix = 2; break;
                    case "Yaourt": prix = 2; break;
                    default: prix = 0; break;
                }
                for (DessertFroid ing : reserve_dessert_froid){
                    if(ing.getNom()==i) cpt++;
                }
                for (int j = cpt; j < 30 ; j++){
                    reserve_dessert_froid.add(new DessertFroid(prix,i));
                    Stock.quantite++;
                }
                cpt = 0;
            } 
        }
        else{
        System.out.println("|-| ALERT RADIO |-| ACCIDENT DE LA ROUTE, LIVRAISON DU STOCK IMPOSSIBLE POUR MAKER !\n");
        MyUtils.line();
        System.out.println();
        }

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