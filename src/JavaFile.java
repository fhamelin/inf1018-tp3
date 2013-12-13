import java.io.File;
import java.util.ArrayList;
import java.util.ListIterator;

/**
 * Contient toutes les informations que l'on peut retrouver dans un fichier
 * .java. <p/>
 * 
 * @author Daniel St-Yves
 */
public class JavaFile {

    static public String ELEMENTNAME = "javafile";

    static public String ATTRIBUTEFILEPATH = "filepath";

    static public String ATTRIBUTEPACKAGE = "package";

    static public String ELEMENTIMPORTS = "imports";

    //Le fichier
    private File m_File;

    //Liste de class
    public ClassList classlist = new ClassList();

    //Liste d'interfaces
    public InterfaceList interfacelist = new InterfaceList();

    //Le package
    private String m_Package = "";

    //Les importations
    private ArrayList m_lstImport = new ArrayList();

    /*
     * ============================================================================
     * Constructor
     * ===========================================================================
     */
    public JavaFile(String path) {
        m_File = new File(path);

    }

    public JavaFile(File file) {
        m_File = file;

    }

    /*
     * ============================================================================
     * Get
     * ===========================================================================
     */
    public File get_File() {
        return this.m_File;
    }

    public String get_Package() {
        return this.m_Package;
    }

    public String get_FullPackageName(String className) {
        return m_Package + "." + className;
    }

    public String get_FullPackageName(DescriptionClass desClass) {
        return m_Package + "." + desClass.get_Name();
    }

    public ClassList get_classList() {
        return this.classlist;
    }

    /**
     * @return Une liste contenant des objets <code>Import</code> représentant
     *         une importation.
     */
    public ArrayList get_importList() {
        return this.m_lstImport;
    }

 
    /*
     * ============================================================================
     * Set
     * ===========================================================================
     */
    public void set_Package(String strPackage) {
        this.m_Package = strPackage;
    }


    /*
     * ============================================================================
     * Method
     * ===========================================================================
     */
    public void add_Class(DescriptionClass desClass) {
        desClass.set_JavaFile(this);
        this.classlist.add(desClass);
    }

    public void add_Interface(DescriptionInterface desInter) {
        desInter.set_JavaFile(this);
        this.interfacelist.add(desInter);
    }

    public void add_Import(String path) {
        this.m_lstImport.add(new Import(path));
    }

    public void add_Import(Import i) {
        this.m_lstImport.add(i);
    }

}