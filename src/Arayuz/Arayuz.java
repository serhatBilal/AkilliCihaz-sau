package Arayuz;

import CevreBirim.IEyleyici;
import Observer.IObserver; 
import DataBase.UserManager; 
import java.util.Scanner; 
import CevreBirim.ISicaklikAlgilayicisi;

public class Arayuz implements IArayuz, IObserver {
    
    Scanner input = new Scanner(System.in);
    
    @Override
    public boolean kullaniciGiris() {
        int hata = 0;
        
        do {
            System.out.println("KULLANICI GİRİŞ ARAYÜZÜ");
            UserManager kullanici = new UserManager();
            System.out.println("Oturum açmak için lütfen Kullanıcı Adı ve Parola girin");
            System.out.print("Kullanıcı Adınız: ");
            kullanici.SetKullaniciAdi(input.next());
            System.out.print("Parolanız: ");
            kullanici.SetParola(input.next());
            boolean sonuc = kullanici.kullaniciDogrulama(kullanici.getKullaniciAdi(), kullanici.getParola());
            
            if (sonuc) {
                return true;
            }
            hata++;
        }while (hata != 3);
        return false;
    }
    
    @Override
    public int islemSecimi() {
        System.out.println("");
        System.out.println("İŞLEM MENÜSÜ"); 
        System.out.println("1.Sıcaklık Göster"); 
        System.out.println("2.Soğutucuyu Aç"); 
        System.out.println("3.Soğutucuyu Kapat"); 
        System.out.println("4.Çıkış"); 
        System.out.println("");
        int secim = input.nextInt();
        System.out.println("Seçtiğiniz İşlem Numarası...: " + secim);
        return secim;
    }
    
    @Override
    public void sicaklikGonder(ISicaklikAlgilayicisi sicaklikAlgilayici) { 
        sicaklikAlgilayici.sicaklikGonder(); 
    }
    
    @Override public void sogutucuAc(IEyleyici eyleyici) {
        eyleyici.sogutucuAc(); 
    }
    
    @Override 
    public void sogutucuKapat(IEyleyici eyleyici) { 
        eyleyici.sogutucuKapat(); 
    }
    
    @Override 
    public void Cikis() { 
        System.out.println("Oturumunuz başarıyla sonlandırıldı."); 
    }
    
    @Override 
    public void guncelleme(int sicaklik) { 
        System.out.println("Sıcaklık güncellendi."); 
    }
    
    
}
