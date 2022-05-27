package Mb;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

@ManagedBean
@SessionScoped
public class Language {
	String locale;
	String localeValue;
	
	static Map<String, Object> countries;
	
	public Language() {
		// TODO Auto-generated constructor stub
		countries = new LinkedHashMap<String, Object>();
		countries.put("English", Locale.ENGLISH);
		countries.put("German", Locale.GERMAN);
		
		this.localeValue = "en";
	}
	
	
	// methods for multilingual 
	public Map<String, Object> GetCountries(){
		return countries;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}
		
	public String getLocaleValue() {
		return localeValue;
	}


	public void setLocaleValue(String localeValue) {
		this.localeValue = localeValue;
	}


	// change value listener
	public void localChanged(ValueChangeEvent e) {
		// get the selected value
		String newLocaleValue = e.getNewValue().toString();
		this.localeValue = newLocaleValue;
		
		// loop through the HashMap 
		for(Map.Entry<String, Object> entry: countries.entrySet()) {
			if(entry.getValue().toString().equals(newLocaleValue)) {
				FacesContext.getCurrentInstance().getViewRoot().setLocale((Locale)entry.getValue());
			}
		}
	}
}
