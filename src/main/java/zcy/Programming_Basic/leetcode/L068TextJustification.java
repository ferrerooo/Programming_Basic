package zcy.Programming_Basic.leetcode;
import java.util.*;
public class L068TextJustification {

	public List<String> fullJustify(String[] words, int L) {
        
        List<String> al = new ArrayList<String>();
        
        if (words == null || words.length == 0)
            return al;
        
        String line = "";
        
        for (int i=0;i<words.length; i++) {
            
            if (line.length() + words[i].length() < L) {
                line += words[i]+" ";
            } else if (line.length() + words[i].length() == L) {
                line += words[i];
                al.add(line);
                line = "";
            } else {
                
                convertAndSave(al, line, L);
                i--;
                line = "";
            }
        }
        
        if (line.length()!=0) {
            int spaceNum = L-line.length();
            StringBuilder sb = new StringBuilder();
            for (int i=0;i<spaceNum;i++)
                sb.append(" ");
            line = line + sb.toString();
            al.add(line);
        }
        
        return al;
    }
    
    private void convertAndSave(List<String> al, String line, int L) {
        
        line = line.trim();
        
        if (!line.contains(" ")) {
            int spaceNum = L-line.length();
            StringBuilder sb = new StringBuilder();
            for (int i=0;i<spaceNum;i++)
                sb.append(" ");
            line = line+sb.toString();
            al.add(line);
            return;
        } else {
            String[] words = line.split(" ");
            int wordNum = words.length;
            int wordLen = 0;
            for (String w:words)
                wordLen += w.length();
            
            int spaceNum = L-wordLen;
            String[] spaces = new String[wordNum-1];
            for (int i=0;i<spaces.length;i++)
                spaces[i] = "";
            
            for (int i=0;i<spaceNum;i++) {
                spaces[i%spaces.length] += " ";
            }
            
            String newline = words[0];
            
            for (int i=0;i<spaces.length; i++) {
                newline += spaces[i]+words[i+1];
            }
            
            al.add(newline);
        }
        
    }

}
