
package Project;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class TestUrls {
    
    public static void TestUrlsFromFile() throws IOException
    {
        
         ArrayList<String> listOfUrl =new ArrayList<>();  // for several URL string...
         Object line;
         String words="browser, url, free";
         
       try {
            FileReader reader = new FileReader("FileOfUrls.txt");
            
            BufferedReader bufferedReader = new BufferedReader(reader);
            
           while ((line = bufferedReader.readLine()) != null) 
                listOfUrl.add((String) line);
               
            
            reader.close();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
       
       
       for(int i=0; i<listOfUrl.size(); i++)
       {
            Scraper.dataScraping(listOfUrl.get(i), words, "-v -w -c -e ");
       }
           
    }
    
    
    public static void TestOneUrl () throws IOException
    {
         String url=("http://en.wikipedia.org/wiki/Web_scraping ");
          String words="url, json, extracting";
          
         Scraper.dataScraping(url, words, "-v -w -c -e");
         
         
    }
}
