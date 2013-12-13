/**
 * Contient les informations d'une variable.
 * 
 * @author Daniel St-Yves
 */

public class Attribute implements HaveRange{

    static public String ELEMENTNAME = "attribut";

    private String m_Name = "";

    private String m_Type = "";

    public Range range = new Range(); //La portée de l'attribut

    /*
     * ============================================================================
     * Constructor
     * ===========================================================================
     */

    //Constructeur
    public Attribute() {
    }


    /*
     * ============================================================================
     * Set
     * ===========================================================================
     */

    /**
     * Redéfinit un attribut avec un nouveau nom et type
     * 
     * @param nom
     *            String : Le nom de l'attribut
     * @param type
     *            String : Le type de l'attribut (nom de classe)
     */
    public void set_Attribute(String nom, String type) {
        m_Name = nom;
        m_Type = type;
    }

    public void set_Name(String nom) {
        m_Name = nom;
    }

    public void set_Type(String type) {
        m_Type = type;
    }

    /*
     * ============================================================================
     * Get
     * ===========================================================================
     */
    public String get_Name() {
        return m_Name;
    }

    public String get_Type() {
        return m_Type;
    }

    /*
     * ============================================================================
     * Method
     * ===========================================================================
     */


    /**
     * Vérifie si deux attributs son égales.
     * 
     * @param Object
     *            att : L'attribut à comparer.
     * @return boolean : Vrai si l'attribut en paramètre est égale à celu-ci.
     */
    public boolean equals(Object att) {
        boolean bEquals = false;

        if (att instanceof Attribute) {
            Attribute attribute = (Attribute) att;

            if (attribute.get_Name().equals(this.get_Name())) {
                if (attribute.get_Type().equals(this.get_Type())) {
                    bEquals = true;
                }
            }
        }

        return bEquals;
    }

    public String toString() {
        return m_Type + " " + m_Name;
    }
}