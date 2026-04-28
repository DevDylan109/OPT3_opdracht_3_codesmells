# Voorraadbeheersysteem

Een desktop applicatie voor het bijhouden en beheren van de voorraad van boormachines, vrachtauto's en personenauto's. Medewerkers kunnen inloggen, items toevoegen, verhuren en retourneren.

---

## Functionaliteiten

- **Inloggen / Uitloggen** — beveiligde toegang per medewerker
- **Voorraad bekijken** — overzicht van alle boormachines, vrachtauto's en personenauto's
- **Items toevoegen** — nieuwe soorten aanmaken met specifieke eigenschappen
- **Items verwijderen** — producten uit het systeem verwijderen
- **Verhuren & retourneren** — items als verhuurd markeren of terugzetten naar voorraad
- **Status bijhouden** — overzichtelijk zien wat *op voorraad* of *verhuurd* is
- **Medewerkersbeheer** — bijhouden welke medewerker een item heeft verhuurd

---

## Benodigdheden

| Vereiste | Versie |
|----------|--------|
| Java JDK | 17.0.1 of hoger |

> Download de JDK via [oracle.com](https://www.oracle.com/java/technologies/downloads/)

---

## Opstarten

### 1. Clone of download het project

```bash
git clone <repository-url>
cd <project-map>
```

### 2. Start de applicatie

```bash
mvnw.cmd clean javafx:run
```

> **Windows gebruikers:** zorg dat `JAVA_HOME` correct is ingesteld in je omgevingsvariabelen.

---

## Inloggegevens

Gebruik een van de volgende accounts om in te loggen:

| Gebruikersnaam | Wachtwoord |
|----------------|------------|
| `John123`      | `password` |
| `Kyle123`      | `password` |

---

## Projectstructuur

```
src/
├── main/
│   ├── java/        # Java broncode
│   └── resources/   # FXML bestanden & stylesheets
pom.xml              # Maven configuratie
mvnw.cmd             # Maven wrapper (Windows)
```
