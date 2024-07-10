
package entity;

import org.springframework.data.annotation.Id;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

public class Ingredient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String amount;
    
    private String type;

    //Getter and Setter Method 
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAmount() {
		return amount;
	}

	public void setAmount(String quantity) {
		this.amount = amount;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String quantity) {
		this.type = type;
	}

	public Ingredient(Long id, String name, String quantity) {
		super();
		this.id = id;
		this.name = name;
		this.amount = amount;
		this.type = type;

	}

  
}