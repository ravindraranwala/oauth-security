package com.security.oauth;

import org.springframework.security.oauth.provider.ConsumerDetailsService;
import org.springframework.security.oauth.provider.OAuthAuthenticationHandler;
import org.springframework.security.oauth.provider.OAuthProcessingFilterEntryPoint;
import org.springframework.security.oauth.provider.OAuthProviderSupport;
import org.springframework.security.oauth.provider.filter.ProtectedResourceProcessingFilter;
import org.springframework.security.oauth.provider.nonce.OAuthNonceServices;
import org.springframework.security.oauth.provider.token.OAuthProviderTokenServices;

/**
 * A skeletal implementation of the servlet filter for oauth authentication
 * flow. This default behavior is sufficient for most of the users and are
 * encouraged to use it. Those who have special kind of requirements, will have
 * to write their own filter extending the similar kind of hooks provided in the
 * framework.
 * 
 * @author ravindra
 *
 */
public final class OAuthProviderProcessingFilter extends ProtectedResourceProcessingFilter {
	/**
	 * Constructs an instance of the {@link OAuthProviderProcessingFilter} with the
	 * given data.
	 * 
	 * @param oAuthConsumerDetailsService     A service that provides the details
	 *                                        about an oauth consumer. This s
	 *                                        houldn't be <code>null</code>
	 * @param oAuthNonceServices
	 * @param oAuthProcessingFilterEntryPoint Entry point for OAuth authentication
	 *                                        requests.
	 * @param oAuthAuthenticationHandler      Callback interface for handing
	 *                                        authentication details that are used
	 *                                        when an authenticated request for a
	 *                                        protected resource is received.
	 * @param oAuthProviderTokenServices
	 * @param oauthProviderSupport Support logic for OAuth providers.
	 */
	public OAuthProviderProcessingFilter(ConsumerDetailsService oAuthConsumerDetailsService,
			OAuthNonceServices oAuthNonceServices, OAuthProcessingFilterEntryPoint oAuthProcessingFilterEntryPoint,
			OAuthAuthenticationHandler oAuthAuthenticationHandler,
			OAuthProviderTokenServices oAuthProviderTokenServices, OAuthProviderSupport oauthProviderSupport) {
		super();
		setAuthenticationEntryPoint(oAuthProcessingFilterEntryPoint);
		setAuthHandler(oAuthAuthenticationHandler);
		setConsumerDetailsService(oAuthConsumerDetailsService);
		setNonceServices(oAuthNonceServices);
		setTokenServices(oAuthProviderTokenServices);
		setProviderSupport(oauthProviderSupport);
	}

}
