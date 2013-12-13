/**
 * 
 * <p>
 * Cette classe indique la portée d'un objet : Public, Privée, Protected et ses
 * caractéristiques: Static, Final et Abstract.
 * 
 */

public class Range {

    //Par defaut le range est PUBLIC.
    private int m_iRange = 0; // Variable contenant la portée de la méthode
                              // (private, public, protected)

    public boolean Static = false; //Est statique

    public boolean Final = false; //Est final

    public boolean Abstract = false; //Est abstraite

    static public int PUBLIC = 0; //Code public

    static public int PRIVATE = 1; //Code privée

    static public int PROTECTED = 2; //Code protected

    static public String ELEMENTNAME = "range"; //représente le string de
                                                // l'élément range dans un
                                                // Element

    /*
     * ============================================================================
     * Constructor
     * ===========================================================================
     */
    public Range() {
    }


    /*
     * ============================================================================
     * Set
     * ===========================================================================
     */
    public void set_Range(int Range) {
        this.m_iRange = Range;
    }

    

    /*
     * ============================================================================
     * Get
     * ===========================================================================
     */
    public int get_Range() {
        return m_iRange;
    }


    /*
     * ============================================================================
     * Method
     * ===========================================================================
     */

    /**
     * Retourne le range en string.
     * 
     * @return String : public, private ou protected.
     */
    public String toString() {
        String strRange = "";

        if (this.m_iRange == Range.PUBLIC) {
            strRange = "public";
        } else if (this.m_iRange == Range.PRIVATE) {
            strRange = "private";
        } else if (this.m_iRange == Range.PROTECTED) {
            strRange = "protected";
        }

        return strRange;
    }

}