package collections.map;

import java.util.LinkedHashMap;
import java.util.Map;

public class MapOperations {
    
    public void sortMapBasedOnValue(Map<String, Integer> map){
        Map<String, Integer> sortedMap = map.entrySet().stream()
        .sorted(
            Map.Entry.comparingByValue()
        ).collect(LinkedHashMap::new, (m, e)-> m.put(e.getKey(), e.getValue()), Map::putAll);

        System.out.println(sortedMap);
    }

}
