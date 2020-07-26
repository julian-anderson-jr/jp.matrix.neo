package jp.matrix.app;

import java.util.EnumSet;
import java.util.stream.Collectors;

import javax.servlet.DispatcherType;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.session.SessionProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.web.http.SessionRepositoryFilter;

@Configuration(proxyBeanMethods = false)
@ConditionalOnBean(SessionRepositoryFilter.class)
@EnableConfigurationProperties(SessionProperties.class)
class SessionRepositoryFilterConfiguration {

	@Bean
	FilterRegistrationBean<SessionRepositoryFilter<?>> sessionRepositoryFilterRegistration(
			SessionProperties sessionProperties, SessionRepositoryFilter<?> filter) {
		FilterRegistrationBean<SessionRepositoryFilter<?>> registration = new FilterRegistrationBean<>(filter);
		registration.setDispatcherTypes(getDispatcherTypes(sessionProperties));
		registration.setOrder(sessionProperties.getServlet().getFilterOrder());
		return registration;
	}

	private EnumSet<DispatcherType> getDispatcherTypes(SessionProperties sessionProperties) {
		SessionProperties.Servlet servletProperties = sessionProperties.getServlet();
		if (servletProperties.getFilterDispatcherTypes() == null) {
			return null;
		}
		return servletProperties.getFilterDispatcherTypes().stream().map((type) -> DispatcherType.valueOf(type.name()))
				.collect(Collectors.collectingAndThen(Collectors.toSet(), EnumSet::copyOf));
	}

}