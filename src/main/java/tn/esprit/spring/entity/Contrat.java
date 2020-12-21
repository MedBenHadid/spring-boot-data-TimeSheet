package tn.esprit.spring.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

@Entity
@Table(name = "Contrat")

public class Contrat implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "Refernce")
	int Reference;
	Date DateDebut;
	String TypeContrat;
	int Salaire;
	@OneToOne(mappedBy="contrat")
	@JoinColumn(name = "Reference")
	private Employe Employe;
	public Employe getEmploye() {
		return Employe;
	}
	public void setEmploye(Employe employe) {
		this.Employe = employe;
	}
	public int getReference() {
		return Reference;
	}
	public void setReference(int reference) {
		Reference = reference;
	}
	@Temporal(TemporalType.DATE)
	public Date getDateDebut() {
		return DateDebut;
	}
	public void setDateDebut(Date dateDebut) {
		DateDebut = dateDebut;
	}
	public String getTypeContrat() {
		return TypeContrat;
	}
	public void setTypeContrat(String typeContrat) {
		TypeContrat = typeContrat;
	}
	public int getSalaire() {
		return Salaire;
	}
	public void setSalaire(int salaire) {
		Salaire = salaire;
	}
	
	
}
