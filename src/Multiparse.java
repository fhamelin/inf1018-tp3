import java.io.File;
import java.util.ArrayList;
import java.util.ListIterator;

/*
 * Created on 2004-11-22
 */

/**
 * 
 * Exemple d'une simple application parsant plusieurs fichier .java
 * dans la console.
 * 
 * @author Daniel
 *
 */
public class Multiparse {
    public static MyJavaFilesManager mjfm = new MyJavaFilesManager();
    
    public static void main(String[] args) {
       
        //Le premier argument est le répertoire où regarder les fichiers .java
        String path = "";
        path = args[0].toString();
	    //path = "E:\\Programmation\\Cours JavaCC\\exemple2";

        //Liste de fichiers
        ArrayList lstJavaFile = new ArrayList();
        ArrayList fileToParse = new ArrayList();
        
        //On recherche les fichiers .java dans le path
        ArrayList filter = new ArrayList();
        filter.add("java");
        Explorer.listFiles(new File(path),fileToParse,filter);
        
        //On parse tous les fichiers à parser...
        JavaParser parser;
        for(ListIterator i = fileToParse.listIterator(); i.hasNext();){
            parser = new JavaParser((File)i.next());
            lstJavaFile.add(parser.get_javaFile());
            mjfm.merged(parser.mjfm);
            //System.out.println("#\n"+parser.mjfm.see());
        }
        //Affiche la liste de fichiers parser
        System.out.println("Liste de fichiers parser :");
        for(ListIterator i = lstJavaFile.listIterator(); i.hasNext();){
            System.out.println(((JavaFile)i.next()).get_File().getPath());
        }
        //System.out.println(((JavaFile)lstJavaFile.get(1)).get_classList());
 //       System.out.println(((DescriptionClass)((JavaFile)lstJavaFile.get(0)).get_classList().get(0)).range);
    }
}
