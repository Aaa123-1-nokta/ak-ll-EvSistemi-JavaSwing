package akillievsistemi;

public class GuvenlikFabrikasi {
    public static  GuvenlikAbstract guvenyap(String oda){
        if(oda.equalsIgnoreCase("mutfak")){
            return new GuvenlikMutfak();
        }
        else{
            return null;
        }
        
    }
    
}
