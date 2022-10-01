package it.eforhum.corsojava.ArchiveDocument.model;

import java.util.Objects;
import org.apache.maven.shared.utils.StringUtils;

public class ArchiveDocument {
	private final static int ID_DIGITS = 6; // max ID lenght
	private static int ID_COUNT = 0;
	private final static int MAX_DESCRIPTION_LENGTH = 30; // max description lenght
	private int id; // file id variable
	private String cod; // file cod variable
	private String desc; // file description variable

	public ArchiveDocument(String cod, String description) {
		this.setId();
		this.setCod(cod);
		this.setDesc(description);
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		if (cod.length() > 6) {
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
		String result = "";
		if (description == null) {
			description = result;
		}
		description = description.trim();
		if (description.length() > MAX_DESCRIPTION_LENGTH) {
			description = description.substring(0, MAX_DESCRIPTION_LENGTH - 3).concat("...");
		}
		this.desc = description;
	}

	private void setId() {
//		TODO fix -> autoassign number ID | NOT RANDOM

		if (ID_COUNT < Math.pow(10, ID_DIGITS)) {
			this.id = ID_COUNT++;
		} else {
			throw new ArithmeticException();
		}
	}

	@Override
	public int hashCode() {
		return Objects.hash(cod, desc, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ArchiveDocument other = (ArchiveDocument) obj;
		return Objects.equals(cod, other.cod) && Objects.equals(desc, other.desc) && id == other.id;
	}

	@Override
	public String toString() {
		return "ArchiveDocument [id=" + id + ", cod=" + cod + ", desc=" + desc + "]";
	}

	public int getId() {
		return id;
	}
}
