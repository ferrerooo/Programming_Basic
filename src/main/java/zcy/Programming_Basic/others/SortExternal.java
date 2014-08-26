package zcy.Programming_Basic.others;
import java.util.*;
import java.io.*;

/*
 * file.exists();   file.delete();  file.getPath();   file.renameTo(file);   file.list();
 * 
 * 
 * */

public class SortExternal {

	public static void main(String[] args) throws Exception {
		
		String originalPath = "C:/Users/zouc/Desktop/david/externalsort/original.txt";
		
		SortExternal.prepareData(originalPath);
		List<String> files = SortExternal.splitFile(originalPath);
		SortExternal.mergeSort(files);
		
	}
	
	private static void mergeSort(List<String> files) throws Exception {
		
		if (files.size()==1) {
			
			File file = new File(files.get(0));
			file.renameTo(new File("C:/Users/zouc/Desktop/david/externalsort/result.txt"));
			return ;
		}
		
		String newFile = "C:/Users/zouc/Desktop/david/externalsort/"+System.nanoTime()+".txt";
		BufferedWriter bw = new BufferedWriter(new FileWriter(newFile));
		String f1 = files.get(0);
		String f2 = files.get(1);
		
		BufferedReader br1 = new BufferedReader(new FileReader(new File(f1)));
		BufferedReader br2 = new BufferedReader(new FileReader(new File(f2)));
		
		// merge operation of two files
		
		String s1 = br1.readLine();		
		String s2 = br2.readLine();
		
		while (true) {
			if (Integer.valueOf(s1)<Integer.valueOf(s2)) {
				bw.write(s1+"\n");
				if ((s1=br1.readLine())!=null ) {
					continue;
				} else {
					break;
				}
			} else {
				bw.write(s2+"\n");
				if ( (s2=br2.readLine())!=null ) {
					continue;
				} else {
					break;
				}
			}
		}
		
		if (s1 == null) {
			bw.write(s2+"\n");
			while ((s2=br2.readLine())!=null) {
				bw.write(s2+"\n");
			}
		} else {
			bw.write(s1+"\n");
			while ((s1=br1.readLine())!=null) {
				bw.write(s1+"\n");
			}
		}

		
		bw.close();
		br1.close();
		br2.close();

		files.add(newFile);
		File oldf1 = new File(f1);
		File oldf2 = new File(f2);
		if (oldf1.exists())
			oldf1.delete();
		if (oldf2.exists())
			oldf2.delete();

		files.remove(0);
		files.remove(0);
		
		mergeSort(files);
		
	}
	
	
	
	private static List<String> splitFile(String path) throws Exception {
		
		List<String> files = new ArrayList<String>();
		
		File file = new File(path);
		BufferedReader br = new BufferedReader(new FileReader(file));
		String line = "";
		
		int[] arr = new int[100];
		int count= 0;
		
		while ( (line=br.readLine()) != null ) {
			
			arr[count] = Integer.valueOf(line);
			count ++;
			if (count == arr.length) {
				
				Arrays.sort(arr);
				File splitfile = new File("C:/Users/zouc/Desktop/david/externalsort/"+System.nanoTime()+".txt");
				BufferedWriter bw = new BufferedWriter(new FileWriter(splitfile));
				for (int i:arr) 
					bw.write(i+"\n");
				bw.close();
				files.add(splitfile.getPath());
				arr = new int[100];
				count = 0;
			}
			
		}
		
		if (count !=0) {
			Arrays.sort(arr);
			File splitfile = new File("C:/Users/zouc/Desktop/david/externalsort/"+System.nanoTime()+".txt");
			BufferedWriter bw = new BufferedWriter(new FileWriter(splitfile));
			for (int i=0;i<count;i++) {
				bw.write(arr[i]+"\n");
			}
			bw.close();
			files.add(splitfile.getPath());
		}		
		return files;
	}
	
	private static void prepareData(String path) throws Exception {
		File file = new File(path);
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		Random rand = new Random();
		int totalAmount = 1000;
		if (file.exists())
			file.delete();
		for (int i=0;i<totalAmount; i++)
			bw.write(rand.nextInt()+"\n");
		
		bw.close();
	}
	
	

}
