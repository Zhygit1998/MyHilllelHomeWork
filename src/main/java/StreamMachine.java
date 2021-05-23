import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMachine {

    public static double averageCount(ArrayList<Integer> arrayListParameters) {

        return arrayListParameters
                .stream()
                .mapToInt(d -> d)
                .average()
                .orElse(0.0D);
    }

    public static List<String> listLower_4(ArrayList<String> listLowerCase_4) {

        return listLowerCase_4
                .stream()
                .filter(c -> c.length() == 4)
                .filter(c -> c.equals(c.toLowerCase()))
                .collect(Collectors.toList());
    }
}
