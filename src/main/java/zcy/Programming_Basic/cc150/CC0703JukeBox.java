package zcy.Programming_Basic.cc150;
import java.util.*;
public class CC0703JukeBox {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	abstract class MusicalInstrument{
		abstract public void play();
		abstract public void stop();
		abstract public void soundControl();
		abstract public void importMusic(Song song);
	}
	
	class JukeBox extends MusicalInstrument {
		
		List<CD> cdlist;
		List<Mp3> mp3list;
		Hashtable<String, List<Song>> favorates;
		
		public void play(){}
		public void stop(){}
		public void soundControl(){}
		public void importMusic(Song song){}
		
	}
	
	class Song{}
	class CD{}
	class Mp3{}

}
