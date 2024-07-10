package tool;

import tool.attributes.tool_code.TOOL_CODE;
import tool.attributes.tool_type.TOOL_TYPE;
import tool.attributes.brand.BRAND;

public enum TOOL {
    CHNS(TOOL_CODE.CHNS, TOOL_TYPE.CHAINSAW, BRAND.STIHL),
    LADW(TOOL_CODE.LADW, TOOL_TYPE.LADDER, BRAND.WERNER),
    JAKD(TOOL_CODE.JAKD, TOOL_TYPE.JACKHAMMER, BRAND.DEWALT),
    JAKR(TOOL_CODE.JAKR, TOOL_TYPE.JACKHAMMER, BRAND.RIDGID);

    // Properties
    public final TOOL_CODE 		toolCode;
    public final TOOL_TYPE 		toolType;
    public final BRAND 			brand;

    // Constructor
    TOOL(
            TOOL_CODE toolCode,
            TOOL_TYPE toolType,
            BRAND brand
    ) {
        this.toolCode       = toolCode;
        this.toolType       = toolType;
        this.brand          = brand;
    }
}
