package use;

import java.io.BufferedReader;
import java.io.FileReader;

import retrieve.Retriever;
import entity.UrlContent;

public class RetrievePage {
	private static BufferedReader reader;

	public static void main(String[] args) {
		Retriever.urlEntities.removeAllElements();

		try {
			reader = new BufferedReader(new FileReader("data/topCat.txt"));
			String line = "";
			String prevUrl= "http://www.freebase.com/";
			while ((line = reader.readLine()) != null) {
				if (!line.contains("/"))
					continue;
				
				line = line.substring(line.indexOf("/"));
				line = line.toLowerCase();
				line = line.replaceAll(" ", "_");
				UrlContent hotelReview = new UrlContent();
				hotelReview.urlString = prevUrl + line;
				Retriever.urlEntities.add(hotelReview);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println();
		Retriever.setOutput("data/content.txt");
		Retriever.retrieve();
	}


}
