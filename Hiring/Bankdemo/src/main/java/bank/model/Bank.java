package bank.model;

public class Bank {
	private String bank;
	private Integer credit_card_count;
	private Integer debit_card_count;
	public String getBank() {
		return bank;
	}
	public void setBank(String bank) {
		this.bank = bank;
	}
	public Integer getCredit_card_count() {
		return credit_card_count;
	}
	public void setCredit_card_count(Integer credit_card_count) {
		this.credit_card_count = credit_card_count;
	}
	public Integer getDebit_card_count() {
		return debit_card_count;
	}
	public void setDebit_card_count(Integer debit_card_count) {
		this.debit_card_count = debit_card_count;
	}

}
