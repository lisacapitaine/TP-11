public class Tour {

private int lance1 ; 
private int lance2 ; 
private int compteur; 
private static int add =0; 


public Tour (int lance1 , int lance2){
    this.lance1 = lance1 ; 
    this.lance2 = lance2 ; 
    compteur = add+1 ; 
    add= add+1 ; 
}

public Tour (int lance1){
    this.lance1 = lance1 ;
    this.lance2 = 0; 
}

public int getLance1 () {
    return lance1 ; 
}

public int getLance2 () {
    return lance2 ; 
}

public int nbPoint (Tour tour2){
if (lance1== 10){
    return 10 + tour2.getLance1() + tour2.getLance2() ; 
}
 else if (lance1 + lance2 == 10){
    return 10 + tour2.getLance1() ; 
 }
else return lance1 + lance2 ; 

}

public int getCompteur () {
    return compteur ; 
}


}





//nb tombé en lancé 1 et l'autre en 2èm tour
//nb de quilles lancées du 1er et 2ème tour si pas strike ou spair
//trike 10+bonus pair et idem pour spair ? 


//la variable add est statique donc elle change pour toute les tours
//genre à notre tour3 elle vaut 3, elle vaut 3 aussi à notre tour1 et à notre tour2
//le compteur qui lui est unique à chaque tour vaut donc le add (qui change à chaque fois)
//plus 1.
