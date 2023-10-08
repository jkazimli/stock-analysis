package fileprocessors;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StockFileReader {
	
	String filePath = null;
	
	public StockFileReader(String filePath){
		this.filePath = filePath;
	}
	
	public List<String> getHeaders() throws IOException{
		String line = readFirstLine(filePath);
		String [] header = line.split(",");
		List<String> values = new ArrayList<String>();
		values = Arrays.asList(header);
		return values;
	}
	
	static String readFirstLine(String path) throws IOException {
	    try (BufferedReader br =
	                   new BufferedReader(new FileReader(path))) {
	        return br.readLine();
	    }
	}

	public List<String> readFileData() throws IOException{
		/*
			lines:
			[
				"142.440002,142.679993,141.850006,142.270004,17245200,142.270004",
				"141.220001,142.919998,141.160004,142.440002,23251100,142.440002"
			]
		 */
		List<String> lines = new ArrayList<>();

		BufferedReader br = new BufferedReader(new FileReader(filePath));

		br.readLine();
		String line;
		while ((line = br.readLine()) != null) {
			lines.add(line);
		}

	    return lines;
	}
	

}
