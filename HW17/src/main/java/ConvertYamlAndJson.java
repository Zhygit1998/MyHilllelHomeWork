import com.google.gson.Gson;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class ConvertYamlAndJson {
    public static void main(String[] args) {
        if (args.length == 0) {
            String dir = "src/main/resources";
            File[] filesJsonTypes = finderJson(dir);
            File[] filesYamlTypes = finderYaml(dir);
            for (File i : filesJsonTypes)
                fromJsonToYaml(i.getAbsoluteFile());
            logging(1);
            for (File i : filesYamlTypes)
                fromYamlToJson(i.getAbsoluteFile());
            logging(1);
        } else {
            File[] filesJsonTypes = finderJson(args[0]);
            File[] filesYamlTypes = finderYaml(args[0]);
            for (File i : filesJsonTypes)
                fromJsonToYaml(i.getAbsoluteFile());
            logging(1);
            for (File i : filesYamlTypes)
                fromYamlToJson(i.getAbsoluteFile());
            logging(1);
        }
    }
    static File logger;

    static {
        try {
            logger = new File(Paths.get(ConvertYamlAndJson.class.getProtectionDomain().getCodeSource().
                    getLocation().toURI()).getParent() + File.separator + "Log" + "_" + System.currentTimeMillis() + "_result" + ".txt");
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
    public static void fromJsonToYaml(File file) {
        Gson gson = new Gson();
        Yaml yaml = new Yaml();
        long startTime = System.currentTimeMillis();
        long startValue = file.length();
        char c = 0;
        File converted = new File(file.getParent() + File.separator + "converted");
        if (!converted.exists()) {
            converted.mkdir();
        }
        File newFile = new File(converted + File.separator + file.getName().split("\\.json")[0] + ".yaml");
        try (FileReader fileReader = new FileReader(file)) {
            c = (char) fileReader.read();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        try (FileReader fileReader = new FileReader(file);
             FileWriter fileWriter = new FileWriter(newFile)) {
            if (c == '{') {
                Map map = gson.fromJson(fileReader, Map.class);
                fileWriter.write(yaml.dump(map));
            } else {
                Map[] map = gson.fromJson(fileReader, Map[].class);
                fileWriter.write(yaml.dump(map));
            }
        } catch (IOException e) {
            logging();
        }
        long endTime = System.currentTimeMillis();
        long endValue = newFile.length();
        logging(file, newFile, startTime, endTime, startValue, endValue);
    }

    public static void fromYamlToJson(File file) {
        long startTime = System.currentTimeMillis();
        long startValue = file.length();
        Yaml yaml = new Yaml();
        Gson gson = new Gson();
        File converted = new File(file.getParent() + File.separator + "converted");
        if (!converted.exists()) {
            converted.mkdir();
        }
        File newFile = new File(converted + File.separator + file.getName().split("\\.yaml")[0] + ".json");
        try (FileReader fileReader = new FileReader(file);
             FileWriter fileWriter = new FileWriter(newFile)) {
            Map<String, Object> obj = yaml.load(fileReader);
            fileWriter.write(gson.toJson(obj));
        } catch (ClassCastException er) {
            try (FileReader fileReader = new FileReader(file);
                 FileWriter fileWriter = new FileWriter(newFile, true)) {
                List<Map> list = yaml.load(fileReader);
                fileWriter.write(gson.toJson(list));
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        } catch (IOException e) {
            logging();
        }
        long endTime = System.currentTimeMillis();
        long endValue = newFile.length();
        logging(file, newFile, startTime, endTime, startValue, endValue);
    }

    public static void logging(File file, File newFile, long startTime, long endTime, long startValue, long endValue) {
        long timeConverting = endTime - startTime;
        try (FileWriter fileWriter = new FileWriter(logger, true);) {
            fileWriter.write(file.getName() + " -> " + newFile.getName() + ", " + timeConverting + " милисекунд, " +
                    startValue + " байт" + " -> " + endValue + " байт" + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void logging() {
        try (FileWriter fileWriter = new FileWriter(logger, true);) {
            fileWriter.write("файл не сконвертирован, ошибка");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void logging(int start) {
        try {
            logger.createNewFile();
        } catch (Exception E) {
            System.out.println(E.getMessage());
        }
    }

    private static File[] finderJson(String dirName) {
        File dir = new File(dirName);

        return dir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String filename) {
                return filename.endsWith(".json");
            }
        });
    }

    private static File[] finderYaml(String dirName) {
        File dir = new File(dirName);

        return dir.listFiles(new FilenameFilter() {
            public boolean accept(File dir, String filename) {
                return filename.endsWith(".yaml");
            }
        });
    }
}
