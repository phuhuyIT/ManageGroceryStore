package Model;

public enum categoryEnum {
    FRESH_FOOD(1),
    PACKAGED_FOOD(2),
    HOUSEHOLD_ITEMS(3),
    PERSONAL_CARE(4),
    OFFICE_SUPPLIES(5),
    CLEANING_PRODUCTS(6),
    TOYS_AND_GIFTS(7),
    MEDICAL_SUPPLIES(8);

    private int code;

    categoryEnum(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
