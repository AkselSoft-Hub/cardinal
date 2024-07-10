package tool.attributes.brand;

import java.lang.String;

public enum BRAND {
    STIHL("Stihl"),
    WERNER("Werner"),
    DEWALT("DeWalt"),
    RIDGID("Ridgid");

    public final String     brand;

    BRAND( String brand ) {
        this.brand          = brand;
    }
}