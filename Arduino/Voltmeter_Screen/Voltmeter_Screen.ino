//#include <LCD5110_Basic.h>
#include <Wire.h> 
#include <EEPROM.h>
#include <LiquidCrystal_I2C.h>

//LCD5110 myGLCD(11,10,9,7,8);

extern uint8_t SmallFont[];
extern uint8_t MediumNumbers[];

char str_buf[100];

double capacity = 0;
double reserve = 0;
double current = 0;

byte high, low;
unsigned int time_ep = 100;

double ream = 0;
double reamc = 0;
double reamd = 0;




#define UD  4                          // OUTPUT
#define INC 5
#define CS  6

void up(){
  digitalWrite(UD, HIGH);
  digitalWrite(INC, HIGH);
  digitalWrite(CS, LOW);              // turn on the microcircuit
  delayMicroseconds(10);
  digitalWrite(INC, LOW);
  delayMicroseconds(10);
 // digitalWrite(INC, HIGH);
 // delayMicroseconds(10);
 // digitalWrite(INC, LOW);            // in this case the position of the slider is not written
 // digitalWrite(CS, HIGH);             // turn off the chip and write the position in the EEPROM
}

void down(){
  digitalWrite(UD, LOW);
  digitalWrite(INC, HIGH);
  digitalWrite(CS, LOW);
  delayMicroseconds(10);
  digitalWrite(INC, LOW);
  delayMicroseconds(10);
 // digitalWrite(INC, HIGH);
 // delayMicroseconds(10);
// digitalWrite(INC, LOW);   
 // digitalWrite(CS, HIGH);
}


unsigned int sj1 = 0;
unsigned int sj2 = 0;
unsigned int sj3 = 0;
unsigned int sjerr = 0;

#define hBut 2
#define hRel 3

#define hRead A0

#define buzzer 7
#define relayO 8

#define butUp A2
#define butDown A3
#define vMet A6

LiquidCrystal_I2C lcd(0x27,24,4);

void setup()
{
  
pinMode(hBut, INPUT);           // button
digitalWrite(hBut, HIGH);       
pinMode(hRel, OUTPUT);          // relay
digitalWrite(hRel, LOW); 


if(EEPROM.read(2)==0xAA){
  
high = EEPROM.read(0);
low = EEPROM.read(1);
reserve = word(high,low) / 100.0f;

high = EEPROM.read(3);
low = EEPROM.read(4);
capacity = word(high,low);

  }
  
if(capacity > 500) capacity = 500;
if(capacity < 5) capacity = 5;


/*
myGLCD.InitLCD();
myGLCD.clrScr();
myGLCD.setFont(SmallFont);
*/

lcd.init();
lcd.clear();
lcd.backlight();
lcd.noAutoscroll();

pinMode(vMet, INPUT);

pinMode(buzzer, OUTPUT);
pinMode(relayO, OUTPUT);

pinMode(butUp, INPUT);
pinMode(butDown, INPUT);


  pinMode(INC, OUTPUT);
  pinMode(UD, OUTPUT);
  pinMode(CS, OUTPUT);
  digitalWrite(CS, LOW); 

for(int i = 0 ; i < 100; i++){
  
  up();
   delay(10);
  }
  sj3 = 100;


}


float vValue;

unsigned long acTime = 0;
unsigned long delTime = 0;

short actInc = 1;
bool isAct = false;

float vBorder = 10.5;


void loop()
{

///Voltmeter///

if(millis() < delTime)
  delTime = 0;

if(millis() > delTime + 500){
  vValue = (float)analogRead(vMet) / 68.2 * 1.2 - 0.15;
  delTime = millis();
}
lcd.setCursor(15,0);
lcd.print((String)vValue + "V");


///Control///

if(vValue < vBorder)
  isAct = true;

else if(isAct && vValue >= vBorder + actInc)
  isAct = false;


///Buzzer///

if(isAct || vValue <= vBorder + 0.2)
  digitalWrite(buzzer,HIGH);
else
  digitalWrite(buzzer,LOW);




///Relay///
if(!isAct){
  digitalWrite(relayO, HIGH);
  lcd.setCursor(15,2);
  lcd.print("Rel:OFF");
}
else{
  digitalWrite(relayO, LOW);
  lcd.setCursor(15,2);
  lcd.print("Rel:ON ");
}
  


///Voltage Adjustment///
if(millis() < acTime)
acTime = 0;

if(millis() > acTime + 250){
  if(analogRead(butUp) > 650 ){
    vBorder += 0.1;
    acTime = millis();
  }
  else if(analogRead(butDown) > 650 ){
    vBorder -= 0.1;
    acTime = millis();
  }
}

lcd.setCursor(15,1);
lcd.print((String)vBorder + "L");

/////////////



if(digitalRead(hBut)==0){
  
//myGLCD.clrScr();
lcd.clear();

unsigned int but_tim = 0;

while(digitalRead(hBut)==0){
  
   sprintf(str_buf,"CALIBRATION %2d",but_tim);
   //myGLCD.print(str_buf, 0, 0); 
   lcd.setCursor(0,0);
   lcd.print(str_buf);
   
   delay(50);
   but_tim++;  if(but_tim > 100) break;
 }
 
capacity = reserve;
if(capacity > 500) capacity = 500; if(capacity < 5) capacity = 5;

if(but_tim > 100){ capacity = 400; reserve = 0;};



EEPROM.write(3,highByte(int(capacity)));
EEPROM.write(4,lowByte(int(capacity)));

//myGLCD.clrScr();
//myGLCD.print("MAXAMPRECORDED", 0, 24); 

lcd.clear();
lcd.setCursor(12,0);
lcd.print("MAXAMPRECORDED");

delay(1000);

//myGLCD.clrScr();
//myGLCD.setFont(SmallFont);

lcd.clear();

}



current = 0;

for(int i = 0 ; i < 400; i++){

  delayMicroseconds(10);
  current += analogRead(hRead) - 512;
 
  }
  
current /=   400.0f;

current *=   0.358f;  // çarpan
// yüzde kaç fazla ölçtüðünü hesapla. O kadar deðeri düþür. örnek : 0.376f


current +=   0.36f ;  //   burasýý kalibrasyon içinnnn ******************************
// 1. Deðere 0.0f yaz. Yükle ekrandaki yazýyý oku. Ekrandaki yazýyý buraya yaz. örnek 1.43f


reserve +=  current / 3600  ; 

if(reserve < 0       ) reserve = 0;
if(reserve > capacity) reserve = capacity;

float f = 14.5f;




sprintf(str_buf,"Rez: %03d/%03d a",int(reserve),int(capacity));
//myGLCD.print(str_buf, 0, 0); 
//myGLCD.print("A:" , 0, 8);
//myGLCD.print("%:" , 0, 24);

//myGLCD.setFont(MediumNumbers);

//myGLCD.printNumF(current,2,12,8,'.',6,'0');
//myGLCD.printNumF(reserve / capacity * 100,2,24,24,'.',5,'0');


lcd.setCursor(0,0);
lcd.print(str_buf);

lcd.setCursor(0,1);
lcd.print("A: " + (String)current);

lcd.setCursor(0,2);
lcd.print("%: " + (String)(reserve / capacity * 100));


//myGLCD.setFont(SmallFont);
//sprintf(stra,"sarj     : %03f",volt); myGLCD.print(stra, 0, 16); 





if(fabs(current) > 0.5f){

reamc = (reamc * 0.90f) + ( current * 0.1f );
if(current < 0){ ream = reserve / reamc  ; } else {  ream = ( capacity - reserve )  / reamc  ; }
ream = fabs(ream);
if(ream > 999) ream = 999;
reamd = (ream - int(ream)) * 60;

sprintf(str_buf,"%02d:%02d saat",int(ream),int(reamd));
//myGLCD.print(str_buf, 24, 40); 

lcd.setCursor(0,3);
lcd.print(str_buf);


}else {
  
//myGLCD.print("--:-- saat", 24, 40); 

lcd.setCursor(4,3);
lcd.print("--:-- saat");

}






time_ep++;
if(time_ep > 60){
unsigned int reserve_ep = reserve * 100;
EEPROM.write(0,highByte(reserve_ep));
EEPROM.write(1,lowByte(reserve_ep));
EEPROM.write(2,0xAA);
time_ep = 0;
}





  if(reserve / capacity < 0.70f) {
  digitalWrite(hRel, HIGH); 
 // myGLCD.print("SRJ" , 0, 40);
  
  
  
  if(current < 32.0f){
    sj3--;
    //myGLCD.printNumI(sj3, 0, 40, 3, '0');
    
    lcd.setCursor(0,3);
    lcd.print((String)sj3);
    
    down(); }
    
  if(current > 36.0f){
       sj3++;
       if(sj3>100) { sj3 = 100; }
    //myGLCD.printNumI(sj3, 0, 40, 3, '0');
    
    lcd.setCursor(0,3);
    lcd.print((String)sj3);
    
    up();}


    if(current > 41.0f){
      
       sj3 += 6 ;
       if(sj3>100) { sj3 = 100; }
    //myGLCD.printNumI(sj3, 0, 40, 3, '0');
    
    lcd.setCursor(0,3);
    lcd.print((String)sj3);
    
    up();up();up();up();up();
      
      }
  
  } 
  
  if (reserve / capacity > 0.98f){
  digitalWrite(hRel, LOW);
  //myGLCD.print("   " , 0, 40); 
  
  lcd.setCursor(0,3);
  lcd.print("   ");
  }


//delay(965);

//myGLCD.print("kap :" , 0, 0); myGLCD.printNumF(13.2f,3,30,0,'.',8,'0');
//myGLCD.setFont(MediumNumbers);
//myGLCD.printNumI(43, 48, 0, 3, '0');
}
