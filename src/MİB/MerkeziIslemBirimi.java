package MİB;

import Arayuz.Arayuz;
import Arayuz.IArayuz;
import CevreBirim.Eyleyici;
import CevreBirim.IEyleyici;
import CevreBirim.ISicaklikAlgilayicisi;
import CevreBirim.SicaklikAlgilayici;


public class MerkeziIslemBirimi implements IMerkeziIslemBirimi {
    
    private static MerkeziIslemBirimi instance = null;
    
    private MerkeziIslemBirimi() { 
    }
    
    public static MerkeziIslemBirimi getInstance() {
        if (instance == null) {
            instance = new MerkeziIslemBirimi();
        }
        return instance;
    }
    
    IArayuz arayuz = new Arayuz();
    ISicaklikAlgilayicisi sicaklikAlgilayici = new SicaklikAlgilayici();
    IEyleyici eyleyici = new Eyleyici();
    
    @Override 
    public boolean arayuzGirisi() { 
        return arayuz.kullaniciGiris(); 
    }
    
    @Override 
    public int islemSecimi() { 
        return arayuz.islemSecimi(); 
    }
    
    @Override public void islemYap() {
        
        if (arayuzGirisi()) {
            int islem = 0;
            do {
                islem = islemSecimi();
                switch (islem) {
                    case 1: 
                        sicaklikGoster(); 
                        break; 
                    case 2: 
                        sogutucuAc(); 
                        break; 
                    case 3: 
                        sogutucuKapat(); 
                        break; 
                    case 4: 
                        Cikis(); 
                        break; 
                    default: 
                        System.out.println("Lütfen geçerli bir işlem seçiniz"); 
                        break;
                }
            }while (islem != 4);
        }else { 
            System.out.println("Arayüze giriş yapılmadı");
        }
    }
    @Override 
    public void sicaklikGoster() { 
        arayuz.sicaklikGonder(sicaklikAlgilayici); 
    }
    
    @Override 
    public void sogutucuAc() { 
        arayuz.sogutucuAc(eyleyici); 
    }
    
    @Override 
    public void sogutucuKapat() { 
        arayuz.sogutucuKapat(eyleyici); 
    }
    
    @Override 
    public void Cikis() { 
        arayuz.Cikis(); 
    }
    
}
