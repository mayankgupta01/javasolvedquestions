package udemy.masterOOdesign.ems;

/**
 * Created by mayank.gupta on 26/01/17.
 */
public enum  SupportedReportFormat {
    XML("xml"),
    CSV("csv");
    private String value;
    private SupportedReportFormat(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }

}
