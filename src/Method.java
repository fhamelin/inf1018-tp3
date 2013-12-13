import java.util.*;


/**
 * Contient les informations relatives à une methode. <p/>
 * 
 * @author Daniel St-Yves
 */
public class Method implements HaveRange {

    static public String ELEMENTNAME = "method";

    static public String ELEMENTBODY = "body";

    static public String ELEMENTPARAM = "parameters";

    static public String ATTRIBUTENAME = "name";

    static public String ATTRIBUTERETURNTYPE = "returntype";

    public Range range = new Range(); //La porté de l'objet (private, public,

    // protected)

    private String m_methodName = ""; // Variable contenant le nom de la méthode

    private String m_returnType = ""; // Le type du retour

    //Liste contenant les paramètres de la classes
    private AttributeList m_lstParameters = new AttributeList();


    //Liste contenant les attributs déclarés locals dans la méthode.
    public AttributeList attributelist = new AttributeList();



    /*
     * ============================================================================
     * Constructor
     * ===========================================================================
     */
    public Method() {
    }


    /*
     * ============================================================================
     * Set
     * ===========================================================================
     */
    public void set_Name(String name) {
        m_methodName = name;
    }

    public void set_returnType(String returnType) {
        m_returnType = returnType;
    }

 

    /*
     * ============================================================================
     * Get
     * ===========================================================================
     */
    public String get_Name() {
        return m_methodName;
    }

    public String get_returnType() {
        return this.m_returnType;
    }

    public AttributeList get_AttributeList() {
        return this.attributelist;
    }

    public AttributeList get_Parameters() {
        return this.m_lstParameters;
    }


    /*
     * ============================================================================
     * Method
     * ===========================================================================
     */
    public void add_Parameter(String type, String name) {
        this.attributelist.add(m_lstParameters.add(type, name));
    }

    public void add_Parameter(Attribute a) {
        m_lstParameters.add(a);
        this.attributelist.add(a);
    }



    public String toString() {

        //Le nom de la méthode
        String className = this.get_Name();

        //Parametre
        String lstParam = "";
        for (ListIterator iterator = this.m_lstParameters.listIterator(); iterator
                .hasNext();) {
            lstParam += ((Attribute) iterator.next()).toString();

            if (iterator.hasNext())
                lstParam += ",";
        }

        return className + "(" + lstParam + ")";

    }

}