package com.security.oauth.client;

import java.net.URL;
import java.util.Map;
import java.util.Set;

import org.springframework.security.oauth.consumer.OAuthConsumerToken;
import org.springframework.security.oauth.consumer.ProtectedResourceDetails;
import org.springframework.security.oauth.consumer.client.CoreOAuthConsumerSupport;

/**
 * Consumer-side support for OAuth.
 * @author ravindra
 *
 */
public final class OauthConsumerSupportWrapper extends CoreOAuthConsumerSupport {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, Set<CharSequence>> loadOAuthParameters(ProtectedResourceDetails details, URL requestURL,
			OAuthConsumerToken requestToken, String httpMethod, Map<String, String> additionalParameters) {
		return super.loadOAuthParameters(details, requestURL, requestToken, httpMethod, additionalParameters);
	}

}
