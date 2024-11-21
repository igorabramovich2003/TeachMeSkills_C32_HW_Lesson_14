package com.teachmeskills.lesson_14.service;

import com.teachmeskills.lesson_14.exception.InvalidDocumentException;
import com.teachmeskills.lesson_14.util.Constant;
import com.teachmeskills.lesson_14.validator.DocumentValidator;

import java.io.*;


public class DocumentService {
    public static void processDocuments(String fileName) {
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName));
            BufferedWriter validDocWriter = new BufferedWriter(new FileWriter(Constant.VALID_DOC_REPORT_PATH));
            BufferedWriter contractWriter = new BufferedWriter(new FileWriter(Constant.VALID_CONTRACT_REPORT_PATH));
            BufferedWriter invalidDocWriter = new BufferedWriter(new FileWriter(Constant.INVALID_DOC_REPORT_PATH))) {

            String line;
            while ((line = reader.readLine()) != null) {
                line = line.trim();

                try {
                    DocumentValidator.validateDocument(line);

                    if (line.toLowerCase().startsWith(Constant.DOCNUM_NAME)){
                        validDocWriter.write(line);
                    } else if (line.toLowerCase().startsWith(Constant.CONTRACT_NAME)) {
                        contractWriter.write(line);
                    }
                } catch (InvalidDocumentException e) {
                    String invalidEntry = line + " - " + e.getMessage();
                    invalidDocWriter.write(invalidEntry + "\n");
                }
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}
