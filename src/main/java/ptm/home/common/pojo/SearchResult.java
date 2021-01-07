package ptm.home.common.pojo;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.Map;

@Component
@RequestScope
public class SearchResult {
	private int intNum1;
	private String strData1;
	private Map<String, Object> responseMap;

	public int getIntNum1() {
		return intNum1;
	}

	public void setIntNum1(int intNum1) {
		this.intNum1 = intNum1;
	}

	public String getStrData1() {
		return strData1;
	}

	public void setStrData1(String strData1) {
		this.strData1 = strData1;
	}

	public Map<String, Object> getResponseMap() {
		return responseMap;
	}

	public void setResponseMap(Map<String, Object> responseMap) {
		this.responseMap = responseMap;
	}
}
