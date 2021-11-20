
package project_ps;

import java.util.Arrays;
import javax.swing.JOptionPane;

public class Codes {
    
    public int[] toIntArray(String str){
        int x;
        StringBuilder sb = new StringBuilder(str);
        for(x = 0; x < sb.length(); x++){
            if(sb.charAt(x) == ' '){
                sb.deleteCharAt(x);
                x--;
            }
                
        }
        
        String[] strin = sb.toString().split(",");
        int[] arr = new int[strin.length];
        
        for(x=0; x < strin.length; x++)
            arr[x] = Integer.parseInt(strin[x]);
        
        return arr;
    }
    
    
    public float[] toFloatArray(String str){
        int x;
        StringBuilder sb = new StringBuilder(str);
        for(x = 0; x < sb.length(); x++){
            if(sb.charAt(x) == ' '){
                sb.deleteCharAt(x);
                x--;
            }
                
        }
        
        String[] strin = sb.toString().split(",");
        float[] arr = new float[strin.length];
        
        for(x=0; x < strin.length; x++)
            arr[x] = Float.parseFloat(strin[x]);
        
        return arr;
    }
    
    
    public float Ki_Kare_Normallik(String str, String RC){
        
        if(RC.equals("") || RC.equals(" ") || str.equals("") || str.equals(" ")){
            JOptionPane.showMessageDialog(null, "Eksik veri girişi.");
            return 0;
        }
        
        int x, y, z=0;
        int yv, xv;
        
        int[] inp = toIntArray(RC);
        
        if(inp.length != 2){
            JOptionPane.showMessageDialog(null, "Satır sütun sayılarında hata bulunmakta.");
            return 0;
        }
            
        
        yv = inp[0];
        xv = inp[1];
        
        
        int[] artemp = toIntArray(str);
        int[][] arr = new int[yv][xv];
        
        
        if(artemp.length != xv*yv){
            JOptionPane.showMessageDialog(null, "Satır sütun sayılarında hata bulunmakta.");
            return 0;
        }
            
        
        
        //Calculating Total Frequency
        int totalAll = 0;
        for(x = 0; x < artemp.length; x++)
            totalAll += artemp[x];
        
        
        //Creating Table
        for(y=0; y < yv; y++){
            for(x=0; x < xv; x++){
                arr[y][x] = artemp[z];
                z++;
            }
        }
        
        //System.out.println(Arrays.toString(artemp));
        //System.out.println(Arrays.deepToString(arr));
        
        //Table Columns and Rows
        int[] totalY = new int[yv];
        int[] totalX = new int[xv];
        
        for(y=0; y < yv; y++)
            totalY[y] = 0;
        for(x=0; x < xv; x++){
            totalX[x] = 0;
        }
        
        
        //Table Column and Row Total Frequencies
        for(y=0; y < yv; y++){
            for(x=0; x < xv; x++){
                totalY[y] += arr[y][x];
                totalX[x] += arr[y][x];
            }
        }
        
        //System.out.println(Arrays.toString(totalY));
        //System.out.println(Arrays.toString(totalX));
        //System.out.println();
        
        //Calculation
        float ki=0;
        float exp;
        int below = 0;
        for(y=0; y < yv; y++){
            for(x=0; x < xv; x++){
                exp = (float)(totalY[y] * totalX[x]) / totalAll;
                if(exp < 5)
                    below++;
                ki += (float) Math.pow((arr[y][x] - exp),2) / exp;
            }
        }
        
        
        if( ( (float) below / (xv*yv) ) >= 0.20){
            JOptionPane.showMessageDialog(null, "5'den küçük beklenen frekans oranı %20'den küçük olduğundan "
                    + "ki kare normallik testi uygulanamaz.");
            return 0;
        }
        
        return ki;
    }
    
    
    public float Ki_Kare(String str){
        //Sadece frekanslar girilerek ki kare hesaplama
        float total = 0;
        int freq = 0, x;
        int[] arr = toIntArray(str);
        
        
        int len = arr.length;

        for(x=0; x < len; x++)
            freq += arr[x];
        
        float exp = (float)freq / len;
        
        
        for(x=0; x < len; x++){
            total += (float) Math.pow((arr[x] - exp),2) / exp;
        }
        
        return total;
    }
    
    
    public float Ki_Kare(String frek, String beklen){
        //Frekanslar ve beklentiler girilerek ki kare hesaplama
        float total = 0;
        int x;
        int[] frekans = toIntArray(frek);
        int[] beklenti = toIntArray(beklen);
        
        if(frekans.length != beklenti.length){
            JOptionPane.showMessageDialog(null,"Frekans ve beklenti sayıları uyuşmamakta.");
            //System.out.println("Frekans ve beklenti sayıları uyuşmamakta.");
            return 0;
        }
        
        for(x=0; x < frekans.length; x++){
            total += (float) Math.pow((frekans[x] - beklenti[x]),2) / beklenti[x];
        }
        
        return total;
    }
    
    
    public long factorial(int x){
        long t = 1;
        if(x < 1)
            return 0;
        
        else if(x == 1)
            return 1;
        
        else{
            for(int y=1; y <= x; y++)
                t *= y;
            return t;
        }
    }
    
    
    public long permutation(int x, int y){
        
        if(x < y || x < 1 || y < 1){
            JOptionPane.showMessageDialog(null,"Geçersiz sayı girişi."
                    + " 2 sayı da pozitif tam sayı olmalı ve 1. tamsayı 2. tamsayıdan büyük veya eşit olmalıdır.");
            return 0;
        }
            
        else if(x == y)
            return factorial(x);
        
        long t = 1;
        for(int i = x; i > x - y; i--)
            t *= i;
        
        return t;
    }
    
    
    public long combination(int x, int y){
        
        if(x < y || x < 1 || y < 1){
            JOptionPane.showMessageDialog(null,"Geçersiz sayı girişi."
                    + " 2 sayı da pozitif tam sayı olmalı ve 1. tamsayı 2. tamsayıdan büyük veya eşit olmalıdır.");
            return 0;
        }
        else if(x == y)
            return 1;
        
        if(x - y > y){
            long t = 1;
            for(int i = x; i > x - y; i--)
                t *= i;
            return t / factorial(y);
        }
            
        else{
            long t = 1;
            for(int i = x; i > y; i--)
                t *= i;
            return t / factorial(x-y);
        }
    }
    
    
    public float BinomHesapla(int a,int b, double c){
        //double deger = kombinasyon(a,b)*Math.pow(c, b)*Math.pow(1-c, a-b);
        double deger = combination(a,b) * Math.pow(c, b) * Math.pow(1-c , a-b);
        return (float)deger;
    }
    
    public double UstHesapla(float a,int b,int c){
        double E = 2.71;
        if( b > 0)
        {
            if(c==0 && b> 0)
             return 1 - ( Math.pow(E,-(a*b)) );
            else
                return 0;
         }
        else if(b==-1 && c>0)//sonsuzu ifade etmek için kullanıcı ~-1 ifadesini girsin 
                return Math.pow(E,-(a*c));
        else
            return 0;
        
    }
    public double NegBinHesapla(int a,int b,float c){
        double deger = combination(a-1,b-1)*Math.pow(c, b)*Math.pow(1-c, a-b);
        return deger;
    }
    
    public double ChebyshevEsitsizligi(float ort, float stdS, float aralik){
        if(aralik>ort){
            double max_deger = aralik;
        }
        else{
            double min_deger = aralik;
        }
        double max_deger=aralik;
        double min_deger = aralik;
        //double maxort_fark;
        //maxort_fark = max_deger-ort;
        
        if(max_deger==aralik){
           
           double k = (max_deger-ort)/stdS;
           double sonuc = 1-(1/Math.pow(k, 2));
           return sonuc;
        }
        else if(min_deger==aralik) {
            double k = (min_deger-ort)/stdS;
            double sonuc = 1-(1/Math.pow(k, 2));
            return sonuc;
        }
        return 0;
    }
}
