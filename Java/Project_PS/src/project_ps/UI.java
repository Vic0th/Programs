
package project_ps;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;
import javax.swing.JOptionPane;

public class UI extends JFrame implements ActionListener{

int sizeW = 800;
int sizeH = 700;
    
Codes code = new Codes();

JButton butMain = new JButton("Ana Menü");
    
/////////////////////////////////////////////////////////////
//-----------MENU
JPanel panMenu = new JPanel();
JButton butM0 = new JButton("Ki-Kare ve Testleri");
JButton butM1 = new JButton("Dağılımlar 1");
JButton butM2 = new JButton("Dağılımlar 2");
JButton butM3 = new JButton("Eşitsizlikler");
JButton butM4 = new JButton("Diğer");
JLabel des1 = new JLabel("Birden çok sayıyı , (virgül) ile ayırınız. 65,23,54 gibi.");
JLabel des2 = new JLabel("Kesirli sayılar için . (nokta) kullanınız. 16.7 gibi.");
JLabel des3 = new JLabel("Sayılar arasındaki boşlukların herhangi bir etkisi yoktur.");
/////////////////////////////////////////////////////////////
//-----------1.Panel
JPanel pan1 = new JPanel();
JTextField p1I0 = new JTextField("25,15,12,26,15,27");
JTextField p1I1 = new JTextField("24,98,95,23");
JTextField p1I2 = new JTextField("30,90,90,30");
JTextField p1I3 = new JTextField("90,40,35,110");
JTextField p1I4 = new JTextField("2,2");
JButton p1B0 = new JButton("Hesapla");
JButton p1B1 = new JButton("Hesapla");
JButton p1B2 = new JButton("Hesapla");
JLabel p1l1 = new JLabel("Düzgün Dağılım Uygunluk Testi (Eşit Beklenen Frekanslar İçin)");
JLabel p1l2 = new JLabel("Sonuç :");
JLabel p1l3 = new JLabel("Normal Dağılım Uyum Testi (Gözlenen ve beklenen frekanslar ile)");
JLabel p1l4 = new JLabel("Sonuç :");
JLabel p1l5 = new JLabel("Ki-Kare Bağımsızlık Testi  (Frekanslar ve Tablo Satır-Sütun Sayısı ile )");
JLabel p1l6 = new JLabel("Sonuç :");
JLabel p1o1 = new JLabel();
JLabel p1o2 = new JLabel();
JLabel p1o3 = new JLabel();
JLabel p1inf1 = new JLabel("Frekans");
JLabel p1inf2 = new JLabel("Gözlenen Frekans");
JLabel p1inf3 = new JLabel("Beklenen Frekans");
JLabel p1inf4 = new JLabel("Frekanslar");
JLabel p1inf5 = new JLabel("Tablo Satır, Sütun Sayısı");

/////////////////////////////////////////////////////////////
//------------2.Panel
JPanel pan2 = new JPanel();
JButton pan2b1 = new JButton("Hesapla");
JButton pan2b2 = new JButton("Hesapla");
JButton pan2b3 = new JButton("Hesapla");
JTextField pan2text1 = new JTextField("13");
JTextField pan2text2 = new JTextField("0.32");
JTextField pan2text3 = new JTextField("5");
JTextField pan2text4 = new JTextField("0.23");
JTextField pan2text5 = new JTextField("6");
JTextField pan2text6 = new JTextField("2.56");
JTextField pan2text7 = new JTextField("8");
JLabel pan2info1 = new JLabel("Bernoulli Deneme Sayısı");
JLabel pan2info2 = new JLabel("Başarı Olasılığı");
JLabel pan2info3 = new JLabel("Başarılı Deneme Sayısı");
JLabel pan2info4 = new JLabel("Başarı olasılığı");
JLabel pan2info5 = new JLabel("Deneme Sayısı");
JLabel pan2info6 = new JLabel("Dağılım Ortalaması");
JLabel pan2info7 = new JLabel("Olay Sayısı");
JLabel pan2lab1 = new JLabel("Binom Dağılımı Hesaplama");
JLabel pan2lab2 = new JLabel("Geometrik Dağılım Hesaplama");
JLabel pan2lab3 = new JLabel("Poisson Dağılımı Hesaplama");
JLabel pan2out1 = new JLabel();
JLabel pan2out2 = new JLabel();
JLabel pan2out3 = new JLabel();
JLabel pan2out4 = new JLabel();
JLabel pan2out5 = new JLabel();
JLabel pan2out6 = new JLabel();
JLabel pan2out7 = new JLabel();
JLabel pan2out8 = new JLabel();
JLabel pan2out9 = new JLabel();
JLabel pan2final1 = new JLabel("Olasılık Değeri :");
JLabel pan2final2 = new JLabel("Beklenen Değer :");
JLabel pan2final3 = new JLabel("Varyans :");
JLabel pan2final4 = new JLabel("Olasılık Değeri :");
JLabel pan2final5 = new JLabel("Beklenen Değer :");
JLabel pan2final6 = new JLabel("Varyans :");
JLabel pan2final7 = new JLabel("Olasılık Değeri :");
JLabel pan2final8 = new JLabel("Beklenen Değer :");
JLabel pan2final9 = new JLabel("Varyans :");

/////////////////////////////////////////////////////////////
//------------3.Panel
JPanel pan3 = new JPanel();
JLabel pan3lab1 = new JLabel("Üstel Dagılım Hesaplama");
JLabel pan3lab2 = new JLabel("Negatif Binom Dağılımı Hesaplama");
JLabel pan3info1 = new JLabel("Ortalama Değer");
JLabel pan3info2 = new JLabel("Maximum Değer");
JLabel pan3info3 = new JLabel("Minimum Değer");
JLabel pan3info4 = new JLabel("Kaçıncı Deneyde Başarılı");
JLabel pan3info5 = new JLabel("Elde Edilen Başarı Sayısı");
JLabel pan3info6 = new JLabel("Başarı Olasılığı");
JTextField pan3text1 = new JTextField("0.3");
JTextField pan3text2 = new JTextField("4");
JTextField pan3text3 = new JTextField("0");
JTextField pan3text4 = new JTextField("8");
JTextField pan3text5 = new JTextField("5");
JTextField pan3text6 = new JTextField("0.74");
JButton pan3but1 = new JButton("Hesapla");
JButton pan3but2 = new JButton("Hesapla");
JLabel pan3final1 = new JLabel("Sonuç :");
JLabel pan3final2 = new JLabel("Beklenen Değer :");
JLabel pan3final3 = new JLabel("Varyans :");
JLabel pan3final4 = new JLabel("Olasılık Değeri :");
JLabel pan3final5 = new JLabel("Beklenen Değer :");
JLabel pan3final6 = new JLabel("Varyans :");
JLabel pan3out1 = new JLabel();
JLabel pan3out2 = new JLabel();
JLabel pan3out3 = new JLabel();
JLabel pan3out4 = new JLabel();
JLabel pan3out5 = new JLabel();
JLabel pan3out6 = new JLabel();
/////////////////////////////////////////////////////////////
//------------4.Panel
JPanel pan4 = new JPanel();
JLabel pan4lab1 = new JLabel("Chebyshev Esitsizligi Hesaplama");
JLabel pan4lab2 = new JLabel("Markov Esitsizligi Hesaplama");
JLabel pan4info1 = new JLabel("Ortalama");
JLabel pan4info2 = new JLabel("Standart Sapma");
JLabel pan4info3 = new JLabel("Maksimum veya Minimum Aralığı");
JLabel pan4info4 = new JLabel("Ortalama");
JLabel pan4info5 = new JLabel("Minimum Değer");
JTextField pan4text1 = new JTextField("26.8");
JTextField pan4text2 = new JTextField("1.25");
JTextField pan4text3 = new JTextField("15");
JTextField pan4text4 = new JTextField("14.3");
JTextField pan4text5 = new JTextField("7");
JButton pan4but1 = new JButton("Hesapla");
JButton pan4but2 = new JButton("Hesapla");
JLabel pan4final1 = new JLabel("Sonuç :");
JLabel pan4final2 = new JLabel("Sonuç :");
JLabel pan4out1 = new JLabel();
JLabel pan4out2 = new JLabel();

/////////////////////////////////////////////////////////////
//------------5.Panel
JPanel pan5 = new JPanel();
JLabel pan5lab1 = new JLabel("Permütasyon");
JLabel pan5lab2 = new JLabel("Kombinasyon");
JLabel pan5lab3 = new JLabel("Faktoriyel");
JLabel pan5lab4 = new JLabel("Beklenen Değer");
JLabel pan5info1 = new JLabel("İlk sayı , İkinci Sayı");
JLabel pan5info2 = new JLabel("İlk sayı , İkinci Sayı");
JLabel pan5info3 = new JLabel("Tam Sayı");
JLabel pan5info4 = new JLabel("Ortalama");
JTextField pan5text1 = new JTextField("13,4");
JTextField pan5text2 = new JTextField("15,7");
JTextField pan5text3 = new JTextField("9");
JTextField pan5text4 = new JTextField("46.39");
JButton pan5but1 = new JButton("Hesapla");
JButton pan5but2 = new JButton("Hesapla");
JButton pan5but3 = new JButton("Hesapla");
JButton pan5but4 = new JButton("Hesapla");
JLabel pan5final1 = new JLabel("Sonuç :");
JLabel pan5final2 = new JLabel("Sonuç :");
JLabel pan5final3 = new JLabel("Sonuç :");
JLabel pan5final4 = new JLabel("Beklenen Değer :");
JLabel pan5final5 = new JLabel("Varyans :");
JLabel pan5out1 = new JLabel();
JLabel pan5out2 = new JLabel();
JLabel pan5out3 = new JLabel();
JLabel pan5out4 = new JLabel();
JLabel pan5out5 = new JLabel();

/////////////////////////////////////////////////////////////

public void setter(){
    
    /////////////////////////////////////////////////////////
    //-----------Menu Button
    butMain.setBounds( (sizeW/2 - 75), sizeH-90, 150, 50);
    butMain.addActionListener(this);
    this.add(butMain);
    
    
    /////////////////////////////////////////////////////////
    //--------------MENU
    panMenu.setBounds(0, 0, sizeW, sizeH-50);
    panMenu.setLayout(null);
    panMenu.setVisible(false);
    
    butM0.setBounds(15, 30, 400, 50);
    butM0.addActionListener(this);
    butM1.setBounds(15, 90, 400, 50);
    butM1.addActionListener(this);
    butM2.setBounds(15, 150, 400, 50);
    butM2.addActionListener(this);
    butM3.setBounds(15, 210, 400, 50);
    butM3.addActionListener(this);
    butM4.setBounds(15, 270, 400, 50);
    butM4.addActionListener(this);
    
    des1.setBounds(15, 350, 600, 30);
    des2.setBounds(15, 400, 600, 30);
    des3.setBounds(15, 450, 600, 30);
    
    
    panMenu.add(butM0);
    panMenu.add(butM1);
    panMenu.add(butM2);
    panMenu.add(butM3);
    panMenu.add(butM4);
    
    panMenu.add(des1);
    panMenu.add(des2);
    panMenu.add(des3);
    
    /////////////////////////////////////////////////////////
    //--------------1.Panel
    pan1.setBounds(0, 0, sizeW, sizeH-50);
    pan1.setLayout(null);
    pan1.setVisible(false);
    
    p1I0.setBounds(150, 70, 270, 40);//Inp1
    p1I1.setBounds(150, 220, 270, 40);//Inp2
    p1I2.setBounds(150, 270, 270, 40);//Inp2
    p1I3.setBounds(150, 430, 270, 40);//Inp3
    p1I4.setBounds(280, 480, 140, 40);//Inp3
    
    p1B0.setBounds(475, 60, 150, 50);//But1
    p1B0.addActionListener(this);//But1
    p1B1.setBounds(475, 220, 150, 50);//But2
    p1B1.addActionListener(this);//But2
    p1B2.setBounds(475, 430, 150, 50);//But3
    p1B2.addActionListener(this);//But3
    
    p1l1.setBounds(15, 20, 400, 30);//Desc1
    p1l2.setBounds(475, 120, 50, 30);//Final1
    p1l3.setBounds(15, 170, 400, 30);//Desc2
    p1l4.setBounds(475, 280, 50, 30);//Final2
    p1l5.setBounds(15, 380, 400, 30);//Desc3
    p1l6.setBounds(475, 490, 50, 30);//Final3
    
    p1o1.setBounds(525, 120, 50, 30);//Out1
    p1o2.setBounds(525, 280, 70, 30);//Out2
    p1o3.setBounds(525, 490, 70, 30);//Out3
    
    p1inf1.setBounds(25, 70, 270, 40);
    p1inf2.setBounds(25, 220, 270, 40);
    p1inf3.setBounds(25, 270, 270, 40);
    p1inf4.setBounds(25, 430, 270, 40);
    p1inf5.setBounds(25, 480, 270, 40);
    
    pan1.add(p1l1);
    pan1.add(p1l2);
    pan1.add(p1l3);
    pan1.add(p1l4);
    pan1.add(p1l5);
    pan1.add(p1l6);
    pan1.add(p1I0);
    pan1.add(p1I1);
    pan1.add(p1I2);
    pan1.add(p1I3);
    pan1.add(p1I4);
    pan1.add(p1B0);
    pan1.add(p1B1);
    pan1.add(p1B2);
    pan1.add(p1o1);
    pan1.add(p1o2);
    pan1.add(p1o3);
    pan1.add(p1inf1);
    pan1.add(p1inf2);
    pan1.add(p1inf3);
    pan1.add(p1inf4);
    pan1.add(p1inf5);
    
    /////////////////////////////////////////////////////////
    //--------------2.Panel
    pan2.setBounds(0, 0, sizeW, sizeH-50);
    pan2.setLayout(null);
    pan2.setVisible(false);
    
    //Labels
    pan2lab1.setBounds(15, 20, 400, 30);
    pan2lab2.setBounds(15, 250, 400, 30);
    pan2lab3.setBounds(15, 430, 400, 30);
    
    
    //Buttons
    pan2b1.setBounds(520, 60, 150, 50);
    pan2b1.addActionListener(this);
    pan2b2.setBounds(520, 270, 150, 50);
    pan2b2.addActionListener(this);
    pan2b3.setBounds(520, 450, 150, 50);
    pan2b3.addActionListener(this);
    
    
    //Inputs
    pan2text1.setBounds(200, 70, 180, 40);
    pan2text2.setBounds(200, 120, 180, 40);
    pan2text3.setBounds(200, 170, 180, 40);
    pan2text4.setBounds(200, 300, 180, 40);
    pan2text5.setBounds(200, 350, 180, 40);
    pan2text6.setBounds(200, 480, 180, 40);
    pan2text7.setBounds(200, 530, 180, 40);
    
    
    //Input Info
    pan2info1.setBounds(25, 70, 270, 40);
    pan2info2.setBounds(25, 120, 270, 40);
    pan2info3.setBounds(25, 170, 270, 40);
    pan2info4.setBounds(25, 300, 270, 40);
    pan2info5.setBounds(25, 350, 270, 40);
    pan2info6.setBounds(25, 480, 270, 40);
    pan2info7.setBounds(25, 530, 270, 40);
    
            
    //Finals
    pan2final1.setBounds(520, 120, 100, 30);
    pan2final2.setBounds(520, 155, 100, 30);
    pan2final3.setBounds(520, 190, 100, 30);
    pan2final4.setBounds(520, 330, 100, 30);
    pan2final5.setBounds(520, 365, 100, 30);
    pan2final6.setBounds(520, 400, 100, 30);
    pan2final7.setBounds(520, 510, 100, 30);
    pan2final8.setBounds(520, 545, 100, 30);
    pan2final9.setBounds(520, 580, 100, 30);
    
    
    //Outputs
    pan2out1.setBounds(630, 120, 80, 30);
    pan2out2.setBounds(630, 155, 80, 30);
    pan2out3.setBounds(630, 190, 80, 30);
    pan2out4.setBounds(630, 330, 80, 30);
    pan2out5.setBounds(630, 365, 80, 30);
    pan2out6.setBounds(630, 400, 80, 30);
    pan2out7.setBounds(630, 510, 80, 30);
    pan2out8.setBounds(630, 545, 80, 30);
    pan2out9.setBounds(630, 580, 80, 30);
    
    
    pan2.add(pan2lab1);
    pan2.add(pan2lab2);
    pan2.add(pan2lab3);
    pan2.add(pan2text1);
    pan2.add(pan2text2);
    pan2.add(pan2text3);
    pan2.add(pan2text4);
    pan2.add(pan2text5);
    pan2.add(pan2text6);
    pan2.add(pan2text7);
    pan2.add(pan2info1);
    pan2.add(pan2info2);
    pan2.add(pan2info3);
    pan2.add(pan2info4);
    pan2.add(pan2info5);
    pan2.add(pan2info6);
    pan2.add(pan2info7);
    pan2.add(pan2b1);
    pan2.add(pan2b2);
    pan2.add(pan2b3);
    pan2.add(pan2out1);
    pan2.add(pan2out2);
    pan2.add(pan2out3);
    pan2.add(pan2out4);
    pan2.add(pan2out5);
    pan2.add(pan2out6);
    pan2.add(pan2out7);
    pan2.add(pan2out8);
    pan2.add(pan2out9);
    pan2.add(pan2final1);
    pan2.add(pan2final2);
    pan2.add(pan2final3);
    pan2.add(pan2final4);
    pan2.add(pan2final5);
    pan2.add(pan2final6);
    pan2.add(pan2final7);
    pan2.add(pan2final8);
    pan2.add(pan2final9);
    /////////////////////////////////////////////////////////
    //--------------3.Panel
    pan3.setBounds(0, 0, sizeW, sizeH-50);
    pan3.setLayout(null);
    pan3.setVisible(false);
    
    //Labels
    pan3lab1.setBounds(15, 20, 400, 30);
    pan3lab2.setBounds(15, 250, 400, 30);
    
    //Infos
    pan3info1.setBounds(25, 70, 270, 40);
    pan3info2.setBounds(25, 120, 270, 40);
    pan3info3.setBounds(25, 170, 270, 40);
    pan3info4.setBounds(25, 300, 270, 40);
    pan3info5.setBounds(25, 350, 270, 40);
    pan3info6.setBounds(25, 400, 270, 40);
    
    //Inputs
    pan3text1.setBounds(220, 70, 180, 40);
    pan3text2.setBounds(220, 120, 180, 40);
    pan3text3.setBounds(220, 170, 180, 40);
    pan3text4.setBounds(220, 300, 180, 40);
    pan3text5.setBounds(220, 350, 180, 40);
    pan3text6.setBounds(220, 400, 180, 40);
    
    //Buttons
    pan3but1.setBounds(520, 50, 150, 50);
    pan3but1.addActionListener(this);
    pan3but2.setBounds(520, 280, 150, 50);
    pan3but2.addActionListener(this);
    
    //Finals
    pan3final1.setBounds(520, 110, 100, 30);
    pan3final2.setBounds(520, 145, 100, 30);
    pan3final3.setBounds(520, 180, 100, 30);
    pan3final4.setBounds(520, 340, 100, 30);
    pan3final5.setBounds(520, 375, 100, 30);
    pan3final6.setBounds(520, 410, 100, 30);
    
    //Outputs
    pan3out1.setBounds(630, 110, 80, 30);
    pan3out2.setBounds(630, 145, 80, 30);
    pan3out3.setBounds(630, 180, 80, 30);
    pan3out4.setBounds(630, 340, 80, 30);
    pan3out5.setBounds(630, 375, 80, 30);
    pan3out6.setBounds(630, 410, 80, 30);
    
    pan3.add(pan3lab1);
    pan3.add(pan3lab2);
    pan3.add(pan3info1);
    pan3.add(pan3info2);
    pan3.add(pan3info3);
    pan3.add(pan3info4);
    pan3.add(pan3info5);
    pan3.add(pan3info6);
    pan3.add(pan3text1);
    pan3.add(pan3text2);
    pan3.add(pan3text3);
    pan3.add(pan3text4);
    pan3.add(pan3text5);
    pan3.add(pan3text6);
    pan3.add(pan3but1);
    pan3.add(pan3but2);
    pan3.add(pan3final1);
    pan3.add(pan3final2);
    pan3.add(pan3final3);
    pan3.add(pan3final4);
    pan3.add(pan3final5);
    pan3.add(pan3final6);
    pan3.add(pan3out1);
    pan3.add(pan3out2);
    pan3.add(pan3out3);
    pan3.add(pan3out4);
    pan3.add(pan3out5);
    pan3.add(pan3out6);
    
    /////////////////////////////////////////////////////////
    //--------------4.Panel
    pan4.setBounds(0, 0, sizeW, sizeH-50);
    pan4.setLayout(null);
    pan4.setVisible(false);
    
    //Labels
    pan4lab1.setBounds(15, 20, 400, 30);
    pan4lab2.setBounds(15, 250, 400, 30);
    
    //Infos
    pan4info1.setBounds(25, 70, 270, 40);
    pan4info2.setBounds(25, 120, 270, 40);
    pan4info3.setBounds(25, 170, 270, 40);
    pan4info4.setBounds(25, 300, 270, 40);
    pan4info5.setBounds(25, 350, 270, 40);
    
    //Inputs
    pan4text1.setBounds(220, 70, 180, 40);
    pan4text2.setBounds(220, 120, 180, 40);
    pan4text3.setBounds(220, 170, 180, 40);
    pan4text4.setBounds(220, 300, 180, 40);
    pan4text5.setBounds(220, 350, 180, 40);
    
    //Buttons
    pan4but1.setBounds(520, 90, 150, 50);
    pan4but1.addActionListener(this);
    pan4but2.setBounds(520, 300, 150, 50);
    pan4but2.addActionListener(this);
    
    //Finals
    pan4final1.setBounds(520, 150, 100, 30);
    pan4final2.setBounds(520, 360, 100, 30);
    
    //Outputs
    pan4out1.setBounds(630, 150, 80, 30);
    pan4out2.setBounds(630, 360, 80, 30);
    
    pan4.add(pan4lab1);
    pan4.add(pan4lab2);
    pan4.add(pan4info1);
    pan4.add(pan4info2);
    pan4.add(pan4info3);
    pan4.add(pan4info4);
    pan4.add(pan4info5);
    pan4.add(pan4text1);
    pan4.add(pan4text2);
    pan4.add(pan4text3);
    pan4.add(pan4text4);
    pan4.add(pan4text5);
    pan4.add(pan4but1);
    pan4.add(pan4but2);
    pan4.add(pan4final1);
    pan4.add(pan4final2);
    pan4.add(pan4out1);
    pan4.add(pan4out2);
    
    /////////////////////////////////////////////////////////
    //--------------5.Panel
    pan5.setBounds(0, 0, sizeW, sizeH-50);
    pan5.setLayout(null);
    pan5.setVisible(false);
    
    //Label
    pan5lab1.setBounds(15, 20, 400, 30);
    pan5lab2.setBounds(15, 150, 400, 30);
    pan5lab3.setBounds(15, 280, 400, 30);
    pan5lab4.setBounds(15, 410, 400, 30);
    
    //Info
    pan5info1.setBounds(25, 70, 270, 40);
    pan5info2.setBounds(25, 200, 270, 40);
    pan5info3.setBounds(25, 330, 270, 40);
    pan5info4.setBounds(25, 460, 270, 40);
    
    //Input
    pan5text1.setBounds(220, 70, 180, 40);
    pan5text2.setBounds(220, 200, 180, 40);
    pan5text3.setBounds(220, 330, 180, 40);
    pan5text4.setBounds(220, 460, 180, 40);
    
    //Button
    pan5but1.setBounds(520, 50, 150, 50);
    pan5but1.addActionListener(this);
    pan5but2.setBounds(520, 180, 150, 50);
    pan5but2.addActionListener(this);
    pan5but3.setBounds(520, 310, 150, 50);
    pan5but3.addActionListener(this);
    pan5but4.setBounds(520, 430, 150, 50);
    pan5but4.addActionListener(this);
    
    //Final
    pan5final1.setBounds(520, 110, 100, 30);
    pan5final2.setBounds(520, 240, 100, 30);
    pan5final3.setBounds(520, 370, 100, 30);
    pan5final4.setBounds(520, 490, 100, 30);
    pan5final5.setBounds(520, 525, 100, 30);
    
    //Output
    pan5out1.setBounds(630, 110, 80, 30);
    pan5out2.setBounds(630, 240, 80, 30);
    pan5out3.setBounds(630, 370, 80, 30);
    pan5out4.setBounds(630, 490, 80, 30);
    pan5out5.setBounds(630, 525, 80, 30);
    
    pan5.add(pan5lab1);
    pan5.add(pan5lab2);
    pan5.add(pan5lab3);
    pan5.add(pan5lab4);
    pan5.add(pan5info1);
    pan5.add(pan5info2);
    pan5.add(pan5info3);
    pan5.add(pan5info4);
    pan5.add(pan5text1);
    pan5.add(pan5text2);
    pan5.add(pan5text3);
    pan5.add(pan5text4);
    pan5.add(pan5but1);
    pan5.add(pan5but2);
    pan5.add(pan5but3);
    pan5.add(pan5but4);
    pan5.add(pan5final1);
    pan5.add(pan5final2);
    pan5.add(pan5final3);
    pan5.add(pan5final4);
    pan5.add(pan5final5);
    pan5.add(pan5out1);
    pan5.add(pan5out2);
    pan5.add(pan5out3);
    pan5.add(pan5out4);
    pan5.add(pan5out5);
    /////////////////////////////////////////////////////////
}

public void actionPerformed(ActionEvent ae){
    Object x = ae.getSource();
    
    /////////////////////////////////////////////////////////
    //---------------Menu Button
    if(x.equals(butMain)){
        //float[] ar = code.toFloatArray("10.5,12,54.5");
        //System.out.println(Arrays.toString(ar));
        panelSwitch(0);
    }
    
    /////////////////////////////////////////////////////////
    //---------------MENU
    else if(x.equals(butM0)){
        panelSwitch(1);
    }
    
    else if(x.equals(butM1)){
        panelSwitch(2);
    }
    
    else if(x.equals(butM2)){
        panelSwitch(3);
    }
    
    else if(x.equals(butM3)){
        panelSwitch(4);
    }
    
    else if(x.equals(butM4)){
        panelSwitch(5);
    }
    
    /////////////////////////////////////////////////////////
    //---------------1.Panel
    else if(x.equals(p1B0)){
        //String str1 = "25,15,12,26,15,27";     
        
        if(p1I0.getText().length() < 1)
            JOptionPane.showMessageDialog(null, "Eksik, fazla veya hatalı veri girişi.");
            
        else
        p1o1.setText( Float.toString(code.Ki_Kare(p1I0.getText()) ) );
        
        //System.out.println(code.Ki_Kare(str1));
    }
    else if(x.equals(p1B1)){
        //String str2 = "24,98,95,23";
        //String str3 = "30,90,90,30";
        if(p1I1.getText().length() < 1 || p1I2.getText().length() < 1)
            JOptionPane.showMessageDialog(null, "Eksik, fazla veya hatalı veri girişi.");
        
        
        else
        p1o2.setText( Float.toString( code.Ki_Kare(p1I1.getText(),p1I2.getText()) ) );
        
        //System.out.println(code.Ki_Kare(str2,str3));
    }
    
    else if(x.equals(p1B2)){
        //String str4 = "90,40,35,110";
        //String str5 = "2,2";
        if(p1I3.getText().length() < 1 || p1I4.getText().length() < 1)
            JOptionPane.showMessageDialog(null, "Eksik, fazla veya hatalı veri girişi.");
        
        else
        p1o3.setText( Float.toString( code.Ki_Kare_Normallik(p1I3.getText(), p1I4.getText())) );
        
        //System.out.println(code.Ki_Kare_Normallik(str4, str5));
    }
    /////////////////////////////////////////////////////////
    //---------------2.Panel
    else if(x.equals(pan2b1)){
        //n , p , X
        if(pan2text1.getText().length() < 1 || pan2text2.getText().length() < 1 ||
                pan2text3.getText().length() < 1)
            JOptionPane.showMessageDialog(null, "Eksik, fazla veya hatalı veri girişi.");
        
        
        else{
            int[] ar1 = code.toIntArray(pan2text1.getText());
            float[] ar2 = code.toFloatArray(pan2text2.getText());
            int[] ar3 = code.toIntArray(pan2text3.getText());
            
            if(ar1.length != 1 || ar2.length != 1 || ar3.length != 1)
                JOptionPane.showMessageDialog(null, "Eksik, fazla veya hatalı veri girişi.");
            
            else{
               //n , X , p
                pan2out1.setText(Float.toString( code.BinomHesapla(ar1[0], ar3[0], ar2[0]) ));
            
                //n * p
                pan2out2.setText(Float.toString( (float)ar1[0] * ar2[0] ));
            
                //n * p *(1 - p)
                pan2out3.setText(Float.toString( (float)ar1[0] * ar2[0] * (1 - ar2[0]) )); 
            }
            
        }
        
    }
    
    else if(x.equals(pan2b2)){
        //p , X
        if(pan2text4.getText().length() <  1 || pan2text5.getText().length() < 1)
            JOptionPane.showMessageDialog(null, "Eksik, fazla veya hatalı veri girişi.");
        
        
        else{
           float[] ar4 = code.toFloatArray(pan2text4.getText());
            int[] ar5 = code.toIntArray(pan2text5.getText());
        
            if(ar4.length != 1 || ar5.length != 1)
                JOptionPane.showMessageDialog(null, "Eksik, fazla veya hatalı veri girişi.");
        
            else{
                //a * Math.pow(1-a, b-1) -- a = p -- b = X
                double temp0 = ar4[0] * Math.pow(1-ar4[0] , ar5[0]-1);
                pan2out4.setText(Float.toString( (float)temp0));
        
                //(1/p)
                pan2out5.setText(Float.toString((float)1/ar4[0]));
        
                //(1-p)/(p*p)
                pan2out6.setText(Float.toString( (float)(1 - ar4[0]) / (ar4[0] * ar4[0]) ));
            }
        }
        
        
    }
    
    else if(x.equals(pan2b3)){
        // ld , X
        
        if(pan2text6.getText().length() < 1 || pan2text7.getText().length() < 1)
            JOptionPane.showMessageDialog(null, "Eksik, fazla veya hatalı veri girişi.");
            
            
        else{
           float[] ar6 = code.toFloatArray(pan2text6.getText());
            int[] ar7 = code.toIntArray(pan2text7.getText());
        
        
            if(ar6.length != 1 || ar7.length != 1)
                JOptionPane.showMessageDialog(null, "Eksik, fazla veya hatalı veri girişi.");
            
            else{
               double E = 2.71;
        
                // a = ld , b = X
                // doube - Math.pow(E, (-a))*Math.pow(a, b)/fakt(b);
                pan2out7.setText(Double.toString( (double)Math.pow(E , (-ar6[0])) * Math.pow(ar6[0] , ar7[0]) /
                        code.factorial(ar7[0]) ));
        
                // ld
                pan2out8.setText(Float.toString(ar6[0] ));
        
                // ld
                pan2out9.setText(Float.toString(ar6[0] ));  
            }    
        }
        
    }
    /////////////////////////////////////////////////////////
    //---------------3.Panel
    else if(x.equals(pan3but1)){
        
        if(pan3text1.getText().length() <  1 || pan3text2.getText().length() < 1
                || pan3text3.getText().length() < 1)
            JOptionPane.showMessageDialog(null, "Eksik, fazla veya hatalı veri girişi.");
        
        
        else{
            float[] ar1 = code.toFloatArray(pan3text1.getText());
            int[] ar2 = code.toIntArray(pan3text2.getText());
            int[] ar3 = code.toIntArray(pan3text3.getText());
        
            if(ar1.length != 1 || ar2.length != 1 || ar3.length != 1)
                JOptionPane.showMessageDialog(null, "Eksik, fazla veya hatalı veri girişi.");
        
            else{
                pan3out1.setText( Double.toString(code.UstHesapla(ar1[0],ar2[0],ar3[0])) );
                pan3out2.setText( Float.toString( (float) 1 / ar1[0]) );
                pan3out3.setText( Double.toString( (float)Math.pow(1/ar1[0],2)) );
                
            }
        }
    }
    
    else if(x.equals(pan3but2)){
        
        if(pan3text4.getText().length() <  1 || pan3text5.getText().length() < 1
                || pan3text6.getText().length() < 1)
            JOptionPane.showMessageDialog(null, "Eksik, fazla veya hatalı veri girişi.");
        
        
        else{
            int[] ar1 = code.toIntArray(pan3text4.getText());
            int[] ar2 = code.toIntArray(pan3text5.getText());
            float[] ar3 = code.toFloatArray(pan3text6.getText());
        
            if(ar1.length != 1 || ar2.length != 1 || ar3.length != 1)
                JOptionPane.showMessageDialog(null, "Eksik, fazla veya hatalı veri girişi.");
        
            else{
                pan3out4.setText( Double.toString(code.NegBinHesapla(ar1[0],ar2[0],ar3[0])) );
                pan3out5.setText( Float.toString( (float)ar2[0] / ar3[0]) );
                pan3out6.setText( Float.toString( (float)ar2[0] * (1 - ar3[0]) / (ar3[0] * ar3[0]) ) );
            }
        }
    }
    /////////////////////////////////////////////////////////
    //---------------4.Panel
    else if(x.equals(pan4but1)){
        
        if(pan4text1.getText().length() <  1 || pan4text2.getText().length() < 1
                || pan4text3.getText().length() < 1)
            JOptionPane.showMessageDialog(null, "Eksik, fazla veya hatalı veri girişi.");
        
        
        else{
            float[] ar1 = code.toFloatArray(pan4text1.getText());
            float[] ar2 = code.toFloatArray(pan4text2.getText());
            float[] ar3 = code.toFloatArray(pan4text3.getText());
        
            if(ar1.length != 1 || ar2.length != 1 || ar3.length != 1)
                JOptionPane.showMessageDialog(null, "Eksik, fazla veya hatalı veri girişi.");
        
            else{
                pan4out1.setText( Double.toString( code.ChebyshevEsitsizligi(ar1[0],ar2[0],ar3[0]) ));
            }
        }
    }
    
    else if(x.equals(pan4but2)){
        
        if(pan4text4.getText().length() <  1 || pan4text5.getText().length() < 1)
            JOptionPane.showMessageDialog(null, "Eksik, fazla veya hatalı veri girişi.");
        
        
        else{
            float[] ar1 = code.toFloatArray(pan4text4.getText());
            float[] ar2 = code.toFloatArray(pan4text5.getText());
        
            if(ar1.length != 1 || ar2.length != 1)
                JOptionPane.showMessageDialog(null, "Eksik, fazla veya hatalı veri girişi.");
        
            else{
                pan4out2.setText( Float.toString( (float)ar1[0] / ar2[0] ));
            }
        }
    }
    /////////////////////////////////////////////////////////
    //---------------5.Panel
    else if(x.equals(pan5but1)){
        
        if(pan5text1.getText().length() <  1)
            JOptionPane.showMessageDialog(null, "Eksik, fazla veya hatalı veri girişi.");
        
        
        else{
            int[] ar1 = code.toIntArray(pan5text1.getText());
        
            if(ar1.length != 2)
                JOptionPane.showMessageDialog(null, "Eksik, fazla veya hatalı veri girişi.");
        
            else{
                pan5out1.setText( Long.toString( code.permutation(ar1[0], ar1[1]) ));
            }
        }
    }
    
    else if(x.equals(pan5but2)){
        
        if(pan5text2.getText().length() <  1)
            JOptionPane.showMessageDialog(null, "Eksik, fazla veya hatalı veri girişi.");
        
        
        else{
            int[] ar1 = code.toIntArray(pan5text2.getText());
        
            if(ar1.length != 2)
                JOptionPane.showMessageDialog(null, "Eksik, fazla veya hatalı veri girişi.");
        
            else{
                pan5out2.setText( Long.toString( code.combination(ar1[0], ar1[1]) ));
            }
        }
    }
    
    else if(x.equals(pan5but3)){
        
        if(pan5text3.getText().length() <  1)
            JOptionPane.showMessageDialog(null, "Eksik, fazla veya hatalı veri girişi.");
        
        
        else{
            int[] ar1 = code.toIntArray(pan5text3.getText());
        
            if(ar1.length != 1)
                JOptionPane.showMessageDialog(null, "Eksik, fazla veya hatalı veri girişi.");
        
            else{
                pan5out3.setText( Long.toString( code.factorial(ar1[0]) ));
            }
        }
    }
    
    else if(x.equals(pan5but4)){
        
        if(pan5text4.getText().length() <  1)
            JOptionPane.showMessageDialog(null, "Eksik, fazla veya hatalı veri girişi.");
        
        
        else{
            float[] ar1 = code.toFloatArray(pan5text4.getText());
        
            if(ar1.length != 1)
                JOptionPane.showMessageDialog(null, "Eksik, fazla veya hatalı veri girişi.");
        
            else{
                pan5out4.setText( Float.toString( (float)1 / ar1[0]) );
                pan5out5.setText( Double.toString( Math.pow((float)1/ar1[0],2 ) ) );
            }
        }
    }
    /////////////////////////////////////////////////////////
}

public void panelSwitch(int x){
    panMenu.setVisible(false);
    pan1.setVisible(false);
    pan2.setVisible(false);
    pan3.setVisible(false);
    pan4.setVisible(false);
    pan5.setVisible(false);
    
    
    if(x == 0){
        panMenu.setVisible(true);
    }
    else if(x == 1){
        pan1.setVisible(true);
    }
    else if(x == 2){
        pan2.setVisible(true);
    }
    else if(x == 3){
        pan3.setVisible(true);
    }
    else if(x == 4){
        pan4.setVisible(true);
    }
    else if(x == 5){
        pan5.setVisible(true);
    }
}


UI(String str){
    super(str);
    
    this.setResizable(true);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setSize(sizeW, sizeH);
    this.setLocationRelativeTo(null);
    
    setter();
    this.add(panMenu);
    this.add(pan1);
    this.add(pan2);
    this.add(pan3);
    this.add(pan4);
    this.add(pan5);
    
    
    
    panelSwitch(0);
    this.setVisible(true);
    
}

public static void main(String[] arg){
    UI ui = new UI("Olasılık Ve İstatistik Hesaplayıcı");
}
    
}
