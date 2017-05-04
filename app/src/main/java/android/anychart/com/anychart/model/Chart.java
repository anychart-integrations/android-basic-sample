package android.anychart.com.anychart.model;

import android.support.v4.util.Pair;

import java.util.Collection;

/**
 * (c) Anychart 2010–2017. All rights reserved.
 */
public class Chart {

    private ChartType chartType;
    private Collection<Pair<String, Number>> data;

    private String title;
    private Legend legend;

    public Collection<Pair<String, Number>> getData() {
        return data;
    }

    public void setData(Collection<Pair<String, Number>> data) {
        this.data = data;
    }

    public ChartType getChartType() {
        return chartType;
    }

    public void setChartType(ChartType chartType) {
        this.chartType = chartType;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Legend getLegend() {
        return legend;
    }

    public void setLegend(Legend legend) {
        this.legend = legend;
    }
}
