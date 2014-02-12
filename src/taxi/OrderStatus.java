/**
 * 
 */
package taxi;

/**
 * @author chaojian.chen (ccj)
 * @modify date 2013-9-11 ����3:27:42
 * @version 
 */
public enum OrderStatus {
	CANCEL(1) {
		@Override
		public String getName() {
			return "ȡ��";
		}
	},
	
	NEW(2) {
		@Override
		public String getName() {
			return "�ȴ�����..."; 
		}
	},
	ACCEPT(3) {
		@Override
		public String getName() {
			return "�ɽ�";
		}
	},
	TIMEOUT(4) {
		@Override
		public String getName() {
			return "��ʱ";
		}
	},
	
	// ����ʵ�ʳɽ����
	SUCC(7) {
		@Override
		public String getName() {
			return "�ɽ�";
		}
		
	},
	
	NOT_SUCC(8) {
		@Override
		public String getName() {
			return "δ�ɽ�";
		}
		
	}
	;
	
	private Integer code;
	
	private OrderStatus(Integer code) {
		this.code = code;
	}
	
	public Integer getCode() {
		return code;
	}
	
	public abstract String getName();
	
	public static OrderStatus valueOf(int code) {
		for (OrderStatus src : OrderStatus.values()) {
			if (code == src.code) {
				return src;
			}
		}
		return null;
	}
		
}

