package ru.bankapi.fba.entities;

// import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**************************************************************************
 * Source File	 :  ClientAccount.java
 * Author        :  Franck Armel Malko
 * Project name  :  Test
 * Created       :  07/12/2022
 * Modified   	 :  07/12/2022
 * Description	 :  Definition of the class ClientAccount
 **************************************************************************/
@Entity
@Table(name="client_account")
@Getter
@Setter
@NoArgsConstructor
@EnableJpaAuditing
public class ClientAccount {
    /****************************************************************************
     ****************************     Attributes     ****************************
     ****************************************************************************/
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_account", nullable = false)
    private Long ident;
    @Column(name = "account_number", length = 255, nullable = false, unique = true)
    private String account_number;
    @Column(name = "amount", nullable = false)
    private Double amount;
    @Column(name = "account_type", length = 25, nullable = false)
    private String type;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "opening_date", nullable = false)
    @CreatedDate
    private Date openDate;
    @Column(name = "validity", length = 5, nullable = false)
    private boolean validity;
    /****************************************************************************
     *********************     Attributes Association     ***********************
     ****************************************************************************/
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="id_client_account")   // , nullable = false
    private Client clientAccount;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="checkout_account")
    @JsonManagedReference
    private List<OrdreCaisse> checkOuts;
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
	 * @return the account_number
	 */
	public String getAccount_number() {
		return account_number;
	}
	/**
	 * @param account_number the account_number to set
	 */
	public void setAccount_number(String account_number) {
		this.account_number = account_number;
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
	 * @return the openDate
	 */
	public Date getOpenDate() {
		return openDate;
	}
	/**
	 * @param openDate the openDate to set
	 */
	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}
	/**
	 * @return the validity
	 */
	public boolean isValidity() {
		return validity;
	}
	/**
	 * @param validity the validity to set
	 */
	public void setValidity(boolean validity) {
		this.validity = validity;
	}
	/**
	 * @return the clientAccount
	 */
	public Client getClientAccount() {
		return clientAccount;
	}
	/**
	 * @param clientAccount the clientAccount to set
	 */
	public void setClientAccount(Client clientAccount) {
		this.clientAccount = clientAccount;
	}
	/**
	 * @return the checkOuts
	 */
	public List<OrdreCaisse> getCheckOuts() {
		return checkOuts;
	}
	/**
	 * @param checkOuts the checkOuts to set
	 */
	public void setCheckOuts(List<OrdreCaisse> checkOuts) {
		this.checkOuts = checkOuts;
	}
}