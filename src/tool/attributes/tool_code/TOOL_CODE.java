package tool.attributes.tool_code;
import java.lang.String;

public enum TOOL_CODE {
    CHNS( "CHNS" ),
    LADW( "LADW" ),
    JAKD( "JAKD" ),
    JAKR( "JAKR" );

    public final String     code;

    TOOL_CODE( String code ) {
        this.code           = code;
    }
}
