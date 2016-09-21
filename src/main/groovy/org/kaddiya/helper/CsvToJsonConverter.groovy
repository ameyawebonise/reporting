package org.kaddiya.helper

import groovy.json.JsonOutput
import org.apache.commons.csv.CSVParser

import static org.apache.commons.csv.CSVFormat.DEFAULT

/**
 * Created by Webonise on 21/09/16.
 */
class CsvToJsonConverter {

    private def listing = []
    private String csvStringToConvert


    CsvToJsonConverter(String csvStringToConvert) {
        assert csvStringToConvert: "Csv String passed to convert can not be null or empty"
        this.csvStringToConvert = csvStringToConvert
    }

    String getJson() {
        CSVParser csvparser = CSVParser.parse(this.csvStringToConvert, DEFAULT.withHeader())
        for (record in csvparser.iterator()) {
            listing << record.toMap()
        }
        return JsonOutput.prettyPrint(JsonOutput.toJson(listing))
    }

}

