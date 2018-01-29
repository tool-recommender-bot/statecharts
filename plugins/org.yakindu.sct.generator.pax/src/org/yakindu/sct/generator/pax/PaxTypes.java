package org.yakindu.sct.generator.pax;

public enum PaxTypes{
	H ("hours"),
	M ("minutes"),
	S ("seconds"),
	MS ("milliseconds")
	;
	
	protected String unit;
	private PaxTypes(String s) {
		this.unit = s;
	}
}
