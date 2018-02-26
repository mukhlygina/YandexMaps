package core;

public class YandexMapsConstants {
    public static final String API_URL = "https://geocode-maps.yandex.ru/1.x/";
    public static final String GEOCODE = "geocode";
    public static final String FORMAT = "format";

    public enum Format {
        JSON("json"),
        XML("xml");

        public String type;

        Format(String type) {
            this.type = type;
        }
    }
}
