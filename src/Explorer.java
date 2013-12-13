/*
 * Created on 2004-11-01
 *
 */
import java.io.File;
import java.util.ArrayList;

/**
 * @author Daniel
 *  
 */
public class Explorer {

    /**
     * Fonction récursive permettant de recueillir une liste contenant tous les
     * fichiers dans le permier répertoire et les sous-répertoires.
     * 
     * @param File :
     *            Le permier répertoire.
     * @param ArrayList :
     *            Un ArrayList devant être remplit d'objet <code>File<code>
     * @param (String)ArrayList  :
     *            Liste de filtre d'extention de fichiers. Par exemple, pour
     *            n'obtenir que les fichiers dont l'extention est '.java',
     *            extfilter contient : 'java'.
     */
    public static void listFiles(File dir, ArrayList fileList, ArrayList extfilter) {

        //Recursivité
        if (dir.isDirectory()) {
            String[] children = dir.list();
            File childFile;
            for (int i = 0; i < children.length; i++) {
                childFile = new File(dir, children[i]);

                //Si c'est un répertoire, alors on recherche ses fichiers
                if (childFile.isDirectory())
                    listFiles(childFile, fileList, extfilter);

                //C'est un fichier
                else if (childFile.isFile()) {
                    //On vérifie s'il contient l'extention recherchée et si
                    // oui, on l'ajoute dans la liste
                    if ((extfilter == null) | (extfilter.size() == 0))
                        fileList.add(childFile);
                    else {
                        if(extfilter.contains(Explorer.getExtention(childFile)))
                            fileList.add(childFile);
                    }

                }
            }
        }

    }

    /**
     * Retourne l'extention d'un fichier sans le "."
     * 
     * @param filename :
     *            le nom du fichier dans le path
     * @return String : L'extention du fichier
     */
    private static String getExtention(String filename) {
        //Dernier index du "." s'il y en a un dans le fichier.
        int lastDotIndex = filename.lastIndexOf(".");
        if (lastDotIndex == -1)
            return null; //Il n'y a pas d'extention
        else {

            //On prend de la fin jusqu'au point.
            return filename.substring(lastDotIndex + 1, filename.length());
        }

    }

    /**
     * Retourne l'extention d'un fichier sans le "."
     * 
     * @param file :
     *            Le fichier
     * @return String : L'extention du fichier
     */
    public static String getExtention(File file) {
        return getExtention(file.getName());
    }

}