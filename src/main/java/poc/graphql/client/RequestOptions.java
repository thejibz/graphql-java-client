/*******************************************************************************
 *
 *    Copyright 2019 Adobe. All rights reserved.
 *    This file is licensed to you under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License. You may obtain a copy
 *    of the License at http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software distributed under
 *    the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR REPRESENTATIONS
 *    OF ANY KIND, either express or implied. See the License for the specific language
 *    governing permissions and limitations under the License.
 *
 ******************************************************************************/

package poc.graphql.client;

import com.google.gson.Gson;
import org.apache.http.Header;
import org.apache.http.message.BasicHeader;

import java.util.List;

/**
 * This class is used to set various options when executing a GraphQL request.
 */
public class RequestOptions {

    private Gson gson;
    private List<Header> headers;
    private HttpMethod httpMethod;

    /**
     * Sets the {@link Gson} instance that will be used to deserialise the JSON response. This should only be used when the JSON
     * response cannot be deserialised by a standard Gson instance, or when some custom deserialisation is needed.
     * 
     * @param gson A custom {@link Gson} instance.
     * @return This RequestOptions object.
     */
    public RequestOptions withGson(Gson gson) {
        this.gson = gson;
        return this;
    }

    /**
     * Permits to define HTTP headers that will be sent with the GraphQL request.
     * See {@link BasicHeader} for an implementation of the Header interface.
     * 
     * @param headers The HTTP headers.
     * @return This RequestOptions object.
     */
    public RequestOptions withHeaders(List<Header> headers) {
        this.headers = headers;
        return this;
    }

    /**
     * Sets the HTTP method used to send the request, only GET or POST are supported.
     * By default, the client sends a POST request. If GET is used, the underlying HTTP client
     * will automatically URL-Encode the GraphQL query, operation name, and variables.
     * 
     * @param httpMethod The HTTP method.
     * @return This RequestOptions object.
     */
    public RequestOptions withHttpMethod(HttpMethod httpMethod) {
        this.httpMethod = httpMethod;
        return this;
    }

    public Gson getGson() {
        return gson;
    }

    public List<Header> getHeaders() {
        return headers;
    }

    public HttpMethod getHttpMethod() {
        return httpMethod;
    }
}
