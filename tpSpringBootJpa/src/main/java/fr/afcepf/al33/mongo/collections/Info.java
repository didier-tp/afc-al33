package fr.afcepf.al33.mongo.collections;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
public class Info {
	private Long id;
	private String text;
	public Info(Long id, String text) {
		super();
		this.id = id;
		this.text = text;
	}

}
