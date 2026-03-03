# HUGINN SFT-PRO: THE WING OF SECURE KNOWLEDGE

In Norse mythology, Huginn is the raven that flies across Midgard to bring information to the All-father, Odin. Huginn SFT-Pro is a high-performance, modular Java framework designed for encrypted and time-sensitive file transfers, ensuring that data reaches its destination without being intercepted by unauthorized entities.

## CORE ARCHITECTURE
The framework is divided into five specialized realms to ensure modularity and security:
* **huginn-core**: The runic foundation containing shared models and the AES-256 CryptoManager.
* **huginn-server**: The gatekeeper that handles incoming encrypted streams and manages the file vault.
* **huginn-client**: The swift messenger responsible for encrypting and delivering data to the server.
* **huginn-web**: The Eye of Odin—a Spring Boot dashboard for real-time monitoring of all transfers.
* **huginn-ui**: A desktop management interface powered by JavaFX for administrative control.

## ADVANCED SECURITY FEATURES
* **Bifrost Encryption**: Every bit of data is shrouded in AES-256 encryption before leaving the client node.
* **Purge of Valhalla (Self-Destruct)**: To prevent data accumulation, the server automatically purges files after a 60-minute window.
* **Runic Identification**: Automatic file-type detection (TXT, IMG, BIN) for prioritized security handling.
* **Live Telemetry**: Real-time tracking of transfer integrity, timestamps, and Time-To-Live (TTL) status.

## DEPLOYMENT GUIDE (STEP-BY-STEP)

Follow these steps to forge and deploy the framework within your environment:

### 1. Prerequisites
Ensure you have the following installed:
* Java 17 or higher
* Maven 3.8+

### 2. Building the Artifacts
Navigate to the root directory and execute the Maven lifecycle:
```
mvn clean install -DskipTests
```
### 3. Launching the Server

Start the central gateway to begin listening for encrypted transmissions:
```
java -jar huginn-server/target/huginn-server-1.0.0-SNAPSHOT-executable.jar
```
### 4. Activating the Web Monitoring (The Eye)
```
Run the web module to monitor the live transfer logs at http://localhost:8080:
```
```
java -jar huginn-web/target/huginn-web-1.0.0-SNAPSHOT.jar
```
### 5. Executing a Secure Transfer (The Messenger)

Use the client module to encrypt and send a file. Provide the target host and file path as arguments:
```
java -jar huginn-client/target/huginn-client-1.0.0-SNAPSHOT-executable.jar <target_host> <file_path>
```
### 6. Desktop UI Management (Optional)
```
To launch the JavaFX-based management console:
```
```
mvn javafx:run -pl huginn-ui
```
AUTHOR

Developed and maintained by Arda Mecik.
