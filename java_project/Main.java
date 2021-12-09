import java.util.*;

public class Main{
    public static void main(String[] args){
        String line = "|----------------------------------------------------------------|";
        
        Stock mystock = Stock.getInstance();
        mystock.avoirLivraison(1);
        Scanner input = new Scanner(System.in);
        /*---- VARIABLE ----*/
        int valeur_commande = 0;
        int demarrage = 1;
        int lineval = 0;
        int pret = 0;
        int choix = 0;
        double prix = 0.0;
        int promo = 0;
        int valeur_debut_programme = 1;

        /*-------- DECLARIATION FASTFOOD ET RISQUE INCENDIE -------- */
        FastFood myfastfood = new FastFood(mystock);
        if (myfastfood.incendie()){
            MyUtils.clear();

            System.out.println("                        ALERTE INCENDIE !\n");
            MyUtils.wait(2000);
            System.out.println("                 NOUS DEVONS FERMER LE FASTFOOD !\n");
            MyUtils.wait(2000);
            System.out.println("                 DESOLE POUR LA GENE OCCASIONNEE !\n");
            System.out.println(line);
        }
        
        else{
            /*-------- CHOIX ARRIVEE --------- */
            MyUtils.clear();
            System.out.println("            Bonjour et bienvenue chez MAKER  ?\n");
            System.out.println("          Venez-vous pour passer une commande  ?\n");
            System.out.println("1 - Oui");
            System.out.println("0 - Non");
            demarrage = input.nextInt();
            System.out.print("\033[H\033[2J"); 
            if(demarrage==0) {
                System.out.println("\nTrès bien, je ne le prend pas du tout mal, allez salut ...\n\n");
                valeur_debut_programme = 0;
            }
            else System.out.println(line+"\n\n           Bienvenue chez MAKER ! Make your own Burger !\n");


            /*-------------------------------WHILE PRINCIPAL-------------------------------*/
            while(demarrage != 0){
                if (lineval == 1) System.out.println(line);
                else{
                    lineval = 1;
                    System.out.println("Que souhaitez vous faire ? \n");
                    System.out.println("1 - Passer une commande");
                    System.out.println("0 - Tout annuler");
                    valeur_commande = input.nextInt();
                    MyUtils.clear();
                    if (valeur_commande == 0){
                        System.out.println("                 Annulation de la commande en cours ...\n");
                        MyUtils.wait(1000);
                        System.out.println("                          Commande annulée !\n");
                        MyUtils.wait(2000);
                        MyUtils.clear();
                        break;
                    } 
                } 

                Commande mycommande = new Commande();

                

                while(pret != 1){
                    MyUtils.clear();
                    myfastfood.ajouterCommande(mycommande);
                    if (mycommande.toString() != ""){
                        System.out.println("              || Informations sur votre commande ||\n");
                        System.out.println(" N° de commande : "+mycommande.getId());
                        System.out.println(" Produits : "+mycommande.toString());
                        System.out.println(" Prix : "+mycommande.getPrix()+"\n");
                        System.out.println(line);
                    }
                    System.out.println("    \nQue souhaitez-vous ajouter à votre commande actuelle ? \n");
                    System.out.println("1 - Valider la commande actuelle");
                    System.out.println("2 - Ajouter un burger");
                    System.out.println("3 - Ajouter un dessert");
                    System.out.println("4 - Ajouter une boisson");
                    pret = input.nextInt();
                
                    if(pret == 1){               /*-------- VALIDATION COMMANDE --------*/
                        MyUtils.clear();
                        System.out.println("               Validation de la commande en cours...\n");
                        MyUtils.wait(2000);
                        System.out.println("\n                      Commande ajoutée !\n");
                        MyUtils.wait(2000);
                        MyUtils.clear();
                    }

                    else if(pret == 3){               /*-------- AJOUT DESSERT --------*/
                        MyUtils.clear();
                        System.out.println("    Quel type de dessert souhaitez-vous ?\n");
                        System.out.println("1 - Dessert sec");
                        System.out.println("2 - Dessert froid");
                        choix = input.nextInt();

                        if (choix == 1){
                            MyUtils.clear();
                            System.out.println("    Lequel voulez-vous dans la liste suivante ?\n");
                            System.out.println("1 - Donut");
                            System.out.println("2 - Brownie");
                            System.out.println("3 - Cookie");
                            choix = input.nextInt();
                            
                            String mychoix = "";
                            switch(choix){

                                case 1:
                                    mychoix = "Donut";
                                    break;
                                case 2:
                                    mychoix = "Brownie";
                                    break;
                                case 3:
                                    mychoix = "Cookie";
                                    break;
                                default:
                                    mychoix = "NONE";
                                    break;
                            }

                            Dessert mydessert = mystock.getDessert(mychoix);
                            mycommande.ajoutDessert(mydessert);
                            //mycommande.setPrix(mydessert.getPrix());
                        }

                        else if (choix == 2){
                            MyUtils.clear();
                            System.out.println("    Lequel voulez-vous dans la liste suivante ?\n");
                            System.out.println("1 - Glace");
                            System.out.println("2 - Compotte");
                            System.out.println("3 - Yaourt");
                            choix = input.nextInt();

                            String mychoix = "";
                            switch(choix){

                                case 1:
                                    mychoix = "Glace";
                                    break;
                                case 2:
                                    mychoix = "Compotte";
                                    break;
                                case 3:
                                    mychoix = "Yaourt";
                                    break;
                                default:
                                    mychoix = "NONE";
                                    break;
                            }

                            DessertFroid mydessertfroid = mystock.getDessertFroid(mychoix);
                            mycommande.ajoutDessert(mydessertfroid);
                            //mycommande.setPrix(mydessertfroid.getPrix());
                        }
                    }






                    else if(pret == 4){               /*-------- AJOUT BOISSON --------*/
                        MyUtils.clear();
                        System.out.println("    Quel type de boisson souhaitez-vous ?\n");
                        System.out.println("1 - Boisson fraiche");
                        System.out.println("2 - Boisson chaude");
                        choix = input.nextInt();

                        if (choix == 1){
                            MyUtils.clear();
                            System.out.println("    Laquelle voulez-vous dans la liste suivante ?\n");
                            System.out.println("1 - Eau");
                            System.out.println("2 - Jus");
                            System.out.println("3 - Coca");
                            choix = input.nextInt();

                            String mychoix = "";
                            switch(choix){

                                case 1:
                                    mychoix = "Eau";
                                    break;
                                case 2:
                                    mychoix = "Jus";
                                    break;
                                case 3:
                                    mychoix = "Coca";
                                    break;
                                default:
                                    mychoix = "NONE";
                                    break;
                            }

                            Boisson myboisson = mystock.getBoisson(mychoix);
                            mycommande.ajoutBoisson(myboisson);
                            //mycommande.setPrix(myboisson.getPrix());
                        }

                        else if (choix == 2){
                            MyUtils.clear();
                            System.out.println("    Lequel voulez-vous dans la liste suivante ?\n");
                            System.out.println("1 - Cafe");
                            System.out.println("2 - The");
                            System.out.println("3 - Vin");
                            choix = input.nextInt();
                            
                            String mychoix = "";
                            switch(choix){

                                case 1:
                                    mychoix = "Cafe";
                                    break;
                                case 2:
                                    mychoix = "The";
                                    break;
                                case 3:
                                    mychoix = "Vin";
                                    break;
                                default:
                                    mychoix = "NONE";
                                    break;
                            }

                            BoissonChaude myboissonchaude = mystock.getBoissonChaude(mychoix);
                            mycommande.ajoutBoisson(myboissonchaude);
                            //mycommande.setPrix(myboissonchaude.getPrix());
                        }
                    }





                    else if(pret == 2){               /*-------- AJOUT BURGER --------*/
                        Burger myburger = new Burger();
                        int pret_burger = 0;
                        while(pret_burger != 1){
                        MyUtils.clear();
                        if (myburger.toString() != ""){
                            System.out.println("    || Informations sur votre burger ||\n");
                            System.out.println(" Composition : "+myburger.toString());
                            System.out.println(" Prix : "+myburger.getPrix()+"\n");
                        } 
                        System.out.println("    Que voulez-vous ajouter dans votre burger ?\n");
                        System.out.println("0 - Rien d'autre !");
                        System.out.println("1 - Pain");
                        System.out.println("2 - Steak");
                        System.out.println("3 - Beacon");
                        System.out.println("4 - Sauce");
                        System.out.println("5 - Fromage");
                        System.out.println("6 - Oignon");
                        System.out.println("7 - Salade");
                        System.out.println("8 - Tomate");
                        
                        
                        choix = input.nextInt();
                        if (choix == 0) pret_burger = 1;

                        String mychoix = "";
                            switch(choix){
                                case 1:
                                    mychoix = "Pain";
                                    break;
                                case 2:
                                    mychoix = "Steak";
                                    break;
                                case 3:
                                    mychoix = "Beacon";
                                    break;
                                case 4:
                                    mychoix = "Sauce";
                                    break;
                                case 5:
                                    mychoix = "Fromage";
                                    break;
                                case 6:
                                    mychoix = "Oignon";
                                    break;
                                case 7:
                                    mychoix = "Salade";
                                    break;
                                case 8:
                                    mychoix = "Tomate";
                                    break;
                                default:
                                    mychoix = "NONE";
                                    break;
                            }
                        Ingredient myingredient = mystock.getIngredient(mychoix);
                        myburger.ajouter_ingredient(myingredient);
                        
                        
                    }
                        mycommande.ajoutBurger(myburger);
                        //mycommande.setPrix(myburger.getPrix());
                    }
                }

                prix += mycommande.getPrix();



                System.out.println("\n              Souhaitez vous ajouter une commande ?\n\n");
                System.out.println("1 - Oui");
                System.out.println("0 - Non");
                demarrage = input.nextInt(); 
                System.out.print("\033[H\033[2J");  
                if (demarrage == 0){
                    System.out.println(line);
                    break;            
                } 
                else pret = 0;
            } /*------------------------------------FIN WHILE PRINCIPAL ----------------------------------------------*/
            if((valeur_commande == 0) || (prix == 0)){
                if (valeur_debut_programme != 0){
                    System.out.println("\n\nVous n'avez rien commandé donc je vous souhaite une bonne journée ! \n\n");
                    System.out.println(line);
                    System.out.println();
                }
            }
                    else{
                        System.out.println("         \nTrès bien, nous allons procéder au payement : \n");
                        MyUtils.wait(2000);
                        System.out.println("\nLe prix de la commande totale s'élève à "+prix+" euro(s) !\n");
                        MyUtils.wait(1000);
                        System.out.println("\n    Avez-vous un code de promotion ?\n");
                        System.out.println("1 - Oui");
                        System.out.println("2 - Non");
                        choix = input.nextInt();

                        if (choix == 1){
                            System.out.println("\nEntrez votre code - 6 numéros réquis");
                            promo = input.nextInt();

                            if (promo >= 100000){
                                MyUtils.clear();
                                System.out.println("                Vérification du code en cours ...\n");
                                MyUtils.wait(1000);
                                System.out.println("                Application du code en cours ...\n");
                                MyUtils.wait(1000);
                                prix  = prix * 0.75;
                                System.out.println("           Code appliqué - Vous avez une remise de 25% !\n");
                                MyUtils.wait(1000);
                                System.out.println("Le prix de la commande totale s'élève à "+prix+" euro(s) !\n");
                                MyUtils.wait(2000);
                            }
                        }

                        System.out.println("\nEntrez votre code carte bleue - 4 numéros réquis\n");
                        choix = input.nextInt();
                        System.out.println("                Vérification du code en cours ...\n");
                        MyUtils.wait(1000);
                        System.out.println("                Code valide, payement accepté !");
                        MyUtils.wait(2000);
                        MyUtils.clear();
                        System.out.println("                   Au revoir et à bientôt !\n");
                        MyUtils.wait(2000);
                        System.out.println(line);
                    } 
            //mettre un code de promo si y'a
        }   /* fin incendie */

    }
}