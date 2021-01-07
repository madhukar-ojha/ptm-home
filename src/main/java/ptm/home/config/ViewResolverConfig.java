package ptm.home.config;

import feign.codec.Decoder;
import feign.optionals.OptionalDecoder;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder;
import org.springframework.cloud.openfeign.support.SpringDecoder;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import ptm.home.converter.spring.GenderStringConverter;
import ptm.home.listener.RequestInterceptor;

import java.util.List;

@Component
public class ViewResolverConfig implements WebMvcConfigurer {
	@Autowired
	private RequestInterceptor requestInterceptor;

	@Override
	public void addResourceHandlers(final ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/images/**").addResourceLocations("classpath:/static/images/");
		registry.addResourceHandler("/styles/css/**").addResourceLocations("classpath:/static/styles/css/");
		registry.addResourceHandler("/styles/js/**").addResourceLocations("classpath:/static/styles/js/");

	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(requestInterceptor).addPathPatterns("/**").excludePathPatterns("/", "/login", "/logout",
				"/styles/**", "/images/**", "/public/**");
	}

	@Override
	public void addFormatters(FormatterRegistry registry) {
		registry.addFormatter(new GenderStringConverter());
	}

	@Bean
	public MessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
		messageSource.setBasename("classpath:application_en_US");
		messageSource.setDefaultEncoding("UTF-8");
		return messageSource;
	}

	@Bean
	public MappingJackson2HttpMessageConverter conveters() {
		return new MappingJackson2HttpMessageConverter();
	}

	@Override
	public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {

		// converters.add(createXmlHttpMessageConverter());
		converters.add(new MappingJackson2HttpMessageConverter());
	}
	@Bean
	public Decoder feignDecoder(@Autowired ObjectFactory<HttpMessageConverters> messageConverters) {
		  return new ResponseEntityDecoder(new SpringDecoder(messageConverters));
		}
	@Bean
	@ConditionalOnMissingBean
	public Decoder feignODecoder(@Autowired ObjectFactory<HttpMessageConverters> messageConverters) {
	  return new OptionalDecoder(new ResponseEntityDecoder(new SpringDecoder(messageConverters)));
	}
	@Bean
	public RestTemplate restTemplate(@Autowired List<HttpMessageConverter<?>> list, RestTemplateBuilder builder) {
		RestTemplate restTemplate = builder.build();
		list.add(new MappingJackson2HttpMessageConverter());
		restTemplate.setMessageConverters(list);
		builder.build();
		return restTemplate;
	}

}
