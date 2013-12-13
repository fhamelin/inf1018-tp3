import java.util.ListIterator;
import java.util.ArrayList;

/**
 *  C'est une liste contenant des objects DescriptionInterface.<p/>
 */
public class InterfaceList
    extends ArrayList {

  /*============================================================================
    Constructor
   ===========================================================================*/
  public InterfaceList() {

  }

  /*============================================================================
    Method
   ===========================================================================*/
  public DescriptionInterface get(String name) {
    DescriptionInterface returnObject = null;

    DescriptionInterface tempObject;
    ListIterator iter = this.listIterator();
    while ( (iter.hasNext()) && (returnObject == null)) {
      tempObject = (DescriptionInterface)this.get_next(iter);

      if (tempObject.get_Name().equals(name)) {
        returnObject = tempObject;
      }
    }

    return returnObject;
  }

  public DescriptionInterface get_Interface(int i) {
    return (DescriptionInterface)super.get(i);
  }

  /*============================================================================
   List Iterator
   ===========================================================================*/
  public DescriptionInterface get_next(ListIterator iter) {
    return (DescriptionInterface)iter.next();
  }

}
