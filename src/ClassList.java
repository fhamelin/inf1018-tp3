import java.util.ArrayList;
import java.util.ListIterator;



/**
 *  C'est une liste contenant des objects DescriptionClass.<p/>
 *
 *
 * @author Daniel St-Yves
 */
public class ClassList
    extends ArrayList {


  /*============================================================================
    Constructor
   ===========================================================================*/
  public ClassList() {
  }

  /*============================================================================
    Get
   ===========================================================================*/
  public DescriptionClass get(String name) {
    DescriptionClass returnObject = null;

    DescriptionClass tempObject;
    ListIterator iterator = this.listIterator();
    while ( (iterator.hasNext()) && (returnObject == null)) {
      tempObject = (DescriptionClass)this.get_next(iterator);

      if (tempObject.get_Name().equals(name)) {
        returnObject = tempObject;
      }
    }

    return returnObject;
  }

  public DescriptionClass get_Class(int i){
    return (DescriptionClass) super.get(i);
  }

  /**
   * Fonction calculant le nombre de classes
   * que la liste possède selon un range(public, private, protected).
   *
   * @param iRange int : Le range
   * @return int : Le nombre de classes dans la liste.
   */
  public int get_classRange(int iRange) {
    int iTotal = 0;

    ListIterator iterator = this.listIterator();
    while (iterator.hasNext()) {
      if ( (this.get_next(iterator)).range.get_Range() == iRange) {
        iTotal++;

      }
    }
    return iTotal;
  }

  /*============================================================================
    List Iterator
   ===========================================================================*/
  public DescriptionClass get_next(ListIterator iter){
    return (DescriptionClass) iter.next();
  }

}
