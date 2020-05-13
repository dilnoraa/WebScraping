package Project;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;


public class DisplayData {

    public static void displayResult(List < WordClass > wordList) {

        String fileName = "DisplayScapingResult.txt";
        PrintWriter printWriter = null;
        File file = new File(fileName);
        try {

            file.createNewFile();
            printWriter = new PrintWriter(new FileOutputStream(fileName, true));
            for (WordClass wrd: wordList) {
                wrd.display();

                printWriter.write("\n \n");
                printWriter.write("\n   Web Page's URL: " + wrd.getUrl());
                printWriter.write("\n  Commands : " + wrd.getCommandsLine());
                if (wrd.getCountChar() != -1) // if -c command is not absent...
                    printWriter.write(" \n ---This Web page has " + wrd.getCountChar() + " characters");

                printWriter.write("\n ---Searched word: " + wrd.getWord());

                if (wrd.getwordCount() != -1) // if -w command is not absent...
                    printWriter.write("\n ---Number of word: " + wrd.getwordCount());

                if (wrd.getSentences() != null) { // if -e command absent...
                    printWriter.write("\n ---Sentences which contain  this word:");
                    for (int i = 0; i < wrd.getSentences().size(); i++) {
                        printWriter.write("\n \n");
                        printWriter.write(i + 1 + ")" + wrd.getSentences().get(i));
                    }
                }

                if (wrd.getProcessingTime() != -1) // if -v command is not absent...
                    printWriter.write("\n ---Time spent for data scraping and data processing: " + wrd.getProcessingTime() + " milliseconds.");
                printWriter.write("\n \n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (printWriter != null) {
                printWriter.flush();
                printWriter.close();

            }
        }
    }
}
