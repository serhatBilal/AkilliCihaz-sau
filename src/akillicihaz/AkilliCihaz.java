package akillicihaz;
import MİB.IMerkeziIslemBirimi;
import MİB.MerkeziIslemBirimi;

public class AkilliCihaz {

    
    public static void main(String[] args) {
     
        IMerkeziIslemBirimi merkeziIslemBirimi = MerkeziIslemBirimi.getInstance();
        merkeziIslemBirimi.islemYap();
        
    }
    
}
