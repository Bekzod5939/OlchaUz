package uz.pdp.enums;

public enum CategoryEnum {
    TV(1),
    SONY(2),
    LG(3),
    ARTEL(4),
    SAMSUNG(5),

    PHONE(6),
    XIAOMI(7),
    NOKIA(8),
    VIVO(9),

    NOTEBOOK(10),
    APPLE(11),
    LENOVO(12),
    ACER(13),
    ASUS(14),
    DELL(15),

    TECHNIQUE(16),
    HOFFMAN(17),
    SHIVAKI(18),
    GOODWELL(19),
    AVALON(20),

    SPORT(21),
    FOOTBALL(22),
    FOOTBALL_UNIFORM(23),
    TENNIS(24),
    TENNIS_UNIFORM(25),
    BASKETBALL(26),
    BASKETBALL_UNIFORM(27),
    SWIM(28),
    SWIM_UNIFORM(29),



    BOOK(30),
    RELIGIOUS(31),
    WORLD(32);

    private int id;

    CategoryEnum(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
