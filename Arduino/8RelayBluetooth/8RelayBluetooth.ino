
// RemoteXY select connection mode and include library 

#define REMOTEXY_MODE__SOFTSERIAL
#include <SoftwareSerial.h>
#include <RemoteXY.h>

// RemoteXY connection settings 
#define REMOTEXY_SERIAL_RX 10
#define REMOTEXY_SERIAL_TX 11
#define REMOTEXY_SERIAL_SPEED 9600


// RemoteXY configurate  
#pragma pack(push, 1)
uint8_t RemoteXY_CONF[] =
  { 255,9,0,31,0,137,1,11,25,4,
  129,0,8,34,15,6,1,92,85,121,
  100,117,0,129,0,9,24,13,6,1,
  92,75,97,112,196,177,0,129,0,0,
  4,34,6,2,92,75,108,111,122,101,
  116,32,65,46,83,46,0,129,0,0,
  16,32,6,2,92,77,117,116,102,97,
  107,32,65,46,83,46,0,129,0,11,
  4,8,6,1,92,84,86,0,129,0,
  7,14,16,6,1,92,75,108,105,109,
  97,0,129,0,2,44,28,6,1,92,
  66,117,122,100,111,108,97,98,196,177,
  0,131,1,1,55,20,7,1,2,31,
  83,97,121,102,97,32,49,0,131,0,
  78,55,20,7,2,2,31,83,97,121,
  102,97,32,50,0,2,1,38,3,24,
  8,2,118,186,31,31,79,78,0,79,
  70,70,0,2,1,38,15,24,8,2,
  118,186,31,31,79,78,0,79,70,70,
  0,2,1,38,3,24,8,1,118,186,
  31,31,79,78,0,79,70,70,0,2,
  1,38,33,24,8,1,118,186,31,31,
  79,78,0,79,70,70,0,2,1,38,
  43,24,8,1,118,186,31,31,79,78,
  0,79,70,70,0,67,5,84,2,16,
  7,0,167,25,7,129,0,67,3,17,
  5,0,141,89,46,32,65,107,195,188,
  58,0,67,5,84,9,16,7,0,167,
  25,7,129,0,66,10,18,5,0,141,
  65,46,32,65,107,195,188,58,0,2,
  1,38,13,24,8,1,118,186,31,31,
  79,78,0,79,70,70,0,3,134,28,
  28,43,8,2,2,26,129,0,0,30,
  23,6,2,92,83,117,110,114,111,111,
  102,0,129,0,65,36,7,5,2,17,
  79,110,0,129,0,27,36,7,5,2,
  17,79,102,102,0,1,2,49,23,17,
  8,1,118,31,79,110,0,1,2,31,
  23,17,8,1,34,31,79,102,102,0,
  67,1,23,55,53,8,0,176,26,17 };
  
// this structure defines all the variables and events of your control interface 
struct {

    // input variables
  uint8_t sw_47; // =1 if switch ON and =0 if OFF 
  uint8_t sw_53; // =1 if switch ON and =0 if OFF 
  uint8_t sw_37; // =1 if switch ON and =0 if OFF 
  uint8_t sw_45; // =1 if switch ON and =0 if OFF 
  uint8_t sw_35; // =1 if switch ON and =0 if OFF 
  uint8_t sw_31; // =1 if switch ON and =0 if OFF 
  uint8_t sw_sr; // =0 if select position A, =1 if position B, =2 if position C, ... 
  uint8_t sw_doorOn; // =1 if button pressed, else =0 
  uint8_t sw_doorOff; // =1 if button pressed, else =0 

    // output variables
  char batt[7];  // string UTF8 end zero 
  char batt2[7];  // string UTF8 end zero 
  char controlText[17];  // string UTF8 end zero 

    // other variable
  uint8_t connect_flag;  // =1 if wire connected, else =0 

} RemoteXY;
#pragma pack(pop)

/////////////////////////////////////////////
//           END RemoteXY include          //
/////////////////////////////////////////////

#define PIN_SW_47 47
#define PIN_SW_53 53
#define PIN_SW_37 37
#define PIN_SW_45 45
#define PIN_SW_35 35
#define PIN_SW_31 31
#define PIN_SW_DOORON 41
#define PIN_SW_DOOROFF 39


int Pin1 = A2;
int Pin2 = A6;
int deskUp = A9;//A3
int deskDown = A4;//A4
int deskBob = A5;
int contIn = A10;
int contOut = 51;

///////////////////////////////////////////////////////////////////////////////////////

void setup() 
{
  RemoteXY_Init (); 

  int tmp1;
  for(tmp1=23; tmp1 <= 53; tmp1++){
    pinMode(tmp1,OUTPUT);
    digitalWrite(tmp1,HIGH);
  }
  
  pinMode (Pin1, INPUT);
  pinMode (Pin2, INPUT);
  pinMode (deskUp, INPUT);
  pinMode (deskDown, INPUT);
  pinMode (deskBob, INPUT);

  pinMode(contIn, INPUT);
  
  RemoteXY.batt[5] = 'V';
  RemoteXY.batt2[5] = 'V';
  RemoteXY.batt[2] = '.';
  RemoteXY.batt2[2] = '.';

}

///////////////////////////////////////////////////////////////////////////////////////

int senv1;
int senv2;
float av1;
float av2;
int vi1;
int vi2;
float vf1;
float vf2;
//Pin1 = A2;
//Pin2 = A6;

void AnBat(){
  senv1 = analogRead(Pin1);
  av1 = senv1 / 63.15;
  senv2 = analogRead(Pin2);
  av2 = senv2 / 63.15;

  //Xx.xxV
  vi1 = av1 / 10;
  vi2 = av2 / 10;
  RemoteXY.batt[0] = vi1 + 48;
  RemoteXY.batt2[0] = vi2 + 48;

  //xX.xxV
  vi1 = av1;
  vi1 %= 10;
  vi2 = av2;
  vi2 %= 10;
  RemoteXY.batt[1] = vi1 + 48;
  RemoteXY.batt2[1] = vi2 + 48;

  //xx.XxV
  vf1 = av1 * 10;
  vf2 = av2 * 10;
  vi1 = vf1;
  vi2 = vf2;
  vi1 %= 10;
  vi2 %= 10;
  RemoteXY.batt[3] = vi1 + 48;
  RemoteXY.batt2[3] = vi2 + 48;

  //xx.xXV
  vf1 = av1 * 100;
  vf2 = av2 * 100;
  vi1 = vf1;
  vi2 = vf2;
  vi1 %= 10;
  vi2 %= 10;
  RemoteXY.batt[4] = vi1 + 48;
  RemoteXY.batt2[4] = vi2 + 48;
  //End of AnBat function
}

///////////////////////////////////////////////////////////////////////////////////////

//PIN_SW_DOORON = 41
//PIN_SW_DOOROFF = 39
//sw_doorOn
//sw_doorOff
bool isOn = false;
bool dact = false;
unsigned long dtime;

void door(){
  if(dact == false && (RemoteXY.sw_doorOn == 1 || RemoteXY.sw_doorOff == 1) ){
    dtime = millis();
    dact = true;
    
    if(RemoteXY.sw_doorOn == 1)
    isOn = true;
    else
    isOn = false;
  }
  if(dact == true){
    if(isOn){
      digitalWrite(PIN_SW_DOORON,LOW);
      if(millis() - 1000 > dtime){
        digitalWrite(PIN_SW_DOORON,HIGH);
        dact = false;
      }
    }
    else{
      digitalWrite(PIN_SW_DOOROFF,LOW);
      if(millis() - 1000 > dtime){
        digitalWrite(PIN_SW_DOOROFF,HIGH);
        dact = false;
      }
    }
  }
//End of door function
}
///////////////////////////////////////////////////////////////////////////////////////

bool isDelayed = true;
unsigned long delTime = 0;

void delayer(){

  if(millis() < delTime)
  delTime = 0;
  
  if(millis() - delTime < 1000)
  isDelayed = false;
  else
  isDelayed = true;
  
}
 
///////////////////////////////////////////////////////////////////////////////////////

//deskUp = A9;
//deskDown = A10;
//deskBob = A5;
unsigned long deskTime;
int drelay1 = 25; //bobbin
int drelay2 = 23; //up
int drelay3 = 29; //down
bool actDesk = false;
bool isUp = true;
bool bob = true;
int prevSt = 0;
int curSt = 0;


void desk(){

//Button Read
  if(analogRead(deskUp) > 600)
    curSt = 1;
  else if(analogRead(deskDown) > 600)
    curSt = 2;
  else
    curSt = 0;
    
  bob = (analogRead(deskBob) > 600)? true : false;

  delayer();

  
  if(actDesk == false && (curSt != 0) && (prevSt != curSt) && isDelayed == true){
    
    deskTime = millis();
    actDesk = true;
    digitalWrite(drelay1,LOW);
    isUp = (curSt == 1) ? true : false;
    
  }
  
  else if(actDesk == true){
    
    digitalWrite(drelay1,LOW);
    if(millis() < deskTime)
    deskTime = 0;


    if(millis() - deskTime < 500){
      
      if(isUp == true){
        digitalWrite(drelay2,HIGH);
        digitalWrite(drelay3,LOW);
      }
      
      else if(isUp == false){
        digitalWrite(drelay2,LOW);
        digitalWrite(drelay3,HIGH);
      }
      
    }


    else if(millis() - deskTime < 55000){
      
      if( (prevSt == 0 && curSt != 0) || bob == false ){
        digitalWrite(drelay1,HIGH);
        digitalWrite(drelay2,HIGH);
        digitalWrite(drelay3,HIGH);
        actDesk = false;
        prevSt = curSt;
        delTime = millis();
      }
      
      else{
        
        if(isUp == true){
          digitalWrite(drelay2,LOW);
          digitalWrite(drelay3,HIGH);
        }

        else{
          digitalWrite(drelay2,HIGH);
          digitalWrite(drelay3,LOW);
        }
        
      }
      
    }


    
    else{
      digitalWrite(drelay1,HIGH);
      digitalWrite(drelay2,HIGH);
      digitalWrite(drelay3,HIGH);
      actDesk = false;
      prevSt = curSt;
      delTime = millis();
    }

    //End of actDesk
  }

    prevSt = curSt;
 
}

///////////////////////////////////////////////////////////////////////////////////////

//sw_sr,  0 = A, 1 = B, 2 = C, 3 = D, 4 = E, 5 = F
int sr_rel1 = 43;
int sr_rel2 = 49;
int prevSR = 1;
int curSR = 1;
bool actionSR = false;
unsigned long srTime;

void sunRoof(){
  if(actionSR == false && RemoteXY.sw_sr != prevSR){
    actionSR = true;
    curSR = RemoteXY.sw_sr;
    srTime = millis();
  }
  if(actionSR == true){
    //Check for the clock reset
    if(srTime > millis() )
    srTime = 0;
    
    if(curSR == 0){
      digitalWrite(sr_rel2, LOW);
      if(millis() - 25000 > srTime){
        digitalWrite(sr_rel2, HIGH);
        actionSR = false;
        prevSR = curSR;
      }
    }
    else if(curSR == 5){
      digitalWrite(sr_rel1, LOW);
      if(millis() - 17000 > srTime){
        digitalWrite(sr_rel1, HIGH);
        actionSR = false;
        prevSR = curSR;
      }
    }
    else{
      if(curSR > prevSR){
        digitalWrite(sr_rel1, LOW);
        if(millis() - ((curSR - prevSR)*3400) > srTime){
          digitalWrite(sr_rel1, HIGH);
          actionSR = false;
          prevSR = curSR;
        }
      }
      else{
        digitalWrite(sr_rel2, LOW);
        if(millis() - ((prevSR - curSR)*5000) > srTime){
          digitalWrite(sr_rel2, HIGH);
          actionSR = false;
          prevSR = curSR;
        }
      }
    }
  }
//End of sunroof function
}

///////////////////////////////////////////////////////////////////////////////////////

void loopFunc() { 
  
  RemoteXY_Handler ();

  door();
  sunRoof();
  
  digitalWrite(PIN_SW_47, (RemoteXY.sw_47==0)?HIGH:LOW);
  digitalWrite(PIN_SW_53, (RemoteXY.sw_53==0)?HIGH:LOW);
  digitalWrite(PIN_SW_37, (RemoteXY.sw_37==0)?HIGH:LOW);
  digitalWrite(PIN_SW_45, (RemoteXY.sw_45==0)?HIGH:LOW);
  digitalWrite(PIN_SW_35, (RemoteXY.sw_35==0)?HIGH:LOW);
  digitalWrite(PIN_SW_31, (RemoteXY.sw_31==0)?HIGH:LOW);
  
}

///////////////////////////////////////////////////////////////////////////////////////
//sw_47; // =1 if switch ON and =0 if OFF 
//sw_53; // =1 if switch ON and =0 if OFF 
//sw_37; // =1 if switch ON and =0 if OFF 
//sw_45; // =1 if switch ON and =0 if OFF 
//sw_35; // =1 if switch ON and =0 if OFF 
//sw_31; // =1 if switch ON and =0 if OFF 
//sw_sr; // =0 if select position A, =1 if position B, =2 if position C, ... 
//sw_doorOn; // =1 if button pressed, else =0 
//sw_doorOff; // =1 if button pressed, else =0

bool anyInput = false;
//contIn = A11;
//contOut = 51;
bool isManuel = true;

void loop(){

  RemoteXY_Handler ();

  int temp;
    
  if(analogRead(contIn) > 600){
    isManuel = true;
  }

  else if(RemoteXY.sw_47 == 1 || RemoteXY.sw_53 == 1 || RemoteXY.sw_37 == 1 || RemoteXY.sw_45 == 1 || RemoteXY.sw_35 == 1
  || RemoteXY.sw_31 == 1 || RemoteXY.sw_sr == 1 || RemoteXY.sw_doorOn == 1 || RemoteXY.sw_doorOff == 1){
    isManuel = false;
  }


//Isolate following desk outputs
//drelay1 = 25; //bobbin
//drelay2 = 23; //up
//drelay3 = 29; //down

  //Manual Control
  if(isManuel == true){
    for(temp=31; temp <= 53; temp+=2)
      digitalWrite(temp,HIGH);
    digitalWrite(27,HIGH);
    

    dact = false;
    actionSR = false;


    //Control State Text
    RemoteXY.controlText[0] = 'M';RemoteXY.controlText[1] = 'a';RemoteXY.controlText[2] = 'n';RemoteXY.controlText[3] = 'u';RemoteXY.controlText[4] = 'e';
    RemoteXY.controlText[5] = 'l';RemoteXY.controlText[6] = ' ';RemoteXY.controlText[7] = 'K';RemoteXY.controlText[8] = 'o';RemoteXY.controlText[9] = 'n';
    RemoteXY.controlText[10] = 't';RemoteXY.controlText[11] = 'r';RemoteXY.controlText[12] = 'o';
    RemoteXY.controlText[13] = 'l';RemoteXY.controlText[14] = 'd';RemoteXY.controlText[15] = 'e';

    //Arduino Switch Resets
    RemoteXY.sw_47 = 0; RemoteXY.sw_53 = 0; RemoteXY.sw_37 = 0; RemoteXY.sw_45 = 0; RemoteXY.sw_35 = 0; 
    RemoteXY.sw_31 = 0; RemoteXY.sw_sr = 0; RemoteXY.sw_doorOn = 0; RemoteXY.sw_doorOff = 0;
  }

  //Arduino in Control
  else{
    digitalWrite(51, LOW);
    
    loopFunc();

    //Control State Text
    RemoteXY.controlText[0] = 'K';RemoteXY.controlText[1] = 'o';RemoteXY.controlText[2] = 'n';RemoteXY.controlText[3] = 't';RemoteXY.controlText[4] = 'r';
    RemoteXY.controlText[5] = 'o';RemoteXY.controlText[6] = 'l';RemoteXY.controlText[7] = ' ';RemoteXY.controlText[8] = 'B';RemoteXY.controlText[9] = 'e';
    RemoteXY.controlText[10] = 'n';RemoteXY.controlText[11] = 'd';RemoteXY.controlText[12] = 'e';
    RemoteXY.controlText[13] = ' ';RemoteXY.controlText[14] = ' ';RemoteXY.controlText[15] = ' ';
  }
  
    
  desk();
  
  //Calculate the Voltages
  if( (millis() % 2000) < 100 )
  AnBat();
  
}

