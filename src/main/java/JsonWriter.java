import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class JsonWriter {

    public static void writeStationsToJson(List<Station> stations, String filePath) {
        JSONArray stationsJsonArray = new JSONArray();

        for (Station station : stations) {
            JSONObject stationJson = new JSONObject();
            stationJson.put("station_name", station.getStationName());
            stationJson.put("depth", station.getDepth());
            stationsJsonArray.add(stationJson);
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonOutput = gson.toJson(stationsJsonArray);

        try (FileWriter fileWriter = new FileWriter(filePath)) {
            fileWriter.write(jsonOutput);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        // Пример использования:
        List<Station> stations = JsonParsing.getListofDateJsons();
        writeStationsToJson(stations, "jsonWriter.json");
    }
}