import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Objects;

public class ReadData implements ConnectDataBase {
    final Data[] dates = readFile();


    @Override
    public void openConnection() {
        System.out.println("Подключеник к базе данных...");
    }

    @Override
    public void closeConnection() {
        System.out.println("Закрытие соединения...");
    }

    @Override
    public void testConnection() {
        if (dates[0].getKey().isEmpty()) {
            System.out.println("Ошибка подключения! Повторите еще раз!");
        } else {
            System.out.println("Подключение успешно!");
        }
    }


    @Override
    public void readStringIndex(Data[] dates, int index) {
        System.out.printf("Считывание строки по индексу...%n Ответ: key: %s value: %s", dates[index].getKey(),dates[index].getValue());
    }

    @Override
    public void checkRecordKey(String key) {
        for (int i = 0; i < dates.length; i++) {
            if (Objects.equals(dates[i].getKey(), key.toUpperCase())) {
                System.out.println("Элемент найден!");
            } else {
                System.out.println("Элемент не найден!");
            }
        }
    }

    @Override
    public void readRecordKey(String key) {
        for (int i = 0; i < dates.length; i++) {
            if (Objects.equals(dates[i].getKey(), key.toUpperCase())) {
                    System.out.println("Элемент найден!" + dates[i].getKey());
            } else {
                System.out.println("Элемент не найден!");
            }
        }
    }

    @Override
    public Data[] readDataBaseRecords(int quantity, int startIndex) {
        Data[] dates2 = new Data[quantity];
        for (int i = startIndex; i <= startIndex ; i++) {
            dates2[i] = dates[i];
        }
        return dates2;
    }

    @Override
    public void readNumberOfRecords() {

    }

    @Override
    public void addRecDataBase() {

    }

    @Override
    public void updateValIndex() {

    }

    @Override
    public void updateContentRecKey() {

    }

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    private static final Path PATH = Paths.get("./data.json");

    public static Data[] readFile() {
        String json = "";
        try {
            json = Files.readString(PATH);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return GSON.fromJson(json, Data[].class);
    }

    public static void writeFile(Data[] data) {
        String json = GSON.toJson(data);
        try {
            byte[] arr = json.getBytes();
            Files.write(PATH, arr);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "ReadData{" +
                "dates=" + Arrays.toString(dates) +
                '}';
    }


}
