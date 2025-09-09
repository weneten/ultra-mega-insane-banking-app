# JavaBankProject

A simple Java banking application with a graphical user interface (GUI) built using Swing.

## Features
- Kontostand anzeigen
- Einzahlen und Auszahlen
- Überweisungen zwischen Konten
- Benutzerfreundliche Oberfläche

## Projektstruktur
```
JavaBankProject/
├── src/
│   └── BankingApp/
│       ├── Bank.java
│       ├── GUI.java
│       ├── Konto.java
│       ├── Kontoinhaber.java
│       └── Ueberweisung.java
├── bin/
│   └── BankingApp/
├── lib/
└── README.md
```

## Voraussetzungen
- Java JDK 17 oder höher
- IDE wie Visual Studio Code oder IntelliJ IDEA

## Kompilieren und Ausführen
1. Kompilieren:
   ```sh
   javac -d bin src/BankingApp/*.java
   ```
2. Starten der GUI:
   ```sh
   java -cp bin BankingApp.GUI
   ```

## Hinweise
- Die Anwendung ist ein Lernprojekt und nicht für den produktiven Einsatz gedacht.
- Erweiterungen wie mehrere Benutzer, Datenpersistenz oder Sicherheit sind möglich.

## Autor
- Tyler Jake Musterfrau