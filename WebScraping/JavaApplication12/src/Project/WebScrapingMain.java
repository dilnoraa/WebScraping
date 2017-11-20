
package Project;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;



public class WebScrapingMain {
   

    public static void main(String[] args) throws IOException, Exception {
       
        
        createFileForUrls.createFile(); // 
                             
         File old_file = new File("DisplayScapingResult.txt"); // the file from the previous test must be deleted
          if (old_file.exists()) 
                 old_file.delete();  
           
          
            options();   
     
       
         
    }                    
   
    public static void options() throws IOException
    {
         System.out.println("------------OPTIONS------------------");
         System.out.println("   -For one URL, please press 1 ");
         System.out.println("   -For more URL from file, please press 2 ");
         
          
         Scanner input = new Scanner(System.in);
         int no = input.nextInt();
         
          switch (no) {
            case 1:   
                      System.out.println(" The results will be displayed on the Console and DisplayScrapingResult.txt .\n");
                      System.out.println(" Loading... Please Wait.\n");
                      TestUrls.TestOneUrl();
                      break;
                
            case 2:   
                      System.out.println(" The results will be displayed on the Console and DisplayScrapingResult.txt .\n");
                      System.out.println(" Loading... Please Wait.\n");
                      TestUrls.TestUrlsFromFile();
                      break;
            default: 
                      System.out.println("Wrong option, please try again. \n");
                      options();
                      break;
          }
        
    }
  
}



		     

		
        
        
        
        
        
       

       
    

