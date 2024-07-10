package checkout;

import rental_agreement.RentalAgreement;
import tool.TOOL;
import tool.attributes.brand.BRAND;
import tool.attributes.tool_code.TOOL_CODE;
import tool.attributes.tool_type.TOOL_TYPE;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;

public class Checkout {
    public TOOL tool;
    public TOOL_CODE    toolCode;
    public TOOL_TYPE    toolType;
    public BRAND        toolBrand;
    public Integer      rentalDays; // error if rentalDays is not 1 or greater
    public LocalDate    checkoutDate;
    public LocalDate    dueDate;
    public BigDecimal   dailyRentalCharge;
    public Integer      chargeDays;
    public BigDecimal   preDiscountCharge;
    public Integer      discountPercent; // error if discountPercent is not in the range 0-100
    public BigDecimal   discountAmount;
    public BigDecimal   finalCharge;

    public Checkout(
            String toolCode,
            LocalDate checkoutDate,
            Integer rentalDays,
            Integer discountPercent
    ) {
        if (rentalDays < 1) {
            throw new IllegalArgumentException("Rental days must be 1 or greater.");
        }

        if (discountPercent < 0 || discountPercent > 100) {
            throw new IllegalArgumentException("Discount percent must be between 0 and 100.");
        }

        this.toolCode           = TOOL_CODE.valueOf(toolCode);
        this.checkoutDate       = checkoutDate;
        this.rentalDays         = rentalDays;
        this.discountPercent    = discountPercent;
        this.tool               = TOOL.valueOf(this.toolCode.code);
        this.toolType           = this.tool.toolType;
        this.toolBrand          = this.tool.brand;
        this.dailyRentalCharge  = this.toolType.dailyCharge;
    }

    protected Set<LocalDate> getHolidays(int year) {
        Set<LocalDate> holidays = new HashSet<>();
        LocalDate independenceDay = this.getIndependenceDay(year);
        LocalDate laborDay = this.getLaborDay(year);
        holidays.add(independenceDay);
        holidays.add(laborDay);

        return holidays;
    }

    protected LocalDate getLaborDay(int year) {
        LocalDate laborDay = LocalDate.of(year, 9, 1)
                .with(java.time.temporal.TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY));

        return laborDay;
    }

    protected LocalDate getIndependenceDay(int year) {
        LocalDate independenceDay = LocalDate.of(year, 7, 4);
        switch (independenceDay.getDayOfWeek()) {
            case SATURDAY:
                return independenceDay.minusDays(1);
            case SUNDAY:
                return independenceDay.plusDays(1);
            default:
                return independenceDay;
        }
    }

    protected void setDueDate() {
        this.dueDate = this.checkoutDate.plusDays( this.rentalDays );
    }

    protected void setChargeDays() {
        Set<LocalDate> holidays = this.getHolidays( this.checkoutDate.getYear() );
        this.chargeDays = 0;

        for ( int index = 0; index < this.rentalDays; index++ ) {
            LocalDate date = this.checkoutDate.plusDays(index + 1 );
            DayOfWeek dayOfWeek = date.getDayOfWeek();

            boolean isWeekday = EnumSet.range( DayOfWeek.MONDAY, DayOfWeek.FRIDAY ).contains( dayOfWeek );
            boolean isWeekend = EnumSet.of( DayOfWeek.SATURDAY, DayOfWeek.SUNDAY ).contains( dayOfWeek );
            boolean isHoliday = holidays.contains( date );

            if (( isWeekday && this.tool.toolType.weekdayCharge )
                    || ( isWeekend && this.tool.toolType.weekendCharge )
                    || ( isHoliday && this.tool.toolType.holidayCharge )) {
                this.chargeDays++;
            }
        }
    }

    protected void setCharges() {
        this.preDiscountCharge = this.toolType.dailyCharge.multiply( BigDecimal.valueOf( this.chargeDays ) );
        this.discountAmount = this.preDiscountCharge.multiply( BigDecimal.valueOf( this.discountPercent ) )
                .divide( BigDecimal.valueOf( 100 ) )
                .setScale( 2, RoundingMode.HALF_UP );
        this.finalCharge = this.preDiscountCharge.subtract( this.discountAmount )
                .setScale(2, RoundingMode.HALF_UP);
    }

    public void makeRentalAgreement() {
        this.setDueDate();
        this.setChargeDays();
        this.setCharges();

        RentalAgreement rentalAgreement = new RentalAgreement(
                this.toolCode,
                this.toolType,
                this.toolBrand,
                this.rentalDays,
                this.checkoutDate,
                this.dueDate,
                this.dailyRentalCharge,
                this.chargeDays,
                this.preDiscountCharge,
                this.discountPercent,
                this.discountAmount,
                this.finalCharge
        );
    }
}
