/*
 * Created on 2004-11-21
 *
 */

import java.util.Stack;

/**
 * Permet de faire la gestion des structures capturées dans un parser créé par
 * JavaCC
 * 
 * @author Daniel
 *  
 */
public class ObjectManager extends Stack {

    public ObjectManager() {
    }

    /**
     * Ajoute un object dans l'object le plus récent de la pile selon le type de
     * classe. Ajoute ensuite l'object au dessus de la pile comme étant l'objet
     * que l'on travail présentement.<p/>
     * 
     * Peut aussi être modifié pour que les if vérifie si l'objet implémente
     * un certain interface comme HaveClass, HaveMethod, etc...
     * 
     * @param o :
     *            Un object devant être ajouté à la pile et à la structure la
     *            plus récente de la pile.
     */
    public void addToTopObject(Object o) {

        if (peek() instanceof Method) {
            Method m = (Method) peek();
            if (o instanceof Attribute) {
                m.attributelist.add(o);
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
        
        //Ajoute l'objet à la pile.
        this.push(o);
    }
}