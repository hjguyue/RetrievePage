package entity;

import java.util.Vector;

import retrieve.*;

public class UrlContent extends UrlEntity{
	
	public void handle(){
		
		String data = MatchFinder.findOneMatch("<tbody>[\\s\\S]*?</tbody>", content);
		Vector<String> vector = MatchFinder.findAllMatch("<tr>[\\s\\S]*?</tr>", data);
		for (String str:vector) {
			String name = MatchFinder.findOneMatch("schema=[\\s\\S]*?</a>", str);
			name = name.replaceAll("schema=\">", "");
			name = name.replaceAll("</a>", "");
			System.out.println(name);	
		}
	}
	
}
