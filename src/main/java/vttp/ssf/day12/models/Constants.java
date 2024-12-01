package vttp.ssf.day12.models;

import java.util.LinkedList;
import java.util.List;

public class Constants {

    public static final String[] ITEMS = {
        "apple", "orange", "pear"};

    public static final int[] QUANTITY = {
        10, 5, 8
    };

    public static List<LineItem> generateLineItems(int count) {
        List<LineItem> items = new LinkedList<>();

        if (count > ITEMS.length)
            count = ITEMS.length;

        for (int i = 0; i < ITEMS.length; i++) {
            LineItem li = new LineItem();
            li.setName(ITEMS[i]);
            li.setQuantity(QUANTITY[i]);
            items.add(li);

        }
        return items;
    }

    public static List<LineItem> generateLineItems() {
        return generateLineItems(ITEMS.length);
    }
}
