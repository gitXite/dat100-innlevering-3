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

	public void utvid() {
		int str = this.innleggTabell.length;
        Innlegg[] nySamling = new Innlegg[str * 2];
        for (int i = 0; i < str; i++) {
            nySamling[i] = this.innleggTabell[i];
        }
        this.innleggTabell = nySamling;
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {
		boolean lagtTil = leggTil(innlegg);
		if (!lagtTil && nesteLedig > this.innleggTabell.length) {
			utvid();
			lagtTil = leggTil(innlegg);
		}
		return lagtTil;
	}
	
	public boolean slett(Innlegg innlegg) {
        if (finnes(innlegg)) {
	        this.innleggTabell[finnInnlegg(innlegg)] = null;
	        return true;
        }
		return false;
	}
	
	public int[] search(String keyword) {
		int[] idTabell;
		int[] temp = new int[getAntall()];
		int antall = 0;

		for (int i = 0; i < getAntall(); i++) {
			if (this.innleggTabell[i] != null && this.innleggTabell[i].toString().contains(keyword)) {
				temp[antall] = this.innleggTabell[i].getId();
				antall++;
			}
		}

		idTabell = new int[antall];
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] != 0) {
				idTabell[i] = temp[i];
			}
		}
		return idTabell;
	}
}
