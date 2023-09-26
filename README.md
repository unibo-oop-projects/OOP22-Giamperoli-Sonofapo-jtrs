# jTetris

Lo scopo del progetto è quello di ricreare un videogioco in grafica 2D che si basa sul famoso Tetris, ideato dal russo Aleksej Leonidovič Pažitnov alla fine degli anni '80.

Componenti del gruppo:
- Antonio Emanuele Pepe
- Alex Giamperoli

## Introduzione
Il fine ultimo del gioco è quello di totalizzare il maggior numero di punti prima che non sia più possibile inserire ulteriori pezzi.

I pezzi presenti nel gioco si chiamano Tetramini e ne esistono di sette tipi diversi, ciascuno di una forma che ricorda una lettera e con uno specifico colore. Nello specifico si hanno i seguenti Tetramini:

- `O`, di colore giallo
- `I`, di colore ciano
- `T`, di colore magenta
- `L`, di colore arancione
- `J`, di colore blu
- `S`, di colore verde
- `Z`, di colore rosso

## Comandi di gioco
Il gioco mette a disposizione i seguenti comandi, da impartire attraverso la tastiera. Nello specifico:

### Movimento
- `W` oppure `↑` permettono di ruotare il Tetramino di 90° in senso orario
- `S` oppure `↓` permettono di far scorrere il Tetramino verso il basso
- `A` oppure `←` permettono di spostare il Tetramino a sinistra
- `D` oppure `→` permettono di spostare il Tetromino a destra

1. Si noti che tutti i movimenti sono unitari e riferiti al Tetramino attualmente in caduta.

### Altri comandi
- `ESC` permette il termine e la chiusura dell'applicazione
- `SPACE` permette di mettere in pausa la partita
- `M` permette di mutare o meno la traccia musicale

## Meccaniche di gioco
Il funzionamento del gioco è molto intuitivo. Al completamento di una, due, tre o quattro linee nel senso orizzontale, queste verrano eliminate dalla griglia e i pezzi soprastanti verrano traslati di conseguenza. Maggiore è il numero di linee eliminate con un singolo posizionamento di un Tetramino, maggiore sarà il punteggio assegnato.

Un Tetramino si considera posizionato quando non può più scorrere verso il basso: questo succede qunado raggiunge il bordo inferiore del campo oppure quando tocca un altro Tetramino che è sotto di lui. Successivamente verrà inserito in gioco un nuovo Tetramino, che è sempre visibile nella finestra di anteprima sulla destra.

Il gioco, secondo una velocità calcolata, farà avanzare automaticamente il Tetramino in caduta di un'unità verso il basso. Ogni 10 linee completate il gioco progredirà di un livello e la velocità di caduta sarà leggermente incrementata. Questo comporta che livelli maggiori risultino essere più difficili.

Un Tetramino non può essere più inserito quando non c'è sufficiente spazio nel campo di gioco per contenerlo. Nel caso si verifichi ciò, la partita è conclusa.
