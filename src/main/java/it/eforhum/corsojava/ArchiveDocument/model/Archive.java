package it.eforhum.corsojava.ArchiveDocument.model;

public class Archive {
	private ArchiveDAO dao = new ArchiveDAO();
	
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
}
