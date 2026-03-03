# HUGINN SFT-PRO: The Wing of Secure Knowledge

In Norse mythology, Huginn is the raven that flies across Midgard to bring information to the All-father, Odin. In the modern digital battlefield, Huginn SFT-Pro is the framework that ensures your data reaches its destination without being intercepted by the Lokean threats of the web.

## The Lore of the System
This is not just a file transfer tool; it is a secure transport protocol built with modularity and defense in mind.

* Odin’s Sight (Real-Time Monitoring): A sophisticated Web Dashboard (Spring Boot + Thymeleaf) that provides a god's-eye view of every incoming data packet.
* The Bifrost Protocol (Encrypted Tunnel): Every file is shrouded in AES-256 encryption using the custom CryptoManager before it leaves the client.
* The Purge of Valhalla (Self-Destruct): Security is temporary, but leaks are eternal. Huginn automatically wipes transferred files after 60 minutes, leaving no trace for scavengers.
* Runic Identification (File Type Recognition): The system identifies data types (TXT, IMG, BIN) and prioritizes security based on the nature of the information.

## Technical Architecture (The Nine Realms)
* Core: The foundation of encryption and shared models.
* Server: The gatekeeper that accepts and secures incoming knowledge.
* Client: The swift messenger that delivers data from the edge.
* Web/UI: The visual interfaces for both desktop (JavaFX) and monitoring (Web).

## Forge and Deploy
1. Clean the Forge:
   mvn clean install -DskipTests
2. Ignite the Server:
   java -jar huginn-server/target/huginn-server-1.0.0-SNAPSHOT-executable.jar
3. Open the Eye (Dashboard):
   java -jar huginn-web/target/huginn-web-1.0.0-SNAPSHOT.jar

## Author
Developed by Arda Mecik - Computer Engineering student at Trakya University.