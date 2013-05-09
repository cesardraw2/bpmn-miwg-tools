package bpmnChecker.tests.validation;

import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import bpmnChecker.base.TestOutput;

public class ValidationErrorHandler extends DefaultHandler {
	private String errMessage = "";
	public int numWarning = 0;
	public int numError = 0;
	public int numFatalError = 0;

	private TestOutput out;

	public void setTestOutput(TestOutput out) {
		this.out = out;
	}

	public void warning(SAXParseException e) {
		numWarning++;
		out.println("Warning Line " + e.getLineNumber() + ": "
				+ e.getMessage() + "\n");
	}

	public void error(SAXParseException e) {
		numError++;
		errMessage = new String("Error Line " + e.getLineNumber() + ": "
				+ e.getMessage() + "\n");
		out.println(errMessage);
	}

	public void fatalError(SAXParseException e) {
		numFatalError++;
		errMessage = new String("Error Line " + e.getLineNumber() + ": "
				+ e.getMessage() + "\n");
		out.println(errMessage);
	}

	public boolean valid() {
		return (numError == 0) && (numFatalError == 0);
	}

}
