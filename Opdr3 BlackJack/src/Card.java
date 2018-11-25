public class Card {
    public Card(Symbool symbool, Waarde waarde) {
        this.symbool = symbool;
        this.waarde = waarde;
    }

    public enum Symbool {
        SCHOPPEN, HARTEN, KLAVER, RUITEN
    }

    public enum Waarde {
        AAS, TWEE, DRIE, VIER, VIJF,ZES,ZEVEN,ACHT,NEGEN,TIEN,BOER,VROUW,HEER
    }

    public Symbool symbool;
    public Waarde waarde;
}
