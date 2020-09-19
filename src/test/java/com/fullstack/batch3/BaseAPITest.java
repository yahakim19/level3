/**
 * 
 */
package com.fullstack.batch3;

import com.fullstack.batch3.common.DataUtils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

/**
 * @author chandan
 *
 */
public abstract class BaseAPITest {

	protected RequestSpecification commonSpec = new RequestSpecBuilder()
			.setBaseUri(DataUtils.getDataFromExcel("APIData", "ServerUrl")).setContentType("application/json").build()
			.log().all();

	protected <T> T getDataFromJsonPath(Response response, String jsonPath) {
		JsonPath jpath = response.jsonPath();

		return jpath.get(jsonPath);
	}

}
