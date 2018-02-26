package core;

import beans.YandexMapAnswer;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Random;

import static core.YandexMapsConstants.*;
import static org.hamcrest.Matchers.lessThan;

public class YandexMapsApi {
    private HashMap<String, String> params = new HashMap<String, String>();

    private YandexMapsApi() {
    }

    public static ApiBuilder with() {
        YandexMapsApi api = new YandexMapsApi();
        return new ApiBuilder(api);
    }

    public static YandexMapAnswer getYandexMapsAnswers(Response response) {
        return new Gson().fromJson(response.asString().trim(), YandexMapAnswer.class);
    }

    public static ResponseSpecification successResponse() {
        return new ResponseSpecBuilder()
                .expectContentType(ContentType.JSON)
                .expectHeader("Connection", "keep-alive")
                .expectResponseTime(lessThan(20000L))
                .expectStatusCode(HttpStatus.SC_OK)
                .build();
    }

    public static RequestSpecification baseRequestConfiguration() {
        return new RequestSpecBuilder()
                .setAccept(ContentType.XML)
                .addHeader("custom header2", "header2.value")
                .addQueryParam("requestID", new Random().nextLong())
                .setBaseUri(API_URL)
                .build();
    }

    public static class ApiBuilder {
        YandexMapsApi mapsApi;

        private ApiBuilder(YandexMapsApi mapsApi) {
            this.mapsApi = mapsApi;
        }

        public ApiBuilder format(YandexMapsConstants.Format format) {
            mapsApi.params.put(FORMAT, format.type);
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
}
