package it.eforhum.corsojava.ArchiveDocument.model;

import java.util.Random;
import org.apache.maven.shared.utils.StringUtils;

public class ArchiveDocument {
	private final static int ID_DIGITS = 6;
	private final static int MAX_DESCRIPTION_LENGTH = 30;
	private int id;
	private String cod;
	private String desc;

	public ArchiveDocument(String cod, String description) {
		this.setId();
		this.setCod(cod);
		this.setDesc(description);
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		if(cod.length() > 6) {
			cod = cod.substring(0, 6);
		} else {
			cod = StringUtils.leftPad(cod, 6, "0");
		}
		this.cod = cod;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String description) {
		if(description == null) {
			description = "";
		}
		description = description.trim();
		if(description.length() > MAX_DESCRIPTION_LENGTH) {
			description = description.substring(0, MAX_DESCRIPTION_LENGTH-3).concat("...");
		}
		this.desc = description;
	}

	
	private void setId() {
		Random rand = new Random();
		int maxNumber = (int) Math.pow(10, ID_DIGITS) - 1;
		this.id = rand.nextInt(maxNumber);
	}
	
	public int getId() {
		return id;
	}	
}
