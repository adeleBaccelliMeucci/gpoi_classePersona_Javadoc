/**
 * La classe Persona aiuta la sviluppatore a gestire dati di tipo Persona
 */
public class Persona {

    private String nome;
    private String cognome;
    private String codice; //codice fiscalse

    /**
     * Costruisce un oggetto dato il nome, il cognome e il codice fiscale (trasformato in automatico in maiuscolo). Se CF non e' valido, viene lanciata un'eccezione.
     *
     * <p><b>CONTROLLO sul CODICE FISCALE:</b></p>
     * <ul>
     *   <li>Il codice deve contenere esattamente 16 caratteri alfanumerici.</li>
     *   <li>Non deve contenere spazi.</li>
     *   <li>I primi 6 caratteri devono essere consonanti.</li>
     *   <li>Il settimo e ottavo carattere devono essere numeri.</li>
     * </ul>
     *
     * @param nome Stringa qualsiasi da assegnare come nome di un nuovo oggetto Persona.
     * @param cognome Stringa qualsiasi da assegnare come cognome di un nuovo oggetto Persona.
     * @param codice Stringa che rappresenta il nuovo codice fiscale dell'oggetto Persona.
     *               Viene automaticamente trasformata in maiuscolo.
     * @throws IllegalArgumentException Se il codice fiscale fornito non è valido.
     */
    public Persona(String nome, String cognome, String codice) {
        this.nome = nome;
        this.cognome = cognome;

        if (!isCodiceFiscaleValido(codice)) {
            throw new IllegalArgumentException("Codice fiscale non valido!");
        }

        this.codice = codice.toUpperCase(); // Trasforma il codice in maiuscolo
    }

    /**
     * Verifica se il codice fiscale fornito è valido.
     *
     * @param codice Il codice fiscale da verificare.
     * @return true se il codice fiscale è valido, altrimenti false.
     */
    private boolean isCodiceFiscaleValido(String codice) {
        // Controlla che il codice sia lungo esattamente 16 caratteri
        if (codice == null || codice.length() != 16) {
            return false;
        }

        // Controlla che non ci siano spazi e che sia alfanumerico
        if (!codice.matches("^[A-Za-z0-9]+$")) {
            return false;
        }

        // Controlla che i primi 6 caratteri siano consonanti
        String consonanti = codice.substring(0, 6);
        if (!consonanti.matches("^[BCDFGHJKLMNPQRSTVWXYZbcdfghjklmnpqrstvwxyz]+$")) {
            return false;
        }

        // Controlla che il settimo e l'ottavo carattere siano numeri
        String numeri = codice.substring(6, 8);
        if (!numeri.matches("^[0-9]{2}$")) {
            return false;
        }

        return true; // Codice fiscale valido
    }


}
