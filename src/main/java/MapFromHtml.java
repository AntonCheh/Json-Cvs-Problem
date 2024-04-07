import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapFromHtml {
    public static void main(String[] args) {
        // Получаем списки названий линий и линий

        List<String> lineNames = WebParsingHtmlLines.parseAndReturnLineNames();
        List<Line> lines = WebParsingHtmlStations.parseWebStations();

        // Создаем Map для хранения данных о линиях метро и их станциях
        Map<String, List<Station>> metroMap = new HashMap<>();

        // Заполняем карту данными
        for (String lineName : lineNames) {
            for (Line line : lines) {
                if (line.getLineNumber().equals(lineName)) {
                    metroMap.put(lineName, line.getStations());
                    break;
                }
            }
        }

        // Выводим содержимое карты
        for (Map.Entry<String, List<Station>> entry : metroMap.entrySet()) {
            System.out.println("Line: " + entry.getKey());
            for (Station station : entry.getValue()) {
                System.out.println(station);
            }
        }
    }
}
