import java.util.ListIterator;
import java.util.ArrayList;

/**
 * Contient les informations relatives � une interface. Une interface ne contient que
 * des attributs et des m�thodes. Il peut par contre h�riter de plusieurs autres interfaces. <p/>
 *
 * @author Daniel St-Yves
 */

public class DescriptionInterface implements HaveRange {


  static public String ELEMENTNAME = "interface";
  static public String ATTRIBUTENAME = "name";
  
    
  //Le fichier Java contenant cette interface
  private JavaFile m_javaFile = null;

  //Liste d'attributs
  public AttributeList attributelist = new AttributeList();

  //Liste de m�thodes
  public MethodList methodlist = new MethodList();

  //Nom de l'interface
  private String m_Name = "";
  
  //Range
  public Range range = new Range();

  /*============================================================================
   Constructor
   ===========================================================================*/
  public DescriptionInterface() {
  }

  public DescriptionInterface(String name) {
      this.set_Name(name);
  }
  


  /*============================================================================
    Get
   ===========================================================================*/
  public String get_Name() {
    return this.m_Name;
  }

  public JavaFile get_JavaFile() {
    return this.m_javaFile;
  }

  public AttributeList get_AttributeList() {
    return this.attributelist;
  }

  /*============================================================================
    Set
   ===========================================================================*/
  public void set_Name(String name) {
    this.m_Name = name;
  }

  public void set_JavaFile(JavaFile javafile) {
    this.m_javaFile = javafile;
  }

  /*============================================================================
    Method
   ===========================================================================*/



}
