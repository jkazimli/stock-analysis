package client;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import fileprocessors.StockFileData;
import fileprocessors.StockFileReader;

public class StockFileApplication {


    public static void main(String args[]) throws IOException {
        StockFileReader fr = new StockFileReader("table.csv");

        List<HashMap<String, Double>> dataResult = populateStockFileData(fr.getHeaders(), fr.readFileData());
        StockFileData fileData = new StockFileData();
        fileData.addData(dataResult);
        fileData.printData();
        System.out.println(dataResult.size());
    }

    public static List<HashMap<String, Double>> populateStockFileData(List<String> headers, List<String> lines) {
        List<HashMap<String, Double>> dataResult = new ArrayList<>();
		/*
			lines:
			[
				"142.440002,142.679993,141.850006,142.270004,17245200,142.270004",
				"141.220001,142.919998,141.160004,142.440002,23251100,142.440002"
			]

			data result:
			[
				{
					open: 142.440002
					high: 142.679993
					low: 141.850006
					close: 142.27000
					volume: 17245200
					adj close: 142.270004
				},

				{
					open: 142.440002
					high: 142.679993
					low: 141.850006
					close: 142.27000
					volume: 17245200
					adj close: 142.270004
				},

				{
					open: 142.440002
					high: 142.679993
					low: 141.850006
					close: 142.27000
					volume: 17245200
					adj close: 142.270004
				}
			]
		 */
        HashMap<String, Double> currentStock;

        for (String line : lines) {
            currentStock = new HashMap<>();
            String[] individualValue = line.split(",");

            for (int i = 0; i < headers.size(); i++) {
                currentStock.put(headers.get(i), Double.parseDouble(individualValue[i]));
            }

            dataResult.add(currentStock);
        }

        return dataResult;
    }


}
