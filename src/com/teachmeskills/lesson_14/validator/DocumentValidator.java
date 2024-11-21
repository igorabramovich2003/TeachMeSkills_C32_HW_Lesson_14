package com.teachmeskills.lesson_14.validator;

import com.teachmeskills.lesson_14.exception.InvalidDocumentException;
import com.teachmeskills.lesson_14.util.Constant;
/*
Let's say there is a file with document numbers.
A document number is a string consisting of letters and numbers (without service characters).
Let this file contain each document number on a new line and no other information in the line, only the document number.
A valid document number must be 15 characters long and begin with the sequence docnum (then any sequence of letters/numbers) or contract (then any sequence of letters/numbers).
Write a program to read information from the input file - the path to the input file must be specified through the console.
The program must check the document numbers for validity.
Valid docnum document numbers should be written to one report file.
Valid contract numbers contract should be written to another report file.
Invalid document numbers should be written to another report file, but after the document numbers, information should be added about why this document is invalid (incorrect sequence of characters at the beginning / there are service characters in the document name, etc.).
 */
public class DocumentValidator {
    public static void validateDocument(String documentNumber)
            throws InvalidDocumentException {
        if (documentNumber.length() != Constant.DOCUM_LENGTH) {
            throw new InvalidDocumentException("Incorrect document number length");
        }
        if (!documentNumber.toLowerCase().startsWith(Constant.DOCNUM_NAME) && !documentNumber.toLowerCase().startsWith(Constant.CONTRACT_NAME)) {
            throw new InvalidDocumentException("Incorrect sequence of characters at the beginning of the document number");
        }
        if (!documentNumber.matches("^[a-zA-Z0-9]+$")) {
            throw new InvalidDocumentException("Incorrect characters");
        }
    }
}
