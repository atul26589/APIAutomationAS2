package requestBuilder;

import static io.restassured.RestAssured.*;

import com.tmb.utils.PropertyUtils;

import enums.PropertiesType;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
public final class RequestBuilder {
	
	private RequestBuilder() {}
	
	public static RequestSpecification buildRequestForGetCalls() {
		return given()
				.log()
				.all()
			       .baseUri(PropertyUtils.getValue(PropertiesType.BASEURL))
			       .log()
			       .all();
	}

	
	public static RequestSpecification buildRequestForPostCalls() {
		return given()
				.baseUri("http://localhost:3000")
				.log()
				.all()
			     .contentType(ContentType.JSON);
	}
}
