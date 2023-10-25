package com.example;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class Util {

	/**
	 * @param filePath
	 * @return readCSV
	 */
	
	public static JSONArray readCSV(String filePath) {
		try {
			JSONArray jsonArray = new JSONArray();

			try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
				String headerLine = br.readLine();
				if (headerLine == null) return jsonArray;

				String[] headers = headerLine.split(",");

				String line;
				while ((line = br.readLine()) != null) {
					String[] values = line.split(",");
					JSONObject jsonObject = new JSONObject();

					for (int i = 0; i < values.length && i < headers.length; i++) {
						jsonObject.put(headers[i], values[i]);
					}

					jsonArray.put(jsonObject);
				}
			}

			return jsonArray;
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return null;
		}
	}

	/**
	 * @param directoryPath
	 * @return getFileNameMap
	 */

	public static Map<Integer, String> getFileNameMap(String directoryPath) {
		Map<Integer, String> fileNameMap = new HashMap<>();

		File directory = new File(directoryPath);

		// .csv 파일만을 필터링합니다.
		File[] files = directory.listFiles((dir, name) -> name.endsWith(".csv"));

		if (files != null) {
			for (File file : files) {
				String fileName = file.getName();
				String[] parts = fileName.split("_"); // 파일명 분할

				if (parts.length == 2) {
					Integer key = Integer.valueOf(parts[0]);
					String value = parts[1].replace(".csv", ""); // 확장자 제거
					fileNameMap.put(key, value);
				}
			}
		}

		return fileNameMap;
	}

}
