package ptm.home.common.pojo;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

import java.util.HashMap;
import java.util.Map;

@Component
@RequestScope
public class SearchParams {

	private int intNum1;
	private int intNum2;
	private String strData1;
	private String strData2;
	private Map<String, Object> requestMap = new HashMap<String, Object>();

	public SearchParams() {

	}

	public int getIntNum1() {
		return intNum1;
	}

	public void setIntNum1(int intNum1) {
		this.intNum1 = intNum1;
	}

	public int getIntNum2() {
		return intNum2;
	}

	public void setIntNum2(int intNum2) {
		this.intNum2 = intNum2;
	}

	public String getStrData1() {
		return strData1;
	}

	public void setStrData1(String strData1) {
		this.strData1 = strData1;
	}

	public String getStrData2() {
		return strData2;
	}

	public void setStrData2(String strData2) {
		this.strData2 = strData2;
	}

	public Map<String, Object> getRequestMap() {
		return requestMap;
	}

	public void setRequestMap(Map<String, Object> requestMap) {
		this.requestMap = requestMap;
	}

}
