package com.bo.process.transfer;

import java.io.Serializable;
import java.io.StringReader;
import java.util.ArrayList;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * DTDObject - Data Transfer Detail Object Stores the details (Grid) in a Matrix
 * format It is stored as a part of DTObject(Data TransferObject)
 */

public class VTDObject extends DefaultHandler implements Serializable {

	public VTDObject() {
	}

	private static final long serialVersionUID = 6967776575442124518L;
	private ArrayList<String> arrListColNames = new ArrayList<String>();
	private ArrayList<String[]> arrListRows = new ArrayList<String[]>();

	private int currColIndex; // Used for XML Parsing in startElement() and
								// characters()
	StringBuffer tagValueBuf = new StringBuffer();

	/**
	 * addColumn - To add a new Column to the Grid.
	 * 
	 * @param ColIndex
	 *            -Column Index
	 * @param ColName
	 *            - Column Name
	 */
	public void addColumn(int ColIndex, String ColName) {
		arrListColNames.add(ColIndex, ColName);
	}

	public void addColumn(int ColIndex) {
		arrListColNames.add(ColIndex, "Cell" + ColIndex);
	}

	/**
	 * addRow - To add a new Row to the Grid.
	 * 
	 */
	public void addRow() {
		int NoOfCols = arrListColNames.size();
		String[] Row = new String[NoOfCols];
		arrListRows.add(arrListRows.size(), Row);
	}

	/**
	 * clearRows - To Clear all the Rows of the Grid.
	 * 
	 */
	public void clearRows() {
		for (int i = 0; i < arrListRows.size(); i++)
			arrListRows.remove(i);
	}

	/**
	 * clear - To Clear All Rows and Column information
	 * 
	 */
	public void clear() {
		for (int i = 0; i < arrListColNames.size(); i++)
			arrListColNames.remove(i);
		for (int i = 0; i < arrListRows.size(); i++)
			arrListRows.remove(i);
	}

	/**
	 * getValue - To get the value of the Cell identified by Row Index and
	 * Column Index
	 * 
	 * @param RowIndex
	 *            - Row index to identify the Row of the Cell.(Index Starts from
	 *            0)
	 * @param ColIndex
	 *            - Column index to identify the Column of the Cell.(Index
	 *            Starts from 0)
	 * @return
	 */
	public String getValue(int RowIndex, int ColIndex) {
		String[] arrRow = (String[]) arrListRows.get(RowIndex);
		if (arrRow[ColIndex] == null)
			return " ";
		else
			return arrRow[ColIndex];
	}

	/**
	 * setValue - To set the value of the Cell identified by Row Index and
	 * Column Index
	 * 
	 * @param RowIndex
	 *            - Row index to identify the Row of the Cell.(Index Starts from
	 *            0)
	 * @param ColIndex
	 *            - Column index to identify the Column of the Cell.(Index
	 *            Starts from 0)
	 * @param Value
	 *            - Value of the Cell (String)
	 */
	public void setValue(int RowIndex, int ColIndex, String Value) {
		String[] arrRow = (String[]) arrListRows.get(RowIndex);
		arrRow[ColIndex] = Value;
	}

	/**
	 * getValue - To get the value of the Cell identified by Row Index and
	 * Column Name
	 * 
	 * @param RowIndex
	 *            - Row index to identify the Row of the Cell.(Index Starts from
	 *            0)
	 * @param ColName
	 *            - Column Name to identify the Column of the Cell.
	 * @return - Value of the Cell (String)
	 */
	public String getValue(int RowIndex, String ColName) {
		return getValue(RowIndex, arrListColNames.indexOf(ColName));
	}

	/**
	 * setValue - To set the value of the Cell identified by Row Index and
	 * Column Name
	 * 
	 * @param RowIndex
	 *            - Row index to identify the Row of the Cell.(Index Starts from
	 *            0)
	 * @param ColName
	 *            - Column Name to identify the Column of the Cell.
	 * @param Value
	 *            - Value of the Cell (String)
	 */
	public void setValue(int RowIndex, String ColName, String Value) {
		setValue(RowIndex, arrListColNames.indexOf(ColName), Value);
	}

	/**
	 * getColSize - To get the No of Columns in the Grid.
	 * 
	 * @return - No of Columns
	 */
	public int getColSize() {
		return arrListColNames.size();
	}

	/**
	 * getColSize - To get the No of Columns in the Grid.
	 * 
	 * @return - No of Columns
	 */
	public void setColSize(int colSize) {
		for (int i = 0; i < colSize; i++) {
			arrListColNames.add(i, "Cell" + i);
		}
	}

	/**
	 * getRowSize - To get the No of Rows in the Grid.
	 * 
	 * @return - No of Rows
	 */
	public int getRowSize() {
		return arrListRows.size();
	}

	/**
	 * getXML - To get the Grid Details in the form XML Tags.
	 * 
	 * @return XML String
	 */

	public String getXML() {
		StringBuffer buffer = new StringBuffer(getRowSize() * getColSize());
		String xml;
		buffer.append("<rows>");
		for (int i = 0; i < getRowSize(); i++) {
			buffer.append("<row id='");
			buffer.append((i + 1));
			buffer.append("'><cell>");
			buffer.append((i + 1));
			buffer.append("</cell>");
			for (int j = 0; j < getColSize(); j++) {
				buffer.append("<cell>");
				buffer.append(getValue(i, j));
				buffer.append("</cell>");
			}
			buffer.append("</row>");
		}
		buffer.append("</rows>");
		xml = buffer.toString().replaceAll("&", "&amp;");
		return xml;
	}

	/**
	 * 
	 * @param xmlString
	 * @throws Exception
	 */
	public void setXML(String xmlString) throws Exception {
		SAXParserFactory factory = SAXParserFactory.newInstance();
		SAXParser saxParser = factory.newSAXParser();
		StringReader strreader = new StringReader(xmlString);
		InputSource insource = new InputSource(strreader);

		saxParser.parse(insource, this);

	} // end setXMLFormat()

	/**
	 * 
	 * @param namespaceURI
	 * @param sName
	 *            - simple name
	 * @param qName
	 *            - qualified name
	 * @param attrs
	 * @throws SAXException
	 */
	public void startElement(String namespaceURI, String sName, String qName, Attributes attrs) throws SAXException {
		tagValueBuf.setLength(0);
		if (qName.equals("row")) {
			addRow();
			currColIndex = -1;
		}

	} // end startElement()

	/**
	 * 
	 * @param ch
	 * @param start
	 * @param length
	 * @throws SAXException
	 */
	public void characters(char[] ch, int start, int length) throws SAXException {
		String tagValue = new String(ch, start, length);
		tagValueBuf.append(tagValue);
	} // end characters()

	public void endElement(String namespaceURI, String sName, String qName) throws SAXException {
		if (qName.indexOf("cell") > -1) {
			String tagValue = new String();
			tagValue = tagValueBuf.toString();
			currColIndex = currColIndex + 1;
			setValue(arrListRows.size() - 1, currColIndex, tagValue.trim());
		}

	} // end endElement()

	public void warning(SAXParseException e) {

	}

	public void error(SAXParseException e) {

	}

	/**
	 * Fetches entire row values delimted by "|" symbol.
	 * 
	 * @param rowIndex
	 * @return String
	 */
	public String getRowValue(int rowIndex) {
		StringBuffer strRowValue = null;
		for (int colIndex = 0; colIndex < getColSize(); colIndex++) {
			if (colIndex == 0)
				strRowValue = new StringBuffer(getValue(rowIndex, colIndex));
			else
				strRowValue.append("|");
			strRowValue.append(getValue(rowIndex, colIndex));
		}
		return strRowValue.toString();
	}

	public ArrayList<String> getColNames() {
		return arrListColNames;
	}

	public int getColCount() {
		return arrListColNames.size();
	} // end getCols()

	public int getRowCount() {
		return arrListRows.size();
	}
}
