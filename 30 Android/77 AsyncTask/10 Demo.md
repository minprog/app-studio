# Data binnenhalen met een AsyncTask

Om data van internet te halen moeten we een aantal elementen aan elkaar knopen. Allereerst gebruiken we een HttpRequestHelper class om de data binnen te halen. Omdat dit een onbekende hoeveelheid tijd duurt, maar soms wel enkele seconden, moeten we dit *asynchroon* doen. Daarvoor gebruiken we een AsyncTask, standaard meegeleverd met Android. Ten slotte is de data meestal in een JSON-formaat, waar we de juiste gegevens uit moeten filteren.

### Stap 1: het starten van het binnenhalen vanuit een Activity.

![embed](https://player.vimeo.com/video/205177897){:width="320" height="200"}

### Stap 2: het aanmaken van een AsyncTask class.

![embed](https://player.vimeo.com/video/205177914){:width="320" height="200"}

### Stap 3: een HttpRequestHelper maken voor het downloaden.

![embed](https://player.vimeo.com/video/205177867){:width="320" height="200"}

### Stap 4: de JSON interpreteren en de juiste gegevens vinden.

![embed](https://player.vimeo.com/video/205177794){:width="320" height="200"}

### Stap 5: de data aan een Adapter voeren.

![embed](https://player.vimeo.com/video/205177831){:width="320" height="200"}

### Stap 6: het werkt!

![embed](https://player.vimeo.com/video/205177822){:width="320" height="200"}

