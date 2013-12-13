import java.util.*;



/**
 * Contient les informations relatives à une classe. Une classe peut contenir
 * d'autres classes internes. <p/>
 * 
 * @author Daniel St-Yves
 */
public class DescriptionClass implements HaveRange{

    static public String ELEMENTNAME = "class";

    static public String ATTRIBUTEEXTENDS = "extends";

    static public String ATTRIBUTENAME = "name";

    public DescriptionClass m_Parent = null;

    private JavaFile m_javaFile = null;

    //  Une liste de classes
    public ClassList classlist = new ClassList();

    //  Une liste de méthodes
    public MethodList methodlist = new MethodList();

    //  Une listed'attributs
    public AttributeList attributelist = new AttributeList();

    //  Une liste d'interface
    public InterfaceList interfacelist = new InterfaceList();

    //  Variable contenant le nom de la classe
    private String m_className = "";

    //  Variable contenant le nom de la super classe
    private String m_superClassName = "";

    //  Indique si la classe hérite d'une super classe.
    private boolean f_extend = false;
    
    // Le range de la classe
    public Range range = new Range();

    /*
     * ============================================================================
     * Constructor
     * ===========================================================================
     */
    public DescriptionClass() {
    }


    /*
     * ============================================================================
     * Set
     * ===========================================================================
     */
    public void set_superClassName(String name) {
        m_superClassName = name;
        f_extend = true;
    }

    public void set_className(String name) {
        m_className = name;
    }

    public void set_Parent(DescriptionClass desClass) {
        this.m_Parent = desClass;
    }

    public void set_JavaFile(JavaFile javafile) {
        this.m_javaFile = javafile;
    }


    /*
     * ============================================================================
     * Get
     * ===========================================================================
     */
    public String get_Name() {
        return m_className;
    }

    public String get_superClassName() {
        return m_superClassName;
    }

    public DescriptionInterface get_Interface(int iPos) {
        //return m_lstInterfaces.get(iPos).toString();
        return (DescriptionInterface) this.interfacelist.get(iPos);
    }

    public DescriptionClass get_Parent() {
        return this.m_Parent;
    }

    public JavaFile get_JavaFile() {
        return this.m_javaFile;
    }

    public AttributeList get_AttributeList() {
        return this.attributelist;
    }



    /*
     * ============================================================================
     * Method
     * ===========================================================================
     */
    public void add_Interface(DescriptionInterface i) {
        //m_lstInterfaces.add(name);
        this.interfacelist.add(i);
    }

    public boolean has_Extends() {
        return f_extend;
    }

    public boolean has_JavaFile() {
        if (this.m_javaFile == null) {
            return false;
        } else {
            return true;
        }
    }


    public boolean has_Parent() {
        if (m_Parent == null) {
            return false;
        } else {
            return true;
        }
    }


    //Ajoute une méthode à la liste
    public void add_Method(Method m) {

        //Vérifie si la méthode ajoutée possède le même nom que la classe.Si
        // c'est le cas,
        //alors la méthode ajouté est un constructeur et renvoit comme type la
        // classe.
        this.methodlist.add(m);

        if (m.get_Name().equals(this.get_Name())) {
            m.set_returnType(this.get_Name());
        }
    }

    public String toString() {
        String strPath = "";

        if (this.has_JavaFile()) {
            strPath = this.get_JavaFile().get_FullPackageName(this);
        } else {
            strPath = this.get_Name();

        }
        return strPath;
    }

    //Deux classes sont égaux lorsqu'elles ont le même package path.Nom
    public boolean equals(Object o) {
        boolean bEquals = false;

        /*
         * if(o instanceof DescriptionClass){ DescriptionClass currentClass =
         * (DescriptionClass) o; if((currentClass.has_JavaFile()) &&
         * (this.has_JavaFile())){ if
         * (currentClass.get_JavaFile().get_FullPackageName(currentClass).
         * equals(this.get_JavaFile().get_FullPackageName(this))) { bEquals =
         * true; } } }
         */

        if (o instanceof DescriptionClass) {
            DescriptionClass currentClass = (DescriptionClass) o;
            if (currentClass.toString().equals(this.toString())) {
                bEquals = true;
            }
        }

        return bEquals;
    }

    public boolean equals(String name) {
        boolean bEquals = false;

        if (this.toString().equals(name)) {
            bEquals = true;

        }

        return bEquals;
    }

}