package CevreBirim;
import Observer.IObserver; 
import Observer.ISubject; 
import java.util.ArrayList; 
import java.util.Random;


public class SicaklikAlgilayici implements ISicaklikAlgilayicisi, ISubject {
    private ArrayList observers = new ArrayList();
    
    @Override 
    public int sicaklikOku() { 
        Random rndm = new Random(); return rndm.nextInt(100); 
    }
    
    @Override 
    public int sicaklikGonder() { 
        System.out.println("Sıcaklık değeri " + sicaklikOku() + " derecedir."); return sicaklikOku(); 
    }
    
    public void registerObserver(IObserver o) { 
        observers.add(o); 
    }
    
    public void removeObserver(IObserver o) {
        int i = observers.indexOf(o);
        if (i >= 0) {
            observers.remove(i);
        }
    }
    
    public void notifyObservers() {
        for (int i = 0; i < observers.size(); i++) {
            IObserver observer = (IObserver) observers.get(i);
            observer.guncelleme(sicaklikGonder());
        }
    }   
}
