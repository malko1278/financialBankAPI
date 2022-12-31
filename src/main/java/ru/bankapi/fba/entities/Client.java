package ru.bankapi.fba.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**************************************************************************
 * Source File	 :  Client.java
 * Author        :  Franck Armel Malko
 * Project name  :  Test
 * Created       :  07/12/2022
 * Modified   	 :  07/12/2022
 * Description	 :  Definition of the class Client
 **************************************************************************/
@Entity
@Table(name="clients")
@Getter
@Setter
@NoArgsConstructor
public class Client {
    /****************************************************************************
     ****************************     Attributes     ****************************
     ****************************************************************************/
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id_client", nullable = false)
    private Long id;
    @Column(name = "name", length = 255, nullable = false)
    private String name;
    @Column(name = "surname", length = 255, nullable = false)
    private String surname;
    @Column(name = "father_name", length = 255)
    private String father_name;
    @Column(name = "client_code", length = 255, nullable = false, unique = true)
    private String password;
    /****************************************************************************
     *********************     Attributes Association     ***********************
     ****************************************************************************/
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name="account_client")
    @JsonManagedReference
    private List<ClientAccount> accountClients;
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}
	/**
	 * @param surname the surname to set
	 */
	public void setSurname(String surname) {
		this.surname = surname;
	}
	/**
	 * @return the father_name
	 */
	public String getFather_name() {
		return father_name;
	}
	/**
	 * @param father_name the father_name to set
	 */
	public void setFather_name(String father_name) {
		this.father_name = father_name;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the accountClients
	 */
	public List<ClientAccount> getAccountClients() {
		return accountClients;
	}
	/**
	 * @param accountClients the accountClients to set
	 */
	public void setAccountClients(List<ClientAccount> accountClients) {
		this.accountClients = accountClients;
	}
}