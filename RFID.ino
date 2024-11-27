/* 

  Código para descobrir a porta a ser utilizada
    get-wmiobject -class win32_serialport

*/


#include <SPI.h>
#include <MFRC522.h>
#include <WiFi.h>
#include <WiFiClientSecureBearSSL.h>

#define SS_PIN 53
#define RST_PIN 14


AsyncWebServer server(80);

void setup() {
  Serial.begin(115200);
  WiFi.begin(ssid, password);
  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");
  }
  Serial.println("");
  Serial.println("WiFi connected");
  server.on("/", HTTP_GET, [](AsyncWebServerRequest *request){
    request->send(200, "text/plain", "Hello, World!");
  });
  server.on("/ligar", HTTP_GET, [](AsyncWebServerRequest *request){
    digitalWrite(2, HIGH); // Substitua 2 pelo pino do LED
    request->send(200, "text/plain", "LED ligado");
  });
  server.on("/desligar", HTTP_GET, [](AsyncWebServerRequest *request){
    digitalWrite(2, LOW);
    request->send(200, "text/plain", "LED desligado");
  });
  server.begin();
}

void loop() {

MFRC522 mfrc522(SS_PIN, RST_PIN);

const char* ssid = "UAIFAI"; 
const char* password = "40028922";

/* Esperar o João confirmar a conexão com o banco ante de subir o firmware para teste 
Conexão com o banco de dados (exemplo para MySQL)
const char* host = "seu_host";
const int port = 3306;
const char* user = "seu_usuario";
const char* password_db = "sua_senha_do_banco";
const char* database = "seu_banco_de_dados";
*/

void setup() {
  Serial.begin(115200);
  SPI.begin();
  mfrc522.PCD_Init();
  Serial.println("Leitor RFID iniciado");

  WiFi.begin(ssid, password);
  while (WiFi.status() != WL_CONNECTED) {
    delay(500);
    Serial.print(".");

  }
  Serial.println("");
  Serial.println("WiFi connected");
}

void loop() {

  if (mfrc522.PICC_IsNewCardPresent()) {
    if (mfrc522.PICC_ReadCardSerial()) {
      
      String uidString = "";
      for (byte i = 0; i < mfrc522.uid.size; i++) {
        uidString += String(mfrc522.uid.uidByte[i], HEX);
      }
      Serial.print("UID do cartão: ");
      Serial.println(uidString);

    }
  }
}
}
