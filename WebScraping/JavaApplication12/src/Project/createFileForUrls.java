
package Project;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;


public class createFileForUrls {
    
    public static void createFile()
    {
          String fileName = "FileOfUrls.txt";
           PrintWriter printWriter = null;
           File file = new File(fileName);
       try {
       
            file.createNewFile();
        printWriter = new PrintWriter(new FileOutputStream(fileName, false));
     
        printWriter.write("http://htmlunit.sourceforge.net/ \n"); //  every line has only one URL string, so I add "\n"
        printWriter.write("https://netbeans.org/features/java/ \n");
        printWriter.write("https://www.java.com/en/download/faq/whatis_java.xml");
                
         } catch (IOException e) {
           System.out.println(e);
    } finally {
        if (printWriter != null) {
            printWriter.flush();
            printWriter.close();
        }
    }
        
    }
    
}
