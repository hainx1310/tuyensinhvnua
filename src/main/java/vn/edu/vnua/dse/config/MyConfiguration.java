package vn.edu.vnua.dse.config;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServletRequest;

import com.ckfinder.connector.configuration.Configuration;
import com.ckfinder.connector.data.ResourceType;

public class MyConfiguration extends Configuration {
	public MyConfiguration(ServletConfig servletConfig) {
		super(servletConfig);
	}

	@Override
	protected Configuration createConfigurationInstance() {
		return new MyConfiguration(this.servletConf);
	}

	@Override
	public void init() throws Exception {
		super.init();
		this.baseURL = "/store";
		ResourceType resourceType = this.types.get("Files");
		resourceType.setAllowedExtensions(resourceType.getAllowedExtensions().concat(",zip,7z"));
	}

	@Override
	public boolean checkAuthentication(final HttpServletRequest request) {
		return request.getSession().getAttribute("loggedIn") != null;
	}

	@Override
	public String getLicenseName() {
		return "MyLicenseName";
	}

	@Override
	public String getBaseDir() {
		return "resources/store";
	}

	@Override
	public String getBaseURL() {
		return "/store";
	}

}