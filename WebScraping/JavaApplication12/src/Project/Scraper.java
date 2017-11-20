
package Project;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



public class Scraper {
    
    
     public static void dataScraping(String url, String words, String commands) throws IOException {
     
         
        java.util.logging.Logger.getLogger("com.gargoylesoftware.htmlunit").setLevel(java.util.logging.Level.OFF);
        java.util.logging.Logger.getLogger("org.apache.http").setLevel(java.util.logging.Level.OFF);
        
        List<WordClass> wordList= new ArrayList<>();
        final String titleOfPage; 
        final String pageAsText; 
 
       
        final WebClient webClient = new WebClient();
        final HtmlPage htmlPage;
        int wordCount;
        int index; 
        int countChar;
        long time=-1;
     
        
        final long start = System.currentTimeMillis();
         
        try {
            htmlPage = webClient.getPage(url);
        } catch (IOException | FailingHttpStatusCodeException e) {
           throw new RuntimeException("Page couldn't be opened, " + e);
        }
        
               titleOfPage = htmlPage.getTitleText().toLowerCase();
               pageAsText = htmlPage.asText().toLowerCase();
            
        
          String page = pageAsText.substring(titleOfPage.length());
          String[] splitWords = words.split(",");  // every word must be split from others and should be kept on the array.
                    
          if(commands.contains("-c"))  
              countChar=pageAsText.trim().length() - titleOfPage.trim().length(); // title length is unnecessary
          else
              countChar=-1;
         
          // for every word ...
         for(int i=0; i<splitWords.length; i++)
         {
               splitWords[i]=splitWords[i].toLowerCase(); // case-sensitive
                 wordCount = 0;
                  
                 if(!commands.contains("-w")) // if -w command is absent
                      wordCount=-1;
                 
                 String sentence;
                 List<String> allSentences=new ArrayList<>(); // for all sentences which contain this word
                              
                              
                  index = page.indexOf(splitWords[i]);
                      while (index >= 0) {  // indexOf returns -1 if no match found
                     
                           if(commands.contains("-w"))
                                 wordCount++;
                          
                                      
                          
                           if(commands.contains("-e")) 
                           {
                               sentence=findSentence(page, index, splitWords[i]);
                               allSentences.add(sentence);
                           }
                           else
                               allSentences=null;
                            
                          
                            index = page.indexOf(splitWords[i], index + 1); // word is searched in all text
                      }
                  
                      if(commands.contains("-v")) 
                      {
                        final long finish = System.currentTimeMillis();
                        time=finish-start; // 
                      } 
                     
                
                      // object is created for each word and then added to arraylist
                  WordClass wordObject=new WordClass(url, splitWords[i], wordCount, allSentences, countChar, time, commands);
                  wordList.add(wordObject);
                  
     }
            
              
         // display result on the console and file
         DisplayData.displayResult(wordList);
             
     }
     
     
      public static String findSentence(String text, int index, String word)
    {
         int startIndex=0;
         int lastIndex=0;
         int index1=index;
         int index2=index;
         String sentence;
         
        // the beginning of sentence is searched
        while(index1>0)
        {
            if(text.charAt(index1)!='.' && text.charAt(index1)!='!' && text.charAt(index1)!='?' && text.charAt(index1)!='\n' )
            {
                index1--;
            }
            else {
               startIndex=index1;
               startIndex++;
               break;
            }
           
        }
        
        //the end of sentence is searched
         while(index2<text.length())
        {
            if(text.charAt(index2)!='.' && text.charAt(index2)!='!' && text.charAt(index2)!='?' && text.charAt(index2)!='\n' )
            {
                index2++;
            }
            else {
              lastIndex=index2;
              lastIndex++;
              break;
            }
           
        }
        
         //the sentence cut out from text
        sentence=text.substring(startIndex, lastIndex);
         
        return sentence;
    }
     
}
