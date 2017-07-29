package aop.utils;

import astra.core.Module;
import astra.formula.Formula;
import astra.formula.Predicate;
import astra.term.ListTerm;
import astra.term.Primitive;

public class Support extends Module{
	   
	@FORMULA
	public Formula equal(char source, char target) {
		return source == target ? Predicate.TRUE:Predicate.FALSE;
	}
	
	/**
     * Inserts the specified element at the specified position in this ListTerm.
	 * @param list ListTerm to which element to be added.
	 * @param index index where to add
	 * @param obj object to be added
	 * @return ListTerm
	 */
	@TERM
	public ListTerm addToAt(ListTerm list, int index, int obj) {
		list.add(index, Primitive.newPrimitive(obj));
		return list;		
	}
	
	/**
     * Term that returns a string that is a substring of this string.
     * The substring begins at the specified {@code beginIndex} and
     * extends to the character at index {@code endIndex - 1}.
     * Thus the length of the substring is {@code endIndex-beginIndex}.
     * @param      source the string
     * @param      startIndex   the beginning index, inclusive.
     * @param      endIndex     the ending index, exclusive.
     * @return     the specified substring.
	 */
	@TERM
	public String substring(String source, int startIndex, int endIndex) {
		return source.substring(startIndex, endIndex);
	}
	
	/**
	 * Term that returns the length of the source string as int
	 * 
	 * @param source the string
	 * @return
	 */
	@TERM
	public int length(String source) {
		return source.length();
	}
	
	/**
	 * Term that returns the char representation of int
	 * 
	 * @param asciiPos the int
	 * @return
	 */
	@TERM
	public char toChar(int asciiPos) {
		return (char)asciiPos;
	}
	
	/**
	 * Term that returns the character at the given index in 
	 * the source string as an int (representation from ASCII)
	 * 
	 * @param source the string
	 * @param index the index of the character in the string
	 * @return
	 */
	@TERM
	public int charAt(String source, int index) {
		return (int)source.charAt(index);
	}
}
