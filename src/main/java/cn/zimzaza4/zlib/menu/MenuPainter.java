package cn.zimzaza4.zlib.menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuPainter {
    private final Map<Character, int[]> slotMap = new HashMap<>();

    public MenuPainter(String... strings) {
        int line = 0;

        Map<Character, List<Integer>> slotListMap = new HashMap<>();

        for (String l : strings) {
            char[] content = l.toCharArray();
            if (content.length < 9) {
                System.out.println("???");
            }
            int raw = 0;
            for (char s : content) {
                int slot = line * 9 + raw;
                if (slotListMap.containsKey(s)) {
                    slotListMap.get(s).add(slot);
                } else {
                    List<Integer> slots = new ArrayList<>();
                    slots.add(slot);
                    slotListMap.put(s, slots);
                }
                raw++;
            }
            line++;
        }


        for (char s : slotListMap.keySet()) {
            List<Integer> slots = slotListMap.get(s);
            int[] ints = new int[slots.size()];
            int i = 0;
            for (int slot : slots) {
                ints[i] = slot;
                i++;
            }
            slotMap.put(s, ints);
        }

    }


    public int[] getSlots(char key) {
        return slotMap.get(key);
    }

}
