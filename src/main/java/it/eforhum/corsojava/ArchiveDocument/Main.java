package it.eforhum.corsojava.ArchiveDocument;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import it.eforhum.corsojava.ArchiveDocument.model.ArchiveDocument;
import it.eforhum.corsojava.ArchiveDocument.view.Menu;

public class Main {
	public static void main(String[] args) {
		try (Scanner scanner = new Scanner(System.in)) {
			boolean repeat = true;
			Menu menu = new Menu();

			do {
				System.out.println("\n--------------------------------------------------------\n");
				System.out.println("0. Esci");
				System.out.println("1. Inserimento manuale dei dati");
				System.out.println("2. Caricamento attraverso generazione causale di informazioni");
				System.out.println("3. Ricerca e stampa di un documento attraverso l'identificativo");
				System.out.println("4. Stampa paginata della lista documenti così rappresentata");
				System.out.println("5. Modifica documento presente (cod e descrizione)");
				System.out.println("6. Rimozione di un documento presente");
				System.out.println(
						"7. Stampa di tutti i documenti che contengono nella descrizione una query di ricerca");
				System.out.print("?. ");
				int choice = -1;
				try {
					choice = Integer.parseInt(scanner.nextLine());
				} catch (NumberFormatException e) {
					choice = -1;
				}
				switch (choice) {
				case 0:
					repeat = false;
					break;
				case 1:
					System.out.print("Inserisci il codice: ");
					String cod = scanner.nextLine();
					System.out.print("Inserisci la descrizione: ");
					String desc = scanner.nextLine();
					menu.createNewDocument(cod, desc);
					break;
				case 2:
					ArchiveDocument newRandomDocument = menu.createNewRandomDocument();
					ArrayList<ArchiveDocument> list = new ArrayList<>(Arrays.asList(newRandomDocument));
					menu.printDocumentsInTable(list, System.out);
					break;
				case 3:
					try {
						System.out.print("Inserisci l'ID del documento da cercare: ");
						String idStr = scanner.nextLine();
						int ID = Integer.parseInt(idStr);
						ArchiveDocument document = menu.searchDocumentByID(ID);
						if(document == null) {
							System.out.println("\nDocumento non trovato");
						} else {
							ArrayList<ArchiveDocument> docs = new ArrayList<>();
							docs.add(document);
							menu.printDocumentsInTable(docs, System.out);
						}
					} catch (NumberFormatException e) {
						System.out.println("Nessun documento trovato");
					}
					break;
				case 4:
					// TODO stampa paginata
					break;
				case 5:
					// TODO modifica documento presente
					break;
				case 6:
					try {
						System.out.print("Inserisci l'ID del documento da eliminare: ");
						String idStr = scanner.nextLine();
						int ID = Integer.parseInt(idStr);
						menu.deleteDocumentByID(ID);
					} catch(NumberFormatException e) {
						System.out.println("ID inserito non valido");
					}
					break;
				case 7:
					System.out.print("Inserisci una parte della descrizione da cercare: ");
					String query = scanner.nextLine();
					ArrayList<ArchiveDocument> docs = menu.filterDocumentsByDescriptionQuery(query);
					if(docs.isEmpty()) {
						System.out.println("Nessun documento trovato");
					} else {
						menu.printDocumentsInTable(docs, System.out);
					}
					break;
				default:
					System.out.println("Scelta non valida");
				}
			} while (repeat);
			System.out.println("\nTerminated");
		}
	}
}
