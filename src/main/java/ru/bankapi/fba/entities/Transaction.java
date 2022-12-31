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
 * Source File	 :  Transaction.java
 * Author        :  Franck Armel Malko
 * Project name  :  Test
 * Created       :  07/12/2022
 * Modified   	 :  07/12/2022
 * Description	 :  Definition of the class Transaction
 **************************************************************************/
@Entity
@Table(name="transactions")
@Getter
@Setter
@NoArgsConstructor
public class Transaction {
	/****************************************************************************
     ****************************     Attributes     ****************************
     ****************************************************************************/
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_transaction", nullable = false)
    private Long ident;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date_creation", nullable = false)
    @CreatedDate
    private Date date_creation;
    @Column(name = "amount", length = 15)
    private Double amount;
    @Column(name = "transaction_type", length = 25, nullable = false)
    // Type (dépôt, retrait, transfert)
    private String type;
    @Column(name = "result_execution", length = 5, nullable = false)
    private String result_execution;
    /****************************************************************************
     *********************     Attributes Association     ***********************
     ****************************************************************************/
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="client_account_transact")
    private ClientAccount accounClient;
    @OneToOne
    @JsonManagedReference
    @JoinColumn(name="check_order_transaction", nullable = false)
    private OrdreCaisse caisseOrder;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="client_account_transaction", nullable = false)
    private ClientAccount accounCliTran;

	/**
	 * 
	 * @param amount
	 * @param type
	 * @param result_execution
	 * @param accounClient
	 * @param caisseOrder
	 * @param accounCliTran
	 */
	public Transaction(Double amount, String type, String result_execution,
			           ClientAccount accounClient, OrdreCaisse caisseOrder, ClientAccount accounCliTran) {
		super();
		this.ident = (long) 0;
		this.date_creation = new Date();
		this.amount = amount;
		this.type = type;
		this.result_execution = result_execution;
		this.accounClient = accounClient;
		this.caisseOrder = caisseOrder;
		this.accounCliTran = accounCliTran;
	}

	/**
	 * @param ident
	 * @param date_creation
	 * @param amount
	 * @param type
	 * @param result_execution
	 * @param accounClient
	 * @param caisseOrder
	 * @param accounCliTran
	 */
	public Transaction(Long ident, Date date_creation, Double amount, String type, String result_execution,
			           ClientAccount accounClient, OrdreCaisse caisseOrder, ClientAccount accounCliTran) {
		super();
		this.ident = ident;
		this.date_creation = date_creation;
		this.amount = amount;
		this.type = type;
		this.result_execution = result_execution;
		this.accounClient = accounClient;
		this.caisseOrder = caisseOrder;
		this.accounCliTran = accounCliTran;
	}
	
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
	 * @return the accounClient
	 */
	public ClientAccount getAccounClient() {
		return accounClient;
	}
	/**
	 * @param accounClient the accounClient to set
	 */
	public void setAccounClient(ClientAccount accounClient) {
		this.accounClient = accounClient;
	}
	/**
	 * @return the caisseOrder
	 */
	public OrdreCaisse getCaisseOrder() {
		return caisseOrder;
	}
	/**
	 * @param caisseOrder the caisseOrder to set
	 */
	public void setCaisseOrder(OrdreCaisse caisseOrder) {
		this.caisseOrder = caisseOrder;
	}
	/**
	 * @return the accounCliTran
	 */
	public ClientAccount getAccounCliTran() {
		return accounCliTran;
	}
	/**
	 * @param accounCliTran the accounCliTran to set
	 */
	public void setAccounCliTran(ClientAccount accounCliTran) {
		this.accounCliTran = accounCliTran;
	}
}