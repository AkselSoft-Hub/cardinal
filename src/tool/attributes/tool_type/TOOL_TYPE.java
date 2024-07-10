package tool.attributes.tool_type;

import java.math.BigDecimal;

public enum TOOL_TYPE {
    LADDER(
            "Ladder",
            new BigDecimal( "1.99"),
            true,
            true,
            false ),
    CHAINSAW(
            "Chainsaw",
            new BigDecimal( "1.49"),
            true,
            false,
            true ),
    JACKHAMMER(
            "Jackhammer",
            new BigDecimal( "2.99"),
            true,
            false,
            false );

    public final String         name;
    public final BigDecimal     dailyCharge;
    public final Boolean        weekdayCharge;
    public final Boolean        weekendCharge;
    public final Boolean        holidayCharge;

    TOOL_TYPE(
            String name,
            BigDecimal dailyCharge,
            Boolean weekdayCharge,
            Boolean weekendCharge,
            Boolean holidayCharge
    ) {
        this.name               = name;
        this.dailyCharge        = dailyCharge;
        this.weekdayCharge      = weekdayCharge;
        this.weekendCharge      = weekendCharge;
        this.holidayCharge      = holidayCharge;
    }
}