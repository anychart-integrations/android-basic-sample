package android.anychart.com.anychart.model;

/**
 * (c) Anychart 2010–2017. All rights reserved.
 */
public enum ChartType {

    AREA("area"),
    BAR("bar"),
    COLUMN("column"),
    PIE("pie");

    ChartType(String chertType) {
        this.chertType = chertType;
    }

    public final String chertType;
}
