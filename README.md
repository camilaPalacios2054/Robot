# Robot
 proyecto IOT

 DOCUMENTACION GRÁFICA Y PRESENTACIÓN
 https://www.canva.com/design/DAF24LUf_RQ/Bm_v2lNaDz-XdOG3UStLPA/edit?utm_content=DAF24LUf_RQ&utm_campaign=designshare&utm_medium=link2&utm_source=sharebutton

 ////CODIGO DE ARDUINO UNO

 #include <SoftwareSerial.h>
#include <LiquidCrystal.h>
#include <Wire.h>

SoftwareSerial BT(10, 11);          // RX, TX para el módulo Bluetooth
const int ledPin = 13;               // Pin del LED
LiquidCrystal lcd(12,9,5,4,3,2);  // Dirección I2C del display 16x2

void setup() {
  pinMode(ledPin, OUTPUT);
  digitalWrite(ledPin, LOW);

  Serial.begin(9600);
  BT.begin(9600);

  lcd.begin(16, 2);
  lcd.clear();
  lcd.print("Esperando datos");

  //AD8232
  //pinMode(6,INPUT);
  //pinMode(7,INPUT);
}

void loop() {

  if (BT.available()) {
    char receivedChar = BT.read();

    // Verifica el carácter recibido y realiza acciones en consecuencia
    if (receivedChar == '1') {
      digitalWrite(ledPin, HIGH);  // Enciende el LED
      lcd.clear();
      lcd.setCursor(0, 0);
      lcd.print("LED encendido");
      Serial.println("LED encendido");
    } else if (receivedChar == '0') {
      digitalWrite(ledPin, LOW);   // Apaga el LED
      lcd.clear();
      lcd.setCursor(0, 0);
      lcd.print("LED apagado");
      Serial.println("LED apagado");
    }
    else if (receivedChar == '2') {
      digitalWrite(ledPin, LOW);   // Apaga el LED
      lcd.clear();
      lcd.print("Esperando datos");
    }
    else if (receivedChar == '3') {
     String receivedString = BT.readStringUntil('\n');
     lcd.clear();
     lcd.setCursor(0, 0);
     lcd.print(receivedString);
    }
  
    // Puedes agregar más lógica según los datos recibidos
  }
    
  }
  //{
  //  Serial.print("No hay lectura!");
  //}
  //else
  //{
  //  Serial.print(analogRead(A0));
  //}
  //delay(5);


 
