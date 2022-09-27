package it.eforhum.corsojava.ArchiveDocument.view;

public class Menu {

	public void displayMenu() {
		boolean repeat = true;

		do {
			System.out.println("0. Esci");
			System.out.println("1. inserimento manuale dei dati");
			System.out.println("2. caricamento attraverso generazione causale di informazioni");
			System.out.println("3. ricerca e stampa di un documento attraverso l'identificativo");
			System.out.println("4. stampa paginata della lista documenti così rappresentata");
			System.out.println("5. modifica documento presente (cod e descrizione)");
			System.out.println("6. rimozione di un documento presente");
			System.out.println("7. stampa di tutti i documenti che contengono nella descrizione una query di ricerca");
			int choice = 0;
			switch (choice) {
				case 0:
					repeat = false;
					break;
				case 1:
					break;
				case 2:
					break;
				case 3:
					break;
				case 4:
					break;
				case 5:
					break;
				case 6:
					break;
				case 7:
					break;
				default: 
					System.out.println("Scelta non valida");
			}
		} while (repeat);
	}
}
