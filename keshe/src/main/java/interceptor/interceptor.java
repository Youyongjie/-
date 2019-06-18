package interceptor;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;

public class interceptor  implements Interceptor {
	private String msg;

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}
	@Override
	public void init() {
		// TODO Auto-generated method stub
	}
	@Override
	public String intercept(ActionInvocation inv) throws Exception {
		// TODO Auto-generated method stub
		String user = (String)ActionContext.getContext().getSession().get("user");
		System.out.println("�������е�use"+user);
		String method=inv.getProxy().getMethod();
		System.out.println("���õķ����ǣ�"+method);
		if("login".equals(method)||"register".equals(method)){
	        return inv.invoke();
		}
		if(user==null||user.equals("")){
			ActionContext.getContext().getSession().put("msg", "�Բ����㻹û����");
			return "fail";
		}
		ActionContext.getContext().getSession().put("msg", null);
		return inv.invoke();
	}

}