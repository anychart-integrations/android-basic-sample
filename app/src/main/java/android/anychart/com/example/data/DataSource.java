package android.anychart.com.example.data;

import android.support.v4.util.Pair;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * (c) Anychart 2010–2017. All rights reserved.
 */
public class DataSource {

    public Collection<Pair<String, Number>> getData() {

        List<Pair<String, Number>> data = new ArrayList<>();

        data.add(new Pair<String, Number>("Apples", 6371664));
        data.add(new Pair<String, Number>("Pears", 789622));
        data.add(new Pair<String, Number>("Bananas", 7216301));
        data.add(new Pair<String, Number>("Grapes", 1486621));
        data.add(new Pair<String, Number>("Oranges", 1200000));

        return data;
    }
}