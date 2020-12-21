package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name = "Employe")
public class Employe implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Employe_ID")
	int id;
	String Prenom;
	String Nom;
	String Email;
	boolean IsActive;
	 public enum Role{ CHEF_DEPARTEMENT,ADMINISTRATEUR, INGENIEUR }
	 @Enumerated(EnumType.ORDINAL)
     Role role ;
	 @OneToOne	
	 private Contrat contrat;
	 
	 @ManyToMany(cascade = CascadeType.ALL)
	 @JoinTable(name = "Temploye", joinColumns={@JoinColumn(name="IDEmploye")}, inverseJoinColumns={@JoinColumn(name ="IdDEP")})
	 private Set<Departement> Departements;
	
	 
	 @OneToMany(mappedBy="Employes")
	 private List<Timesheet>timesheets;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getPrenom() {
		return Prenom;
	}
	public void setPrenom(String prenom) {
		Prenom = prenom;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public boolean isIsActive() {
		return IsActive;
	}
	public void setIsActive(boolean isActive) {
		IsActive = isActive;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public Contrat getContrat() {
		return contrat;
	}
	public void setContrat(Contrat contrat) {
		this.contrat = contrat;
	}
		

}
