package com.nagarro.CustomerService.dto;

public class AccountDto {

		private Integer aid;
		private Integer cid;
		private Long balance;
				
		public AccountDto() {
			
		}

		public AccountDto(Integer cid, Long balance) {
			this.cid = cid;
			this.balance = balance;
		}
		
		
		
		public Integer getAid() {
			return aid;
		}
		public void setAid(Integer aid) {
			this.aid = aid;
		}
		public Integer getCid() {
			return cid;
		}
		public void setCid(Integer cid) {
			this.cid = cid;
		}
		public Long getBalance() {
			return balance;
		}
		public void setBalance(Long balance) {
			this.balance = balance;
		}

}
