package ch.zli.m223.api20a.crm.exception;

@SuppressWarnings("serial")
public class NoTraceException extends RuntimeException {

	public NoTraceException(){
		super("", null, true, false);
	}
}
