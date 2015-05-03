package day02;


public class InjectCheck {
	/*
	 * 函数名称：inject_check() 函数作用：检测提交的值是不是含有SQL注射的字符，防止注射，保护服务器安全 参　　数：sql_str:
	 * 提交的变量 返 回 值：返回检测结果，ture or false
	 */
	public static boolean inject_check(String sql_str) {

		StringBuilder sb = new StringBuilder();
		
		//与数据库相关不安全字符
		sb.append("'|and|exec|insert|select|delete|update|where|and|");
		sb.append("#|count|*|%|chr|mid|master|truncate|char|declare|;|or|-|+|,");
		sb.append("mysql|user|database|show|tables|create|drop|");
		sb.append("information_schema|grant|revoke|db|tables_priv|");
		sb.append("char|hex|concat|concat_ws|elt|insert|instr|lower|");
		
		
		//remote XXS 攻击
		sb.append("javascript|vbscript|expression|applet|meta|");
		sb.append("xml|blink|link|style|script|embed|object|iframe|");
		sb.append("frame|frameset|ilayer|layer|bgsound|title|base|");
		sb.append("onabort|onactivate|onafterprint|onafterupdate|");
		sb.append("onbeforeactivate|onbeforecopy|onbeforecut|onbeforedeactivate|");
		sb.append("onbeforeeditfocus|onbeforepaste|onbeforeprint|onbeforeunload|");
		sb.append("onbeforeupdate|onblur|onbounce|oncellchange|onchange|");
		sb.append("onclick|oncontextmenu|oncontrolselect|oncopy|oncut|");
		sb.append("ondataavailable|ondatasetchanged|ondatasetcomplete|ondblclick|");
		sb.append("ondeactivate|ondrag|ondragend|ondragenter|ondragleave|");
		sb.append("ondragover|ondragstart|ondrop|onerror|onerrorupdate|");
		sb.append("onfilterchange|onfinish|onfocus|onfocusin|onfocusout|");
		sb.append("onhelp|onkeydown|onkeypress|onkeyup|onlayoutcomplete|");
		sb.append("onload|onlosecapture|onmousedown|onmouseenter|onmouseleave|");
		sb.append("onmousemove|onmouseout|onmouseover|onmouseup|onmousewheel|");
		sb.append("onmove|onmoveend|onmovestart|onpaste|onpropertychange|");
		sb.append("onreadystatechange|onreset|onresize|onresizeend|");
		sb.append("onresizestart|onrowenter|onrowexit|onrowsdelete|");
		sb.append("onrowsinserted|onscroll|onselect|onselectionchange|");
		sb.append("onselectstart|onstart|onstop|onsubmit|onunload|");

		String inj_stra[] = sb.toString().split("\\|");
		sql_str = sql_str.toLowerCase();
		int size = inj_stra.length;
		for (int i = 0; i < size; i++) {
			// System.out.println(inj_stra[i]);
			if (sql_str.indexOf(inj_stra[i]) >= 0) {
				
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		boolean rs = inject_check("SELECT * FROM Where 1=1");
		System.out.println(rs);
	}

}