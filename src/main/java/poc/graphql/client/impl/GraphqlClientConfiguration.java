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

package poc.graphql.client.impl;


import poc.graphql.client.HttpMethod;

public interface GraphqlClientConfiguration {

    int MAX_HTTP_CONNECTIONS_DEFAULT = 20;
    boolean ACCEPT_SELF_SIGNED_CERTIFICATES = false;

    int DEFAULT_CONNECTION_TIMEOUT = 5000;
    int DEFAULT_SOCKET_TIMEOUT = 5000;
    int DEFAULT_REQUESTPOOL_TIMEOUT = 2000;


    /**
     * name = "GraphQL Service URL",
     * description = "The URL of the GraphQL server endpoint.",
     */
    String url();

    /**
     * name = "Default HTTP method",
     * description = "The default HTTP method used to send GraphQL requests."
     */
    default HttpMethod httpMethod() {
        return HttpMethod.POST;
    }

    /**
     * name = "Accept self-signed SSL certificates",
     * description = "Enable insecure/developer mode to accept self-signed SSL certificates.
     * Do NOT activate on production systems!"
     */
    default boolean acceptSelfSignedCertificates() {
        return ACCEPT_SELF_SIGNED_CERTIFICATES;
    }

    /**
     * name = "Max HTTP connections",
     * description = "The maximum number of concurrent HTTP connections the connector can make"
     */
    default int maxHttpConnections() {
        return MAX_HTTP_CONNECTIONS_DEFAULT;
    }

    /**
     * name = "Http connection timeout",
     * description = "The timeout in milliseconds until a connection is established.
     * A timeout value of zero is interpreted as an infinite timeout."
     */
    default int connectionTimeout() {
        return DEFAULT_CONNECTION_TIMEOUT;
    }


    /**
     * name = "Http socket timeout",
     * description = "The socket timeout in milliseconds, which is the timeout for waiting for data or, put differently,
     * a maximum period inactivity between two consecutive data packets.
     * A timeout value of zero is interpreted as an infinite timeout."
     */
    default int socketTimeout() {
        return DEFAULT_SOCKET_TIMEOUT;
    }

    /**
     * name = "Request pool timeout",
     * description = "The timeout in milliseconds used when requesting a connection from the connection manager.
     * A timeout value of zero is interpreted as an infinite timeout."
     */
    default int requestPoolTimeout() {
        return DEFAULT_REQUESTPOOL_TIMEOUT;
    }

    /**
     * name = "Default HTTP Headers",
     * description = "HTTP Headers which shall be sent with each request. Might be used for authentication.
     * The format of each header is name:value"
     */
    default String[] httpHeaders() {
        return new String[] {};
    }
}
