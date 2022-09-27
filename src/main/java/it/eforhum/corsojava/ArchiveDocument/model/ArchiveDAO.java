package it.eforhum.corsojava.ArchiveDocument.model;

import java.util.ArrayList;
import java.util.Arrays;

public class ArchiveDAO {
	private ArrayList<ArchiveDocument> documents = new ArrayList<>();
	
	public void addDocument(ArchiveDocument newDocument) {
		this.documents.add(newDocument);
	}
	
	public ArchiveDocument searchByID(int ID) {
		for(ArchiveDocument document : this.documents) {
			if(document.getId() == ID) {
				return document;
			}
		}
		return null;
	}
	
	public void changeDocumentByID(int id, String cod, String description) {
		ArchiveDocument oldDocument = this.searchByID(id);
		if(oldDocument == null) {
			return;
		}
		oldDocument.setCod(cod);
		oldDocument.setDesc(description);
	}
	
	public void deleteDocumentByID(int ID) {
		ArchiveDocument document = this.searchByID(ID);
		if(document == null) {
			return;
		}
		int index = this.documents.indexOf(document);
		this.documents.remove(index);
	}
}
