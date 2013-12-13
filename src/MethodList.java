import java.util.ArrayList;
import java.util.ListIterator;

/**
 *  C'est une liste contenant des objects Method.<p/>
 */
public class MethodList
    extends ArrayList {

  /*============================================================================
    Constructor
   ===========================================================================*/
  public MethodList() {
  }

  /*============================================================================
    Method
   ===========================================================================*/
  //Renvoit la première méthode rencontré dans la liste sans se soucier des arguments
  public Method get(String name) {
    Method returnObject = null;

    Method tempObject;
    ListIterator iterator = this.listIterator();
    while ( (iterator.hasNext()) && (returnObject == null)) {
      tempObject = (Method)this.get_next(iterator);

      if (tempObject.get_Name().equals(name)) {
        returnObject = tempObject;
      }
    }

    return returnObject;
  }

  public Method get_Method(int i) {
    return (Method)super.get(i);
  }


  /**
   * Fonction calculant le nombre de méthodes
   * que la liste possède selon un range(public, private, protected).
   *
   * @param iRange int : Le range
   * @return int : Le nombre de méthodes dans la liste.
   */
  public int get_methodsRange(int iRange) {
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
 public Method get_next(ListIterator iter) {
    return (Method) iter.next();
  }

  public void remove_current(ListIterator iter) {
    iter.remove();
  }
}
