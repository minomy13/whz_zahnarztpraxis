# Softwareprojekt Zahnarztpraxis

# Vorbereitung

## Klassendiagramm

```mermaid
classDiagram
class Patientenverwaltung {
	+terminVereibaren()
	+terminStornieren()
	+patientAnmelden()
	+patientAbmelden()
	+behandlungStarten()
}
Patientenverwaltung --> Patientenaktenverwaltung
Patientenverwaltung --> Behandlung : erstellt

class Patientenaktenverwaltung {
	+anlegen()
	+archivieren()
	+austragen()
	+getBefund()
}
Patientenaktenverwaltung --> "0..*" Patientenakte

class Patientenakte
Patientenakte --> TerminCollection : creates
Patientenakte --> Patient
Patientenakte --> Befund

class Patient {
	-String patientenName

	+getName()
}

class Termin {
	-Date von
	-Date bis

	+getVon()
	+getBis()
}

class Terminkalender {
	+buchen()
	+stornieren()
}
Terminkalender --> Patientenaktenverwaltung : Termine

class Sprechstundenverwaltung {
	+istRaumBelegt(roomNumber)
}
Sprechstundenverwaltung --> "1..*" Room

class Room {
	-String roomNumber
	-boolean belegt

	+getRoomNumber()
	+istBelegt()
}
Room --> Patientenaktenverwaltung : belegt von

class Befund {
	-String behandlungsart
	-String befund
	
	+getBehandlungsart()
	+getBefund()
}

class TerminCollection {
	-String collectionId

	+getId()
}
TerminCollection --> "0..*" Termin

class Praxis {
	-double budget

	+getBudget()
	+increaseBudget()
	+decreaseBudget()
	+getPatientenverwaltung()
	+getSprechstundenverwaltung()
	+getLagerverwaltung()
	+getTerminkalender()
}
Praxis --> Patientenverwaltung
Praxis --> Sprechstundenverwaltung
Praxis --> Lagerverwaltung
Praxis --> Terminkalender
Praxis --> Mitarbeiterverwaltung

class Item {
	<<enumeration>>
	BECHER
	WATTEPAD
	...
}

class Lagerverwaltung {
	-List<Item> bestand
	
	+kaufen(Item)
	+getVorrat(Item)
	+entnehmen(Item)
}
Lagerverwaltung --> Item

class Behandlung {
	-double kostet
	-String art

	+getKostet()
	+getArt()
}
Behandlung --> Sprechstundenverwaltung : belegt
Behandlung --> Lagerverwaltung : benötigt
Behandlung --> Praxis : bringt Budget ein

class Mitarbeiterverwaltung {
	+getMitarbeiter()
	+einstellen()
	+entlassen()
	+arbeitszeitStarten(Mitarbeiter)
	+arbeitszeiBeenden(Mitarbeiter)
}
Mitarbeiterverwaltung --> "0..*" Mitarbeiter
Mitarbeiterverwaltung --> Stechuhr

class Mitarbeiter {
	-String name

	+getName()
}

class Stechuhr {
	-List times

	+startStechen()
	+endeStechen()
}
Stechuhr --> Arbeitszeit

class Arbeitszeit {
	-LocalTime start

	+getStart()
	+getMitarbeiter()
}
Arbeitszeit --> Mitarbeiter
```

## Komplexer Prozessablauf

Zunächst wird eine Instanz von Praxis erstellt. Mithilfe der Mitarbeiterverwaltung dieser werden nun mehrere Mitarbeiter
“eingestellt”.

Die Mitarbeiter “kommen in der Praxis an”, die Stechuhr wird aktiviert.

Danach werden mithilfe des Terminkalenders Termine für neue Patienten angelegt, wozu gleichzeitig automatisch die
Patientenakten angelegt werden.

Nach Ankunft des Patienten wird eine neue Instanz einer Behandlung angelegt. Ein Raum wird belegt, die benötigten
Materialien werden aus dem Lager entnommen. Dabei wird überprüft, ob Materialien zur Neige gehen und bei Bedarf
automatisch nachgekauft, das Budget sinkt um die Kosten der Materialien.

Nach Beendigung der Behandlung werden Art und Ergebnis als neuer Befund in die Patientenakte übernommen und die Kosten
der Behandlung zum Budget hinzugefügt.

Die Mitarbeiter verlassen nun die Praxis, es wird überprüft, ob sie ihre Arbeitszeit erfüllt haben.