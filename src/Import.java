
/**
 * Définit un import dans un fichier .java<p/>
 *
 */
public class Import {

    static public String ELEMENTNAME = "import";
    static public String ATTRIBUTEPATH = "path";
    
    //Le chemin de l'importation
    private String _path = "";
    
    
    
    /*
     * ============================================================================
     * Constructor
     * ===========================================================================
     */
    public Import(){
        
    }
    
    public Import(String path){
        this();
        this.set_path(path);
    }
    
    
    /*
     * ============================================================================
     * Get
     * ===========================================================================
     */
    /**
     * @return Retourne le chemin d'importation (ex: java.util.ListIterator)
     */
    public String get_path() {
        return _path;
    }
    
    
    
    /*
     * ============================================================================
     * Set
     * ===========================================================================
     */
    /**
     * @param Set le chemin d'importation
     */
    public void set_path(String _path) {
        this._path = _path;
    }
    


}
