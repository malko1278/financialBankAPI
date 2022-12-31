package ru.bankapi.fba.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.Date;

/**************************************************************************
 * Source File	 :  OrdreCaisse.java
 * Author        :  Franck Armel Malko
 * Project name  :  Test
 * Created       :  07/12/2022
 * Modified   	 :  07/12/2022
 * Description	 :  Definition of the class OrdreCaisse
 **************************************************************************/
@Entity
@Table(name="checkouts_order")
@Getter
@Setter
@NoArgsConstructor
public class OrdreCaisse {
    /****************************************************************************
     ****************************     Attributes     ****************************
     ****************************************************************************/
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_check_order", nullable = false)
    private Long ident;
    @Column(name = "order_type", length = 25, nullable = false)
    // Type d'ordre (dépôt, retrait)
    private String type;
    @Column(name = "amount", nullable = false)
    private Double amount;
    @Column(name = "result_execution", length = 255, nullable = false)
    private String result_execution;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_creation", nullable = false, updatable = false)
    @CreatedDate
    private Date date_creation;
    /****************************************************************************
     *********************     Attributes Association     ***********************
     ****************************************************************************/
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="client_account_checkout")
    private ClientAccount accountCliCheck;
    @OneToOne
    @JsonManagedReference
    @JoinColumn(name="transaction_checkout")
    private Transaction transactOrder;
	/**
	 * @return the ident
	 */
	public Long getIdent() {
		return ident;
	}
	/**
	 * @param ident the ident to set
	 */
	public void setIdent(Long ident) {
		this.ident = ident;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the amount
	 */
	public Double getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(Double amount) {
		this.amount = amount;
	}
	/**
	 * @return the result_execution
	 */
	public String getResult_execution() {
		return result_execution;
	}
	/**
	 * @param result_execution the result_execution to set
	 */
	public void setResult_execution(String result_execution) {
		this.result_execution = result_execution;
	}
	/**
	 * @return the date_creation
	 */
	public Date getDate_creation() {
		return date_creation;
	}
	/**
	 * @param date_creation the date_creation to set
	 */
	public void setDate_creation(Date date_creation) {
		this.date_creation = date_creation;
	}
	/**
	 * @return the accountCliCheck
	 */
	public ClientAccount getAccountCliCheck() {
		return accountCliCheck;
	}
	/**
	 * @param accountCliCheck the accountCliCheck to set
	 */
	public void setAccountCliCheck(ClientAccount accountCliCheck) {
		this.accountCliCheck = accountCliCheck;
	}
	/**
	 * @return the transactOrder
	 */
	public Transaction getTransactOrder() {
		return transactOrder;
	}
	/**
	 * @param transactOrder the transactOrder to set
	 */
	public void setTransactOrder(Transaction transactOrder) {
		this.transactOrder = transactOrder;
	}
}