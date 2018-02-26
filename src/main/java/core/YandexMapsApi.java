package core;

import beans.YandexMapAnswer;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import io.restassured.RestAssured;
import io.restassured.response.Response;

import java.util.HashMap;
import java.util.List;

import static core.YandexMapsConstants.API_URL;
import static core.YandexMapsConstants.FORMAT;
import static core.YandexMapsConstants.GEOCODE;

public class YandexMapsApi {
    private YandexMapsApi() {
    }

    private HashMap<String, String> params = new HashMap<String, String>();

    public static class ApiBuilder {
        YandexMapsApi mapsApi;

        private ApiBuilder(YandexMapsApi mapsApi) {
            this.mapsApi = mapsApi;
        }

        public ApiBuilder format(String format) {
            mapsApi.params.put(FORMAT, format);
            return this;
        }

        public ApiBuilder geocode(String geocode) {
            mapsApi.params.put(GEOCODE, geocode);
            return this;
        }

        public Response callApi() {
            return RestAssured.with().queryParams(mapsApi.params).log().all().get(API_URL).prettyPeek();
        }
    }

    public static ApiBuilder with() {
        YandexMapsApi api = new YandexMapsApi();
        return new ApiBuilder(api);
    }

    public static List<YandexMapAnswer> getYandexMapsAnswers(Response response){
        return new Gson().fromJson( response.asString().trim(), new TypeToken<List<YandexMapAnswer>>() {}.getType());
    }
}
