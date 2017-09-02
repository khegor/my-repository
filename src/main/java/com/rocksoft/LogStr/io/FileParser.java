package com.rocksoft.LogStr.io;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.io.FileUtils;

public class FileParser {

    public void printWordCountsToFile(String[] words) {
        List<String> usedWords = new ArrayList();
        List<Integer> countList = new ArrayList();
        boolean isUsed;
        int count;
        for(int i = 0; i < words.length; i++) {
            count = 1;
            isUsed = false;
            for(String usedWord : usedWords) {
                if(words[i].equals(usedWord)) {
                    isUsed = true;
                    break;
                }
            }
            if(!isUsed) {
                for (int j = i + 1; j < words.length; j++) {
                    if (words[i].equals(words[j]))
                        count++;
                }
                usedWords.add(words[i]);
                countList.add(count);
            }
        }
        printToFile(usedWords, countList);
    }

    private void printToFile(List<String> words, List<Integer> counts) {
    	File f2 = new File("C:\\Users\\Esenin\\eclipse-workspace\\LogisticStruct\\src\\text2.txt");
    	
    	List<String> result = new ArrayList<>();
    		
    	for (int i = 0; i < words.size(); i++) {
    		result.add(words.get(i) + " " + counts.get(i));
    	}
    	
    	try {
			FileUtils.writeLines(f2, result, false);
		} catch (IOException e) {
			System.out.println(e);
		}
    }
}
