package com.security.oauth;

import java.util.Collections;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.oauth.common.OAuthException;
import org.springframework.security.oauth.common.signature.SharedConsumerSecretImpl;
import org.springframework.security.oauth.provider.ConsumerDetails;
import org.springframework.security.oauth.provider.ConsumerDetailsService;

import com.security.oauth.ConsumerDetailsStorageStrategy;
import com.security.oauth.OAuthConsumerDetails;
import com.security.oauth.OAuthConsumerDetailsService;

import junit.framework.Assert;

public final class OAuthConsumerDetailsServiceTest {
	private static final String consumerName = "John";
	private static final String consumerKey = "3a4393c3da1a4e316ee66c0cc61c71";
	private static final String consumerSecret = "fe1372c074185b19c309964812bb8f3f2256ba514aea8a318";
	private static final List<GrantedAuthority> authorities = Collections.emptyList();

	@Test
	public void testLoadConsumerWithValidConsumerKey() {
		final ConsumerDetailsStorageStrategy storageStrategy = Mockito.mock(ConsumerDetailsStorageStrategy.class);
		final ConsumerDetailsService consumerDetailsService = new OAuthConsumerDetailsService(storageStrategy);
		final ConsumerDetails consumerDetails = new OAuthConsumerDetails(consumerName, consumerKey, consumerSecret,
				authorities, false);

		Mockito.when(storageStrategy.loadConsumerByKey(consumerKey)).thenReturn(consumerDetails);

		final ConsumerDetails loadedConsumerDetails = consumerDetailsService.loadConsumerByConsumerKey(consumerKey);
		Assert.assertEquals(consumerDetails, loadedConsumerDetails);
		
		Mockito.verify(storageStrategy).loadConsumerByKey(consumerKey);
	}
	
	@Test(expected = OAuthException.class)
	public void testLoadConsumerWithInvalidConsumerKey() {
		final ConsumerDetailsStorageStrategy storageStrategy = Mockito.mock(ConsumerDetailsStorageStrategy.class);
		final ConsumerDetailsService consumerDetailsService = new OAuthConsumerDetailsService(storageStrategy);
		Mockito.when(storageStrategy.loadConsumerByKey(consumerKey)).thenReturn(null);
		
		consumerDetailsService.loadConsumerByConsumerKey(consumerKey);
		
		Mockito.verify(storageStrategy).loadConsumerByKey(consumerKey);
	}
}
