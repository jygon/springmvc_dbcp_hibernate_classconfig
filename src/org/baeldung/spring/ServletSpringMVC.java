package org.baeldung.spring;

import javax.servlet.Filter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import org.springframework.core.env.AbstractEnvironment;
import org.springframework.web.context.request.RequestContextListener;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class ServletSpringMVC extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		return new Class[] { };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		return new Class[]{AppWebConfiguration.class, PersistenceConfig.class, PersistenceXmlConfig.class};
	}

	@Override
	protected String[] getServletMappings() {
		return new String[] { "/" };
	}

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		super.onStartup(servletContext);
		servletContext.addListener(RequestContextListener.class);
		servletContext.setInitParameter(AbstractEnvironment.DEFAULT_PROFILES_PROPERTY_NAME, "dev");
		
        //AnnotationConfigWebApplicationContext appContext = new AnnotationConfigWebApplicationContext();
        //appContext.register(PersistenceConfig.class);
	}

	@Override
	protected Filter[] getServletFilters() {
		return new Filter[] { };
	}
}