package com.ttc.main.util;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.ttc.main.data.Task;

public class JsonHelper {

	public static final String STORE_PATH = System.getProperty("user.dir") + "/shared";

	private JsonHelper() {
	}

	public static void createJsonFile(String jsonFileName) {
		try {

			if (jsonFileName == null || jsonFileName.trim().isEmpty()) {
				throw new IllegalArgumentException("File name cannot be blank or null");
			}

			File dir = new File(STORE_PATH);
			if (!dir.exists()) {
				dir.mkdirs();
			}

			File jsonFile = new File(STORE_PATH + "/" + jsonFileName + ".json");

			if (jsonFile.exists()) {
				LoggerUtil.warn("JSON file already exists: " + jsonFile.getAbsolutePath());
			} else {
				if (jsonFile.createNewFile()) {
					LoggerUtil.info("JSON file created: " + jsonFile.getAbsolutePath());
				} else {
					LoggerUtil.warn("Failed to create JSON file.");
				}
			}
		} catch (IOException e) {
			LoggerUtil.error("An error occurred while handling the JSON file: " + e.getMessage());
		} catch (Exception e) {
			LoggerUtil.error("An error occurred while handling the JSON file: " + e.getMessage());
		}
	}

	public static void deleteJsonFile(String jsonFileName) {
		try {
			if (jsonFileName == null || jsonFileName.trim().isEmpty()) {
				throw new IllegalArgumentException("File name cannot be blank or null");
			}

			File jsonFile = new File(STORE_PATH + "/" + jsonFileName + ".json");
			if (jsonFile.exists()) {
				if (jsonFile.delete()) {
					LoggerUtil.info("JSON file deleted successfully.");
				}
			} else {
				LoggerUtil.warn("No JSON file found with name " + jsonFileName + ".json");
			}
		} catch (Exception e) {
			LoggerUtil.error("An error occurred while deleting the JSON file: " + e.getMessage());
		}
	}

	public static void writeTaskOnJsonFile(Task task, String jsonFileName) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		File file = new File(STORE_PATH + "/" + jsonFileName + ".json");
		List<Task> tasks = new ArrayList<>();

		if (file.exists()) {
			try (FileReader reader = new FileReader(file)) {
				Type listType = new TypeToken<List<Task>>() {
				}.getType();
				tasks = gson.fromJson(reader, listType);
				if (tasks == null) {
					tasks = new ArrayList<>();
				}
			} catch (IOException e) {
				LoggerUtil.error("Failed to read existing JSON: " + e.getMessage());
			}
		}

		tasks.add(task);

		try (FileWriter writer = new FileWriter(file)) {
			gson.toJson(tasks, writer);
			LoggerUtil.info("Person added to JSON file.");
		} catch (IOException e) {
			LoggerUtil.error("Failed to write JSON: " + e.getMessage());
		}

	}

}
