import core.YandexMapsApi;
import org.testng.annotations.Test;

public class YandexMapJSONTests {
    private final String address = "Москва, улица Новый Арбат, дом 24";
    private final String format = "json";

    @Test
    public void mainTest() {
        YandexMapsApi.with().format(format).geocode(address).callApi();
    }
}
