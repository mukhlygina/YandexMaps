import beans.YandexMapAnswer;
import core.YandexMapsApi;
import io.restassured.RestAssured;
import org.testng.annotations.Test;

import static core.YandexMapsConstants.FORMAT;
import static core.YandexMapsConstants.Format.JSON;
import static core.YandexMapsConstants.GEOCODE;
import static org.testng.Assert.assertEquals;

public class YandexMapJSONTests {
    private final String address = "Москва, улица Новый Арбат, 24";
    private final String position = "37.587614 55.753083";

    @Test
    public void positionCheck() {
        YandexMapAnswer ans = YandexMapsApi.getYandexMapsAnswers(YandexMapsApi
                .with().format(JSON).geocode(address).callApi());

        ans.response.geoObjectCollection.featureMember
                .forEach(obj -> assertEquals(obj.geoObject.point.pos, position));
    }

    @Test
    public void addressCheck() {
        YandexMapAnswer ans = YandexMapsApi.getYandexMapsAnswers(
                YandexMapsApi.with().format(JSON).geocode(position).callApi());

        ans.response.geoObjectCollection.featureMember.stream()
                .filter(obj -> obj.geoObject.point.pos.equals(position))
                .forEach(obj -> assertEquals(obj.geoObject.metaDataProperty.geocoderMetaData.address.formatted, address));
    }

    @Test
    public void baseResponsAndRequest() {
        RestAssured.given(YandexMapsApi.baseRequestConfiguration())
                .param(FORMAT, JSON.type).param(GEOCODE, address)
                .get().prettyPeek()
                .then().specification(YandexMapsApi.successResponse());
    }
}
