package it.eforhum.corsojava.ArchiveDocument.model;

import java.util.ArrayList;
import java.util.List;

public class Archive {
	private ArchiveDAO dao = new ArchiveDAO();

	public List<ArchiveDocument> getDocuments() {
		return this.dao.getDocuments();
	}

	public void addDocument(ArchiveDocument newDocument) {
		this.dao.addDocument(newDocument);
	}

	public ArchiveDocument searchByID(int ID) {
		return this.dao.searchByID(ID);
	}

	public void changeDocumentByID(int id, String cod, String description) {
		this.dao.changeDocumentByID(id, cod, description);
	}

	public void deleteDocumentByID(int ID) {
		this.dao.deleteDocumentByID(ID);
	}

	public ArrayList<ArchiveDocument> searchByPartOfDescription(String query) {
		return this.dao.searchByPartOfDescription(query);
	}
}
