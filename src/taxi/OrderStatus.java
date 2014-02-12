/**
 * 
 */
package taxi;

/**
 * @author chaojian.chen (ccj)
 * @modify date 2013-9-11 下午3:27:42
 * @version 
 */
public enum OrderStatus {
	CANCEL(1) {
		@Override
		public String getName() {
			return "取消";
		}
	},
	
	NEW(2) {
		@Override
		public String getName() {
			return "等待抢单..."; 
		}
	},
	ACCEPT(3) {
		@Override
		public String getName() {
			return "成交";
		}
	},
	TIMEOUT(4) {
		@Override
		public String getName() {
			return "超时";
		}
	},
	
	// 订单实际成交情况
	SUCC(7) {
		@Override
		public String getName() {
			return "成交";
		}
		
	},
	
	NOT_SUCC(8) {
		@Override
		public String getName() {
			return "未成交";
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

