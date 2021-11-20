
package yazituraolasilik;

import java.util.Scanner;

public class YaziTuraOlasilik {

    public static Scanner input = new Scanner(System.in);
    
    public static void main(String[] args) {
        
        System.out.print("Para kaç kez atılacak? Giriniz: ");    
        int tekrar = input.nextInt();
        
        System.out.print("Yazı mı, tura mı? Giriniz: ");
        String ihtimal = input.next();
        
        System.out.print("Kaç kez "+ihtimal+" gelme olasılığını soruyorsunuz? Giriniz: ");
        int kez = input.nextInt();
        
        double ornekuzay = Math.pow(2, tekrar);
        System.out.println("Örnek uzay: " +ornekuzay);
        
        if(kez==0){
            System.out.println("Olasılık Değeri: " +(double)1/ornekuzay);
        }
        else
        System.out.println("Olasılık Değeri: "+Binom(tekrar,kez,0.5));
    }
        public static int fakt(int s) {
		int sonuc=1;
		for(int i=1;i<=s;i++) {
			sonuc*=i;
		}
		return sonuc;
	}
        
        public static int kombinasyon(int c, int r) {
		if(c>0 && r>0 && c >= r) {
		return (fakt(c)/(fakt(c-r)*fakt(r)));
		}
		else return 0;
	}
        public static double Binom(int a,int b, double c){
            double deger=kombinasyon(a,b)*Math.pow(c, b)*Math.pow(1-c, a-b);
        return deger;
        }
}
    
