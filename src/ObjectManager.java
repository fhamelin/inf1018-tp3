/*
 * Created on 2004-11-21
 *
 */

import java.util.Stack;

/**
 * Permet de faire la gestion des structures captur�es dans un parser cr�� par
 * JavaCC
 * 
 * @author Daniel
 *  
 */
public class ObjectManager extends Stack {

    public ObjectManager() {
    }

    /**
     * Ajoute un object dans l'object le plus r�cent de la pile selon le type de
     * classe. Ajoute ensuite l'object au dessus de la pile comme �tant l'objet
     * que l'on travail pr�sentement.<p/>
     * 
     * Peut aussi �tre modifi� pour que les if v�rifie si l'objet impl�mente
     * un certain interface comme HaveClass, HaveMethod, etc...
     * 
     * @param o :
     *            Un object devant �tre ajout� � la pile et � la structure la
     *            plus r�cente de la pile.
     */
    public void addToTopObject(Object o) {

        if (peek() instanceof Method) {
            Method m = (Method) peek();
            if (o instanceof Attribute) {
                m.attributelist.add(o);
            }
            else if (o instanceof MethodCall) {
            	m.add_Call((MethodCall)o);
            }

        } else if (peek() instanceof JavaFile) {
            JavaFile jf = (JavaFile) peek();
            if (o instanceof DescriptionClass){
                jf.add_Class((DescriptionClass) o);              
            }

        } else if (peek() instanceof DescriptionClass) {
            DescriptionClass c = (DescriptionClass)peek();

            if (o instanceof DescriptionClass)
                c.classlist.add((DescriptionClass) o);

            if (o instanceof Method)
                c.add_Method((Method) o);
            
            if (o instanceof Attribute)
                c.attributelist.add((Attribute)o);
            

        } else if (peek() instanceof DescriptionInterface) {

        }
        
        //Ajoute l'objet � la pile.
        this.push(o);
    }
}