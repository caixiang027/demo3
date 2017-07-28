package com.example3.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc
public class WebMvcConfig {
	
	/** 
	 * <p>提供VC层的处理接口</p>
	 * @return WebMvcConfigurerAdapter:WebMvcConfigurerAdapter实例
	 */
	@Bean
	public WebMvcConfigurerAdapter webMvcConfigurerAdapter(){
		return new WebMvcConfigurerAdapter() {

			/* 
			 * <p>添加拦截器</p>
			 * @param registry 拦截器列表
			 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#addInterceptors(org.springframework.web.servlet.config.annotation.InterceptorRegistry) 
			 */
			@Override
			public void addInterceptors(InterceptorRegistry registry) {
				super.addInterceptors(registry);
				//registry.addInterceptor(sessionInterceptor).addPathPatterns("/**").excludePathPatterns("/login");
			}

			/* 
			 * <p>配置静态资源</p>
			 * @param registry 静态资源信息
			 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#addResourceHandlers(org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry) 
			 */
			@Override
			public void addResourceHandlers(ResourceHandlerRegistry registry) {
				registry.addResourceHandler("/static/**")
				.addResourceLocations("/static/")
				.setCachePeriod(0);
				registry.addResourceHandler("/templates/**")
				.addResourceLocations("/templates/")
				.setCachePeriod(0);
				super.addResourceHandlers(registry);
			}

			/* 
			 * <p>配置默认的静态资源处理程序</p>
			 * @param configurer 默认处理程序配置信息
			 * @see org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter#configureDefaultServletHandling(org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer) 
			 */
			@Override
			public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
				configurer.enable();
			}
		};
	}
	
	/** 
	 * <p>配置国际化视图解析器</p>
	 * @return InternalResourceViewResolver:国际化视图解析器
	 */
	@Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/");
        resolver.setSuffix("");
        return resolver;
    }
}
