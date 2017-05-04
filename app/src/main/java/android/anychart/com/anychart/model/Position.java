package android.anychart.com.anychart.model;

/**
 * (c) AnyChart 2010–2017. All rights reserved.
 */
public enum Position {

    /**
     * Automatic mode for anchor of the element.
     */
    AUTO("auto"),

    /**
     * The center anchor of the element.
     */
    CENTER("center"),

    /**
     * The center-bottom anchor of the element.
     */
    CENTER_BOTTOM("centerBottom"),

    /**
     * The center-top anchor of the element.
     */
    CENTER_TOP("centerTop"),

    /**
     * The left-bottom anchor of the element.
     */
    LEFT_BOTTOM("leftBottom"),

    /**
     * The left-center anchor of the element.
     */
    LEFT_CENTER("leftCenter"),

    /**
     * The left-top anchor of the element.
     */
    LEFT_TOP("leftTop"),

    /**
     * The right-bottom anchor of the element.
     */
    RIGHT_BOTTOM("rightBottom"),

    /**
     * The right-center anchor of the element.
     */
    RIGHT_CENTER("rightCenter"),

    /**
     * The right-top anchor of the element.
     */
    RIGHT_TOP("rightTop");

    Position(String positionname) {
        this.positionName = positionname;
    }

    public final String positionName;
}
