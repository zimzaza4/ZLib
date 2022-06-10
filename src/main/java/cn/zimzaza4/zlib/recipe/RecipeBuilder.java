package cn.zimzaza4.zlib.recipe;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RecipeBuilder {
    private final Map<String, List<Integer>> slotMap = new HashMap<>();
    private final Map<Integer, ItemStack> items = new HashMap<>();

    public RecipeBuilder(String... s) {
        StringBuilder r = new StringBuilder();
        for (String l : s) {
            r.append(l);
        }

        char[] indexes = r.toString().toCharArray();
        int i = 0;
        for (char c : indexes) {
            String key = String.valueOf(c);
            if (slotMap.containsKey(key)) {
                slotMap.get(key).add(i);
            } else {
                List<Integer> ints = new ArrayList<>();
                ints.add(i);
                slotMap.put(key, ints);
            }
        }
    }


    public RecipeBuilder(char ingore, String... s) {
        StringBuilder r = new StringBuilder();
        for (String l : s) {
            r.append(l.replace(String.valueOf(ingore),""));
        }

        char[] indexes = r.toString().toCharArray();
        int i = 0;
        for (char c : indexes) {
            String key = String.valueOf(c);
            if (slotMap.containsKey(key)) {
                slotMap.get(key).add(i);
            } else {
                List<Integer> ints = new ArrayList<>();
                ints.add(i);
                slotMap.put(key, ints);
            }
        }
    }



    public RecipeBuilder map(String s, ItemStack item) {
        if (slotMap.containsKey(s)) {
            List<Integer> ints = slotMap.get(s);
            for (int i : ints) {
                items.put(i, item);
            }
        }
        return this;
    }

    public RecipeBuilder map(String s, Material material) {
        return map(s, new ItemStack(material));
    }

    public RecipeBuilder map(String s, Material material, int amount) {
        return map(s, new ItemStack(material, amount));
    }

    public ItemStack[] build() {
        ItemStack[] itemStacks = new ItemStack[slotMap.size()];
        for (int i : items.keySet()) {
            itemStacks[i] = items.get(i);
        }
        return itemStacks;
    }

}
