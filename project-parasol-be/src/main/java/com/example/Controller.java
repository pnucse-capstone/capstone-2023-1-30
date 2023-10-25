package com.example;

import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class Controller {

	/**
	 * @return getStocks
	 */

	@GetMapping("/stocks")
	public ResponseEntity<String> getStocks() {
		Map<Integer, String> stockCodes = Util.getFileNameMap("data");

		JSONArray resultArray = new JSONArray();

		for (Integer stockCode : stockCodes.keySet()) {
			ResponseEntity<String> stockResponse = getStock(stockCode);

			if (stockResponse.getStatusCode() == HttpStatus.OK) {
				resultArray.put(new JSONObject(stockResponse.getBody()));
			}
		}

		return ResponseEntity.ok(resultArray.toString());
	}

	/**
	 * @param stockCode
	 * @return getStock
	 */

	@GetMapping("/stock/{stockCode}")
	public ResponseEntity<String> getStock(@PathVariable Integer stockCode) {
		JSONArray jsonArray = Util.readCSV(String.format("data/%06d_%s.csv", stockCode, Util.getFileNameMap("data").get(stockCode)));

		if (jsonArray == null) {
			return ResponseEntity.badRequest().body("파일을 읽던 중 문제가 발생했습니다.");
		}

		JSONObject lastModel = jsonArray.getJSONObject(jsonArray.length() - 1);
		JSONObject lastButOneModel = (jsonArray.length() > 1) ? jsonArray.getJSONObject(jsonArray.length() - 2) : null;

		JSONObject price = new JSONObject();
		price.put("date", lastModel.getString("date"));
		price.put("value", lastModel.getDouble("close"));
		price.put("change", lastButOneModel != null ? (lastModel.getDouble("close") - lastButOneModel.getDouble("close")) : JSONObject.NULL);

		JSONObject recentRecommend = new JSONObject();
		recentRecommend.put("date", lastModel.getString("date"));

		switch (lastModel.getString("action")) {
		case "0": recentRecommend.put("recommend", "buy"); break;
		case "1": recentRecommend.put("recommend", "sell"); break;
		case "2": recentRecommend.put("recommend", "hold"); break;
		}

		JSONObject result = new JSONObject();
		result.put("stockCode", stockCode);
		result.put("price", price);
		result.put("recentRecommend", recentRecommend);
		// result.put("model", Util.getFileNameMap("data").get(stockCode));

		return ResponseEntity.ok(result.toString());
	}

	/**
	 * @param stockCode
	 * @param page
	 * @return
	 */

	@GetMapping("/recommend/{stockCode}/{page}")
	public ResponseEntity<String> getRecommend(@PathVariable Integer stockCode, @PathVariable int page) {
		JSONArray jsonArray = Util.readCSV(String.format("data/%06d_%s.csv", stockCode, Util.getFileNameMap("data").get(stockCode)));

		if (jsonArray == null) {
			return ResponseEntity.badRequest().body("파일을 읽던 중 문제가 발생했습니다.");
		}

		int startIndex = Math.max(0, jsonArray.length() - 10 * page);
		int endIndex = Math.min(jsonArray.length(), jsonArray.length() - 10 * (page - 1));

		JSONArray combinedData = new JSONArray();

		for (int i = startIndex; i < endIndex; i++) {
			JSONObject modelObject = jsonArray.getJSONObject(i);

			if (modelObject != null) {

				JSONObject combinedObject = new JSONObject();
				combinedObject.put("date", modelObject.getString("date"));

				switch (modelObject.getString("action")) {
				case "0": combinedObject.put("recommend", "buy"); break;
				case "1": combinedObject.put("recommend", "sell"); break;
				case "2": combinedObject.put("recommend", "hold"); break;
				}

				combinedData.put(combinedObject);
			}
		}

		return ResponseEntity.ok(combinedData.toString());
	}

	/**
	 * @param stockCode
	 * @param page
	 * @return getPrices
	 */

	@GetMapping("/prices/{stockCode}/{page}")
	public ResponseEntity<String> getPrices(@PathVariable Integer stockCode, @PathVariable int page) {
		JSONArray jsonArray = Util.readCSV(String.format("data/%06d_%s.csv", stockCode, Util.getFileNameMap("data").get(stockCode)));

		if (jsonArray == null) {
			return ResponseEntity.badRequest().body("파일을 읽던 중 문제가 발생했습니다.");
		}

		JSONArray selectedPrices = new JSONArray();
		int startIndex = Math.max(0, jsonArray.length() - 10 * page);
		int endIndex = Math.min(jsonArray.length(), jsonArray.length() - 10 * (page - 1));

		Double prevClose = (startIndex - 1 >= 0) ? jsonArray.getJSONObject(startIndex - 1).getDouble("close") : null;

		for (int i = startIndex; i < endIndex; i++) {
			JSONObject obj = jsonArray.getJSONObject(i);
			String date = obj.getString("date");
			Double currentClose = obj.getDouble("close");
			Double change = (prevClose == null) ? null : currentClose - prevClose;
			JSONObject priceData = new JSONObject();
			priceData.put("date", date);
			priceData.put("value", currentClose);
			priceData.put("change", change);
			selectedPrices.put(priceData);
			prevClose = currentClose;
		}

		return ResponseEntity.ok(selectedPrices.toString());
	}


}
