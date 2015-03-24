package cn.c.core.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.c.core.domain.IdEntity;
import cn.c.core.service.SimpleService;

/**
 * 
 * @author hz453@126.com
 */
public abstract class SimpleController<T extends IdEntity, S extends SimpleService<T>> {
	public static final String LIST_PATH = "/list";
	public static final String FORM_PATH = "/form";
	public static final String VIEW_PATH = "/view";
	
	private S service;
	private HttpServletRequest httpServletRequest;
	
	public S getService() {
		return service;
	}
	@Autowired
	public void setService(S service) {
		this.service = service;
	}
	
	public HttpServletRequest getHttpServletRequest() {
		return httpServletRequest;
	}
	@Autowired
	public void setHttpServletRequest(HttpServletRequest httpServletRequest) {
		this.httpServletRequest = httpServletRequest;
	}
	
	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String hello(Model model) {
		String message = this.getService().sayHello();
		model.addAttribute("message", message);
		return this.getPrefix() + this.getUriDirector() + FORM_PATH;
	}
	
	protected abstract String getUriDirector();
	protected String getPrefix(){
		return "";
	}
	
	public void addAttribute(String key, Object object) {
		this.httpServletRequest.setAttribute(key, object);
	}
}
