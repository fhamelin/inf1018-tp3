
public class MethodCall
{
	private String strCall;
	private String[] call;
	
	public MethodCall() {
		strCall = "";
		call = strCall.split("[.]");
	}
	
	public MethodCall(String strCall){
		this.strCall = strCall;
		call = strCall.split("[.]");
	}
	
	public void setCall(String strCall) {
		this.strCall = strCall;
		call = strCall.split("[.]");
	}
	
	public String getStrCall() {
		return strCall;
	}
	
	public String getObject() {
		if (call.length > 0) {
			return call[0];
		}
		return "";
	}
	
	public String getCall(int position) {
		if (call.length > position) {
			return call[position];
		}
		return "";
	}
	
	public int getLength() {
		return call.length;
	}
}
