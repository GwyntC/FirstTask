package org.example;

import java.util.*;
import java.util.stream.Collectors;

public class SecondTask {
    public Map<String, Integer> getTopTagsFromArr(List<String> lines) {
        Map<String, Integer> topFive = getTags(lines);
        topFive = getTopTagsFromMap(topFive);
        return topFive;
    }

    public Map<String, Integer> getTags(List<String> lines) {
        if (lines == null) {
            throw new IllegalArgumentException("List must not be null");
        } else if (lines.size() == 0) {
            throw new IllegalArgumentException("List must not be empty");
        }
        int row_num = -1;
        Map<String, Integer> tags = new HashMap<>();
        for (int i = 0; i < lines.size(); i++) {
            if (lines.get(i) == null) {
                throw new IllegalArgumentException("List element must not be null");
            }
            String[] words = lines.get(i).split(" ");
            for (int j = 0; j < words.length; j++) {
                if (words[j].charAt(0) == '#') {
                    if (!tags.containsKey(words[j])) {
                        tags.put(words[j], 1);
                        row_num = i;
                    } else if (tags.containsKey(words[j])) {
                        if (i != row_num) {
                            tags.put(words[j], tags.get(words[j] + 1));
                        }
                    }
                }
            }
        }
        return tags;
    }

    public Map<String, Integer> getTopTagsFromMap(Map<String, Integer> map) {
        if (map.size() == 0) {
            throw new IllegalArgumentException("List contains no tags");
        }
        Map<String, Integer> topFive =
                map.entrySet().stream()
                        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                        .limit(5)
                        .collect(Collectors.toMap(
                                Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        return topFive;
    }
}
