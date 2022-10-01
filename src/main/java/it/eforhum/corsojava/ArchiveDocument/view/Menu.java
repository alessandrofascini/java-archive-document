package it.eforhum.corsojava.ArchiveDocument.view;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

import it.eforhum.corsojava.ArchiveDocument.Utils.Util;
import it.eforhum.corsojava.ArchiveDocument.model.Archive;
import it.eforhum.corsojava.ArchiveDocument.model.ArchiveDocument;

public class Menu {
	private Archive archive = new Archive();

	public ArchiveDocument createNewDocument(String cod, String description) {
		ArchiveDocument doc = new ArchiveDocument(cod, description);
		this.archive.addDocument(doc);
		return doc;
	}

	public ArchiveDocument createNewRandomDocument() {
		Random rand = new Random();
		int randInt = rand.nextInt(16777215); // FFFFFF in esadecimale
		String hexString = Integer.toHexString(randInt);
		String cod = (rand.nextBoolean() ? hexString.toLowerCase() : hexString.toUpperCase());
		String description = "The quick brown fox jumps over the lazy dog";
		return this.createNewDocument(cod, description);
	}

	public String getTableHeader() {
		return new StringBuilder().append("------|").append("------|").append("------------------------------\n")
				.append("ID    |").append("COD   |").append("DESC \n").append("------|").append("------|")
				.append("------------------------------").toString();
	}

	public String printDocument(ArchiveDocument doc) {
		return String.format("%6d|%s|%s", doc.getId(), doc.getCod(), doc.getDesc());
	}

	public void printDocumentsInTable(ArrayList<ArchiveDocument> docs, PrintStream stream) {
		stream.println(this.getTableHeader());
		for (ArchiveDocument doc : docs) {
			stream.println(this.printDocument(doc));
		}
		stream.println();
	}

	public ArchiveDocument searchDocumentByID(int id) {
		return this.archive.searchByID(id);
	}

	public ArrayList<ArchiveDocument> filterDocumentsByDescriptionQuery(String query) {
		return this.archive.searchByPartOfDescription(query);
	}

	public void deleteDocumentByID(int ID) {
		this.archive.deleteDocumentByID(ID);
	}

	public void changeDocumentByID(int ID, String cod, String desc) {
		this.archive.changeDocumentByID(ID, cod, desc);
	}

	public List<ArchiveDocument> printSectionOfDocx(List<ArchiveDocument> sublist,Pagination page, PrintStream stream) {
		Pagination newPage = new Pagination();
		sublist = docxOrdination(page);
		return this.archive.sectionOfDocumets(docxOrdination(page), 0, 4);
	}

	public List<ArchiveDocument> docxOrdination(Pagination page) {

		List<ArchiveDocument> orderedDocx = archive.getDocuments();
		Collections.sort(orderedDocx, new Comparator<ArchiveDocument>() {
			public int compare(ArchiveDocument doc1, ArchiveDocument doc2) {
				int result = 0;
				switch (page.getOrderedByField()) {
				case Util.FIELD_ID:
					result = Integer.compare(doc1.getId(), doc2.getId());
					break;

				case Util.FIELD_COD:
					result = doc1.getCod().compareTo(doc2.getCod());
					break;
				case Util.FIELD_DESCRIPTION:
					result = doc1.getDesc().compareTo(doc2.getDesc());
					break;
				}
				return page.isOrderedByAscending() ? result : -result;
			}
		});

		return orderedDocx;
	}

}
