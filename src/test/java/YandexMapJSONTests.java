import beans.YandexMapAnswer;
import core.YandexMapsApi;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class YandexMapJSONTests {
    private final String address = "Москва, улица Новый Арбат, 24";
    private final String format = "json";
    private final String position = "37.587614 55.753083";

    @Test
    public void baseTest() {
       YandexMapAnswer ans = YandexMapsApi.getYandexMapsAnswers(YandexMapsApi
               .with().format(format).geocode(address).callApi());

       ans.response.geoObjectCollection.featureMember.forEach(obj -> assertEquals(obj.geoObject.point.pos, position));
    }

    @Test
    public void baseTest2() {
        YandexMapAnswer ans = YandexMapsApi.getYandexMapsAnswers(YandexMapsApi
                .with().format(format).geocode(position).callApi());

        ans.response.geoObjectCollection.featureMember.forEach(
                obj -> assertEquals(obj.geoObject.metaDataProperty.geocoderMetaData.address.formatted, address));
    }
}
