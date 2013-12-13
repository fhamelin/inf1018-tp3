import java.util.ArrayList;
import java.util.ListIterator;



/**
 *  C'est une liste contenant des objects Attribute.<p/>
 *
 *
 * @author Daniel St-Yves
 * @see Attribute
 * @see Range
 */
public class AttributeList
    extends ArrayList {


  /*============================================================================
    Constructor
   ===========================================================================*/

  public AttributeList() {
  }

  /*============================================================================
    Method
   ===========================================================================*/

  /**
   * Recherche un attribut d'un nom en particulier.
   *
   * @param attributeName String : Le nom de l'attribut à rechercher.
   * @return Attribute : L'attribut trouvé. Null si non trouvé.
   */
  public Attribute get(String name) {
    Attribute returnObject = null;

    Attribute tempObject;
    ListIterator iterator = this.listIterator();
    while ( (iterator.hasNext()) && (returnObject == null)) {
      tempObject = this.get_next(iterator);

      if (tempObject.get_Name().equals(name)) {
        returnObject = tempObject;
      }
    }

    return returnObject;
  }


  public Attribute get_Attribute(int i){
    return (Attribute) this.get(i);
  }


  /**
   * Indique si deux listes d'attibuts sont égales
   *
   * @param Object list : La liste avec laquelle on compare.
   * @return boolean : Vrai si les deux listes sont identiques.
   */
   public boolean equals(Object list){
     boolean bEquals = false;

     if(list instanceof AttributeList){
       AttributeList attList = (AttributeList)list;

       if(attList.size() == this.size()){
         ListIterator listIterator = attList.listIterator();
         ListIterator thisIterator = this.listIterator();

         Attribute att1;
         Attribute att2;
         while((listIterator.hasNext()) && (thisIterator.hasNext())){
           att1 = (Attribute)listIterator.next();
           att2 = (Attribute)thisIterator.next();

           if(att1.equals(att2))
             bEquals = true;
           else
             bEquals = false;
         }
       }
     }

     return bEquals;
   }


  /**
   * Fonction calculant le nombre d'attributs
   * que la liste possède selon un range(public, private, protected).
   *
   * @param iRange int : Le range
   * @return int : Le nombre d'attributs dans la liste.
   */
  public int get_AttributesRange(int iRange) {
    int iTotal = 0;

    ListIterator iterator = this.listIterator();
    while (iterator.hasNext()) {
      if ( (this.get_next(iterator)).range.get_Range() == iRange) {
        iTotal++;

      }
    }
    return iTotal;
  }



  /**
   * Ajoute un nouvel attribut dans la liste à partir des informations fournis.
   *
   * @param name String : Le nom de l'attribut
   * @param type String : Son type
   */
  public Attribute add(String type, String name) {
    Attribute temp = new Attribute();
    temp.set_Attribute(name, type);
    this.add(temp);

    return temp;
  }


  /*============================================================================
    Iterator (delege)
   ===========================================================================*/

  /**
   * Retourne un prochain élément
   *
   * @return Attribute
   */
  public Attribute get_next(ListIterator iter){
    return (Attribute) iter.next();
  }

}
