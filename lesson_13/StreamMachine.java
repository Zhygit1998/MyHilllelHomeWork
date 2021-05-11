import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamMachine {
    public static void main(String[] args) {
      List list = new ArrayList();
        list.add(1);
        list.add(7);
        list.add(4);
        list.add(9);
        list.add(6);
        Stream<Integer> stream = list.stream();
        double averageCount = list.stream()
                .mapToInt(d -> (int) d)
                .average()
                .orElse(0.0D);
        List<Pair> string_list_param = Stream.of("one", "two", "three", "four", "five", "six", "seven")
                .map(x -> new Pair(x, x.toUpperCase()))
                .collect(Collectors.toList());
        System.out.println("TASK 1");
        System.out.println(averageCount);
        System.out.println("TASK 2");
        System.out.println(string_list_param);
        System.out.println("TASK 3");
        ArrayList<String> listLower_4 = new ArrayList<>();
        listLower_4.add("egor");
        listLower_4.add("vlad");
        listLower_4.add("MASHA");
        listLower_4.add("Pasha");
        listLower_4.add("Anna");
        listLower_4.add("dima");
        listLower_4.stream()
                .filter(c -> c.length() == 4)
                .filter(c -> c.equals(c.toLowerCase()))
                .forEach(System.out::println);

    }
}
