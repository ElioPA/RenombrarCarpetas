package renombrarcarpetas;

import java.io.File;

/**
 *
 * @author Elio
 */
public class RenombrarCarpetas {

    public static void main(String[] args) {
       
        String carpAct = System.getProperty("user.dir");
        File carpeta = new File(carpAct);
        carpActual(carpeta, carpAct);
        
    }

    public static void carpActual(File c, String carpAct) {
        c = new File(carpAct);
        File nameFiles[] = c.listFiles();
        for (int i = 0; i < nameFiles.length; i++) {
            if (nameFiles[i].isDirectory()) {
                carpActual(nameFiles[i],carpAct + "\\" + nameFiles[i].getName());
                for (int j = 0; j < nameFiles[i].getName().length(); j++) {
                    if (nameFiles[i].getName().charAt(j) == '(') {
                        File newName = new File(carpAct + "\\" + nameFiles[i].getName().substring(0, j));
                        nameFiles[i].renameTo(newName);
                        break;
                    }
                }
            }
        }
    }
    
}
