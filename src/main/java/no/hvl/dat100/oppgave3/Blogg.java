package no.hvl.dat100.oppgave3;

import no.hvl.dat100.common.TODO;
import no.hvl.dat100.oppgave1.*;

public class Blogg {

	private Innlegg[] innleggTabell;
	private int nesteLedig;

	public Blogg() {
		this.innleggTabell = new Innlegg[20];
        this.nesteLedig = getAntall();
	}

	public Blogg(int lengde) {
		this.innleggTabell = new Innlegg[lengde];
        this.nesteLedig = getAntall();
	}

	public int getAntall() {
		int antall = 0;
        for (Innlegg inl : this.innleggTabell) {
            if (inl != null) {
                antall++;
            }
        }
        return antall;
	}
	
	public Innlegg[] getSamling() {
		return this.innleggTabell;
	}
	
	public int finnInnlegg(Innlegg innlegg) {
		for (int i = 0; i < this.innleggTabell.length; i++) {
			if (innlegg.erLik(this.innleggTabell[i])) {
                return i;
            }
		}
		return -1;
	}

	public boolean finnes(Innlegg innlegg) {
		for (Innlegg inl : this.innleggTabell) {
            if (innlegg.erLik(inl)) {
                return true;
            }
        }
        return false;
	}

	public boolean ledigPlass() {
        for (Innlegg inl : this.innleggTabell) {
            if (inl == null && nesteLedig <= this.innleggTabell.length) {
                return true;
            }
        }
        return false;
    }
	
	public boolean leggTil(Innlegg innlegg) {
        if (ledigPlass() && !finnes(innlegg)) {
            this.innleggTabell[nesteLedig] = innlegg;
            nesteLedig++;
            return true;
        }
        return false;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
        sb.append(getAntall()).append("\n");
        for (Innlegg inl : this.innleggTabell) {
            if (inl != null) {
                sb.append(inl.toString());
            }
        }
        return sb.toString();
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		throw new UnsupportedOperationException(TODO.method());
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {

		throw new UnsupportedOperationException(TODO.method());
		
	}
	
	public boolean slett(Innlegg innlegg) {
		
		throw new UnsupportedOperationException(TODO.method());
	}
	
	public int[] search(String keyword) {
		
		throw new UnsupportedOperationException(TODO.method());

	}
}
