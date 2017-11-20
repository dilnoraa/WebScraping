
package Project;

import java.util.List;

public class WordClass {
    final private String url;
    final private String word;
    final private int wordCount;
    final private List<String> sentences;
    final private int countChar;
    final private long processingTime;
    final private String commands;

    public WordClass(String url, String word, int wordCount, List<String> sentences,int countChar, long processingTime, String commands ) {
        this.url = url;
        this.word = word;
        this.wordCount = wordCount;
        this.sentences = sentences;
        this.countChar=countChar;
        this.processingTime=processingTime;
        this.commands=commands;
    }

    public void display()
    {
         System.out.println();
         
         System.out.println("  Web Page's URL: "+ url);
         System.out.println("  Commands : "+ commands);
          if(countChar!=-1)
            System.out.println("---This Web page has " +countChar + " characters");
        
           System.out.println("---Searched word: " + word);
         
         if(wordCount!=-1)
         System.out.println("---Number of word: " + wordCount);
         
         if(sentences!=null){
            System.out.println("---Sentences which contain  this word:");
            for(int i=0 ; i<sentences.size(); i++) {
             System.out.println(i+1 + ")" + sentences.get(i));
             System.out.println();
          }}
          
         
         if(processingTime!=-1)
           System.out.println("---Time spent for data scraping and data processing: " + processingTime + " milliseconds.");
           System.out.println();
           System.out.println();
            
    }
     
        
     
    public String getUrl() {
        return url;
    }

    public String getWord() {
        return word;
    }

    public int getwordCount() {
        return wordCount;
    }

    public List<String> getSentences() {
        return sentences;
    }
    
     public int getCountChar() {
        return countChar;
    }
     public long getProcessingTime ()
     {
         return processingTime;
     }
     
     public String getCommandsLine()
     {
         return commands;
     }
}
